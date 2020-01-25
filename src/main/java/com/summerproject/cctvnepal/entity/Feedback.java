package com.summerproject.cctvnepal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@Column(name = "customer_name")
	private String customerName; 
	
	@Column(name="title")
	private String title;
	
	@Column(name = "feedback")
	private String feedback;
	
	public Feedback() {
		}
	
	public Feedback(String customerEmail,String customerName, String title, String feedback) {
		this.customerEmail = customerEmail;
		this.customerName = customerName;
		this.title = title;
		this.feedback = feedback;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", customerEmail=" + customerEmail + ", title=" + title + ", feedback=" + feedback
				+ "]";
	}


	
	
	
	

}
