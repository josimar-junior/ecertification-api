package com.jj.ecertification.repository.question;

import java.util.List;

import com.jj.ecertification.model.Question;

public interface QuestionRepositoryQuery {

	List<Question> listQuestionByIdCertification(Long idCertification);
}
