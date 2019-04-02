package com.jj.ecertification.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Void> save(@Valid @RequestBody List<UserResponse> userResponse) {
		userResponseService.save(userResponse);
		return ResponseEntity.noContent().build();
	}
}
