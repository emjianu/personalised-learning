package com.slearn.user;

import org.jasypt.util.password.StrongPasswordEncryptor;
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
           // user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());

            user.setPassword(encryptedPassword);


            User check = userRepository.findByUsername(user.getUsername());

            //username exists!!!!
            //send an empty user with id 0
            if(check != null){
                user = new User();
                user.setId((long)0);
            } else {

                user.levelUp();
                user = userRepository.save(user);
            }
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
