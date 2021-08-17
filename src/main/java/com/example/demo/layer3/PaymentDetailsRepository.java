package com.example.demo.layer3;

import java.util.List;

import com.example.demo.layer2.PaymentDetails;
import com.example.demo.layer2.ReservationDetails;

public interface PaymentDetailsRepository {
	
	int insertPayment(PaymentDetails ref);
	
	public List<PaymentDetails> viewPaymentDetailsByPaymentId(int payment_id);

	
	public List<PaymentDetails> viewCurrentPaymentByUserId(String registered_email);
	void deletePayment(int rID) throws NumberNotFoundException;
}
