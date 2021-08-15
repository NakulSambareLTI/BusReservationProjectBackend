package com.example.demo.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer3.NumberNotFoundException;
import com.example.demo.layer3.ReservationDetailsRepositoryImpl;
import com.example.demo.layer4.BusDetailsServiceImpl;
import com.example.demo.layer4.BusJourneyDetailServiceImpl;
import com.example.demo.layer4.BusSeatesDetailsServiceImpl;
import com.example.demo.layer4.ServiceImpl;


//import com.example.layer2.EmployeeNotFoundException;



@CrossOrigin(origins="*")
@RestController // it is a specialized version of @Component - arker to receive web request
@RequestMapping("/bus")
public class BusJPAController {
	
	public BusJPAController() {
		System.out.println("JPA Created");
	} 
	
	@Autowired
	ServiceImpl serviceRepo;
	
	@Autowired
	BusDetailsServiceImpl busDetailServiceImpl;
	
	@Autowired
	BusJourneyDetailServiceImpl busJourneyDetailServiceImpl;
	
	@Autowired
	BusSeatesDetailsServiceImpl busSeatesDetailsServiceImpl;
	
	

	
	@Autowired
	ReservationDetailsRepositoryImpl reservationDetailsRepositoryImpl;
	
	
	/*@PutMapping
	@ResponseBody
	@RequestMapping(value="/busJourneyDetails/{busNo}")
	public void updateAvailableSeats(@PathVariable String busNo) {
		String message = "Bus not found";
		BusJourneyDetails newBus = new BusJourneyDetails(busNo);
		boolean modified = false;
		for(BusJourneyDetails bus1 : empList) {
			if(employee.getEmployeeNumber() == newEmp.getEmployeeNumber()) {
				int idx = empList.indexOf(employee);
				empList.set(idx,  newEmp);
				modified = true;
				break;
			}
		}
		if(modified) {
			message =  "Employee modified successfully...";			
		}
		return message;
	}*/
	
	@ResponseBody
	@DeleteMapping(value="/deleteReservation/{rID}")
	public void deleteReservation(@PathVariable int rID) throws NumberNotFoundException {
			System.out.println("Deleted Reservation");
			serviceRepo.deleteReservation(rID);
		}
	
		
		  @ResponseBody
		  @DeleteMapping(value="/deleteTransaction/{rID}") public void
		  deleteTransaction(@PathVariable int rID) throws NumberNotFoundException {
		  System.out.println("Deleted Transaction");
		  serviceRepo.deleteTransaction(rID); 
		  }
		  
		  @ResponseBody
		  @DeleteMapping(value="/deletePayment/{rID}") public void
		  deletePayment(@PathVariable int rID) throws NumberNotFoundException {
		  System.out.println("Deleted Payment"); 
		  serviceRepo.deletePayment(rID); 
		  }
		 
		
	@PutMapping
	@ResponseBody
	@RequestMapping(value="/addMoney/{emailID}")
	public void addMoneyToWallet(@PathVariable String emailID) throws NumberNotFoundException{
		System.out.println("Add Money");
		serviceRepo.addMoneyToWallet(emailID);
	}
	
	@PutMapping
	@ResponseBody
	@RequestMapping(value="/changeSeatsNo/{jID}/{rID}")
	public void changeAvailableSeats(@PathVariable int jID,@PathVariable int rID) throws NumberNotFoundException{
		System.out.println("Changing Seats Count");
		busJourneyDetailServiceImpl.changeAvailableSeats(jID,rID);
	}
	
	@PutMapping
	@ResponseBody
	@RequestMapping(value="/changeSeatsDetails/{rID}")
	public void updateSeatDetails(@PathVariable int rID) throws NumberNotFoundException{
		System.out.println("Changing Seats Details");
		busSeatesDetailsServiceImpl.updateSeatDetails(rID);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/cancelReservation/{email}/{jID}/{rID}")
	public void cancelReservation(@PathVariable String email,@PathVariable int jID,@PathVariable int rID){
		System.out.println("Starting Cancel Reservation");
		serviceRepo.cancelReservation(email,jID,rID);
	}
	
	@ResponseBody
	@RequestMapping(value="/seatCountDecrease/{jID}/{rID}")
	public void decreaseSeatCount(@PathVariable int jID, @PathVariable int rID) throws NumberNotFoundException {
		serviceRepo.decreaseSeatCount(jID, rID);
	}
}