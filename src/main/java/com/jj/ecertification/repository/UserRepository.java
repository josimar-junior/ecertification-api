package com.jj.ecertification.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.ecertification.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);

	public List<User> findByPermissionsDescription(String descriptionPermission);
}
