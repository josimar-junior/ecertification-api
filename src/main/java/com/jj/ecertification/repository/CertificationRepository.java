package com.jj.ecertification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.ecertification.model.Certification;
import com.jj.ecertification.repository.certification.CertificationRepositoryQuery;

public interface CertificationRepository extends JpaRepository<Certification, Long>, CertificationRepositoryQuery {

}
