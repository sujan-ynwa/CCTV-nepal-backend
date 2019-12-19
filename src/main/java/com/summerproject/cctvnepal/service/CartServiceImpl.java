package com.summerproject.cctvnepal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summerproject.cctvnepal.dao.CartRepository;
import com.summerproject.cctvnepal.entity.Cart;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepo;

	@Override
	public List<Cart> findAll() {
		return cartRepo.findAll();
	}

	@Override
	public List<Cart> findByEmail(String email) {
		
		return cartRepo.findByEmail(email);
	}

	@Override
	public void deleteById(int id) {
		cartRepo.deleteById(id);	
	}

	@Override
	public void insertOrUpdate(Cart cart) {
		cartRepo.save(cart);
	}

}
