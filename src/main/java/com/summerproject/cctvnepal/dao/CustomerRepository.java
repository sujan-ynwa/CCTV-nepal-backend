package com.summerproject.cctvnepal.dao;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.summerproject.cctvnepal.entity.Customer;

@RepositoryRestResource(path= "customers")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	// this will find the data with the corresponding email passed
	// the url will look something like this: http://localhost:8080/api/customers/search/findByEmail?email=thekopsfc.sd@gmail.com
	// this is a custom method for JPA repository
	Customer findByEmail(@Param("email") String email);
}
