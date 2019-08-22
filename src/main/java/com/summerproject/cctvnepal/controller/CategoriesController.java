package com.summerproject.cctvnepal.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.summerproject.cctvnepal.entity.Categories;
import com.summerproject.cctvnepal.service.CategoriesService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	
	// injecting category service for doing the CRUD 
	@Autowired
	CategoriesService categoriesService;
	
	
	@GetMapping("/list")
	public String listAll(Model theModel) {
		
		// populating the list with the data from database
		List<Categories> categories = categoriesService.findAll();
	
		
		// adding the value the the model
		theModel.addAttribute("categories",categories);
		
		return "categories/show-categories-list";
		
		
	}
	
	@GetMapping("/addCategoryForm")
	public String addCategory(Model theModel) {
		
		// creating a model attribute to bind form data
		Categories categories = new Categories();
		
		theModel.addAttribute("category",categories);
		
		return "categories/category-add-form";
		
	}
	
	@PostMapping("/insert")
	public String insertCategory(@Valid @ModelAttribute("category") Categories theCategories,BindingResult result,
								@RequestParam("file") MultipartFile file) throws IOException {
		
		
		if(result.hasErrors()) {
			return "categories/category-add-form";
		}else{
		
		// this is for saving the image path into the database
		String image_url =  "/images/categories/"+file.getOriginalFilename();
		
		// this is to create new file or update existing
		String filePath =  "src/main/resources/static/images/categories/"+file.getOriginalFilename();
		
		
		// this is for update
		// if the file with same name already exists then delete it first and only update
		Path fileToDelete = Paths.get(filePath);
		if(Files.exists(fileToDelete)) {
			// deleting the existing file
			Files.delete(fileToDelete);
			
			// replacing it with the new file
			File convertFile = new File(filePath);
		      convertFile.createNewFile();
		      FileOutputStream fout = new FileOutputStream(convertFile);
		      fout.write(file.getBytes());
		      fout.close();
		}else {
			
			// if the file is not present the create a new one
			File convertFile = new File(filePath);
		      convertFile.createNewFile();
		      FileOutputStream fout = new FileOutputStream(convertFile);
		      fout.write(file.getBytes());
		      fout.close();
		}
	      theCategories.setImagePath(image_url);
	      categoriesService.insertOrUpdate(theCategories);
	      return "redirect:/categories/list";	
		}
	}
	
	
	// for update form
	@GetMapping("/showUpdateFrom/{categoryId}")
	public String showUpdateFrom(@PathVariable("categoryId") int categoryId, Model theModel) {
		
		// get the object from the database
		Categories categories = categoriesService.findById(categoryId);
			
		// setting up the model attribute to pre-populate form
		theModel.addAttribute("category",categories); // model value should be same as the retrieved object in the form
		
		
		//sendig the populated form
		return "categories/category-add-form";
		
		
	}
	
	
	
	
	
	// for deleting a category form the database
	@GetMapping("/delete/{categoryId}")
	public String deleteCategory(@PathVariable int categoryId ) {
		
		// for deleting the file present in the server
		Categories categories = categoriesService.findById(categoryId);
		String image_path ="src/main/resources/static"+categories.getImagePath();
		
		 Path fileToDeletePath = Paths.get(image_path);
		 if(Files.exists(fileToDeletePath)){
		    try {
				Files.delete(fileToDeletePath);
				// deleting the record on the database
				categoriesService.deleteCategory(categoryId);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		 }else {
			 System.out.println("---------------------------------------File do not exist");
			// deleting the record on the database
				categoriesService.deleteCategory(categoryId);
		 }
		 
		
		return "redirect:/categories/list";	
		
	}
	
	
}
