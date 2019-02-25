package com.jj.ecertification.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "organization")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Organization implements Serializable {
	
	private static final long serialVersionUID = 5865391568843619240L;

	@Id
	@SequenceGenerator(name = "organization_seq", sequenceName = "organization_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_seq")
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String name;
	
	@Type(type = "true_false")
	@NotNull
	private Boolean active;
}
