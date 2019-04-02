package com.jj.ecertification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.ecertification.model.Historic;
import com.jj.ecertification.model.User;

public interface HistoricRepository extends JpaRepository<Historic, Long> {

	List<Historic> findByUserOrderByDateDesc(User user);
}
