package com.example.demo.layer3;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.BusDetails;
import com.example.demo.layer2.BusJourneyDetails;
import com.example.demo.layer2.BusJourneyDetailsNotFoundException;
@Repository
public class BusJourneyDetailsRepositoryImpl extends BaseRepository implements BusJourneyDetailsRepository{

	
	public BusJourneyDetailsRepositoryImpl()
	{
		System.out.println("BusJourneyDetailsRepositoryImpl()..Created...");
	}
	@Transactional
	public List<BusJourneyDetails> selectAllBusJourneyDetails() {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("from BusJourneyDetails");
		List<BusJourneyDetails> busJourneyDetailsList = query.getResultList();
		System.out.println("busDetailsList "+busJourneyDetailsList.size());
		
		return busJourneyDetailsList;
	}

	@Transactional
	public BusJourneyDetails selectBusJourneyDetails(int journey_id) throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("inside selectbusjourney...");
		EntityManager entityManager = getEntityManager();
		return entityManager.find(BusJourneyDetails.class, journey_id);//based on PK
		
	}

	@Transactional
	public List<BusJourneyDetails> selectBusJourneyDetailsbyDepartureTime(String departure_Time)
			throws BusJourneyDetailsNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select j from BusJourneyDetails j where j.departure_Time = :vdeparture_Time");
		query.setParameter("vdeparture_Time", departure_Time);
		List<BusJourneyDetails>  busJourneyDetailsbyDepartureTime= query.getResultList();
		return busJourneyDetailsbyDepartureTime;
	}

	@Transactional
	public List<BusJourneyDetails> selectBusJourneyDetailsbyArrivalTime(String arrival_Time)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select j from BusJourneyDetails j where j.arrival_Time = :varrival_Time");
		query.setParameter("varrival_Time", arrival_Time);
		List<BusJourneyDetails>  busJourneyDetailsbyArrivalTime= query.getResultList();
		return busJourneyDetailsbyArrivalTime;
	}

	@Transactional
	public List<BusJourneyDetails> selectBusJourneyDetailsbySourceLocation(String source_loc)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select j from BusJourneyDetails j where j.source_loc = :vsource_loc");
		query.setParameter("vsource_loc", source_loc);
		List<BusJourneyDetails>  busJourneyDetailsbysource_loc= query.getResultList();
		return busJourneyDetailsbysource_loc;
	}

	@Transactional
	public List<BusJourneyDetails> selectBusJourneyDetailsbyDestinationLocation(String destination_loc)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select j from BusJourneyDetails j where j.destination_loc = :vdestination_loc");
		query.setParameter("vdestination_loc", destination_loc);
		List<BusJourneyDetails>  busJourneyDetailsbydestinationLoc= query.getResultList();
		return busJourneyDetailsbydestinationLoc;
	}

	@Transactional
	public List<BusJourneyDetails> selectBusJourneyDetailsbyDepartureDate(Date departure_date)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select j from BusJourneyDetails j where j.departure_date = :vdeparture_date");
		query.setParameter("vdeparture_date", departure_date);
		List<BusJourneyDetails>  busJourneyDetailsbydeparture_date= query.getResultList();
		return  busJourneyDetailsbydeparture_date;
	}

	@Transactional
	public List<BusJourneyDetails> selectBusJourneyDetailsbyJourneyID(int journeyID)
			throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select j from BusJourneyDetails j where j.journeyID = :vjourneyID");
		query.setParameter("vjourneyID", journeyID);
		List<BusJourneyDetails>  busJourneyDetailsbyjourneyID= query.getResultList();
		return  busJourneyDetailsbyjourneyID;
	}

	@Transactional
	public int selectAvailableSeates(String busNo, int journeyId) throws BusJourneyDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select b from BusJourneyDetails b where b.bus_no = : vbus_no and b.journey_ID = : v_journeyID");
		query.setParameter("vbus_no", busNo);
		query.setParameter("v_journeyID", journeyId);
		int seates=  query.getFirstResult();
		System.out.println("Seates availabel "+seates);
		return seates ;
	}

//@Transactional 
//	public boolean updatebusRoute(int journeyId, String source, String destination) {
//		// TODO Auto-generated method stub
//		boolean res=false;
//		EntityManager entityManager = getEntityManager();
//		BusJourneyDetails busJourneyDetails=entityManager.find(BusJourneyDetails.class, journeyId );
//		if (busJourneyDetails!=null)
//		{
//			busJourneyDetails.setSource_loc(source);
//			busJourneyDetails.setDestination_loc(destination);
//			entityManager.persist(busJourneyDetails);	
//			res=true;
//		}
//		return res;
//	}
	@Transactional
	public void decreaseSeatCount(int jID, int rID) {
	EntityManager entityManager = getEntityManager();
	Query query = entityManager.createQuery("update BusJourneyDetails b set b.available_seates = ((select s.available_seates from BusJourneyDetails s where s.journeyID = :jID) - (select r.seats_Booked from ReservationDetails r where r.journey_Id = :jID and r.reservation_id = :rID)) where b.journeyID = :jID").setParameter("jID",jID).setParameter("rID", rID);
	query.executeUpdate();
	}
	
	
	@Transactional
	public void changeAvailableSeats(int jID, int rID) throws NumberNotFoundException{
	EntityManager entityManager = getEntityManager();
	Query query = entityManager.createQuery("update BusJourneyDetails b set b.available_seates = (select r.seats_Booked from ReservationDetails r where r.journey_Id = :jID and r.reservation_id = :rID) + b.available_seates where b.journeyID = :jID").setParameter("jID",jID).setParameter("rID", rID);
	query.executeUpdate();
	}
	
	
	
	
	
	
}
