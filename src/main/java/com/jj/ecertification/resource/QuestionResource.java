package com.jj.ecertification.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jj.ecertification.model.Question;
import com.jj.ecertification.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionResource {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Question question) {
		question = questionService.save(question);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/certification/{id}")
	public ResponseEntity<List<Question>> listQuestionsCertification(@PathVariable Long id) {
		return ResponseEntity.ok(questionService.listQuestionsCertification(id));
	}
}
