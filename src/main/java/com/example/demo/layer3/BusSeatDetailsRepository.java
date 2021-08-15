package com.example.demo.layer3;

import java.util.List;

import com.example.demo.layer2.BusJourneyDetails;
import com.example.demo.layer2.BusSeatDetailsNotFoundException;
import com.example.demo.layer2.BusSeatesDetails;

public interface BusSeatDetailsRepository {
	List<BusSeatesDetails> selectAllBusSeatesDetails();
	List<BusSeatesDetails> selectBusSeatesDetailsByReservationId(int ReservationID)throws BusSeatDetailsNotFoundException;
	List<BusSeatesDetails> selectBusSeatesDetailsBySeatNo(String SeatNo)throws BusSeatDetailsNotFoundException;
	List<BusSeatesDetails> selectBusSeatesDetailsByJourneyID(int journeyID)throws BusSeatDetailsNotFoundException;
void updateBusSeatesDetails(int rID,int jID,String s_no);
	
	void updateBusSeatesDetailsListSeat(int rID,int jID,List<String> seat_no);
	void updateSeatDetails(int rID) throws NumberNotFoundException;
	//void updateSeatDetails(int rID) throws NumberNotFoundException;
}
