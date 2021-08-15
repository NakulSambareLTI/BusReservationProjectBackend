package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.BusDetails;
import com.example.demo.layer2.BusDetailsNotFoundException;
import com.example.demo.layer2.BusJourneyDetails;
import com.example.demo.layer2.BusJourneyDetailsNotFoundException;
import com.example.demo.layer2.BusSeatDetailsNotFoundException;
import com.example.demo.layer2.BusSeatesDetails;
import com.example.demo.layer2.ReservationDetails;
import com.example.demo.layer3.BusDetailRepositoryImpl;
import com.example.demo.layer3.ReservationDetailsRepositoryImpl;
import com.example.demo.layer4.BusDetailsServiceImpl;
import com.example.demo.layer4.BusJourneyDetailServiceImpl;
import com.example.demo.layer4.BusSeatesDetailsServiceImpl;

@CrossOrigin(origins = "*")
@Controller 
//@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/busDetails")
public class BusDetailsJPAController {
	@Autowired
	BusDetailsServiceImpl busDetailServiceImpl;
	
	@Autowired
	BusJourneyDetailServiceImpl busJourneyDetailServiceImpl;
	
	@Autowired
	BusSeatesDetailsServiceImpl busSeatesDetailsServiceImpl;
	
	

	
	@Autowired
	ReservationDetailsRepositoryImpl reservationDetailsRepositoryImpl;
	
	public BusDetailsJPAController()
	{
System.out.println("BusDetailsJPAController() constructor working.....");
	}
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getAllBusDetails")
	public List<BusDetails> getAllBusDetails() {
		System.out.println("getEmployees() ");
		return busDetailServiceImpl.selectAllBusDetails(); // FROM THE DB
	}
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getBusDetails/{bno}")
	 BusDetails getBusDetails(@PathVariable String bno)
	 {
		return busDetailServiceImpl.selectBusDetailsService(bno);
	 }
 
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getBusDetailsByBusType/{btype}")
	List<BusDetails> getBusDetailsbyBusType(@PathVariable String btype)
	 {
		try {
			return busDetailServiceImpl.selectBusDetailsByBusTypeService(btype);
		} catch (BusDetailsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getAllBusJourneyDetails")
	public List<BusJourneyDetails> getAllBusJourneyDetails() {
		System.out.println("get allBusJourneyDetails() ");
		return busJourneyDetailServiceImpl.selectAllBusJourneyDetailsService() ; // FROM THE DB
	}
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getBusJourneyDetails/{jid}")
	public BusJourneyDetails getBusJourneyDetails(@PathVariable int jid) {
		System.out.println("get allBusJourneyDetails() ");
		try {
			return busJourneyDetailServiceImpl.selectBusJourneyDetailsService(jid) ;
		} catch (BusJourneyDetailsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // FROM THE DB
		return null;
	}
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getBusSeatesDetails/{jid}")
	public List<BusSeatesDetails> getBusSeatesDetails(@PathVariable int jid) throws BusSeatDetailsNotFoundException {
		System.out.println("get allBusJourneyDetails() ");
		
			return busSeatesDetailsServiceImpl.selectBusSeatesDetailsByJourneyIDService(jid) ;
		
		
	}
	
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getCostPerSeat/{busno}")
	public int getCostPer_Seat(@PathVariable String busno)  {
		System.out.println("get allBusJourneyDetails() ");
		try {
			return busDetailServiceImpl.selectCostPerSeatService(busno) ;
		} catch (BusDetailsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return -1;
		return 0;
	}
	
	
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getTotalNoOfSeates/{busno}")
	public int getTotalNoOfSeates(@PathVariable String busno) throws BusDetailsNotFoundException {
		System.out.println("get allBusJourneyDetails() ");
		return busDetailServiceImpl.selectNoOfSeatsService(busno) ;
		//return -1;
	}
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getReservationDetails/{email}")
	public List<ReservationDetails> getReservationDetails(@PathVariable String  email)  {
		System.out.println("get allBusJourneyDetails() ");
		
			return reservationDetailsRepositoryImpl.viewCurrentBookingByUserId(email);
		
		
	}
	
//	@GetMapping("/changeRoute")
//	public boolean updateBusRoute(@RequestParam int journeyId,@RequestParam String source,@RequestParam String destination)
//	{
//		return busJourneyDetailServiceImpl.updatebusRoute(journeyId, source, destination);
//	}
	
	
	
	@PostMapping("/addBus")
	public ResponseEntity addBus(@RequestBody BusDetails bus)
	{
		busDetailServiceImpl.addBusDetails(bus);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	
}
