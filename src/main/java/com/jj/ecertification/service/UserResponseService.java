package com.jj.ecertification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.ecertification.model.UserResponse;
import com.jj.ecertification.repository.UserResponseRepository;
import com.jj.ecertification.security.AppUserDetailsService;
import com.jj.ecertification.security.SystemUser;

@Service
public class UserResponseService {

	@Autowired
	private UserResponseRepository userResponseRepository;
	
	@Autowired
	private AppUserDetailsService userDetailsService;
	
	public void save(List<UserResponse> userResponse, String userName) {
		SystemUser systemUser = (SystemUser) userDetailsService.loadUserByUsername(userName);
		userResponse.forEach(u -> u.setUser(systemUser.getUser()));
		userResponseRepository.saveAll(userResponse);
	}
	
	public List<UserResponse> listAllByCertification(Long id, Long idCertification, String userName) {
		SystemUser systemUser = (SystemUser) userDetailsService.loadUserByUsername(userName);
		return userResponseRepository.listAllByCertification(idCertification, systemUser.getUser().getId(), id);
	}
}
