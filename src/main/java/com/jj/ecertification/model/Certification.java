package com.jj.ecertification.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "certification")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Certification implements Serializable {

	private static final long serialVersionUID = 7401315725720807199L;

	@Id
	@SequenceGenerator(name = "certification_seq", sequenceName = "certification_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certification_seq")
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String exam;
	
	@OneToMany(mappedBy = "certification",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Detail> details = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal percentage;
}
