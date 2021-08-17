package com.example.demo.layer4;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmailUtility.EmailUtility;
import com.example.demo.layer2.BusSeatesDetails;
import com.example.demo.layer2.PaymentDetails;
import com.example.demo.layer2.ReservationDetails;
import com.example.demo.layer2.TransactionDetails;
import com.example.demo.layer3.BusJourneyDetailsRepository;
import com.example.demo.layer3.BusSeatDetailsRepository;
import com.example.demo.layer3.NumberNotFoundException;
//import com.example.demo.layer3.BusSeatesDetailsRepository;
import com.example.demo.layer3.PaymentDetailsRepository;
import com.example.demo.layer3.ReservationDetailsRepository;
import com.example.demo.layer3.TransactionDetailsRepository;
import com.example.demo.layer3.WalletRepoImpl;

@Service
public class ServiceImpl implements Service1 {

	@Autowired
	ReservationDetailsRepository reservationDetailsRepository;
	@Autowired
	BusJourneyDetailsRepository busJourneyDetailsRepository;
	@Autowired
	BusSeatDetailsRepository busSeatesDetailsRepository;
	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;
	@Autowired
	PaymentDetailsRepository paymentDetailsRepository;
	
	@Autowired
	WalletRepoImpl walletRepoImpl;
	@Autowired
	EmailUtility emailUtility;
	
	 public int insertReservation(ReservationDetails rd) {
			int reserv_id=reservationDetailsRepository.insertReservation(rd);
			emailUtility.sendEmail(rd.getRegistered_email(), "Success : The Ticket resreveration details", getEmailBody(rd));
	     return reserv_id;	
	 }
	 
	 
	 private String getEmailBody(ReservationDetails reservationDetails) {
		 return "Your ticket is booked successfully. Your journey scheduled on "+
	 reservationDetails.getDeparture_Date()+". Your seat number is:"+reservationDetails.getSeats_Booked();
	 }
	
	 public List<ReservationDetails> viewBookingDetailsByReservationID(int reservation_id){
		return reservationDetailsRepository.viewBookingDetailsByReservationID(reservation_id);
		 
	 }
		
	 public List<ReservationDetails> viewCurrentBookingByUserId(String registered_email){
		return reservationDetailsRepository.viewCurrentBookingByUserId(registered_email);
		 
	 }

//	@Override
//	public Class<? extends Annotation> annotationType() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String value() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	//==================BusJourneyDEtails
	
	//@Override
	 public void decreaseSeatCount(int jID, int rID){
		 System.out.println("SeatCountDecrease");
		 
			 busJourneyDetailsRepository.decreaseSeatCount(jID, rID);
		 System.out.println("Seats Count Decreased");
		 
		 }
	
	
	
	//==============BusSeatesDetails
		
		
		//@Override
		public void updateBusSeatesDetails(int rID,int jID,String s_no) {
			System.out.println("updateBusSeatesDetails() calling........");
			
			try {
			busSeatesDetailsRepository.updateBusSeatesDetails(rID,jID,s_no);
			System.out.println("ReservationId in BusSeatesDetails Updated");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		public void updateBusSeatesDetailsListSeat(int rID, int jID, List<String> seat_no) {
			System.out.println("updateBusSeatesDetailsListSeat() calling...");
			try {
				busSeatesDetailsRepository.updateBusSeatesDetailsListSeat(rID,jID,seat_no);
				System.out.println("ReservationId in BusSeatesDetails Updated");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	//================Transaction
		
		//@Override
		public int  insertTransaction(TransactionDetails rd) {
	int tid=	transactionDetailsRepository.insertTransaction(rd);
	return tid;
			
		}

		//@Override
		public List<TransactionDetails> viewTransactionDetailsByTransactionID(int transaction_id) {
			return transactionDetailsRepository.viewTransactionDetailsByTransactionID(transaction_id);
			
		}

//		//@Override
		public List<TransactionDetails> viewCurrentTransactionByUserId(String registered_email) {
			
			return transactionDetailsRepository.viewCurrentTransactionByUserId(registered_email);
		}
	
	//==================Payment
		
		
		public int insertPayment(PaymentDetails ref) {
			//PaymentDetails pd=ref;
			//pd.setPaymentId("PID223");
			int pid =paymentDetailsRepository.insertPayment(ref);
			return pid;
			
		}
		
		public List<PaymentDetails> viewPaymentDetailsByPaymentId(int payment_id){
			return paymentDetailsRepository.viewPaymentDetailsByPaymentId(payment_id);
					
		}

		public List<PaymentDetails> viewCurrentPaymentByUserId(String registered_email){
			return paymentDetailsRepository.viewCurrentPaymentByUserId(registered_email);
			
			
			
		}


//		@Override
//		public void updateBusJourneyDetails(int rID, int jID) {
//			// TODO Auto-generated method stub
//			
//		}
//
//
//		@Override
//		public void updateBusJourneyDetails1(int rID, int jID) {
//			// TODO Auto-generated method stub
//			
//		}
//		
		
	
//	public ReservationDetails addAResevervation(ReservationDetails reservationDetails) {
//		return reservationDetailsRepository.addAResevervation(reservationDetails);
//		
//	}
	
		public void deletePayment(int rID) throws NumberNotFoundException {
			  System.out.println("deletePayment...method "); 
			  try {
				  paymentDetailsRepository.deletePayment(rID); System.out.println("Payment Deleted");
			 } 
			  catch (NumberNotFoundException e) { e.printStackTrace(); } 
			  }
		
		
		public void deleteReservation(int rID) throws NumberNotFoundException{
			System.out.println("deleteReservation...method ");
			try {
				reservationDetailsRepository.deleteReservation(rID);
				System.out.println("Reservation Deleted");
			} catch (NumberNotFoundException e) {
				e.printStackTrace();
			}
	}
		public void deleteTransaction(int rID) throws NumberNotFoundException {
			  System.out.println("deleteTransaction...method "); 
			  try {
				  transactionDetailsRepository.deleteTransaction(rID);
			  System.out.println("Transaction Deleted"); 
			  } 
			  catch (NumberNotFoundException
			  e) 
			  { e.printStackTrace(); } 
			  }
	
		public void addMoneyToWallet(String mailID) throws NumberNotFoundException{
			System.out.println("addMoneyWallet()");
			try {
				walletRepoImpl.addMoneyToWallet(mailID);
				System.out.println("Money Added to Wallet");
			}
			catch(NumberNotFoundException e) {
				e.printStackTrace();
			}
		}
		public void cancelReservation(String email, int jID, int rID) {
			try {
				busJourneyDetailsRepository.changeAvailableSeats(jID, rID);
				busSeatesDetailsRepository.updateSeatDetails(rID);
				//addMoneyToWallet(email);
			deleteTransaction(rID); deletePayment(rID);
			deleteReservation(rID);
			
			}
			catch(NumberNotFoundException e){
				e.printStackTrace();
			}
		}
		
		public void insertReservationDetails1(ReservationDetails r,PaymentDetails p,TransactionDetails t)
		{
			int rid=reservationDetailsRepository.insertReservation(r);
			
			p.setReservationId(rid);
			int pid= paymentDetailsRepository.insertPayment(p);
			
			t.setReservation_id(rid);
			t.setPayment_id(pid);
			transactionDetailsRepository.insertTransaction(t);
			
			
			
		}
		
		
}
