package com.summerproject.cctvnepal.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;



@Entity
@Table(name="product")
public class Products{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "*required")
	@Size(min=5,message = "Product Name must have least 5 character")
	@Column(name="product_name")
	private String productName;
	
	@NotBlank(message = "*required")
	@Size(min=20,message = "description too short should be at least 20 characters")
	@Column(name="product_specs")
	private String specs;
	
	@NotBlank(message = "*required")
	@Column(name="company_name")
	private String companyName;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@NotNull(message = "price cannot be empty")
	@PositiveOrZero(message = "price cannot be Negative")
	//@Digits(integer = 10,fraction = 3,message = "price too large")
	@Column(name="price")
	private double price;
	
	@NotEmpty(message = "don't leave this field empty")
	@Column(name="warranty")
	private String warranty;
	
	
	@Column(name="available")
	private boolean available;
	
	 
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,
	CascadeType.DETACH,CascadeType.REFRESH}) // everyThing except delete
	@JoinColumn(referencedColumnName = "category_code",name="category_code") // this shit took me fucking 4 days
	@NotNull(message = "Please select a category")
	private Categories categories;
	
	public Products() {
		
	}
	
	// don't change the pattern in which parameter are passed
	public Products(String productName,String companyName, String imagePath, double price,String specs,String warranty,boolean available) {
		this.productName = productName;
		this.specs = specs;
		this.imagePath = imagePath;
		this.price = price;
		this.companyName = companyName;
		this.warranty= warranty;
		this.available = available;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getSpecs() {
		return specs;
	}


	public void setSpecs(String specs) {
		this.specs = specs;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	
	  public Categories getCategories(){
		  return categories; 
	}
	  
	  
	  public void setCategories(Categories categories){ 
		  this.categories =  categories;
	 }
	 





	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", specs=" + specs + ", imagePath=" + imagePath
				+ ", price=" + price + ", categories=" + categories + "]";
	}
	
	
	
	
	
}



	