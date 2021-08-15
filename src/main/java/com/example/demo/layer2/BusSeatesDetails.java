package com.example.demo.layer2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BUS_SEATES_DETAILS")
public class BusSeatesDetails {
	@Id
	@Column(name="SEAT_NO")
	 private String seat_no;
	@Column(name="RESERVATION_ID")
	 private int reservation_id;
	
	@Column(name="JOURNEY_ID")
	 private int journey_id;

	public String getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getJourney_id() {
		return journey_id;
	}

	public void setJourney_id(int journey_id) {
		this.journey_id = journey_id;
	}
	
}
