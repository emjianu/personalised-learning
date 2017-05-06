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

        if (kni.size() > 0) {
            kis.addAll(kni);
        }

        Collections.shuffle(kis);

        //dont matter cuz its shuffled
        KnowledgeItem chosenKI = kis.get(0);

        System.out.println(chosenKI);


        //for testing use the first ki
        KnowledgeItem test = knowledgeItemService.getById((long) 1);

        //should be return chosen ki;
        return test;

    }

    public Question getRandomTheoreticalQuestion(User user, KnowledgeItem ki, double ability) {

        Question theChosenOne = null;

        double diff_decrease_ratio = (double) 1 / 2;

        List<Question> nonAnswered = questionService.getTheoreticalUnansweredQuestions(user, ki);

        //we still have unanswered theoretical questions
        if (nonAnswered.size() > 0) {

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

        } else {
            //HERE A WRONG QUESTION CAN BE BROUGHT UP SEVERAL TIMES AFTER IT HAS BEEN CORRECTLY ANSWERED!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //from all the questions, get first the ones he got wrong, and offer them with easier difficulty!!
            //then, ultimately, offer the wquestions he answered correctly but with much greater difficulty
            List<Question> allWrongThQs = questionService.getAllCurrentlySTILLWrongTheoreticalQuestions(user, ki);
            Collections.shuffle(allWrongThQs);

            theChosenOne = allWrongThQs.get(0);

            double low = questionActivityService.getLowestDiffApplied(user, theChosenOne);

            System.out.println("chosen :: " + theChosenOne.toString());

            System.out.println("low :: " + low);


            //apply about 2/3 of the lowest difficulty
            double new_difficulty = low * diff_decrease_ratio;
            System.out.println(new_difficulty);

            choiceService.getChoicesForQuestion(new_difficulty, theChosenOne);
            theChosenOne.setAppliedDifficulty(new_difficulty);


        }


        return theChosenOne;
    }


    public Question getRandomQuestionIncludingReasoning(User user, KnowledgeItem ki, double ability) {

        List<Question> nonAnswered = questionService.getAllUnansweredQuestions(user, ki);

        Collections.shuffle(nonAnswered);

        return nonAnswered.get(0);
    }


}
