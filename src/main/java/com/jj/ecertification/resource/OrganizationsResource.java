package com.jj.ecertification.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jj.ecertification.model.Organization;
import com.jj.ecertification.service.OrganizationService;

@RestController
@RequestMapping("/organizations")
public class OrganizationsResource {

	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping
	public ResponseEntity<List<Organization>> findAll() {
		return ResponseEntity.ok(organizationService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Organization organization) {
		organization = organizationService.save(organization);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(organization.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Organization organization, @PathVariable Long id) {
		organization.setId(id);
		organizationService.update(organization);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		organizationService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
