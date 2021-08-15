package com.example.demo.layer3;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.UserProfile;


@Repository
public interface UserRepository {
	
	void inserUserProfile(UserProfile user);
	boolean checkUserForLogin(String email,String password);
	
	

}
