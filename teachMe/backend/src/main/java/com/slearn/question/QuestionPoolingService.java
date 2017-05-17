package com.slearn.question;

import com.slearn.KI.KnowledgeItem;
import com.slearn.KI.KnowledgeItemService;
import com.slearn.choice.ChoiceService;
import com.slearn.lesson.Lesson;
import com.slearn.questionActivity.QuestionActivityService;
import com.slearn.user.User;
import com.slearn.userKnowledge.UserKnowledge;
import com.slearn.userKnowledge.UserKnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by E-M on 5/3/2017.
 */

@Service
public class QuestionPoolingService {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private KnowledgeItemService knowledgeItemService;

    @Autowired
    private UserKnowledgeService userKnowledgeService;

    @Autowired
    private ChoiceService choiceService;

    @Autowired
    private QuestionActivityService questionActivityService;


    private double reasoning_threshold;

    private double extra_difficulty;

    //get the next question based on the lesson you are testing, the current user and the question number
    // for this particular testing session
    //what, when, how
    public Question nextQuestion(Lesson lesson, User user, int currentNoOfQuestion) {

        reasoning_threshold = 2.5;
        extra_difficulty = 0.3;

        //should KIs have an order?

        //step one: get a random KI from the set {0,.., current, next}
        KnowledgeItem chosenKi = getNextRandomKI(user, lesson);

        UserKnowledge uk = userKnowledgeService.getUserKnByUserAndKI(user, chosenKi);

        double ability = uk.getScore();

        Question theChosenOne = null;

        //if theoretical ability for this KI is greater than 3.5, user is ready for reasoning questions
        //if no more th questions, start asking reasoning with low diff
        if (ability > reasoning_threshold) {
            System.out.println("reasoning much?");
            theChosenOne = getRandomQuestionIncludingReasoning(user, chosenKi, ability);


        } else if (ability <= reasoning_threshold) {
            //otherwise, just give him more theory questions
            theChosenOne = getRandomTheoreticalQuestion(user, chosenKi, ability);
        }


        return theChosenOne;
    }

    public KnowledgeItem getNextRandomKI(User user, Lesson lesson) {

        //bring all KIs that have an answered question and the first next KI that has 0 questions answered
        List<KnowledgeItem> kis = knowledgeItemService.getTackledKIsForUser(user, lesson);

        List<KnowledgeItem> kni = knowledgeItemService.getNextUNTackledKIForUser(user, lesson);

        System.out.println(kni.toString());
        System.out.println(kis.toString());

        KnowledgeItem chosenKI = null;

        ArrayList<KnowledgeItem> testItems = new ArrayList<>();

        if (kis.size() == 0 && kni.size() == 0) {
            chosenKI = knowledgeItemService.getFirstKI(lesson.getId());
        } else {

            if (kni.size() > 0) {
                kis.addAll(kni);
            }

            Collections.shuffle(kis);

          /*  //dont matter cuz its shuffled
            chosenKI = kis.get(0);*/




            //for testing use the first 2 ki
                 // chosenKI = knowledgeItemService.getById((long) 1);
         /*   KnowledgeItem test2 = knowledgeItemService.getById((long) 2);

            KnowledgeItem test = knowledgeItemService.getById((long) 1);

            KnowledgeItem test3 = knowledgeItemService.getById((long) 3);

            testItems = new ArrayList<>();

            testItems.add(test);
            testItems.add(test2);
            testItems.add(test3);

            Collections.shuffle(testItems);

            chosenKI = testItems.get(0);*/


            chosenKI = kis.get(0);

            System.out.println(chosenKI);
        }

        //should be return chosen ki;
        return chosenKI;
        //return chosenKI;

    }

