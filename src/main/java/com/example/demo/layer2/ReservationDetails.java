package com.example.demo.layer2;




import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="reservation_details")
public class ReservationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RESERVATION_ID")
	private int reservation_id;
	
@Column(name="REGISTERED_EMAIL")
	private String registered_email;
	
//	@JoinColumn(name="REGISTERED_EMAIL")
//	@OneToOne(fetch=FetchType.EAGER)
//	private UserProfile registered_email;
	
	@Column(name="UNREGISTERED_EMAIL")
	private String unregistered_email;
	
	@Column(name="SEATS_BOOKED")
	private int seats_Booked;
	
//	@JoinColumn(name="JOURNEY_ID")
//	@OneToOne(fetch=FetchType.EAGER)
//private BusJourneyDetails journey_Id;
	
	
   @Column(name="JOURNEY_ID")
	private int journey_Id;
	
	@Column(name="DEPARTURE_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date departure_Date;
	
	@Column(name="RESERVATION_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date reservation_Date;

	@Column(name="RESERVATION_TIME")
	private String reservation_Time;

	@Column(name="DRIVERLESS")
	private String driver_less;
	
//	@OneToMany(mappedBy="reservationDetail")
//	private List<BusSeatesDetails> busSeatesDetails;

	
	
	public ReservationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public ReservationDetails(String reservation_id, String registered_email, String unregistered_email,
//			String seats_Booked, int journey_Id, Date departure_Date, Date reservation_Date, String reservation_Time,
//			String driver_less) {
//		super();
//		this.reservation_id = reservation_id;
//		this.registered_email = registered_email;
//		this.unregistered_email = unregistered_email;
//		this.seats_Booked = seats_Booked;
//		this.journey_Id = journey_Id;
//		this.departure_Date = departure_Date;
//		this.reservation_Date = reservation_Date;
//		this.reservation_Time = reservation_Time;
//		this.driver_less = driver_less;
//	}

	
	

	public ReservationDetails(String reservation_id,String registered_email, String unregistered_email,
		int seats_Booked, int journey_Id, Date departure_Date, Date reservation_Date, String reservation_Time,
		String driver_less) {
	super();
	
	this.registered_email = registered_email;
	this.unregistered_email = unregistered_email;
	this.seats_Booked = seats_Booked;
	this.journey_Id = journey_Id;
	this.departure_Date = departure_Date;
	this.reservation_Date = reservation_Date;
	this.reservation_Time = reservation_Time;
	this.driver_less = driver_less;
}


//
public String getRegistered_email() {
		return registered_email;
	}
//
public void setRegistered_email(String registered_email) {
	this.registered_email = registered_email;
	}


//	public UserProfile getRegistered_email() {
//		return registered_email;
//	}
//
//	public void setRegistered_email(UserProfile  registered_email) {
//		this.registered_email = registered_email;
//	}

	public String getUnregistered_email() {
		return unregistered_email;
	}

	public void setUnregistered_email(String unregistered_email) {
		this.unregistered_email = unregistered_email;
	}

	public int getSeats_Booked() {
		return seats_Booked;
	}

	public void setSeats_Booked(int seats_Booked) {
		this.seats_Booked = seats_Booked;
	}

//     public BusJourneyDetails getJourney_Id() {
//		return journey_Id;
//	}
//
//	public void setJourney_Id(BusJourneyDetails journey_Id) {
//		this.journey_Id = journey_Id;
//	}

	public int getJourney_Id() {
		return journey_Id;
}
//
	public void setJourney_Id(int journey_Id) {
		this.journey_Id = journey_Id;
	}
	public Date getDeparture_Date() {
		return departure_Date;
	}

	public void setDeparture_Date(Date departure_Date) {
		this.departure_Date = departure_Date;
	}

	public Date getReservation_Date() {
		return reservation_Date;
	}

	public void setReservation_Date(Date reservation_Date) {
		this.reservation_Date = reservation_Date;
	}

	public String getReservation_Time() {
		return reservation_Time;
	}

	public void setReservation_Time(String reservation_Time) {
		this.reservation_Time = reservation_Time;
	}

	public String getDriver_less() {
		return driver_less;
	}

	public void setDriver_less(String driver_less) {
		this.driver_less = driver_less;
	}

//	public List<BusSeatesDetails> getBusSeatesDetails() {
//		return busSeatesDetails;
//	}
//
//	public void setBusSeatesDetails(List<BusSeatesDetails> busSeatesDetails) {
//		this.busSeatesDetails = busSeatesDetails;
//	}
	
	
	
}
//	public ReservationDetails() {
//	}
//
//	public String getReservationId() {
//		return this.reservation_id;
//	}
//
//	public void setReservationId(String reservationId) {
//		this.reservation_id = reservationId;
//	}
//
//	public Date getDepartureDate() {
//		return this.departure_Date;
//	}
//
//	public void setDepartureDate(Date departureDate) {
//		this.departure_Date = departureDate;
//	}
//
//	public String getDriverless() {
//		return this.driver_less;
//	}
//
//	public void setDriverless(String driverless) {
//		this.driver_less = driverless;
//	}
//
//	public Integer getJourneyId() {
//		return this.journey_Id;
//	}
//
//	public void setJourneyId(Integer journeyId) {
//		this.journey_Id = journey_Id;
//	}
//
//	public String getRegisteredEmail() {
//		return this.registered_email;
//	}
//
//	public void setRegisteredEmail(String registeredEmail) {
//		this.registered_email = registered_email;
//	}
//
//	public Date getReservationDate() {
//		return this.reservation_Date;
//	}
//
//	public void setReservationDate(Date reservationDate) {
//		this.reservation_Date = reservation_Date;
//	}
//
//	public String getReservationTime() {
//		return this.reservation_Time;
//	}
//
//	public void setReservationTime(String reservationTime) {
//		this.reservation_Time = reservationTime;
//	}
//
//	public String getSeatsBooked() {
//		return this.seats_Booked;
//	}
//
//	public void setSeatsBooked(String seats_Booked) {
//		this.seats_Booked = seats_Booked;
//	}
//
//	public String getUnregistered_Email() {
//		return this.unregistered_email;
//	}
//
//	public void setUnregisteredEmail(String unregistered_Email) {
//		this.unregistered_email = unregistered_Email;
//	}
//
//	public List<BusSeatesDetails> getBusSeatesDetails() {
//		return this.busSeatesDetails;
//	}
//
//	public void setBusSeatesDetails(List<BusSeatesDetails> busSeatesDetails) {
//		this.busSeatesDetails = busSeatesDetails;
//	}
//
//	

	

