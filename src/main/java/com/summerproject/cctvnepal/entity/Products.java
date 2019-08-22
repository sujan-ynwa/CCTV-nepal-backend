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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;



@Entity
@Table(name="product")
public class Products{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message = "don't leave this field empty")
	@Size(min=1,message = "please! don't leave this field empty")
	@Column(name="product_name")
	private String productName;
	
	@NotNull(message = "don't leave this field empty")
	@Size(min=1,message = "please! don't leave this field empty")
	@Column(name="product_specs")
	private String specs;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@NotNull(message = "price cannot be empty")
	@Column(name="price")
	private Double price;
	
	@Column(name="available")
	private boolean available;
	
	 
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,
	CascadeType.DETACH,CascadeType.REFRESH}) // everyThing except delete
	@JoinColumn(referencedColumnName = "category_code",name="category_code",insertable = true) // this shit took me fucking 4 days
	@NotNull(message = "Please select a category")
	private Categories categories;
	
	public Products() {
		
	}
	
	// don't change the pattern in which parameter are passed
	public Products(String productName, String imagePath, Double price,String specs,boolean available) {
		this.productName = productName;
		this.specs = specs;
		this.imagePath = imagePath;
		this.price = price;
		this.available = available;
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


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
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



	