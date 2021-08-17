package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.TransactionDetails;

@Repository
public interface TransactionDetailsRepository {

	 int insertTransaction(TransactionDetails ref);
	 
		//public List<ReservationDetails> viewAllBookingDetailsByReservationID(String reservation_id, LocalDate date);
	 public List<TransactionDetails> viewTransactionDetailsByTransactionID(int transaction_id);
		
		public List<TransactionDetails> viewCurrentTransactionByUserId(String registered_email);
		void deleteTransaction(int rID) throws NumberNotFoundException;
	
	
}
