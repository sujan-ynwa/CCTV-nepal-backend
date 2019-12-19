package com.summerproject.cctvnepal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.summerproject.cctvnepal.entity.Customer;
import com.summerproject.cctvnepal.entity.Feedback;
import com.summerproject.cctvnepal.service.CustomerService;
import com.summerproject.cctvnepal.service.FeedbackService;

@Controller
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	// injecting the service so that it will retrive the data from the database
	@Autowired
	FeedbackService feedbackService;
	
	// this method will return the list of customers retrieved from database to the view page 
	@GetMapping("/listAll")
	public String  listAll(Model theModel){
		
		// get the employee from the database
		List<Feedback> feedbacks = feedbackService.findAll();
		
		theModel.addAttribute("feedback",feedbacks);
		
		return "/feedback/feedback-list";
		
	}
	
	// for deleting a category form the database
		@GetMapping("/delete/{feedbackId}")
		public String deleteCategory(@PathVariable int feedbackId ) {
			
			feedbackService.deleteFeedback(feedbackId);
			
			return "redirect:/feedbacks/listAll";	
		}
		

}
