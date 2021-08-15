package com.example.demo.layer4;

import java.util.List;

import com.example.demo.layer2.BusSeatDetailsNotFoundException;
import com.example.demo.layer2.BusSeatesDetails;

public interface BusSeatesDetailsService {
	List<BusSeatesDetails> selectAllBusSeatesDetailsService();
	List<BusSeatesDetails> selectBusSeatesDetailsByReservationIdService(int ReservationID)throws BusSeatDetailsNotFoundException;
	List<BusSeatesDetails> selectBusSeatesDetailsBySeatNoService(String SeatNo)throws BusSeatDetailsNotFoundException;
	List<BusSeatesDetails> selectBusSeatesDetailsByJourneyIDService(int journeyID)throws BusSeatDetailsNotFoundException;
}
