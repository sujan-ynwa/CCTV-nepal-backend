package com.summerproject.cctvnepal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.summerproject.cctvnepal.entity.Orders;
import com.summerproject.cctvnepal.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/listAll")
	public String listAll(Model theModel) {
		
		List<Orders> orders = orderService.findAll();
		
		theModel.addAttribute("orders",orders);
		
		return "orders/show-order-list";
	}
	
}
