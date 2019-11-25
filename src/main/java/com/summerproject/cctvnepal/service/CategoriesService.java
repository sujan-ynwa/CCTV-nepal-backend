package com.summerproject.cctvnepal.service;

import java.util.List;


import com.summerproject.cctvnepal.entity.Categories;



public interface CategoriesService {
	
	public List<Categories> findAll();
	
	public Categories findById(int theId);
	
	public void insertOrUpdate(Categories theCategories);
	
	public void deleteCategory(int theId);
}
