package com.example.demo.layer4;



import org.springframework.stereotype.Service;

import com.example.demo.layer2.UserProfile;



@Service
public interface UserService {
	
	void inserUserProfile(UserProfile user);
	boolean checkUserForLogin(String email,String password);
	
	

}
