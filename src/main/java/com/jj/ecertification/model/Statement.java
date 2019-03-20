package com.jj.ecertification.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "statement_question")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Statement implements Serializable {

	private static final long serialVersionUID = 5943022217545029712L;
	
	@Id
	@SequenceGenerator(name = "statement_seq", sequenceName = "statement_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statement_seq")
	@EqualsAndHashCode.Include
	private Long id;
	private String item;
	private String description;
	
	@Type(type = "true_false")
	private boolean correct;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private Question question;
}
