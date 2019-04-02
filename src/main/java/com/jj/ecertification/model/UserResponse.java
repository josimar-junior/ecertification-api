package com.jj.ecertification.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user_response")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserResponse {

	@Id
	@SequenceGenerator(name = "user_response_seq", sequenceName = "user_response_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_response_seq")
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "certification_id")
	private Certification certification;
	
	private String questionNumber;
	
	private String items;
}
