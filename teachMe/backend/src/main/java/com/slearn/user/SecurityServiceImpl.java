package com.slearn.user;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by E-M on 5/13/2017.
 */
@Service
public class SecurityServiceImpl {


    @Autowired
    private AuthenticationManager authenticationManager;

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

    public void autologin(String username, String password) {

        System.out.println("in autologin");
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        System.out.println("user details: "+userDetails.toString());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        System.out.println("token: "+usernamePasswordAuthenticationToken.toString());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

     /*   if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            //logger.debug(String.format("Auto login %s successfully!", username));
        }*/
    }
}