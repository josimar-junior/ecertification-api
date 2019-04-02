package com.jj.ecertification.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jj.ecertification.model.Certification;
import com.jj.ecertification.model.Detail;
import com.jj.ecertification.model.dto.CertificationDTO;
import com.jj.ecertification.model.filter.CertificationFilter;
import com.jj.ecertification.service.CertificationService;

@RestController
@RequestMapping("/certifications")
public class CertificationResource {

	@Autowired
	private CertificationService certificationService;
	
	@GetMapping
	public ResponseEntity<List<CertificationDTO>> list(CertificationFilter filter) {
		return ResponseEntity.ok(certificationService.list(filter));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Certification> findById(@PathVariable Long id) {
		return ResponseEntity.ok(certificationService.findById(id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> save(@Valid @RequestBody Certification certification) {
		certification = certificationService.save(certification);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(certification.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}/details")
	public ResponseEntity<List<Detail>> details(@PathVariable Long id) {
		return ResponseEntity.ok(certificationService.details(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Certification certification, @PathVariable Long id) {
		certificationService.update(certification, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		certificationService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
