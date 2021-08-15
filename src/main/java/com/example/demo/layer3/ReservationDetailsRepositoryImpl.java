package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.ReservationDetails;

@Repository
public class ReservationDetailsRepositoryImpl  extends BaseRepository
implements ReservationDetailsRepository{

	
	@Transactional
	public void insertReservation(ReservationDetails ref) {
		EntityManager em = getEntityManager();
		em.persist(ref); //based on PK
	System.out.println("reservation inserted...");
		
	}
	
	
	@Override
	//@Transactional
	public List<ReservationDetails> viewCurrentBookingByUserId(String registered_email) {
		EntityManager entityManager = getEntityManager();
	String jpql="select j from ReservationDetails j where j.registered_email=:registered_email";
	Query query=entityManager.createQuery(registered_email, ReservationDetails.class);
//	query.setParameter("", query);
	query.setParameter("registered_email", registered_email);
	List<ReservationDetails> lu=query.getResultList();
		return lu;
	}

	@Override
	
	public List<ReservationDetails> viewBookingDetailsByReservationID(int reservation_id) {
		EntityManager entityManager = getEntityManager();
		String jpql="select j from ReservationDetails j where j.reservation_id=:vreservation_id";
		Query query=entityManager.createQuery(jpql, ReservationDetails.class);
		query.setParameter("vreservation_id", reservation_id);
		List<ReservationDetails> lu=query.getResultList();
		return lu;
	}

	//@Override
	
	@Transactional
	public void deleteReservation(int rID) throws NumberNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("delete from ReservationDetails r where r.reservation_id = :rID");
		query.setParameter("rID", rID);
		query.executeUpdate();
	}
	
	
	
}
