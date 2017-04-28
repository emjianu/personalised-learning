package com.slearn.question;

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

    private double q_weight = 0.2;



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

    public Question getQuestionByIdAndDiff(long questionId, double diff) {
        Question question = null;
        try {

            System.out.println("find q");
            question = questionRepository.findOne(questionId);


            System.out.println("q: " + question.toString());

            choiceService.getChoicesForQuestion(diff, question);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return question;

    }




    public QuestionFeedback handleAnsweredQuestion(UserAnswer userAnswer){

        Question answeredQuestion = questionRepository.findOne((long)userAnswer.getQuestionId());
        Choice correct = choiceService.getCorrectChoiceForQuestion(answeredQuestion);

        User user = userService.getUserById((long)userAnswer.getUserid());


        QuestionActivity qa = new QuestionActivity();

        qa.setQuestion(answeredQuestion);
        qa.setUser(user);
        qa.setLesson(answeredQuestion.getLesson());
        qa.setDifficulty(userAnswer.getAppliedDifficulty());

        UserKnowledge uk = userKnowledgeService.getUserKnByUserAndKI(user, answeredQuestion.getKnowledgeItem());
        double previousScore = uk.getScore();

        System.out.println("prev: "+previousScore);


        QuestionFeedback qf = new QuestionFeedback();
        qf.setAnsweredQuestion(answeredQuestion);


        if(correct.getId() == Long.parseLong(userAnswer.getAnswerId())){
            //answered correctly
            qa.setStatus(true);
            qf.setWasCorrect(true);


            if(previousScore < 4.9) {
                uk.setScore(previousScore + q_weight);
            }

        } else {
            //answered incorrectly
            qa.setStatus(false);
            qf.setWasCorrect(false);



            if(previousScore > 0.2) {

                System.out.println("should be "+(previousScore - q_weight));
                uk.setScore(previousScore - q_weight);

                System.out.println("should be "+uk.getScore());
            }

        }

        questionActivityService.addQuestionActivity(qa);

        userKnowledgeService.saveOrUpdate(uk);

        return qf;


    }



    public Question getHelperQuestion(long questionId){

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
