package com.example.demo.layer5;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer4.BusServiceImplementation;

import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/bus")
public class BusController {
	
	
	@Autowired
	BusServiceImplementation busService;
	
	@GetMapping("/changeRoute")
	public boolean updateBusRoute(@RequestParam int journeyId,@RequestParam String source,@RequestParam String destination)
	{
		return busService.updatebusRoute(journeyId, source, destination);
	}
	

	 
	
	
	
	

}
