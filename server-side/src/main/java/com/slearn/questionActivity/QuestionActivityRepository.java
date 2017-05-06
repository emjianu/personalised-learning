package com.slearn.questionActivity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by E-M on 4/24/2017.
 */
public interface QuestionActivityRepository extends CrudRepository<QuestionActivity, Long> {


    @Query("select min(qa.difficulty) from QuestionActivity qa where qa.user.id = :userId and qa.question.id = :qId")
    public double getLowestDiffByUserAndQuestion(@Param("userId") long userId, @Param("qId") long qId);

}
