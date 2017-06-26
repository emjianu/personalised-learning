package com.slearn.question;

import com.slearn.lesson.Lesson;
import com.slearn.lesson.LessonService;

import com.slearn.user.User;
import com.slearn.user.UserService;
import com.slearn.util.QAMap;
import com.slearn.util.QuestionFeedback;
import com.slearn.util.QuestionQAns;
import com.slearn.util.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by E-M on 3/5/2017.
 */
@Controller
public class QuestionCtrl {

    @Autowired
    QuestionService questionService;


    @Autowired
    UserService userService;

    @Autowired
    QuestionPoolingService qps;

    @Autowired
    LessonService lessonService;

   /* @ResponseBody
    @RequestMapping(value = "/tests/{testid}", method = RequestMethod.GET)
    public List<Question> getTestQuestions(@PathVariable long testid) {

        System.out.println("in java ctrl");
        List<Question> questions = questionService.getQuestionsForTest(testid);



    *//*  Question q = questionService.getParentQuestionById();*//*
  *//*  System.out.println("in java ctrl "+q.toString());*//*

        return questions;
    }
*/
    @ResponseBody
    @RequestMapping(value = "lessons/{lessonid}/users/{userid}/question", method = RequestMethod.GET)
    public Question getTestQuestions(@PathVariable long lessonid, @PathVariable long userid) {

        System.out.println("did my lovely java receive my lovely params???? DID IT FUCKING GET THEM "+lessonid+" "+userid);

        User user = userService.getUserById(userid);
        Lesson lesson = lessonService.getLessonById(lessonid);

        Question theChosenOne = qps.nextQuestion(lesson, user, 2);

       // Question theChosenOne = questionService.getQuestionByIdAndDiff(4, 2.5);


        Collections.shuffle(theChosenOne.getCurrentChoices());

    /*  Question q = questionService.getParentQuestionById();*/
  /*  System.out.println("in java ctrl "+q.toString());*/

        return theChosenOne;
    }


    @ResponseBody
    @RequestMapping(value = "/lessons/{lessonid}/question/answer", method = RequestMethod.POST)
    public QuestionFeedback receiveAnswer(@PathVariable long lessonid, @RequestBody UserAnswer input) {

        System.out.println("did my lovely java receive my lovely params???? DID IT FUCKING GET THEM "+lessonid+" "+input.getUserid()+" qid: "+input.getQuestionId()+" ans: "+input.getAnswerId() );

        QuestionFeedback qf = questionService.handleAnsweredQuestion(input);

        return qf;
    }



/*    @ResponseBody
    @RequestMapping(value = "/tests/{testid}/submit", method = RequestMethod.POST)
    public List<Question> getHelperQuestions(@PathVariable long testid,@RequestBody QAMap answerMap) {

        System.out.println("RECEIVED LIST OF ANSWERED QS");



        System.out.println("ans:::: "+answerMap.getAnswerMap().toString());
        List<Question> questions = questionService.getQuestionsForTest(testid);

        testService.processAnswers(answerMap.getAnswerMap());


    *//*  Question q = questionService.getParentQuestionById();*//*
  *//*  System.out.println("in java ctrl "+q.toString());*//*

        return questions;
    }*/



}
