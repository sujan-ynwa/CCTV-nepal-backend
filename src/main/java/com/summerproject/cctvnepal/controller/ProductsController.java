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
import com.summerproject.cctvnepal.entity.Products;
import com.summerproject.cctvnepal.service.CategoriesService;
import com.summerproject.cctvnepal.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {

	
	// getting the service for crud implementation
	@Autowired
	private ProductService productService;
	
	// making this a global variable so that it will be easier to validate
	// the same list will be returned to the model there is error so that the drop-down list won't be empty
	private List<Categories> categories;
	
	
	// to get the data for drop-down list
	@Autowired
	private CategoriesService categoriesService;
	
	@GetMapping("/list")
	public String getAll(Model theModel) {
		
		// getting the list of products from the database
		List<Products> products = productService.getAll();
		
		// adding it to the model for view
		theModel.addAttribute("products",products); // setting name to model so it will be easier to relate to the view
		
		return "products/show-products";
		}
	
	
	
	// for showing the product form
	@GetMapping("/showProductForm")
	public String showInsertForm(Model theModel) {
		
		 categories = categoriesService.findAll();
	
		// refrencing the product class to fill with form data
		Products products = new Products();
		
		
		
		theModel.addAttribute("products", products);
		theModel.addAttribute("categories",categories);
		
		return "products/add-product";
	}
	
	@GetMapping("/showUpdateForm/{productId}")
	public String showUpdateForm(@PathVariable("productId") int productId,
									@PathVariable("file") MultipartFile file, Model theModel) throws IOException {
		
		// get the object form the database
		Products products = productService.findById(productId);
		// getting the category of the given product
		Categories categoriesobj = categoriesService.findById(products.getCategories().getId());
		
		// getting the categories
		 List<Categories> catrgoryList = categoriesService.findAll();
		
		// add the value in view through model
		theModel.addAttribute("products",products);
		
		// sending the category 
		theModel.addAttribute("categories", categoriesobj);
		
		// sending the list for the drop down list
		theModel.addAttribute("categories",catrgoryList);
		
		
		return "products/add-product";	
	}
	
	// after the form is filled and when the submit buttom is clicked
	@PostMapping("/insert")
	public String insertCategory(@Valid @ModelAttribute("products") Products products,BindingResult result,
								@RequestParam("file") MultipartFile file,
								@RequestParam("availability") boolean availabiltiy,
								 Model model) throws IOException {
		
		if(result.hasErrors()) {
			//adding the model attribute so that the drop-down list won't be empty when the form is redirected
			model.addAttribute("categories", categories);
			return "products/add-product";
		}else {
			// to delete a file
			String filePathtoDelete;
			
			// go get the file name 
			if(products.getId() != 0) {
				System.out.println(products);
				 Products getProducts = productService.findById(products.getId()); 
			filePathtoDelete =  "src/main/resources/static/"+getProducts.getImagePath();
			System.out.println(filePathtoDelete);
			}else {
				filePathtoDelete =  "src/main/resources/static/"+products.getImagePath();
			}
			
			// for saving into the database
			String image_url = "/images/products/"+file.getOriginalFilename();
			// this is to create new file or update existing
			
			// to create new path
			String newFile = "src/main/resources/static/images/products/"+file.getOriginalFilename();
		
			// this is for update
			// if the file with same name already exists then delete it first and only update
			Path fileToDelete = Paths.get(filePathtoDelete);
			
			if(Files.exists(fileToDelete)) {
				// deleting the existing file
				Files.delete(fileToDelete);
				
				// replacing it with the new file
				File convertFile = new File(newFile);
			      convertFile.createNewFile();
			      FileOutputStream fout = new FileOutputStream(convertFile);
			      fout.write(file.getBytes());
			      fout.close();
			}else {
				
				// if the file is not present then create a new one
				File convertFile = new File(newFile);
			      convertFile.createNewFile();
			      FileOutputStream fout = new FileOutputStream(convertFile);
			      fout.write(file.getBytes());
			      fout.close();
			}
			products.setImagePath(image_url);
			products.setAvailable(availabiltiy);
			// this is required for the foreign key refrence
			Categories categories =categoriesService.findById (products.getCategories().getId());
			categories.add(products);
			//categoriesService.insertOrUpdate(categories);
			productService.insertOrUpdate(products);
			return "redirect:/products/list";	
		}
		
		
	}
	
	
	
	@GetMapping("/delete/{productId}")
	public String deleteProducts(@PathVariable int productId) throws IOException{
	
		Products products = productService.findById(productId);
		// to delete the image
		String filePath = "src/main/resources/static"+products.getImagePath();
		
		Path fileToDelete = Paths.get(filePath);
		if(Files.exists(fileToDelete)) {
			// deleting the existing file
			Files.delete(fileToDelete);
			productService.deleteById(productId);
		}else {
			productService.deleteById(productId);
		}
		
		return "redirect:/products/list";
		
	}
	  
			
}
