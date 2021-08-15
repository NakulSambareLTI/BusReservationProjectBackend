package com.example.demo.layer3;
import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import com.example.demo.layer2.BusJourneyDetails;
import com.example.demo.layer2.BusJourneyDetailsNotFoundException;
import com.example.demo.layer3.NumberNotFoundException;

public interface BusJourneyDetailsRepository {
      List<BusJourneyDetails> selectAllBusJourneyDetails();
     BusJourneyDetails selectBusJourneyDetails(int journey_id) throws BusJourneyDetailsNotFoundException ;
      List<BusJourneyDetails> selectBusJourneyDetailsbyDepartureTime(String departure_Time) throws BusJourneyDetailsNotFoundException ;
      List<BusJourneyDetails> selectBusJourneyDetailsbyArrivalTime(String arrival_Time) throws BusJourneyDetailsNotFoundException ;
      List<BusJourneyDetails> selectBusJourneyDetailsbySourceLocation(String sourceLoc) throws BusJourneyDetailsNotFoundException ;
      List<BusJourneyDetails> selectBusJourneyDetailsbyDestinationLocation(String destinationLoc) throws BusJourneyDetailsNotFoundException ;
      List<BusJourneyDetails> selectBusJourneyDetailsbyDepartureDate(Date departure_date) throws BusJourneyDetailsNotFoundException ;
      List<BusJourneyDetails> selectBusJourneyDetailsbyJourneyID(int journeyId) throws BusJourneyDetailsNotFoundException ;
      int selectAvailableSeates(String busNo,int journeyId)throws BusJourneyDetailsNotFoundException;
      void changeAvailableSeats(int jID, int rID) throws NumberNotFoundException;
      void decreaseSeatCount(int jID, int rID);
}
