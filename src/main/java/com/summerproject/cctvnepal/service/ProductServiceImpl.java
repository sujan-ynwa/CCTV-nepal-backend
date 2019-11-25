package com.summerproject.cctvnepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import com.summerproject.cctvnepal.dao.ProductRepository;
import com.summerproject.cctvnepal.entity.Categories;
import com.summerproject.cctvnepal.entity.Products;

@Service
public class ProductServiceImpl implements ProductService{
	
	// inject the Product repo for performing the crud operation
	@Autowired
	private ProductRepository productsRepo;

	@Override
	public List<Products> getAll() {
	
		return  productsRepo.findAll();
	}

	@Override
	public Products findById(int productId) {
		Optional<Products> result = productsRepo.findById(productId);

		Products products;
		if(result.isPresent()) {
			products = result.get();
		}else {
			throw new RuntimeException("Product doesn't exists");
		}
		
		return products;
	}

	@Override
	public void insertOrUpdate(Products products) {
		
		productsRepo.save(products);
		
	}

	@Override
	public void deleteById(int productId) {
		
		productsRepo.deleteById(productId);
		
	}

	@Override
	public List<Products> findByCategoriesName(String categories) {
		return productsRepo.findByCategories(categories);
		
	}

	

}
