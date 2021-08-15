package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.BusDetails;
import com.example.demo.layer2.BusDetailsNotFoundException;
import com.example.demo.layer2.BusJourneyDetails;
import com.example.demo.layer2.BusJourneyDetailsNotFoundException;
import com.example.demo.layer2.BusSeatDetailsNotFoundException;
import com.example.demo.layer2.BusSeatesDetails;
import com.example.demo.layer2.ReservationDetails;
import com.example.demo.layer3.BusDetailRepositoryImpl;
import com.example.demo.layer3.BusJourneyDetailsRepositoryImpl;
import com.example.demo.layer3.BusSeatesDetailsRepositoryImpl;
import com.example.demo.layer3.ReservationDetailsRepositoryImpl;

@SpringBootTest
class BusReservationApplicationTests {
	
	@Autowired
	BusJourneyDetailsRepositoryImpl busJourneyDetailsRepositoryImpl = new BusJourneyDetailsRepositoryImpl();
	@Autowired 
	BusDetailRepositoryImpl busDetailRepositoryImpl = new BusDetailRepositoryImpl();
	@Autowired
	BusSeatesDetailsRepositoryImpl busSeatesDetailsRepositoryImpl = new BusSeatesDetailsRepositoryImpl();
	
	@Autowired
	ReservationDetailsRepositoryImpl reservationDetailsRepositoryImpl;
	
	@Test
	void selectAllBusJourneyDetailsTest() {
		List<BusJourneyDetails> busJourneyDetailsList=busJourneyDetailsRepositoryImpl.selectAllBusJourneyDetails();
		for (BusJourneyDetails busJourneyDetails : busJourneyDetailsList) {
			System.out.println("Bus No :"+busJourneyDetails.getBus_no());
			
		}
	}
	@Test
	void selectAllBusDetailsTest() {
		//BusDetailRepositoryImpl busDetailRepositoryImpl = new BusDetailRepositoryImpl(); 
		List<BusDetails> busDetailsList=busDetailRepositoryImpl.selectAllBusDetails();
	     for (BusDetails busDetails : busDetailsList) {
			System.out.println(busDetails.getBus_no());
		}
	}
	
	@Test
	void selectSeatesAvailableInBusJourneyDetails()
	{
		int seates=0;
		try {
			 seates = busJourneyDetailsRepositoryImpl.selectAvailableSeates("TN101", 23456);
		} catch (BusJourneyDetailsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Seates available : "+seates);
	}
	
	@Test
	void selectAllSeatesDetails() {
		List<BusSeatesDetails> busSeatDetailsList=busSeatesDetailsRepositoryImpl.selectAllBusSeatesDetails();
		for (BusSeatesDetails busSeatesDetails : busSeatDetailsList) {
			System.out.println(busSeatesDetails.getJourney_id());
			System.out.println(busSeatesDetails.getReservation_id());
			System.out.println(busSeatesDetails.getSeat_no());


		}

		
	}
	@Test
	void selectAllSeatesByJourneyID() throws BusSeatDetailsNotFoundException
	{
		List<BusSeatesDetails> busSeatDetailsList=busSeatesDetailsRepositoryImpl.selectBusSeatesDetailsByJourneyID(23456);
		for (BusSeatesDetails busSeatesDetails : busSeatDetailsList) {
			System.out.println(busSeatesDetails.getJourney_id());
			System.out.println(busSeatesDetails.getReservation_id());
			System.out.println(busSeatesDetails.getSeat_no());


		}

	}
	@Test 
	void selectCostPfSeatByBusNo() throws BusDetailsNotFoundException
	{
		int cost_per_Seat=busDetailRepositoryImpl.selectCostPerSeat("TN102");
		System.out.println("Coat per seat = "+cost_per_Seat);
	}
	
	
	@Test 
	void selectTotalNoOfSeates() throws BusDetailsNotFoundException
	{
		int no_of_seates=busDetailRepositoryImpl.selectNoOfSeates("TN101");
		System.out.println("Total No of seates = "+no_of_seates);
	}
	
	@Test
	void ReservationDetailsTest()
	{
		List<ReservationDetails> reservationDetails=reservationDetailsRepositoryImpl.viewCurrentBookingByUserId("jack@gmail.com");
		for (ReservationDetails reservationDetails2 : reservationDetails) {
			System.out.println("Source Location "+reservationDetails2.getJourney_Id());
		}
	}
	

}