    public Question getRandomTheoreticalQuestion(User user, KnowledgeItem ki, double ability) {

        System.out.println("I WILL BE TH");

        Question theChosenOne = null;

        double diff_decrease_ratio = (double) 1 / 2;

        List<Question> nonAnswered = questionService.getTheoreticalUnansweredQuestions(user, ki);

        //we still have unanswered theoretical questions
        if (nonAnswered.size() > 0) {

            System.out.println("I WILL BE TH UNANSWRD");

            Collections.shuffle(nonAnswered);

            System.out.println(nonAnswered.toString());

            theChosenOne = nonAnswered.get(0);

            //apply difficulty with an extra
            if (ability <= (5 - extra_difficulty)) {
                choiceService.getChoicesForQuestion(ability + extra_difficulty, theChosenOne);
                theChosenOne.setAppliedDifficulty(ability + extra_difficulty);
            } else {
                choiceService.getChoicesForQuestion(ability, theChosenOne);
                theChosenOne.setAppliedDifficulty(ability);
            }

            setDisplayInfo(theChosenOne, user, false, 0, false, ability);

        } else {

            System.out.println("I WILL BE TH ANS WRONG");

            //from all the questions, get first the ones he got wrong, and offer them with easier difficulty!!
            //then, ultimately, offer the questions he answered correctly but with much greater difficulty
            List<Question> allWrongThQs = questionService.getAllCurrentlySTILLWrongTheoreticalQuestions(user, ki);

            if (allWrongThQs.size() > 0) {

                Collections.shuffle(allWrongThQs);
                theChosenOne = allWrongThQs.get(0);

                double low = questionActivityService.getLatestDiffAppliedForWrong(user, theChosenOne);

                System.out.println("chosen :: " + theChosenOne.toString());

                System.out.println("low :: " + low);


                //apply about 1/2 of the lowest difficulty previously applied
                double new_difficulty = low * diff_decrease_ratio;
                System.out.println(new_difficulty);

                choiceService.getChoicesForQuestion(new_difficulty, theChosenOne);
                theChosenOne.setAppliedDifficulty(new_difficulty);


                //for display thingies
                //im so tired.
         /*       theChosenOne.setAnsweredBefore(true);
                theChosenOne.setLastPrevAppDiff(low);
                theChosenOne.setLatestStatus(false);
*/


                setDisplayInfo(theChosenOne, user, true, low, false, ability);

            } else {


                System.out.println("I WILL BE TH ANS CORRECT");
                double diff_increase_ratio = 2;

                List<Question> allCorrectThQs = questionService.getAllCorrectTheoreticalQuestions(user, ki);

                Collections.shuffle(allCorrectThQs);
                theChosenOne = allCorrectThQs.get(0);

                double high = questionActivityService.getLatestDiffAppliedForCorrect(user, theChosenOne);


                //apply about 1.5 times more diff
                double new_difficulty = high + diff_increase_ratio;

                if (new_difficulty >= 5) {
                    new_difficulty = 4.9;
                }
                System.out.println(new_difficulty);

                System.out.println("high :: " + high);

                choiceService.getChoicesForQuestion(new_difficulty, theChosenOne);
                theChosenOne.setAppliedDifficulty(new_difficulty);

     /*           theChosenOne.setAnsweredBefore(true);
                theChosenOne.setLastPrevAppDiff(high);
                theChosenOne.setLatestStatus(true);*/

                setDisplayInfo(theChosenOne, user, true, high, true, ability);


            }


        }

/*        theChosenOne.setCurrentAbility(ability);

        theChosenOne.setNoOfPreviousAnswers(questionActivityService.getNumberOfAnswerTimesTotal(user,theChosenOne));
        theChosenOne.setNoOfPreviousCorrectAnswers(questionActivityService.getNumberOfAnswerTimesCorrect(user,theChosenOne));
        theChosenOne.setNoOfPreviousWrongAnswers(questionActivityService.getNumberOfAnswerTimesWrong(user,theChosenOne));*/


        return theChosenOne;
    }


