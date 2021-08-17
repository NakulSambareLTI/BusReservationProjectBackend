package com.example.demo.layer5;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.BusSeatesDetails;
import com.example.demo.layer2.ComplexClass;
import com.example.demo.layer2.MyDto;
import com.example.demo.layer2.PaymentDetails;
import com.example.demo.layer2.ReservationDetails;
import com.example.demo.layer2.TransactionDetails;
import com.example.demo.layer3.BusJourneyDetailsRepositoryImpl;
import com.example.demo.layer3.BusSeatesDetailsRepositoryImpl;
import com.example.demo.layer3.NumberNotFoundException;
import com.example.demo.layer3.WalletRepoImpl;
import com.example.demo.layer4.Service1;
import com.example.demo.layer4.ServiceImpl;


//@RestController
//@org.springframework.stereotype.Controller
//@Component
//@Repository

@CrossOrigin(origins ="*")
//@CrossOrigin(origins = "http://localhost:4200")
//@Controller // it is a specialized version of @Component - marker to receive web request
@RestController
@RequestMapping("/reserv")
public class Controller1 {

	@Autowired 
	ServiceImpl service; //reservationRepoImpl Service
	
	
	@Autowired 
	WalletRepoImpl walletRepoImpl;
//	@Autowired
//	PaymentDetailsServiceImpl payService;
//	@Autowired
//	TransactionDetailsServiceImpl tranService;
//	@Autowired 
//	BusSeatesDetailsRepositoryImpl busSeatesService;
//	@Autowired
//	BusJourneyDetailsRepositoryImpl busJourneyService;
	
	
	
	//================RESERVATION=============
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/viewBookingDetailsByBookingId/{reservation_id}")
	public List<ReservationDetails> viewBookingDetailsByReservationID(@PathVariable int reservation_id)
	{
	return service.viewBookingDetailsByReservationID(reservation_id);
	}
	//("reservation_id")
		
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/viewCurrentBookingByUserId/{registered_email}")
	public List<ReservationDetails> viewCurrentBookingByUserId(@PathVariable String registered_email){
		return service.viewCurrentBookingByUserId(registered_email);
		
	}
//("registered_email")
		
	//@PostMapping 
	@ResponseBody
	@PostMapping(path="/addReserve")
		public int  insertReservation(@RequestBody ReservationDetails rd) {
		System.out.println(rd.getString());
		System.out.println("addReserver()...method ");
		//BusDetails bus = new BusDetails(); // spring JPA - get the data from DB
	//emp.setEmployeeNumber(eno);
		ReservationDetails r=rd;
		Integer rid=service.insertReservation(r);
			//empList.add(emp);
		
		return rid;
		
	}	
	//==============PAYMENT=============
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addPayment")
		public int insertPayment(@RequestBody PaymentDetails rd) {
		System.out.println("addReserver()...method ");
		//BusDetails bus = new BusDetails(); // spring JPA - get the data from DB
	//emp.setEmployeeNumber(eno);
		PaymentDetails r=rd;
		int pid=service.insertPayment(r);
			//empList.add(emp);
		return pid;
	
	}	
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/viewPaymentDetailsByPaymentId/{payment_id}")
	public List<PaymentDetails> viewPaymentDetailsByPaymentId(@PathVariable int payment_id)
	{
	return service.viewPaymentDetailsByPaymentId(payment_id);
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/viewCurrentPaymentByUserId/{registered_email}")
	public List<PaymentDetails> viewCurrentPaymentByUserId(@PathVariable String registered_email){
		return service.viewCurrentPaymentByUserId(registered_email);
		
	}
	
	
	//@ResponseBody
	@PostMapping(path="/insertReserv1/{complex}")
	public String insertRev(@RequestBody ComplexClass complexClass){
		System.out.println("Starting Cancel Reservation");
		service.insertReservationDetails1(complexClass.getReservationDetails(),complexClass.getPaymentDetails(),complexClass.getTransactionDetails());
	       return "Working..";
	}
	
	
	
	//============Transaction==========
	
	//@PostMapping 
	//@ResponseBody
	@PostMapping(path="/addTransaction")
		public String insertTransaction(@RequestBody TransactionDetails rd) {
		System.out.println("addTransaction()...method ");
		TransactionDetails r=rd;
		int tid=service.insertTransaction(r);
		return "Transaction addedd sucessfully";
		
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/viewTransactionDetailsByBookingId/{transaction_id}")
	public List<TransactionDetails> viewTransactionDetailsByReservationID(@PathVariable int transaction_id)
	{
	return service.viewTransactionDetailsByTransactionID(transaction_id);
	}
	//("reservation_id")
		
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/viewCurrentTransactionByUserId/{registered_email}")
	public List<TransactionDetails> viewCurrentTransactionByUserId(@PathVariable String registered_email){
	return service.viewCurrentTransactionByUserId(registered_email);
	
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/deleteMoneyfromWallet/{registered_email}")
	public void deleteFromWallet(@PathVariable String registered_email) throws NumberNotFoundException
	{
		 walletRepoImpl.deleteMoneyFromWallet(registered_email);
	}
	
	//==============BusSeatesDetails================
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/updateBusSeatesDetails/{rID}/{jID}/{s_no}")
		public void updateBusSeatesDetails(@PathVariable int rID,@PathVariable int jID,@PathVariable String s_no) {
	System.out.println("Seates Details updating..");
	service.updateBusSeatesDetails(rID,jID,s_no);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateBusSeatesDetailsListSeat/{rID}/{jID}/{seat_no}")
	public void updateBusSeatesDetailsListSeat(@PathVariable int rID,@PathVariable int jID,@PathVariable List<String>seat_no) {
		System.out.println("Lis of Seates Details updating.. ");
		service.updateBusSeatesDetailsListSeat(rID,jID,seat_no);
	}
	
	
	
	
	
	
	
	//=============BusJourneyDetails==============
	
//	@PutMapping
//	@ResponseBody
//	@RequestMapping(value="/updateBusJourneyDetails/{rID}/{jID}")
//	public void updateBusJourneyDetails(@PathVariable int rID,@PathVariable int jID)
//	//public void updateBusJourneyDetails(@PathParam(value = "") String rID,@PathParam(value = "") int jID)
//	{
//		System.out.println("Bus Journey Details updating....");
//		service.updateBusJourneyDetails(rID, jID);
//		System.out.println("Bus journey details updated...........");
//		
//	}
//	
//	@GetMapping
//	@ResponseBody
//	@RequestMapping(value="/updateBusJourneyDetails1/{rID}/{jID}")
//	public void updateBusJourneyDetails1(@PathVariable int rID,@PathVariable int jID) {
//		System.out.println("Bus journey details is ready to update...");
//		service.updateBusJourneyDetails1(rID,jID);
//		System.out.println("Bus Journey Details is updated....");
//	}
	
//	@ResponseBody
//	@RequestMapping(value="/seatCountDecrease/{jID}/{rID}")
//	public void decreaseSeatCount(@PathVariable int jID, @PathVariable int rID)  {
//		service.decreaseSeatCount(jID, rID);
//	}
//	

	@ResponseBody
	@RequestMapping(value="/seatCountDecrease/")
	public void decreaseSeatCount(@RequestBody MyDto myDto)  {
		
		
		service.decreaseSeatCount(myDto.getJid(),myDto.getRid());
	}
	
	
//	@ResponseBody
	
	
	
}







