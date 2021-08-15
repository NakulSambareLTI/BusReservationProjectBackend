package com.example.demo.layer2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class AdminProfile {
	
	@Id
	@Column(name="email")
	private String adminEmailId;
	
	@Column(name="password")
	private String adminPassword;
	
	

	public AdminProfile() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AdminProfile(String adminEmailId, String adminPassword) {
		super();
		this.adminEmailId = adminEmailId;
		this.adminPassword = adminPassword;
	}



	public String getAdminEmailId() {
		return adminEmailId;
	}



	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}



	public String getAdminPassword() {
		return adminPassword;
	}



	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	



}
  
