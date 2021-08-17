package com.example.demo.layer2;

public class ComplexClass {
     ReservationDetails  reservationDetails;
     PaymentDetails   paymentDetails;
     TransactionDetails transactionDetails;
	public ReservationDetails getReservationDetails() {
		return reservationDetails;
	}
	public void setReservationDetails(ReservationDetails reservationDetails) {
		this.reservationDetails = reservationDetails;
	}
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public TransactionDetails getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(TransactionDetails transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
     
}
