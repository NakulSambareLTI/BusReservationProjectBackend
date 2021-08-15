package com.example.demo.layer2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_details")
public class TransactionDetails {
	
	@Id
	@GeneratedValue
	 @Column(name="TRANSACTION_ID")
	 private int transaction_id;
	 
	 @Column(name="REGISTERED_EMAIL")
	 private String registered_email;
	 
	 
	 @Column(name="UNREGISTERED_EMAIL")
	 private String unregistered_email;
	 
	 @Column(name="RESERVATION_ID")
	 private int reservation_id;
	 
	 @Column(name="TRANSACTION_DATE")
	 private Date transaction_date;
	 
	 @Column(name="PAYMENT_ID")
	 private int payment_id;

	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDetails( String registered_email, String unregistered_email,
			int reservation_id, Date transaction_date, int payment_id) {
		super();
		//this.transaction_id = transaction_id;
		this.registered_email = registered_email;
		this.unregistered_email = unregistered_email;
		this.reservation_id = reservation_id;
		this.transaction_date = transaction_date;
		this.payment_id = payment_id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getRegistered_email() {
		return registered_email;
	}

	public void setRegistered_email(String registered_email) {
		this.registered_email = registered_email;
	}

	public String getUnregistered_email() {
		return unregistered_email;
	}

	public void setUnregistered_email(String unregistered_email) {
		this.unregistered_email = unregistered_email;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	
	

}
