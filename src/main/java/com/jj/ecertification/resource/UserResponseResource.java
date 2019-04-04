package com.jj.ecertification.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jj.ecertification.model.UserResponse;
import com.jj.ecertification.service.UserResponseService;

@RestController
@RequestMapping("/user-response")
public class UserResponseResource {

	@Autowired
	private UserResponseService userResponseService;
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody List<UserResponse> userResponse, @AuthenticationPrincipal String userName) {
		userResponseService.save(userResponse, userName);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{id}/certification/{idCertification}")
	public ResponseEntity<List<UserResponse>> listAllByCertification(@PathVariable Long id, @PathVariable Long idCertification, @AuthenticationPrincipal String userName) {
		return ResponseEntity.ok(userResponseService.listAllByCertification(id, idCertification, userName));
	}
}
