package com.jj.ecertification.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CertificationDTO {

	private Long id;
	private String name;
	private String exam;
	private BigDecimal percentage;
}
