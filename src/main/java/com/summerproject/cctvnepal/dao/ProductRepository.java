package com.summerproject.cctvnepal.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.summerproject.cctvnepal.entity.Categories;
import com.summerproject.cctvnepal.entity.Products;

@RepositoryRestResource(path= "product")
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	//http://localhost:8080/api/product/search/findByCategories?code=CAM
	public List<Products> findByCategories(@Param("code")Categories categories);
	//public List<Products> findByCategoryCode(@Param("code")String categories);
}
