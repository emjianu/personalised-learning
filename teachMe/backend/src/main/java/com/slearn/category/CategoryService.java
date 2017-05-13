package com.slearn.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by E-M on 4/22/2017.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    //this will always return category with id 11 - the correct choice for a question will have this category
    public Category getCorrectChoiceCategory(){
        return categoryRepository.findOne((long)11);
    }

}
