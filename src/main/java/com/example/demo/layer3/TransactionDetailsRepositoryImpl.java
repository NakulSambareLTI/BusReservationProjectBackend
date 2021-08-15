package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.ReservationDetails;
import com.example.demo.layer2.TransactionDetails;

@Repository
public class TransactionDetailsRepositoryImpl extends BaseRepository implements TransactionDetailsRepository {

	@Transactional
	public void insertTransaction(TransactionDetails ref) {
		EntityManager em = getEntityManager();
		em.persist(ref); //based on PK
	System.out.println("Transaction inserted...");
		
	}

	@Override
	public List<TransactionDetails> viewTransactionDetailsByTransactionID(int transaction_id) {
		EntityManager entityManager = getEntityManager();
		String jpql="select j from TransactionDetails j where j.transaction_id=:vtransaction_id";
		Query query=entityManager.createQuery(jpql, TransactionDetails.class);
		query.setParameter("vtransaction_id", transaction_id);
		List<TransactionDetails> lu=query.getResultList();
		return lu;
	}
//
	@Override
	public List<TransactionDetails> viewCurrentTransactionByUserId(String registered_email) {
		EntityManager entityManager = getEntityManager();
		String jpql="select j from TransactionDetails j where j.registered_email=:vregistered_email";
		Query query=entityManager.createQuery(registered_email, TransactionDetails.class);
		query.setParameter("vregistered_email", registered_email);
		List<TransactionDetails> lu=query.getResultList();
			return lu;
	}
	@Transactional
	public void deleteTransaction(int rID) throws NumberNotFoundException {
	EntityManager entityManager = getEntityManager();
	Query query = entityManager.createQuery("delete from TransactionDetails t where t.reservation_id = :rID");
	query.setParameter("rID", rID);
	query.executeUpdate();
	}

}
