package com.summerproject.cctvnepal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.summerproject.cctvnepal.entity.Customer;
import com.summerproject.cctvnepal.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// injecting the service so that it will retrive the data from the database
	@Autowired
	CustomerService customerService;
	
	// this method will return the list of customers retrieved from database to the view page 
	@GetMapping("/listAll")
	public String  listAll(Model theModel){
		
		// get the employee from the database
		List<Customer> thecustomers = customerService.findAll();
		
		String numberOfCustomers= String.valueOf(thecustomers.size());
		
		System.out.println("mo pf customers"+numberOfCustomers);
		
		theModel.addAttribute("numbers",numberOfCustomers);
		theModel.addAttribute("customers",thecustomers);
		
		return "show-customer-list";
		
	}
	
	// for deleting a category form the database
		@GetMapping("/delete/{customerId}")
		public String deleteCategory(@PathVariable int customerId ) {
			
			customerService.deleteCustomer(customerId);
			
			return "redirect:/customer/listAll";	
		}
		

}
