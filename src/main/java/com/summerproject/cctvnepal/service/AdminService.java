package com.summerproject.cctvnepal.service;

import java.util.List;

import com.summerproject.cctvnepal.entity.Admin;

public interface AdminService {
	
	public List<Admin> findAll();
	public Admin findByPassword(String password);
	public Admin findByAdminName(String adminName);
	
}