    public Question getRandomQuestionIncludingReasoning(User user, KnowledgeItem ki, double ability) {

        System.out.println("I WILL BE ANY !!!!");

        List<Question> nonAnswered = questionService.getAllUnansweredQuestions(user, ki);

        Question theChosenOne = null;

        double diff_decrease_ratio = (double) 1 / 2;


        if (nonAnswered.size() > 0) {
            System.out.println("I WILL BE ANY UNANSW!!!!");

            Collections.shuffle(nonAnswered);

            System.out.println(nonAnswered.toString());

            theChosenOne = nonAnswered.get(0);

            //apply difficulty with an extra
            if (ability <= (5 - extra_difficulty)) {
                choiceService.getChoicesForQuestion(ability + extra_difficulty, theChosenOne);
                theChosenOne.setAppliedDifficulty(ability + extra_difficulty);
            } else {
                choiceService.getChoicesForQuestion(ability, theChosenOne);
                theChosenOne.setAppliedDifficulty(ability);
            }

            setDisplayInfo(theChosenOne, user, false, 0, false, ability);

        } else if (nonAnswered.size() == 0) {

            System.out.println("I WILL BE ANY ANS WRONG!!!!");

            double diff_increase_ratio = 2;

            //from all the questions, get first the ones he got wrong, and offer them with easier difficulty!!
            //then, ultimately, offer the questions he answered correctly but with much greater difficulty

            // this includes the reasoning quesitions
            List<Question> allWrongQs = questionService.getAllCurrentlySTILLWrongQuestions(user, ki);

            if (allWrongQs.size() > 0) {

                Collections.shuffle(allWrongQs);
                theChosenOne = allWrongQs.get(0);

                double low = questionActivityService.getLatestDiffAppliedForWrong(user, theChosenOne);

                System.out.println("chosen :: " + theChosenOne.toString());
                System.out.println("low :: " + low);


                //apply about 1/2 of the lowest difficulty previously applied
                double new_difficulty = low * diff_decrease_ratio;
                System.out.println(new_difficulty);

                choiceService.getChoicesForQuestion(new_difficulty, theChosenOne);
                theChosenOne.setAppliedDifficulty(new_difficulty);


                setDisplayInfo(theChosenOne, user, true, low, false, ability);

            } else {

                System.out.println("I WILL BE ANY ANS CORRECT!!!!");
                List<Question> allCorrectQs = questionService.getAllCorrectQuestions(user, ki);

                Collections.shuffle(allCorrectQs);
                theChosenOne = allCorrectQs.get(0);

                double high = questionActivityService.getLatestDiffAppliedForCorrect(user, theChosenOne);


                //apply about 1.5 times more diff
                double new_difficulty = high + diff_increase_ratio;

                if (new_difficulty >= 5) {
                    new_difficulty = 4.9;
                }
                System.out.println(new_difficulty);

                System.out.println("high :: " + high);

                choiceService.getChoicesForQuestion(new_difficulty, theChosenOne);
                theChosenOne.setAppliedDifficulty(new_difficulty);

     /*           theChosenOne.setAnsweredBefore(true);
                theChosenOne.setLastPrevAppDiff(high);
                theChosenOne.setLatestStatus(true);*/

                setDisplayInfo(theChosenOne, user, true, high, true, ability);
            }

        }


 /*       else {

            System.out.println(nonAnswered.toString());

            theChosenOne = nonAnswered.get(0);

            choiceService.getChoicesForQuestion(ability, theChosenOne);

            setDisplayInfo(theChosenOne, user, false, 0, false, ability);

            Collections.shuffle(nonAnswered);


        }*/

        return theChosenOne;
    }

    public void setDisplayInfo(Question q, User user, boolean ansBefore, double diff, boolean latestStatus, double ability) {

        q.setAnsweredBefore(ansBefore);
        q.setLastPrevAppDiff(diff);
        q.setLatestStatus(latestStatus);


        q.setCurrentAbility(ability);

        q.setNoOfPreviousAnswers(questionActivityService.getNumberOfAnswerTimesTotal(user, q));
        q.setNoOfPreviousCorrectAnswers(questionActivityService.getNumberOfAnswerTimesCorrect(user, q));
        q.setNoOfPreviousWrongAnswers(questionActivityService.getNumberOfAnswerTimesWrong(user, q));

    }


}
