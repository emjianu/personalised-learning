package com.slearn.question;

import com.slearn.KI.KnowledgeItem;
import com.slearn.category.Category;
import com.slearn.category.CategoryService;
import com.slearn.choice.Choice;
import com.slearn.choice.ChoiceService;
import com.slearn.questionActivity.QuestionActivity;
import com.slearn.questionActivity.QuestionActivityService;
import com.slearn.test.Test;
import com.slearn.test.TestRepository;
import com.slearn.test.TestService;
import com.slearn.user.User;
import com.slearn.user.UserService;
import com.slearn.userKnowledge.UserKnowledge;
import com.slearn.userKnowledge.UserKnowledgeService;
import com.slearn.util.QuestionFeedback;
import com.slearn.util.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by E-M on 3/5/2017.
 */
@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    @Autowired
    TestService testService;

    @Autowired
    ChoiceService choiceService;

    @Autowired
    UserService userService;

    @Autowired
    UserKnowledgeService userKnowledgeService;

    @Autowired
    QuestionActivityService questionActivityService;

    @Autowired
    QuestionPoolingService questionPoolingService;

    //the amount of points deducted/added for answering wrong/correctly
    private double q_weight = 0.2;

    //the amount deducted/added in the total theoretical/reasoning score if answered wrong/correctly
    private double q_type_weight = 0.2;


    public List<Question> getQuestionsForTest(long testId) {
        List<Question> questions = null;

        try {

            Test t = testService.getTestById(testId);

       /*     questions = questionRepository.findByTest(t);*/
            double diff = 2.4;

            System.out.println("qq " + questions.toString());

            for (Question q : questions) {
                choiceService.getChoicesForQuestion(diff, q);

            /*    System.out.println(q.getCurrentChoices().toString());*/
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return questions;

    }


    public Question getQuestionById(long questionId) {
        Question question = null;
        try {

            System.out.println("find q");
            question = questionRepository.findOne(questionId);


            System.out.println("q: " + question.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return question;

    }

    public Question getQuestionByIdAndDiff(long questionID, double difficulty) {
        Question question = null;
        try {

            System.out.println("find q");
            question = questionRepository.findOne(questionID);


            System.out.println("q: " + question.toString());

            choiceService.getChoicesForQuestion(difficulty, question);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return question;

    }


    public QuestionFeedback handleAnsweredQuestion(UserAnswer userAnswer) {

        Question answeredQuestion = questionRepository.findOne((long) userAnswer.getQuestionId());
        Choice correct = choiceService.getCorrectChoiceForQuestion(answeredQuestion);

        User user = userService.getUserById((long) userAnswer.getUserid());


        //build a new Question Activity object
        QuestionActivity qa = new QuestionActivity();

        qa.setQuestion(answeredQuestion);
        qa.setUser(user);
        qa.setLesson(answeredQuestion.getLesson());
        qa.setKnowledgeItem(answeredQuestion.getKnowledgeItem());
        qa.setDifficulty(userAnswer.getAppliedDifficulty());

        //get the mapping between user and KI in order to update it
        UserKnowledge uk = userKnowledgeService.getUserKnByUserAndKI(user, answeredQuestion.getKnowledgeItem());
        double previousScore = uk.getScore();


        System.out.println("prev: " + previousScore);

        //a sort of interface for communicating with the front end, may change shape as we go
        QuestionFeedback qf = new QuestionFeedback();
        //qf.setAnsweredQuestion(answeredQuestion);


        //logic for updating according to answer
        if (correct.getId() == Long.parseLong(userAnswer.getAnswerId())) {
            //answered correctly
            qa.setStatus(true);
            qf.setCorrect(true);

            System.out.println("was correct "+correct.getId()+ " "+userAnswer.getAnswerId());
            System.out.println(qf.toString());

            if (previousScore < 4.9) {
                uk.setScore(previousScore + q_weight);
            }


        } else {
            //answered incorrectly
            qa.setStatus(false);
            qf.setCorrect(false);

            System.out.println(qf.toString());

            System.out.println("was incorrect "+correct.getId()+ " "+userAnswer.getAnswerId());

            if (previousScore > 0.2) {

                System.out.println("should be " + (previousScore - q_weight));
                uk.setScore(previousScore - q_weight);

                System.out.println("should be " + uk.getScore());
            }


        }

        user.setXp(userAnswer.getXp());
        user.setLevel(userAnswer.getLevel());

        //update also the total score for theoretical vs reasoning
        updateQuestionTypeScore(user, answeredQuestion, qf, uk);

        //update all in db
        questionActivityService.addQuestionActivity(qa);

        userKnowledgeService.saveOrUpdate(uk);

        userService.updateUser(user);

        System.out.println(qf.toString());

        //questionPoolingService.nextQuestion(answeredQuestion.getLesson(), user, 2);

        return qf;


    }

    public List<Question> getAllUnansweredQuestions(User user, KnowledgeItem knowledgeItem) {

        List<Question> allQs = questionRepository.findByKnowledgeItem(knowledgeItem);
        List<Question> answeredQs = questionRepository.findAnsweredQuestionsForUser(user.getId(), knowledgeItem.getId());

        System.out.println("all "+allQs.toString());
        System.out.println("answered "+answeredQs.toString());

        List<Question> unansweredQs = new ArrayList<>();

        for (Question q : allQs) {
            if (!answeredQs.contains(q)) {
                unansweredQs.add(q);
            }
        }

        return unansweredQs;
    }


    public List<Question> getTheoreticalUnansweredQuestions(User user, KnowledgeItem knowledgeItem) {

        List<Question> allThQs = questionRepository.findByKnowledgeItemAndType(knowledgeItem, 0);
        List<Question> answeredQs = questionRepository.findAnsweredQuestionsForUser(user.getId(), knowledgeItem.getId());

        System.out.println(allThQs.toString());
        System.out.println(answeredQs.toString());

        List<Question> unansweredQs = new ArrayList<>();

        for (Question q : allThQs) {
            if (!answeredQs.contains(q)) {
                unansweredQs.add(q);
            }
        }

        return unansweredQs;
    }


    public List<Question> getAllTheoreticalQuestions(User user, KnowledgeItem knowledgeItem) {

        List<Question> allThQs = questionRepository.findByKnowledgeItemAndType(knowledgeItem, 0);

        System.out.println(allThQs.toString());

        return allThQs;
    }

    /**
     * get all the theoretical questions that the user answered wrong
     *
     * @param user
     * @param knowledgeItem
     * @return
     */
    public List<Question> getAllWrongTheoreticalQuestions(User user, KnowledgeItem knowledgeItem) {

        List<Question> allWrongThQs = questionRepository.getByUserAndKnowledgeItemAndTypeAndAnswer(user.getId(), knowledgeItem.getId(), 0, false);

        System.out.println(allWrongThQs.toString());

        return allWrongThQs;
    }



    /**
     *
     * get all the theoretical questions that the user answered correctly
     *
     * @param user
     * @param knowledgeItem
     * @return
     */
    public List<Question> getAllCorrectTheoreticalQuestions(User user, KnowledgeItem knowledgeItem) {

        List<Question> allCorrectThQs = questionRepository.getByUserAndKnowledgeItemAndTypeAndAnswer(user.getId(), knowledgeItem.getId(), 0, true);

        System.out.println(allCorrectThQs.toString());

        return allCorrectThQs;
    }


    public List<Question> getAllCorrectQuestions(User user, KnowledgeItem knowledgeItem) {

        List<Question> allCorrectQs = questionRepository.getByUserAndKnowledgeItemAndAnswer(user.getId(), knowledgeItem.getId(), true);

        System.out.println(allCorrectQs.toString());

        return allCorrectQs;
    }


    /**
     *
     * get all the theoretical questions that the user still has not answered correctly
     *
     * sometimes the user gets questions wrong, and its ok because i got his back. i can reask
     * the same questions but with lower difficulty so that he can get them right this time
     *
     * @param user
     * @param knowledgeItem
     * @return
     */
    public List<Question> getAllCurrentlySTILLWrongTheoreticalQuestions(User user, KnowledgeItem knowledgeItem) {

        List<Question> allSTILLWrong = new ArrayList<>();

        List<Question> allWrongThQs = questionRepository.getByUserAndKnowledgeItemAndTypeAndAnswer(user.getId(), knowledgeItem.getId(), 0, false);

        List<Question> allCorrectThQs = questionRepository.getByUserAndKnowledgeItemAndTypeAndAnswer(user.getId(), knowledgeItem.getId(), 0, true);

        for(Question wrong: allWrongThQs){


            long lastWrong = questionActivityService.getLatestID(user,wrong,false);

            long lastCorrect = questionActivityService.getLatestID(user,wrong,true);
            System.out.println(" 1 LAST WRONG::: "+lastWrong+" LAST CORRECT:: "+lastCorrect);

            if(!allCorrectThQs.contains(wrong) || lastCorrect < lastWrong){
                allSTILLWrong.add(wrong);


                System.out.println("I'M SPECIAL. HI, SPECIAL, I'M TIRED. 1");
            }
        }

        System.out.println(allWrongThQs.toString());

        return allSTILLWrong;
    }



    public List<Question> getAllCurrentlySTILLWrongQuestions(User user, KnowledgeItem knowledgeItem) {

        List<Question> allSTILLWrong = new ArrayList<>();

        List<Question> allWrongQs = questionRepository.getByUserAndKnowledgeItemAndAnswer(user.getId(), knowledgeItem.getId(), false);

        List<Question> allCorrectQs = questionRepository.getByUserAndKnowledgeItemAndAnswer(user.getId(), knowledgeItem.getId(), true);

        for(Question wrong: allWrongQs){

            long lastWrong = questionActivityService.getLatestID(user,wrong,false);

            long lastCorrect = questionActivityService.getLatestID(user,wrong,true);


            System.out.println("LAST WRONG::: "+lastWrong+" LAST CORRECT:: "+lastCorrect);

            if(!allCorrectQs.contains(wrong) || lastCorrect < lastWrong){
                allSTILLWrong.add(wrong);

                System.out.println("I'M SPECIAL. HI, SPECIAL, I'M TIRED.");

            }
        }

        System.out.println(allWrongQs.toString());

        return allSTILLWrong;
    }



    public void updateQuestionTypeScore(User user, Question q, QuestionFeedback qf, UserKnowledge uk) {

        boolean isTheoretical = (q.getType() == 0);
        boolean isReasoning = (q.getType() == 1);

        double newScore = 0;

        if (isTheoretical) {
            double thScore = user.getTheoryScore();
            int thQsAnswered = uk.getTheoreticalQsAnswered();

            if (qf.isCorrect()) {
                newScore = thScore + q_type_weight;
            } else {
                newScore = thScore - q_type_weight;
            }

            //user.setTheoryScore(newScore);
            uk.setTheoreticalQsAnswered(thQsAnswered + 1);

        } else if (isReasoning) {

            double reScore = user.getReasoningScore();
            int reQsAnswered = uk.getReasoningQsAnswered();

            if (qf.isCorrect()) {
                newScore = reScore + q_type_weight;
            } else {
                newScore = reScore - q_type_weight;
            }

            //user.setReasoningScore(newScore);
            uk.setTheoreticalQsAnswered(reQsAnswered + 1);
        }


    }


    public Question getHelperQuestion(long questionId) {

        Question helper = null;

        System.out.println("helper q-----");
/*
        Question currentWrongQuestion = getQuestionById(questionId);
        List<Long> wordIds = new ArrayList<>();
        currentWrongQuestion.getTags().forEach((tag) -> wordIds.add(tag.getWord().getId()));

        System.out.println("similar----- "+wordIds.toString());

        List<Question> similar = questionRepository.findSimilarQuestions(wordIds, currentWrongQuestion.getId());
        System.out.println("similar----- found  "+similar.size()+" results");

        System.out.println(similar.toString());*/

        /*IDENTIFY THE BEST QUESTION
        scores for each question
        *
        *
        * */


        return null;


    }


/*
    public Question getParentQuestionById() {
        Question question = null;
        try {

            System.out.println("find q");
            Question q = questionRepository.findOne((long)475);
            System.out.println("found q "+q.toString());
            question = questionRepository.findParentQuestion(q);


            System.out.println("q: "+question.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return question;

    }*/


}
