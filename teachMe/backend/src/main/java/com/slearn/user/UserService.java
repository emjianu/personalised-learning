package com.slearn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public User getUserByEmail(String email) {

        User user = null;

        try {
            user = userRepository.findByEmail(email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public User getUserByUsername(String username) {

        User user = null;

        try {
            user = userRepository.findByUsername(username);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public User saveUser(User user) {

        try {

            // encrypt and set new password
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

            user = userRepository.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }


    public User updateUser(User user) {

        try {
            user = userRepository.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }


}
