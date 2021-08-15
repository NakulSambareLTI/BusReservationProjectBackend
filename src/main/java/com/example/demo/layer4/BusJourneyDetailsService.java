package com.example.demo.layer4;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import com.example.demo.layer2.BusJourneyDetails;
import com.example.demo.layer2.BusJourneyDetailsNotFoundException;
import com.example.demo.layer3.NumberNotFoundException;

public interface BusJourneyDetailsService {
	List<BusJourneyDetails> selectAllBusJourneyDetailsService();
    BusJourneyDetails selectBusJourneyDetailsService(int journey_id) throws BusJourneyDetailsNotFoundException ;
     List<BusJourneyDetails> selectBusJourneyDetailsbyDepartureTimeService(String departure_Time) throws BusJourneyDetailsNotFoundException ;
     List<BusJourneyDetails> selectBusJourneyDetailsbyArrivalTimeService(String arrival_Time) throws BusJourneyDetailsNotFoundException ;
     List<BusJourneyDetails> selectBusJourneyDetailsbySourceLocationService(String sourceLoc) throws BusJourneyDetailsNotFoundException ;
     List<BusJourneyDetails> selectBusJourneyDetailsbyDestinationLocationService(String destinationLoc) throws BusJourneyDetailsNotFoundException ;
     List<BusJourneyDetails> selectBusJourneyDetailsbyDepartureDateService(Date departure_date) throws BusJourneyDetailsNotFoundException ;
    // List<BusJourneyDetails> selectBusJourneyDetailsbyJourneyIDService(int journeyId) throws BusJourneyDetailsNotFoundException ;
     int selectAvailableSeatesService(String busNo,int journeyId)throws BusJourneyDetailsNotFoundException;
     void changeAvailableSeats(int jID,int rID) throws NumberNotFoundException;
     //boolean updatebusRoute(int journeyid,String source,String destination);
}
