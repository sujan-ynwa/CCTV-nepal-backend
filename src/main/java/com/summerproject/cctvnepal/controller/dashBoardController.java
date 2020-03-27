package com.summerproject.cctvnepal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.GetMapping;

import com.summerproject.cctvnepal.entity.Categories;
import com.summerproject.cctvnepal.entity.Customer;
import com.summerproject.cctvnepal.entity.Feedback;
import com.summerproject.cctvnepal.entity.Orders;
import com.summerproject.cctvnepal.entity.Products;
import com.summerproject.cctvnepal.service.CategoriesService;
import com.summerproject.cctvnepal.service.CustomerService;
import com.summerproject.cctvnepal.service.FeedbackService;
import com.summerproject.cctvnepal.service.OrderService;
import com.summerproject.cctvnepal.service.ProductService;

@Controller
public class dashBoardController {
	
	// for getting list of customers
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;

	@Autowired
	CategoriesService categoriesService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/showDashboard")
	public String showDasboard(Model model) {
		
		// customers
		List<Customer> thecustomers = customerService.findAll();		
		String totalCustomers= String.valueOf(thecustomers.size());		
		model.addAttribute("totalCustomers",totalCustomers);
		model.addAttribute("customerList",thecustomers);
		
		
		//  products
		List<Products> productList = productService.getAll();		
		String totalProducts= String.valueOf(productList.size());		
		model.addAttribute("totalProducts",totalProducts);
		model.addAttribute("productList",productList);
		
		// purchase order
		List<Orders> orderList = orderService.findAll();		
		String totalOrders= String.valueOf(orderList.size());		
		model.addAttribute("totalOrders",totalOrders);
		model.addAttribute("orderList",orderList);
		
		//categories
		List<Categories> categoriesList = categoriesService.findAll();
		model.addAttribute("categoryList", categoriesList);
		
		//feedbacks
		List<Feedback> feedbackList = feedbackService.findAll();
		model.addAttribute("feedbackList", feedbackList);
		
		
		
		return "dashboard";
	}

}
