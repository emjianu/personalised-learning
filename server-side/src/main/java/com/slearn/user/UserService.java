package com.slearn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by E-M on 4/22/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUserById(Long userId) {

        User user = null;

        try {
            user = userRepository.findOne(userId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public User saveOrUpdateUser(User user) {

        try {
            user = userRepository.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }


}
