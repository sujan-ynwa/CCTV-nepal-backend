package com.summerproject.cctvnepal.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "categories")
public class Categories implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotBlank(message = "Please fill this field")
	@Column(name = "category_name")
	private String categoryName;

	@NotEmpty(message="Please select a file")
	@Column(name = "image_path")
	private String imagePath;

	@NotBlank(message = "Please fill this field")
	@Column(name = "category_code")
	private String categoryCode;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "categories", 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH}) // it will look for categories in products table to create a relationship
	private List<Products> products;

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Categories() {

	}

	public Categories(String categoryName, String imagePath, String categroyCode) {
		this.categoryName = categoryName;
		this.imagePath = imagePath;
		this.categoryCode = categroyCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", categoryName=" + categoryName + ", imagePath=" + imagePath
				+ ", categroyCode=" + categoryCode + "]";
	}

	
	  // this is for the relational mapping
	  
	  public void add(Products tempProduct) {
	  
	  if(products == null) { products = new ArrayList<>(); }
	  
	  products.add(tempProduct); 
	  tempProduct.setCategories(this);
	  
	  }
	 

}
