package com.summerproject.cctvnepal.dao;

import java.util.List;

import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;
import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.transaction.annotation.Transactional;

import com.summerproject.cctvnepal.entity.Cart;

@RepositoryRestController
@RepositoryRestResource
public interface CartRepository extends JpaRepository<Cart, Integer> {

	
	// this will find the data with the corresponding email passed
		// the url will look something like this: http://localhost:8080/api/carts/search/findByEmail?email=thekopsfc.sd@gmail.com
		// this is a custom method for JPA repository
		List<Cart> findByEmail(@Param("email") String email);
	
		/*url for delete is:
		 * //http://localhost:8080/api/carts/search/deleteByEmail?email=thekopsfc.sd@gmail.com
		 * and send it with the GET method
		 * */
		@Transactional
		@Modifying      // to mark delete or update query
		@Query(value = "DELETE FROM Cart e WHERE e.email = :email")
		int deleteByEmail(@Param("email")String email);
		
		
		
	/*
	 * @Transactional
	 * 
	 * @Modifying // to mark delete or update query
	 * 
	 * @Query(value =
	 * "DELETE FROM Cart e WHERE e.email = :email and e.productName= :productName")
	 * void deleteByProductNameAndEmail(@Param("productName")String
	 * product,@Param("email")String email);
	 */
}
