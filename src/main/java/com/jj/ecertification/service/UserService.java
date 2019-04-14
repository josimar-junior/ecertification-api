package com.jj.ecertification.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.ecertification.model.Permission;
import com.jj.ecertification.model.User;
import com.jj.ecertification.repository.PermissionRepository;
import com.jj.ecertification.repository.UserRepository;
import com.jj.ecertification.util.PasswordGenerator;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	public User save(User user) {
		user.setActive(true);
		user.setPassword(PasswordGenerator.encoded(user.getPassword()));
		user.setPermissions(getPermissions());
		return userRepository.save(user);
	}
	
	private List<Permission> getPermissions() {
		return permissionRepository.findByIdIn(Arrays.asList(3L, 7L));
	}
}
