package com.jj.ecertification.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jj.ecertification.model.Organization;
import com.jj.ecertification.repository.OrganizationRepository;
import com.jj.ecertification.service.exception.OrganizationNotFoundException;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizations;
	
	public List<Organization> findAll() {
		return organizations.findAll();
	}
	
	public Organization save(@Valid @RequestBody Organization organization) {
		return organizations.save(organization);
	}
	
	public Organization findById(Long id) {
		return organizations.findById(id).orElseThrow(() -> new OrganizationNotFoundException("Organization not found."));
	}
	
	public void update(Organization organization) {
		checkForExistence(organization);
		organizations.save(organization);
	}
	
	public void delete(Long id) {
		organizations.deleteById(id);
	}
	
	private void checkForExistence(Organization organization) {
		findById(organization.getId());
	}
}
