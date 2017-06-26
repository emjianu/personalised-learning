package com.slearn.questionActivity;

import com.slearn.lesson.Lesson;
import com.slearn.question.Question;
import com.slearn.question.QuestionRepository;
import com.slearn.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by E-M on 4/24/2017.
 */
@Service
public class QuestionActivityService {

    @Autowired
    private QuestionActivityRepository questionActivityRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionActivity addQuestionActivity(QuestionActivity qa){

        try{

          qa =  questionActivityRepository.save(qa);
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return qa;
    }

    public QuestionActivity getById(long id){

        QuestionActivity qa = null;
        try{

            qa =  questionActivityRepository.findOne(id);
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return qa;
    }

    //return the lowest difficulty applied for a question ever for a user
    public double getLatestDiffAppliedForWrong(User user, Question question){

        long id = questionActivityRepository.getLowestDiffByUserAndQuestion(user.getId(), question.getId(), false);

        return getById(id).getDifficulty();
    }


    //return the highest difficulty applied for a question ever for a user
    public double getLatestDiffAppliedForCorrect(User user, Question question){

        long id = questionActivityRepository.getHighestDiffByUserAndQuestion(user.getId(), question.getId(), true);

        return getById(id).getDifficulty();
    }


    public long getLatestID(User user, Question question, boolean status){
        long id = 0;
        System.out.println("for q "+ question.getQuestionText()+" "+status);

        try {


                id = questionActivityRepository.getHighestDiffByUserAndQuestion(user.getId(), question.getId(), status);




        } catch(Exception ex){
            ex.printStackTrace();
        }
        return id;
    }


    public long getLatestQForUser(User user) {

        long id = questionActivityRepository.getLatestByUser(user.getId());
        return id;
    }


    public Question getOldestWrongQForUserAndLesson(User user, Lesson lesson) {

        long id = questionActivityRepository.getOldestByUserAndLessonAndAnswer(user.getId(),lesson.getId(), false);

        Question q = questionRepository.findOne(id);

        return q;
    }


    public Question getOldestWrongQForUser(User user) {

        long id = questionActivityRepository.getOldestByUserAndAnswer(user.getId(), false);

        Question q = questionRepository.findOne(id);

        return q;
    }



    public long getLatestForUserAndQ(User user, Question question) {

        long id = questionActivityRepository.getLatestByUserAndQuestion(user.getId(), question.getId());

        return id;
    }


    //how many times the user answer this question correctly
    public int getNumberOfAnswerTimesCorrect(User user, Question question){

        int n = questionActivityRepository.getNoOfTimesByStatus(user.getId(), question.getId(), true);

        return n;
    }


    //how many times the user answer this question correctly
    public int getNumberOfAnswerTimesWrong(User user, Question question){

        int n = questionActivityRepository.getNoOfTimesByStatus(user.getId(), question.getId(), false);

        return n;
    }

    //how many times the user answer this question total
    public int getNumberOfAnswerTimesTotal(User user, Question question){

        int n = questionActivityRepository.getTotalNoOfAnswers(user.getId(), question.getId());

        return n;
    }



}
