package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.PaymentDetails;
import com.example.demo.layer2.ReservationDetails;

@Repository
public class PaymentDetailsRepositoryImpl extends BaseRepository implements PaymentDetailsRepository{

	
	@Transactional
	public void insertPayment(PaymentDetails ref) {
		EntityManager em = getEntityManager();
		em.persist(ref); //based on PK
	System.out.println("Payment inserted...");
		
	}

	@Override
	public List<PaymentDetails> viewPaymentDetailsByPaymentId(int paymentId) {
	EntityManager entityManager=getEntityManager();
	String jpql="select j from PaymentDetails j where j.paymentId=: vpaymentId";
	Query query=entityManager.createQuery(jpql,PaymentDetails.class);
	query.setParameter("vpaymentId", paymentId);
	List<PaymentDetails> lu=query.getResultList();		
		return lu;
	}

	@Override
	public List<PaymentDetails> viewCurrentPaymentByUserId(String registeredEmail) {
		EntityManager entityManager=getEntityManager();
		String jpql="select j from PaymentDetails j where j.registeredEmail=: vregistered_email";
		Query query=entityManager.createQuery(jpql,PaymentDetails.class);
		query.setParameter("vregistered_email", registeredEmail);
		List<PaymentDetails> lu=query.getResultList();
		return lu;
	}

	@Transactional
	public void deletePayment(int rID) throws NumberNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("delete from PaymentDetails p where p.reservationId = :rID");
		query.setParameter("rID", rID);
		query.executeUpdate();		
	}
}
