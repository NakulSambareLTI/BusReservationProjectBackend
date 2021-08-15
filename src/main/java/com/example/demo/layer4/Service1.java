package com.example.demo.layer4;

import java.util.List;

import com.example.demo.layer2.BusSeatesDetails;

//import org.springframework.stereotype.Service;

import com.example.demo.layer2.PaymentDetails;
import com.example.demo.layer2.ReservationDetails;
import com.example.demo.layer2.TransactionDetails;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

//@Controller
//@Component
//public interface Service 

@Service
public interface Service1{

	
	
	//=============================Reservation
	//void addAResevervation(ReservationDetails ref);
	
	 public void insertReservation(ReservationDetails rd);
	public List<ReservationDetails> viewBookingDetailsByReservationID(int reservation_id);
	
	public List<ReservationDetails> viewCurrentBookingByUserId(String registered_email);
	
	//==============================BusJourneyDetails
//	public void updateBusJourneyDetails(int rID,int jID) ;
//	//=====new for bus journey details==
//	public void updateBusJourneyDetails1(int rID,int jID);
	
	
	//===============================BusSeatesDetails
	void updateBusSeatesDetails(int rID,int jID,String s_no);
	public void updateBusSeatesDetailsListSeat(int rID,int jID, List<String> seat_no);
//	
	 public void decreaseSeatCount(int jID, int rID);
	//=================================Transaction
//	 public void insertTransaction(TransactionDetails rd);
//		public List<TransactionDetails> viewTransactionDetailsByTransactionID(int transaction_id);
//		
//		public List<TransactionDetails> viewCurrentTransactionByUserId(String registered_email);
//
//		
//		//==============================Payment
//		public void insertPayment(PaymentDetails rd);
//		
//		public List<PaymentDetails> viewPaymentDetailsByPaymentId(int payment_id);
//		
	 

}

//public ReservationDetails addAResevervation(ReservationDetails reservationDetails);

//public List<ReservationDetails> viewAllBookingDetailsByReservationID(String reservation_id, LocalDate date);
