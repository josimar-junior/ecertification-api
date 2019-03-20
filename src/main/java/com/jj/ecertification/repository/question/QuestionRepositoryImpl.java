package com.jj.ecertification.repository.question;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jj.ecertification.model.Question;

public class QuestionRepositoryImpl implements QuestionRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> listQuestionByIdCertification(Long idCertification) {
		String jpql = "select q from Question q where q.certification.id = :idCertification";
		
		Query query = manager.createQuery(jpql, Question.class);
		
		query.setParameter("idCertification", idCertification);
		
		return query.getResultList();
	}

}
