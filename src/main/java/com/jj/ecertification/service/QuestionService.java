package com.jj.ecertification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.ecertification.model.Question;
import com.jj.ecertification.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questions;
	
	public Question save(Question question) {
		addQuestionInStatement(question);
		return questions.save(question);
	}
	
	public List<Question> listQuestionsCertification(Long idCertification) {
		return questions.listQuestionByIdCertification(idCertification);
	}

	private void addQuestionInStatement(Question question) {
		if(!question.getStatements().isEmpty()) {
			question.getStatements().forEach(sta -> {
				sta.setQuestion(question);
			});
		}
	}
}
