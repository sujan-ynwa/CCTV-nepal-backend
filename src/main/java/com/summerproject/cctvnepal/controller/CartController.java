package com.summerproject.cctvnepal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.summerproject.cctvnepal.entity.Cart;
import com.summerproject.cctvnepal.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/list")
	public String listAll(Model theModel) {
		
		List<Cart> cart = cartService.findAll();
		
		theModel.addAttribute("cart", cart);
		
		return "cart/listCart" ;
		
	}
	
	
}
