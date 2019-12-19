package com.summerproject.cctvnepal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summerproject.cctvnepal.dao.AdminRepository;
import com.summerproject.cctvnepal.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepo;

	@Override
	public List<Admin> findAll() {
	
		return adminRepo.findAll();
	}

	@Override
	public Admin findByPassword(String password) {
		
		return adminRepo.findByPassword(password);
	}

	@Override
	public Admin findByAdminName(String adminName) {
		
		return adminRepo.findByAdminName(adminName);
	}
	
	

}
