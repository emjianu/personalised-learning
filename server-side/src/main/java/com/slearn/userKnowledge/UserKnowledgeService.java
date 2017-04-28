package com.slearn.userKnowledge;

import com.slearn.KI.KnowledgeItem;
import com.slearn.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by E-M on 4/24/2017.
 */
@Service
public class UserKnowledgeService {


    @Autowired
    private UserKnowledgeRepository userKnowledgeRepo;

    public UserKnowledge getUserKnByUserAndKI(User user, KnowledgeItem ki) {

        UserKnowledge uk = null;

        try {
            uk = userKnowledgeRepo.findByUserAndKnowledgeItem(user, ki);
            if (uk == null) {

                uk = new UserKnowledge();
                uk.setUser(user);
                uk.setKnowledgeItem(ki);
                uk.setScore(2.5); //set it average

                uk = userKnowledgeRepo.save(uk);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return uk;
    }

    public UserKnowledge saveOrUpdate(UserKnowledge uk) {

        try {

            userKnowledgeRepo.save(uk);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return uk;
    }

}
