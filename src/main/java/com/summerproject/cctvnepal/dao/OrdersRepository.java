package com.summerproject.cctvnepal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.summerproject.cctvnepal.entity.Orders;


@RepositoryRestResource(path= "orders")
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	
	// the url will look something like this: http://localhost:8080/api/orders/search/findByCustomerEmail?email=thekopsfc.sd@gmail.com
			// this is a custom method for JPA repository
	List<Orders> findByCustomerEmail(@Param("email")String email);
	
}
