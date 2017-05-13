package com.slearn.choice;

import java.util.List;


import com.slearn.category.Category;
import com.slearn.choice.Choice;
import com.slearn.question.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends CrudRepository<Choice, Long> {


    Choice findByCategoryAndQuestion(Category category, Question question);


}