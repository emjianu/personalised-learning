package com.slearn.user;

import org.springframework.security.core.authority.AuthorityUtils;

//a way of storing the current logged in user
public class CurrentUser extends org.springframework.security.core.userdetails.User {

	/**
	 * extension of spring security User model class
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	public CurrentUser(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList("USER"));
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CurrentUser [user=" + user + "]";
	}

}
