package com.summerproject.cctvnepal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summerproject.cctvnepal.dao.OrdersRepository;
import com.summerproject.cctvnepal.entity.Orders;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrdersRepository orderRepo;

	@Override
	public List<Orders> findAll() {
		
		return orderRepo.findAll();
	}

	@Override
	public void insertOrUpdate(Orders order) {
		
		orderRepo.save(order);
		
	}

	@Override
	public List<Orders> findByEmail(String email) {
		
		return orderRepo.findByCustomerEmail(email);
	}

}
