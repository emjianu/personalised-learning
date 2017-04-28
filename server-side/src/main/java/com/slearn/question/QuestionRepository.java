package com.slearn.question;

import java.util.List;


import com.slearn.test.Test;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

 /*   List<Question> findByTest(Test test);*/

    //finds all the questions that share these keywords
    @Query( "SELECT distinct q from Question q inner join q.tags qt where qt.word.id in :wordIds and qt.question.id <> :currentQuestionId" )
    List<Question> findSimilarQuestions(@Param("wordIds") List<Long> wordIds, @Param("currentQuestionId") long currentQuestionId);



   //Question findParentQuestion(@Param("questionId") Question question);
}