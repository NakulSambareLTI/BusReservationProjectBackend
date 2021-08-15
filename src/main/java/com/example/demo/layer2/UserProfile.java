package com.example.demo.layer2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user_profile")
public class UserProfile {
	
	@Id
	@Column(name="registered_email")
	private String registeredEmail;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="phone")
	private String phoneNumber;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="DOB")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	


	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile(String registeredEmail, String userName, String gender, String phoneNumber, String password,
			Date dateOfBirth) {
		super();
		this.registeredEmail = registeredEmail;
		this.userName = userName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	public String getRegisteredEmail() {
		return registeredEmail;
	}

	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "UserProfile [registeredEmail=" + registeredEmail + ", userName=" + userName + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	

}
