package com.summerproject.cctvnepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summerproject.cctvnepal.dao.CustomerRepository;
import com.summerproject.cctvnepal.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	// injecting the repository which does all the work of the DAO
	@Autowired
	CustomerRepository customerRepository;

	// to list all the employee
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	// to list one customer by id
	@Override
	public Customer findById(int theId) {
		
		Optional<Customer> result = customerRepository.findById(theId);
		
		Customer customerObject;
		
		if(result.isPresent()) {
			customerObject = result.get();
		}else {
			throw new RuntimeException("sorry the customer doesn't exists");
		}
		return customerObject ;
	}

	
	// to inset or update the customer
	@Override
	public void insertOrUpdate(Customer theCustomer) {
		customerRepository.save(theCustomer);
		
	}

	// to delete a customer by it's id
	@Override
	public void deleteCustomer(int theId) {
		customerRepository.deleteById(theId);
		
	}

	@Override
	public Customer findByEmail(String email) {
		
		return customerRepository.findByEmail(email);
	}

}
