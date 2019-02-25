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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "detail")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Detail implements Serializable {

	private static final long serialVersionUID = -5606273128376931876L;

	@Id
	@SequenceGenerator(name = "detail_seq", sequenceName = "detail_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_seq")
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String description;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "certification_id")
	private Certification certification;
}
