package com.slearn.user;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.logging.Logger;

/**
 * Created by E-M on 5/13/2017.
 */
@Service
public class SecurityServiceImpl {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

   /* private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);*/

/*    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }*/

    public User autologin(String username, String password) {


        User user = userService.getUserByUsername(username);

        if (user == null) {
            user = new User();
            user.setId((long) 0);
            return user;
        } else {

            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            String encryptedPassword = passwordEncryptor.encryptPassword(password);

            System.out.println("enc :: " + encryptedPassword);

            if (passwordEncryptor.checkPassword(password, user.getPassword())) {
                System.out.println(" yes ! user :: " + user.toString());
                return user;
            } else {
                System.out.println(" it aint here ");
                user = new User();
                user.setId((long) 0);
                return user;
            }

        }


   /*     System.out.println("in autologin "+username +" "+password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        System.out.println("user details: "+userDetails.toString());
        //UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());

        System.out.println("token: "+usernamePasswordAuthenticationToken.toString());


        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);*/


     /*   if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            //logger.debug(String.format("Auto login %s successfully!", username));
        }*/
    }
}