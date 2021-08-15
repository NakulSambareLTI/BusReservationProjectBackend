package com.example.demo.layer5;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer4.AdminServiceImplementation;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImplementation adminService;
	
	@GetMapping("/checkAdminLogin")
	public boolean checkLogin(@RequestParam String email , @RequestParam String password)
	{
		return adminService.checkAdminForLogin(email, password);
	}
	
	
	
	

}
