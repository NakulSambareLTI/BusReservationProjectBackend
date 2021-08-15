package com.example.demo.layer4;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.BusJourneyDetails;
import com.example.demo.layer2.BusJourneyDetailsNotFoundException;
import com.example.demo.layer3.BusJourneyDetailsRepositoryImpl;
import com.example.demo.layer3.NumberNotFoundException;
@Service
public class BusJourneyDetailServiceImpl implements BusJourneyDetailsService{
	@Autowired
	BusJourneyDetailsRepositoryImpl busJourneyDetailsRepositoryImpl;
	@Override
	public List<BusJourneyDetails> selectAllBusJourneyDetailsService() {
		// TODO Auto-generated method stub
		return busJourneyDetailsRepositoryImpl.selectAllBusJourneyDetails();
	}

	@Override
	public BusJourneyDetails selectBusJourneyDetailsService(int journey_id) throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busJourneyDetailsRepositoryImpl.selectBusJourneyDetails(journey_id);
	}

	@Override
	public List<BusJourneyDetails> selectBusJourneyDetailsbyDepartureTimeService(String departure_Time)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busJourneyDetailsRepositoryImpl.selectBusJourneyDetailsbyDepartureTime(departure_Time);
	}

	@Override
	public List<BusJourneyDetails> selectBusJourneyDetailsbyArrivalTimeService(String arrival_Time)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busJourneyDetailsRepositoryImpl.selectBusJourneyDetailsbyArrivalTime(arrival_Time);
	}

	@Override
	public List<BusJourneyDetails> selectBusJourneyDetailsbySourceLocationService(String sourceLoc)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busJourneyDetailsRepositoryImpl.selectBusJourneyDetailsbySourceLocation(sourceLoc);
	}

	@Override
	public List<BusJourneyDetails> selectBusJourneyDetailsbyDestinationLocationService(String destinationLoc)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busJourneyDetailsRepositoryImpl.selectBusJourneyDetailsbyDestinationLocation(destinationLoc);
	}

	@Override
	public List<BusJourneyDetails> selectBusJourneyDetailsbyDepartureDateService(Date departure_date)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busJourneyDetailsRepositoryImpl.selectBusJourneyDetailsbyDepartureDate(departure_date);
	}

//	@Override
//	public List<BusJourneyDetails> selectBusJourneyDetailsbyJourneyIDService(int journeyId)
//			throws BusJourneyDetailsNotFoundException {
//		// TODO Auto-generated method stub
//		return busJourneyDetailsRepositoryImpl.selectBusJourneyDetailsbyJourneyID(journeyId);
//	}

	@Override
	public int selectAvailableSeatesService(String busNo, int journeyId) throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busJourneyDetailsRepositoryImpl.selectAvailableSeates(busNo, journeyId);
	}

//	@Override
//	public boolean updatebusRoute(int journeyid, String source, String destination) {
//		// TODO Auto-generated method stub
//		return busJourneyDetailsRepositoryImpl.updatebusRoute(journeyid, source, destination);
//	}

	public void changeAvailableSeats(int jID,int rID) throws NumberNotFoundException{
		System.out.println("changeAvailableSeats");
		try {
			busJourneyDetailsRepositoryImpl.changeAvailableSeats(jID,rID);
		System.out.println("Seats Count Changed");
		}
		catch(NumberNotFoundException e) {
		e.printStackTrace();
		}
		}
}
