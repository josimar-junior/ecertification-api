package com.jj.ecertification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jj.ecertification.config.property.EcertificationApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(EcertificationApiProperty.class)
public class EcertificationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcertificationApiApplication.class, args);
	}

}

