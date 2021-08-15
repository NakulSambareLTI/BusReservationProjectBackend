package com.example.demo.layer4;



import org.springframework.stereotype.Service;

@Service
public interface AdminService {
	boolean checkAdminForLogin(String email,String password);

}
