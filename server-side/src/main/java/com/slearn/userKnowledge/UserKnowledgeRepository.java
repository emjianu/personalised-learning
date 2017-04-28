package com.slearn.userKnowledge;

import com.slearn.KI.KnowledgeItem;
import com.slearn.user.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by E-M on 4/24/2017.
 */
public interface UserKnowledgeRepository extends CrudRepository<UserKnowledge, Long> {


        UserKnowledge findByUserAndKnowledgeItem(User user, KnowledgeItem knowledgeItem);


}
