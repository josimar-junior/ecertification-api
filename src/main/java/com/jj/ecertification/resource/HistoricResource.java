package com.jj.ecertification.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jj.ecertification.model.Historic;
import com.jj.ecertification.service.HistoricService;

@RestController
@RequestMapping("/historic")
public class HistoricResource {

	@Autowired
	private HistoricService historicService;
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Historic historic, @AuthenticationPrincipal String userName) {
		historic = historicService.save(historic, userName);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(historic.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Historic>> findAll(@AuthenticationPrincipal String userName) {
		return ResponseEntity.ok(historicService.findAll(userName));
	}
}
