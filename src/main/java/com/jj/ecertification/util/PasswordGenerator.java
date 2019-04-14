package com.jj.ecertification.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static String encoded(String password) {
		BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
		return encrypt.encode(password);
	}
}
