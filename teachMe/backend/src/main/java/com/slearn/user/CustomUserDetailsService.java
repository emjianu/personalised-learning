package com.slearn.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * for using spring security automated login with email instead of username, the
 * UserDetailsInterface must be implemented
 * 
 * @author E-M
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;


	// for spring security login
	// change the default property that is searched for to EMAIL; default was
	// USERNAME
	@Override
	public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			//user = userService.getUserByEmail(email);

			user = userService.getUserByUsername(username);
			System.out.println("found: "+user.toString());

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return new CurrentUser(user);
	}


}
