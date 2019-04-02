package com.jj.ecertification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.ecertification.model.UserResponse;
import com.jj.ecertification.repository.UserResponseRepository;

@Service
public class UserResponseService {

	@Autowired
	private UserResponseRepository userResponseRepository;
	
	public void save(List<UserResponse> userResponse) {
		userResponseRepository.saveAll(userResponse);
	}
}
