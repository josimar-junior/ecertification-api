package com.jj.ecertification.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SystemUser extends User {

	private static final long serialVersionUID = -1831737539606657346L;

	private com.jj.ecertification.model.User user;

	public SystemUser(com.jj.ecertification.model.User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getEmail(), user.getPassword(), authorities);
		this.user = user;
	}

	public com.jj.ecertification.model.User getUser() {
		return user;
	}
}
