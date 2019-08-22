package com.summerproject.cctvnepal.service;

import java.util.List;

import com.summerproject.cctvnepal.entity.Customer;


public interface CustomerService {
	
	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void insertOrUpdate(Customer theCustomer);
	
	public void deleteCustomer(int theId);
	
	public Customer findByEmail(String email);

}
