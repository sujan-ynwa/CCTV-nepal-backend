package com.summerproject.cctvnepal.service;

import java.util.List;

import com.summerproject.cctvnepal.entity.Categories;
import com.summerproject.cctvnepal.entity.Products;

public interface ProductService {
	
	public List<Products> getAll();
	
	public Products findById(int productId);
	
	public void insertOrUpdate(Products products);
	
	public void deleteById(int productId);
	
	public List<Products> findByCategoriesName(String categories);
	

}
