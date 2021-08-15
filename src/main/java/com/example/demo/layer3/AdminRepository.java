package com.example.demo.layer3;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository {
	boolean checkAdminForLogin(String email,String password);

}
