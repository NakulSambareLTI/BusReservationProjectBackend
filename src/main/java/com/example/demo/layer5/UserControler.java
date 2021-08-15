package com.example.demo.layer5;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.UserProfile;
import com.example.demo.layer4.UserServiceImplementation;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserControler {
	
	@Autowired
	UserServiceImplementation userService;
	
	@PostMapping("/register")
	public ResponseEntity insertUser(@RequestBody UserProfile user)
	{
		System.out.println(user);
		userService.inserUserProfile(user);	
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public boolean checkLogin(@RequestParam String email , @RequestParam String password)
	{
		return userService.checkUserForLogin(email, password);
	}
	
	
	
	

}
