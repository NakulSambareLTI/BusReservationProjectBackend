package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
//import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.BusDetails;
import com.example.demo.layer2.BusDetailsNotFoundException;
import com.example.demo.layer2.BusJourneyDetails;
import com.example.demo.layer2.BusJourneyDetailsNotFoundException;
import com.example.demo.layer2.BusSeatDetailsNotFoundException;
import com.example.demo.layer2.BusSeatesDetails;
import com.example.demo.layer2.PaymentDetails;
import com.example.demo.layer2.ReservationDetails;
import com.example.demo.layer2.TransactionDetails;
import com.example.demo.layer2.UserProfile;
import com.example.demo.layer2.WalletEntity;
import com.example.demo.layer3.AdminRepositoryImplementation;
import com.example.demo.layer3.BusDetailRepositoryImpl;
import com.example.demo.layer3.BusJourneyDetailsRepositoryImpl;
import com.example.demo.layer3.BusRepositoryImplementation;
import com.example.demo.layer3.BusSeatesDetailsRepositoryImpl;
import com.example.demo.layer3.NumberNotFoundException;
import com.example.demo.layer3.ReservationDetailsRepositoryImpl;
import com.example.demo.layer3.TransactionDetailsRepositoryImpl;
import com.example.demo.layer3.UserRepositoryImplementation;
import com.example.demo.layer3.WalletException;
import com.example.demo.layer4.ServiceImpl;
import com.example.demo.layer4.WalletService;
import com.example.demo.layer4.WalletServiceImpl;
import com.example.demo.layer5.WalletController;
import com.example.demo.layer3.PaymentDetailsRepositoryImpl;

@SpringBootTest
class BusReservationApplicationTests {
	
	@Autowired
	BusJourneyDetailsRepositoryImpl busJourneyDetailsRepositoryImpl = new BusJourneyDetailsRepositoryImpl();
	@Autowired 
	BusDetailRepositoryImpl busDetailRepositoryImpl = new BusDetailRepositoryImpl();
	@Autowired
	BusSeatesDetailsRepositoryImpl busSeatesDetailsRepositoryImpl = new BusSeatesDetailsRepositoryImpl();
	
	@Autowired
	ReservationDetailsRepositoryImpl reservationDetailsRepositoryImpl;
	
	@Autowired
	PaymentDetailsRepositoryImpl     paymentDetailsRepositoryImpl;
	
	
	@Autowired
	TransactionDetailsRepositoryImpl transactionDetailsRepositoryImpl;
	
	@Autowired
    WalletController walletController;
	
	@Autowired 
	WalletServiceImpl walletServiceImpl;
	
	
	@Autowired
	UserRepositoryImplementation userRepoImpl;
	
	@Autowired
	AdminRepositoryImplementation adminRepoImpl;
	
	@Autowired
	BusRepositoryImplementation busRepoImpl;
	
	
	
	//Nakul Sambare Test Cases
	@Test
	void selectAllBusJourneyDetailsTest() {
		List<BusJourneyDetails> busJourneyDetailsList=busJourneyDetailsRepositoryImpl.selectAllBusJourneyDetails();
		for (BusJourneyDetails busJourneyDetails : busJourneyDetailsList) {
			System.out.println("Bus No :"+busJourneyDetails.getBus_no());
			
		}
	}
	@Test
	void selectAllBusDetailsTest() {
		//BusDetailRepositoryImpl busDetailRepositoryImpl = new BusDetailRepositoryImpl(); 
		List<BusDetails> busDetailsList=busDetailRepositoryImpl.selectAllBusDetails();
	     for (BusDetails busDetails : busDetailsList) {
			System.out.println(busDetails.getBus_no());
		}
	}
	
