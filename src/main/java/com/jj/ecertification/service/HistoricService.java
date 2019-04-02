package com.jj.ecertification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.ecertification.model.Historic;
import com.jj.ecertification.repository.HistoricRepository;
import com.jj.ecertification.security.AppUserDetailsService;
import com.jj.ecertification.security.SystemUser;

@Service
public class HistoricService {

	@Autowired
	private HistoricRepository historicRepository;
	
	@Autowired
	private AppUserDetailsService userDetailsService;
	
	public Historic save(Historic historic, String userName) {
		SystemUser systemUser = (SystemUser) userDetailsService.loadUserByUsername(userName);
		historic.setUser(systemUser.getUser());
		return historicRepository.save(historic);
	}
	
	public List<Historic> findAll(String userName) {
		SystemUser systemUser = (SystemUser) userDetailsService.loadUserByUsername(userName);
		return historicRepository.findByUserOrderByDateDesc(systemUser.getUser());
	}
}
