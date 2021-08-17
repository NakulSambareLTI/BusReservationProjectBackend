package com.example.demo.layer2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="payment_details")
public class PaymentDetails {
	@Id
	 @SequenceGenerator(name="payment_details_paymentId_GENERATOR", sequenceName="PAYMENT_ID")
		@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="payment_details_paymentId_GENERATOR")
	//@GeneratedValue
	
	@Column(name="PAYMENT_ID")
	private int paymentId;
	
	@Column(name="REGISTERED_EMAIL")
	private String registeredEmail;

	@Column(name="UNREGISTERED_EMAIL")
	private String unregisteredEmail;
	
	@Column(name="RESERVATION_ID")
	private int reservationId;
	
	@Column(name="PAYMENT_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date paymentDate;


	@Column(name="TOTAL_AMOUNT_PAID")
	private int totalAmountPaid;

	
	
	//String paymentId,

	public PaymentDetails(int paymentId, String registeredEmail, String unregisteredEmail, int reservationId,
			Date paymentDate, int totalAmountPaid) {
		super();
		this.paymentId = paymentId;
		this.registeredEmail = registeredEmail;
		this.unregisteredEmail = unregisteredEmail;
		this.reservationId = reservationId;
		this.paymentDate = paymentDate;
		this.totalAmountPaid = totalAmountPaid;
	}


	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public String getRegisteredEmail() {
		return registeredEmail;
	}


	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}


	public String getUnregisteredEmail() {
		return unregisteredEmail;
	}


	public void setUnregisteredEmail(String unregisteredEmail) {
		this.unregisteredEmail = unregisteredEmail;
	}


	public int getReservationId() {
		return reservationId;
	}


	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public int getTotalAmountPaid() {
		return totalAmountPaid;
	}


	public void setTotalAmountPaid(int totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}
	
	
	
}
