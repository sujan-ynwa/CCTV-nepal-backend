package com.summerproject.cctvnepal.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.summerproject.cctvnepal.entity.Cart;

public interface CartService {
	
	public List<Cart> findAll();
	
	public List<Cart> findByEmail(String email);
	
	public void deleteById(int id);
	
	@Transactional
	public int deleteByEmail(String email);
	
	public void insertOrUpdate(Cart cart);
	
	

}
