package com.slearn.questionActivity;

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



}
