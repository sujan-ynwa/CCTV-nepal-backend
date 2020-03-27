package com.summerproject.cctvnepal.controller;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import javax.validation.Valid;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.summerproject.cctvnepal.entity.Admin;
import com.summerproject.cctvnepal.service.AdminService;


@Controller
public class LoginController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/login")
	public String showForm(Model theModel) {
		
		// first you need to add the "login" to the model so that it can act like a model attribute
		theModel.addAttribute("login",new Admin());
		
		// login.html page opens
		return "login";
	}
	
	@GetMapping("/")
	public String showlogin(Model theModel) {
		
		// first you need to add the "login" to the model so that it can act like a model attribute
		theModel.addAttribute("login",new Admin());
		
		// login.html page opens
		return "login";
	}
	
	
	@PostMapping("/login")
		public String verifyLogin(@Valid @ModelAttribute("login") Admin theAdmin,BindingResult result ){
		
		System.out.println(adminService.findByPassword(theAdmin.getPassword()));
		
		// doing the simple validation for the admin part
		  if(((adminService.findByPassword(theAdmin.getPassword()))== null) || ((adminService.findByAdminName(theAdmin.getAdminName())) == null)) {
			  System.out.println("credential don't match");  
			  return "login";
		  }else {
			  
			// take to dashboard.html page
			  return "redirect:/showDashboard";  
		  }
		 
			
		
	}
	
}
