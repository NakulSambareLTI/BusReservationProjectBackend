package com.example.demo.layer4;


import java.util.List;

//import org.springframework.stereotype.Service;


import com.example.demo.layer2.ReservationDetails;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

//@Controller
//@Component
//public interface Service 

@Service
public interface ReservationService{

	
	
	//Reservation
	void addAResevervation(ReservationDetails ref);
	
	 public void insertReservation(ReservationDetails rd);
	public List<ReservationDetails> viewBookingDetailsByReservationID(String reservation_id);
	
	public List<ReservationDetails> viewCurrentBookingByUserId(String registered_email);
	

	
	
	
	
	
	
	
	

}

//public ReservationDetails addAResevervation(ReservationDetails reservationDetails);

//public List<ReservationDetails> viewAllBookingDetailsByReservationID(String reservation_id, LocalDate date);
