package com.slearn.KI;

import com.slearn.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * Created by E-M on 5/4/2017.
 */

public interface KnowledgeItemRepository extends CrudRepository<KnowledgeItem, Long> {

    @Query("select distinct ki from KnowledgeItem ki inner join ki.knowledgeItemScores kis where kis.user.id = :idUser and kis.knowledgeItem.lesson.id = :idLesson and (kis.theoreticalQsAnswered > 0 or kis.reasoningQsAnswered > 0)")
    List<KnowledgeItem> getAllTackledKIsForUserAndLesson(@Param("idUser") long idUser, @Param("idLesson") long idLesson);


    /**
     * this only returns the next KI that has not been "touched" ;) by the current user
     *
     * @param idUser
     * @param pageable
     * @return
     */
    @Query("select distinct ki from KnowledgeItem ki inner join ki.knowledgeItemScores kis where kis.user.id = :idUser and kis.knowledgeItem.lesson.id = :idLesson and  (kis.theoreticalQsAnswered = 0 and kis.reasoningQsAnswered = 0)")
    List<KnowledgeItem> getNextUNTackledKIforUserAndLesson(@Param("idUser") long idUser , @Param("idLesson") long idLesson, Pageable pageable);

}
