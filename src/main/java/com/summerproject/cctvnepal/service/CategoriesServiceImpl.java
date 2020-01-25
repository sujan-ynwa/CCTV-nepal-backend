package com.summerproject.cctvnepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summerproject.cctvnepal.dao.CategoryRepository;
import com.summerproject.cctvnepal.entity.Categories;

@Service
public class CategoriesServiceImpl implements CategoriesService {
	
	// injecting the Categories repository to perform CRUD function
	@Autowired
	private CategoryRepository categroiesRepo;
	

	@Override
	public List<Categories> findAll() {
		
		return categroiesRepo.findAll();
	}

	@Override
	public Categories findById(int theId) {
		Optional<Categories> result = categroiesRepo.findById(theId);
		
		Categories categories;
		if(result.isPresent()) {
			 categories = result.get();
		}else {
			throw new RuntimeException("The category doesn't exists");
		}
		
		return categories;
		
	}
	
	
	

	@Override
	public void insertOrUpdate(Categories theCategories) {
		categroiesRepo.save(theCategories);
		
	}

	@Override
	public void deleteCategory(int theId) {
		categroiesRepo.deleteById(theId);
		
	}

	@Override
	public Categories findByCategoryCode(String code) {

		return categroiesRepo.findByCategoryCode(code);
	}

	

	
	
	
	

}
