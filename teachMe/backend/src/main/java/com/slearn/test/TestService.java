package com.slearn.test;


import com.slearn.choice.Choice;
import com.slearn.choice.ChoiceService;
import com.slearn.question.Question;
import com.slearn.question.QuestionService;
import com.slearn.util.QuestionQAns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;


    @Autowired
    ChoiceService choiceService;

    @Autowired
    QuestionService questionService;

    public Test getTestByName(long testId) {
        Test t = null;
        try {

            t = testRepository.findByName("T" + testId);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return t;

    }

    public Test getTestById(long testId) {
        Test t = null;
        try {

            t = testRepository.findOne(testId);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return t;

    }


    public List<Question> processAnswers(List<QuestionQAns> answers) {
        List<QuestionQAns> wrongAnswers = new ArrayList<>();

        for (QuestionQAns qa : answers) {
            Choice c = choiceService.getChoiceById(qa.getA());

            //if the choice is not the correct one(the correct choice has category with id 11 !!)
            if (c.getCategory().getId() != 11) {
                wrongAnswers.add(qa);
            }

        }

        List<Long> wrongQuestions =  getWrongQuestions(wrongAnswers);
        List<Question> helperQuestions = getHelperQuestions(wrongQuestions);

        return helperQuestions;

    }


    // return a list of question IDs with all the wrong questions that were answered
    public List<Long> getWrongQuestions(List<QuestionQAns> wrongAnswers) {
        List<Long> wrongQuestions = new ArrayList<>();

        wrongAnswers.forEach((qa) -> wrongQuestions.add(qa.getQ()));

        return wrongQuestions;

    }


    public List<Question> getHelperQuestions(List<Long> wrongQuestions){

        List<Question> helperQuestions = new ArrayList<>();

       for(long i: wrongQuestions){
          Question q =  questionService.getHelperQuestion(i);
           helperQuestions.add(q);

       }
        return helperQuestions;

    }


}