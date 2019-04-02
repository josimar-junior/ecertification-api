package com.jj.ecertification.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "historic")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Historic {

	@Id
	@SequenceGenerator(name = "historic_seq", sequenceName = "historic_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historic_seq")
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "certification_id")
	private Certification certification;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@NotNull
	private LocalDateTime date = LocalDateTime.now();
	
	@NotBlank
	private String time;
	
	@NotNull
	@Column(precision = 10, scale = 2)
	private BigDecimal percentage;
}
