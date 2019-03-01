package com.jj.ecertification.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "permission")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permission implements Serializable {

	private static final long serialVersionUID = -2581689997829078470L;

	@Id
	@SequenceGenerator(name = "permission_seq", sequenceName = "permission_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_seq")
	@EqualsAndHashCode.Include
	private Long id;
	
	private String description;
}
