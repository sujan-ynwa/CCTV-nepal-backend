package com.summerproject.cctvnepal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.summerproject.cctvnepal.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByPassword(@Param("password") String password);

	Admin findByAdminName(@Param("adminName")String adminName);

	
}
