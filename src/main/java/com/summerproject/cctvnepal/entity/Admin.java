package com.summerproject.cctvnepal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name="password")
	private String password;
	

	public Admin() {
					
	}
	
	public Admin(String adminName, String password) {
		this.adminName = adminName;
		this.password = password;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", password=" + password + "]";
	}
	
	
	
	
	

}
