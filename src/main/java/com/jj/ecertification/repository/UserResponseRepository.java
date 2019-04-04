package com.jj.ecertification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jj.ecertification.model.UserResponse;

public interface UserResponseRepository extends JpaRepository<UserResponse, Long> {

	@Query("select u from UserResponse u where u.certification.id = ?1 and u.user.id = ?2 and u.historic.id = ?3")
	List<UserResponse> listAllByCertification(Long idCertification, Long idUser, Long idHistoric);
}
