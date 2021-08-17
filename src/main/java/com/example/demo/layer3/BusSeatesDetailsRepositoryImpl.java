package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.BusJourneyDetails;
import com.example.demo.layer2.BusSeatDetailsNotFoundException;
import com.example.demo.layer2.BusSeatesDetails;
@Repository
public class BusSeatesDetailsRepositoryImpl extends BaseRepository implements BusSeatDetailsRepository{
          public BusSeatesDetailsRepositoryImpl()
          {
        	  System.out.println("BusSeatesDetailsRepositoryImpl()......");
          }

        @Transactional
		public List<BusSeatesDetails> selectAllBusSeatesDetails() {
			// TODO Auto-generated method stub
        	EntityManager entityManager = getEntityManager();

    		Query query = entityManager.createQuery(" from BusSeatesDetails");
    		List<BusSeatesDetails> busSeatesDetailsList = query.getResultList();
    		System.out.println("BusSeatesDetails length "+busSeatesDetailsList.size());
    		
    		return busSeatesDetailsList;		
    		}

        @Transactional
		public List<BusSeatesDetails> selectBusSeatesDetailsByReservationId(int ReservationID)
				throws BusSeatDetailsNotFoundException {
			// TODO Auto-generated method stub
        	EntityManager entityManager = getEntityManager();
    		Query query = entityManager.createQuery("select b from BusSeatesDetails b where b.reservation_id = :vreservation_id");
    		query.setParameter("vreservation_id",ReservationID);
    		List<BusSeatesDetails> busSeatesDetailsbyReservationId= query.getResultList();
    		return busSeatesDetailsbyReservationId;		
    		}

        @Transactional
		public List<BusSeatesDetails> selectBusSeatesDetailsBySeatNo(String SeatNo)
				throws BusSeatDetailsNotFoundException {
			// TODO Auto-generated method stub
        	EntityManager entityManager = getEntityManager();
    		Query query = entityManager.createQuery("select b from BusSeatesDetails b where b.seat_no = :vseat_no");
    		query.setParameter("vseat_no",SeatNo);
    		List<BusSeatesDetails> busSeatesDetailsbySeatNo= query.getResultList();
    		return busSeatesDetailsbySeatNo;	
		}

        @Transactional
		public List<BusSeatesDetails> selectBusSeatesDetailsByJourneyID(int journeyID)
				throws BusSeatDetailsNotFoundException {
			// TODO Auto-generated method stub
        	EntityManager entityManager = getEntityManager();
    		Query query = entityManager.createQuery("select b from BusSeatesDetails b where b.journey_id = :vjourney_id");
    		query.setParameter("vjourney_id",journeyID);
    		List<BusSeatesDetails> busSeatesDetailsbyjourneyID= query.getResultList();
    		return busSeatesDetailsbyjourneyID;
		}
        
        
        
        
        
        @Transactional
    	public void updateBusSeatesDetails(int rID,int jID,String s_no) {
    		EntityManager entityManager = getEntityManager();
    		Query query=entityManager.createQuery("update BusSeatesDetails set reservation_id=:rID where journey_id=:jID and seat_no=:s_no").setParameter("jID",jID).setParameter("rID", rID).setParameter("s_no",s_no);
    		//query.setParameter("rID", rID);
    		query.executeUpdate();
    		
    		
    		
    	}

    	//@Override
    	@Transactional
    	public void updateBusSeatesDetailsListSeat(int rID, int jID, List<String> seat_no) {
    		EntityManager entityManager=getEntityManager();
//    		String seat_no1;
    		for(String seat_no1: seat_no) {
    			System.out.println(seat_no1);
    		Query query=entityManager.createQuery("update BusSeatesDetails set reservation_id=:rID where journey_id=:jID and seat_no=:s_no").setParameter("jID",jID).setParameter("rID", rID).setParameter("s_no",seat_no1);
    		
    		query.executeUpdate();
    		
    		}
    		
    		
    	}
        
    	@Transactional
    	public void updateSeatDetails(int rID) throws NumberNotFoundException{
    	EntityManager entityManager = getEntityManager();
    	Query query = entityManager.createQuery("update BusSeatesDetails b set b.reservation_id=0 where b.reservation_id = :rID ").setParameter("rID", rID);
    	query.setParameter("rID", rID);
    			
    	query.executeUpdate();
    	}
        
}
