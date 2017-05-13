package com.slearn.questionActivity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by E-M on 4/24/2017.
 */
public interface QuestionActivityRepository extends CrudRepository<QuestionActivity, Long> {


    //select the newest record for wrong answer by user and question
    @Query("select min(qa.id) from QuestionActivity qa where qa.user.id = :userId and qa.question.id = :qId and qa.status = :status")
    public long getLowestDiffByUserAndQuestion(@Param("userId") long userId, @Param("qId") long qId, @Param("status") boolean status);


    //select the newest record for right answer by user and question
    @Query("select max(qa.id) from QuestionActivity qa where qa.user.id = :userId and qa.question.id = :qId and qa.status = :status")
    public long getHighestDiffByUserAndQuestion(@Param("userId") long userId, @Param("qId") long qId, @Param("status") boolean status);


    //how many times a user answered a question - TOTAL
    @Query("select count(qa.id) from QuestionActivity qa where qa.user.id = :userId and qa.question.id = :qId")
    public int getTotalNoOfAnswers(@Param("userId") long userId, @Param("qId") long qId);


    //how many times a user answered a question correctly
    @Query("select count(qa.id) from QuestionActivity qa where qa.user.id = :userId and qa.question.id = :qId and qa.status = :status")
    public int getNoOfTimesByStatus(@Param("userId") long userId, @Param("qId") long qId, @Param("status") boolean status);


}