	@Test
	void selectSeatesAvailableInBusJourneyDetails()
	{
		int seates=0;
		try {
			 seates = busJourneyDetailsRepositoryImpl.selectAvailableSeates("TN101", 23456);
		} catch (BusJourneyDetailsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Seates available : "+seates);
	}
	
	@Test
	void selectAllSeatesDetails() {
		List<BusSeatesDetails> busSeatDetailsList=busSeatesDetailsRepositoryImpl.selectAllBusSeatesDetails();
		for (BusSeatesDetails busSeatesDetails : busSeatDetailsList) {
			System.out.println(busSeatesDetails.getJourney_id());
			System.out.println(busSeatesDetails.getReservation_id());
			System.out.println(busSeatesDetails.getSeat_no());


		}

		
	}
	@Test
	void selectAllSeatesByJourneyID() throws BusSeatDetailsNotFoundException
	{
		List<BusSeatesDetails> busSeatDetailsList=busSeatesDetailsRepositoryImpl.selectBusSeatesDetailsByJourneyID(23456);
		for (BusSeatesDetails busSeatesDetails : busSeatDetailsList) {
			System.out.println(busSeatesDetails.getJourney_id());
			System.out.println(busSeatesDetails.getReservation_id());
			System.out.println(busSeatesDetails.getSeat_no());


		}

	}
	@Test 
	void selectCostPfSeatByBusNo() throws BusDetailsNotFoundException
	{
		int cost_per_Seat=busDetailRepositoryImpl.selectCostPerSeat("TN102");
		System.out.println("Coat per seat = "+cost_per_Seat);
	}
	
	
	@Test 
	void selectTotalNoOfSeates() throws BusDetailsNotFoundException
	{
		int no_of_seates=busDetailRepositoryImpl.selectNoOfSeates("TN101");
		System.out.println("Total No of seates = "+no_of_seates);
	}
	
	
	//Dharshanas Test Cases
	@Test
	void ReservationDetailsTest()
	{
		List<ReservationDetails> reservationDetails=reservationDetailsRepositoryImpl.viewCurrentBookingByUserId("jack@gmail.com");
		for (ReservationDetails reservationDetails2 : reservationDetails) {
			System.out.println("Source Location "+reservationDetails2.getJourney_Id());
		}
	}
	
	
	@Test
	void insertPaymentTest() {
		//List<PaymentDetails>details paymentDetailsRepositoryImpl.
		
		Date date1=new Date(2021,12,12);
	
		PaymentDetails insertpay=new PaymentDetails();
		//insertpay.setPaymentId(null);
		insertpay.setRegisteredEmail("dharshu2@gmail.com");
		insertpay.setUnregisteredEmail("");
		insertpay.setReservationId(102);
		//insertpay.setPaymentDate(2012-12-21);
		insertpay.setPaymentDate(date1);
		insertpay.setTotalAmountPaid(250);
		System.out.println(paymentDetailsRepositoryImpl.insertPayment(insertpay));
	}
	
	@Test
	void insertReservationTest() {
		Date date1=new Date(2021,12,12);
		Date date2=new Date(2021,12,12);
		ReservationDetails insertReserve=new ReservationDetails();
		insertReserve.setRegistered_email("dharshu2@gmail.com");
		insertReserve.setUnregistered_email("");
		insertReserve.setSeats_Booked(2);
		insertReserve.setJourney_Id(23456);
		insertReserve.setDeparture_Date(date2);
		insertReserve.setReservation_Date(date1);
		insertReserve.setReservation_Time("09:08:47");
		insertReserve.setDriver_less("NO");
		int rid=reservationDetailsRepositoryImpl.insertReservation(insertReserve);
		System.out.println(rid);
	}
	
	@Test
	void insertTransactionTest() {
		Date date2=new Date(2021,12,12);
		TransactionDetails inserttrans=new  TransactionDetails();
		inserttrans.setRegistered_email("dharshu2@gmail.com");
		inserttrans.setUnregistered_email("");
		inserttrans.setReservation_id(102);
		inserttrans.setTransaction_date(date2);
		inserttrans.setPayment_id(52);
		transactionDetailsRepositoryImpl.insertTransaction(inserttrans);
	}
	//Vasavis Test Cases
	
	@Test
    public void createWalletTest() throws WalletException {
		WalletEntity wallet = new WalletEntity();
		wallet.setRegisteredEmail("abc@gmail.com");
		wallet.setWalletPin("12321");
		wallet.setWalletAmount((long) 0);
		
		walletServiceImpl.createWallet(wallet.getRegisteredEmail(),wallet.getWalletPin());
    	 System.out.println("created wallet successfully");
    }
	    
//	    @Test
//	    public void deductBalance() throws WalletException {
//	    	try {
//	    	walletController.processWalletPayment("jyothi@gmail.com","123",(long)300);
//	    	System.out.println("Amount deducted successfully");
//	    	}
//	    	catch(Exception e) {
//	    		throw new WalletException("Invalid Email");
//	    	}
//	    }
//		
		@Test
		public void addBalance() throws WalletException {
			WalletEntity wallet1 = new WalletEntity();
			wallet1.setRegisteredEmail("nakul@gmail.com");
			wallet1.setWalletPin("12345");
			wallet1.setWalletAmount((long) 2000);
		    walletController.addBalance(wallet1);
			System.out.println("Balance added successfully");
		} 
		
		
		@Test
		public void getBalance() throws WalletException {
			Long availableBalance=walletController.getBalance("kushi@gmail.com");
			System.out.println("Available Balance: "+availableBalance);
		}
	
	
		@Test
		void updateBusJourneyDetails() {
			busJourneyDetailsRepositoryImpl.decreaseSeatCount(602,23456);
			System.out.println("Running...");
		}
	    @Test
	    void updateBusSeatesDetails() {
		busSeatesDetailsRepositoryImpl.updateBusSeatesDetails(123,23456,"S1");
	     }
		@Test
		void updateBusSeatesListTest() {
	     List<String> list1 = Arrays.asList("S5","S6","S7");
	     busSeatesDetailsRepositoryImpl.updateBusSeatesDetailsListSeat(852,23456,list1);
		}
		
		
		
		//Ameys Test Cases
		
		@Test
		void testNotNull()
		{
			assertNotNull(userRepoImpl);//checks the object is not null
		}
		
//		@Test
//		void testInsertUserProfile()
//		{
//			//userRepoImpl.inserUserProfile(new UserProfile("ameyba@gmail.com","","","","",new Date()));
//			assertTrue(true);
//		}
		@Test
		void testCheckUserForLogin()
		{
			assertTrue(userRepoImpl.checkUserForLogin("sambarenakul@gmail.com", "Nakul@1999") );
		}
		
		@Test
		void testCheckUserForLogin2()
		{
			assertFalse(userRepoImpl.checkUserForLogin("nakuls@gmail.com", "Akash@124") );
		}
		
		@Test
		void testCheckAdminForLogin()
		{
			assertTrue(adminRepoImpl.checkAdminForLogin("admin@lti.com", "Admin@123"));
		}
		
		@Test
		void testCheckAdminForLogin2()
		{
			assertFalse(adminRepoImpl.checkAdminForLogin("admin@lti.com", "Admin@124"));
		}
		
		@Test
		void checkUpdateBusRoute()
		{
			assertTrue(busRepoImpl.updatebusRoute(12345, "Chennail", "Delhi"));		
		}
		
		@Test
		void checkUpdateBusRoute2()
		{
			assertFalse(busRepoImpl.updatebusRoute(12346, "Chennail", "Delhi"));		
		}
		//Thanigaivelan test cases
		
		@Autowired
		ServiceImpl busService = new ServiceImpl();
		
		@Test
		void updateWalletTest() throws NumberNotFoundException {
			busService.addMoneyToWallet("tharun@gmail.com");
		}
		@Test
		void updateSeatDetails() throws NumberNotFoundException{
			busSeatesDetailsRepositoryImpl.updateSeatDetails(123);
		}
		@Test
		void changeSeatCount() throws NumberNotFoundException{
			busJourneyDetailsRepositoryImpl.changeAvailableSeats(23456, 123);
		}
		@Test
		void deleteReservation() throws NumberNotFoundException{
			busService.deleteReservation(123);
		}
		@Test
		void cancelReservation() throws NumberNotFoundException{
			busService.cancelReservation("tharun@gmail.com", 23441, 555);
		}

	     @Test
		 void deleteTransaction() throws NumberNotFoundException{
		 busService.deleteTransaction(123); 
		 } 
	     
	     @Test
	     void deletePayment() throws NumberNotFoundException{ 
	    	 busService.deletePayment(123);
		 
		}
		
}
