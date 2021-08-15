package com.example.demo.layer4;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer3.AdminRepositoryImplementation;



@Service
public class AdminServiceImplementation implements AdminService{

	
	@Autowired
	AdminRepositoryImplementation adminRepoImpl;
	
	@Override
	public boolean checkAdminForLogin(String email, String password) {
		// TODO Auto-generated method stub
		return  adminRepoImpl.checkAdminForLogin(email, password);
	}

}
