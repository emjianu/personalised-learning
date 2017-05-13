package com.slearn.question;

import java.util.List;


import com.slearn.KI.KnowledgeItem;
import com.slearn.test.Test;

import com.slearn.user.User;
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


    List<Question> findByKnowledgeItem(KnowledgeItem knowledgeItem);

    List<Question> findByKnowledgeItemAndType(KnowledgeItem knowledgeItem, int type);

    @Query("select distinct q from Question q inner join q.questionActivities qa where qa.user.id = :userId and qa.knowledgeItem.id = :kiId")
    List<Question> findAnsweredQuestionsForUser( @Param("userId") long userId, @Param("kiId") long kiId);

    @Query("select distinct q from Question q inner join q.questionActivities qa where qa.user.id = :userId and qa.knowledgeItem.id = :kiId and qa.question.type = :type and qa.status = :ans")
    List<Question> getByUserAndKnowledgeItemAndTypeAndAnswer( @Param("userId") long userId, @Param("kiId") long kiId, @Param("type") int type, @Param("ans") boolean ans);

   //Question findParentQuestion(@Param("questionId") Question question);
}