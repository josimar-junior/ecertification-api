package com.jj.ecertification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.ecertification.model.Question;
import com.jj.ecertification.repository.question.QuestionRepositoryQuery;

public interface QuestionRepository extends JpaRepository<Question, Long>, QuestionRepositoryQuery {

}
