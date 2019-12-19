package com.summerproject.cctvnepal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.summerproject.cctvnepal.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	
	// this will find the data with the corresponding email passed
		// the url will look something like this: http://localhost:8080/api/cart/search/findByEmail?email=thekopsfc.sd@gmail.com
		// this is a custom method for JPA repository
		List<Cart> findByEmail(@Param("email") String email);
}
