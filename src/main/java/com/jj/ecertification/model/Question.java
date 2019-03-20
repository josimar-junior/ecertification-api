package com.jj.ecertification.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "question")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Question implements Serializable {

	private static final long serialVersionUID = 3322200799099302240L;

	@Id
	@SequenceGenerator(name = "question_seq", sequenceName = "question_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
	@EqualsAndHashCode.Include
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "certification_id")
	private Certification certification;
	
	private String number;
	
	@Column(columnDefinition = "text")
	private String statementQuestion;
	
	@OneToMany(mappedBy = "question",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Statement> statements = new ArrayList<>();
}
