package com.summerproject.cctvnepal.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	@Column
	private String customerEmail;
	
	@Column
	private String contactNumber;
	
	@Column
	private String contactName;
	
	@Column
	private String productName;
	
	@Column
	private String companyName;
	
	@Column
	private double price;
	
	@Column
	private int quantity;

	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date purchaseDate;

	public Orders() {
		
	}
	
	public Orders( String customerEmail,String contactName,String contactNumber,String productName, String companyName, double price, int quantity, Date pruchase_date) {
		this.productName = productName;
		this.customerEmail = customerEmail;
		this.companyName = companyName;
		this.price = price;
		this.quantity = quantity;
		this.purchaseDate = pruchase_date;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
	}


	

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchase_date) {
		this.purchaseDate = purchase_date;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Orders [id=" + id + ", productName=" + productName + ", customerEmail=" + customerEmail + ", companyName="
				+ companyName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
		
	

}
