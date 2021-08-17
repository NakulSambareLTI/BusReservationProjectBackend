package com.example.demo.layer3;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.ReservationDetails;
//import com.example.demo.layer2.ReservationDetailsNotFoundException;

//@Repository
public interface ReservationDetailsRepository {

// void ReservationDetails
 //void addAResevervation(ReservationDetails ref);
	
 int insertReservation(ReservationDetails ref);
 
	//public List<ReservationDetails> viewAllBookingDetailsByReservationID(String reservation_id, LocalDate date);
 public List<ReservationDetails> viewBookingDetailsByReservationID(int reservation_id);
	
	public List<ReservationDetails> viewCurrentBookingByUserId(String registered_email);
	void deleteReservation(int res) throws NumberNotFoundException;

}

	
	
	
	
	
	
	
	
//	
//	void insertReservation(ReservationDetails ref);
//	//void insertReservations(int ref);
//	ReservationDetails selectReservation(String reservation_id) throws ReservationDetailsNotFoundException;
//	
//	List<ReservationDetails> selectAllReservation();
//}
