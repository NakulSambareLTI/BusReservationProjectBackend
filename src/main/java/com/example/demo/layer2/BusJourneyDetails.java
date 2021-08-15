package com.example.demo.layer2;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="bus_journey_details")
public class BusJourneyDetails {
	 @Id
	 @Column(name="JOURNEY_ID")
	 private int journeyID;
	 
	 @Column(name="BUS_NO")
	 private String bus_no;

		@Column(name="DEPARTURE_TIME")
		 private String departure_time;
		 
		 @Column(name="ARRIVAL_TIME")
		 private String arrival_time;
		 
		 @Column(name="SOURCE_LOC")
		 private String source_loc;
		 
		 @Column(name="DESTINATION_LOC")
		 private String destination_loc;
		 
		 
		 @Column(name="DEPARTURE_DATE")
		 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
		 private Date departure_date;
		 
		 @Column(name="AVAILABLESEATES")
		 private int available_seates;
		 
	 public int getJourneyID() {
		return journeyID;
	}

	public void setJourneyID(int journeyID) {
		this.journeyID = journeyID;
	}

	public BusJourneyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusJourneyDetails(int journeyID, String bus_no, String departure_time, String arrival_time,
			String source_loc, String destination_loc, Date departure_date, int available_seates) {
		super();
		this.journeyID = journeyID;
		this.bus_no = bus_no;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.source_loc = source_loc;
		this.destination_loc = destination_loc;
		this.departure_date = departure_date;
		this.available_seates = available_seates;
	}

	public String getBus_no() {
		return bus_no;
	}

	public void setBus_no(String bus_no) {
		this.bus_no = bus_no;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public String getSource_loc() {
		return source_loc;
	}

	public void setSource_loc(String source_loc) {
		this.source_loc = source_loc;
	}

	public String getDestination_loc() {
		return destination_loc;
	}

	public void setDestination_loc(String destination_loc) {
		this.destination_loc = destination_loc;
	}

	public Date getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}

	public int getAvailable_seates() {
		return available_seates;
	}

	public void setAvailable_seates(int available_seates) {
		this.available_seates = available_seates;
	}

	 
	 
	 
	 
}
