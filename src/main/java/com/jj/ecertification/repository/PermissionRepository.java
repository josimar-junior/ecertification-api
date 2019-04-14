package com.jj.ecertification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.ecertification.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

	List<Permission> findByIdIn(List<Long> ids);
}
