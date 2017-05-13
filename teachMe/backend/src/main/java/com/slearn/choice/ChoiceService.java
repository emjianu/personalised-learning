package com.slearn.choice;

import com.slearn.category.Category;
import com.slearn.category.CategoryService;
import com.slearn.question.Question;
import com.slearn.question.QuestionRepository;
import com.slearn.question.QuestionService;
import com.slearn.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by E-M on 3/6/2017.
 */
@Service
public class ChoiceService {

    @Autowired
    QuestionService questionService;

    @Autowired
    ChoiceRepository choiceRepository;


    @Autowired
    CategoryService categoryService;

    //sets current choices for a question, according to difficulty
    public void getChoicesForQuestion(double difficulty, Question q) {
    /*    Question q = null;*/
        try {

           /* q = questionService.getQuestionById(questionId);*/
            for(Choice c: q.getAnswerChoices()){
                c = choiceRepository.findOne(c.getId());
             /*   if(c.getCategory().getMin() <= difficulty && c.getCategory().getMax() > difficulty && difficulty < 3){
                    System.out.println("chosen "+difficulty);
                    q.addCurrentChoice(c);
                } else     && difficulty >= 3*/
                if(c.getCategory().getMin() < difficulty && c.getCategory().getMax() >= difficulty ){
                    System.out.println("chosen "+difficulty);
                    q.addCurrentChoice(c);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

   /*     return q;*/

    }


    public Choice getChoiceById(long id){
        Choice c = null;
        try{
           c = choiceRepository.findOne(id);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return c;
    }


    public Choice getCorrectChoiceForQuestion(Question question){

        Category correctCategory = categoryService.getCorrectChoiceCategory();

        Choice c = null;
        try{
            c = choiceRepository.findByCategoryAndQuestion(correctCategory, question);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return c;
    }





}
