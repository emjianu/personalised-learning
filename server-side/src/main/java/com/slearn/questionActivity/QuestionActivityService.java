package com.slearn.questionActivity;

import com.slearn.question.Question;
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

    public QuestionActivity addQuestionActivity(QuestionActivity qa){

        try{

          qa =  questionActivityRepository.save(qa);
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return qa;
    }

    //return the lowest difficulty applied for a question ever for a user
    public double getLowestDiffApplied(User user, Question question){

        double l = questionActivityRepository.getLowestDiffByUserAndQuestion(user.getId(), question.getId());

        return l;
    }



}
