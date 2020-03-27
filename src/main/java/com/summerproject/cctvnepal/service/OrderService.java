package com.summerproject.cctvnepal.service;

import java.util.List;

import com.summerproject.cctvnepal.entity.Orders;

public interface OrderService {
	
	public List<Orders> findAll();
	
	public List<Orders> findByEmail(String email);
	
	public void insertOrUpdate(Orders orders);
	

}
