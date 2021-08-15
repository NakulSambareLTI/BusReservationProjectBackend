package com.example.demo.layer3;



import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.BusDetails;
import com.example.demo.layer2.BusDetailsNotFoundException;


@Repository
public class BusDetailRepositoryImpl extends BaseRepository implements BusDetailsRepository{
	public BusDetailRepositoryImpl()
	{
		System.out.println("BusDetailRepositoryImpl() constructed..");
	}

	@Transactional
	public List<BusDetails> selectAllBusDetails() {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("from BusDetails");
		List<BusDetails> busDetailsList = query.getResultList();
		System.out.println("busDetailsList "+busDetailsList.size());
		
		return busDetailsList;
	}

	@Transactional
	public BusDetails selectBusDetails(String bus_no) {
		// TODO Auto-generated method stub
          System.out.println("In the select bus method...");
		EntityManager entityManager = getEntityManager();
		return entityManager.find(BusDetails.class, bus_no);//based on PK
		
	}

	@Transactional
	public List<BusDetails> selectBusDetailsByBusType(String bus_type) throws BusDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select b from BusDetails b where b.bus_type = :vbus_type");
		query.setParameter("vbus_type", bus_type);
		List<BusDetails>  busDetailsByBusType= query.getResultList();
		return busDetailsByBusType;
	}

	@Transactional
	public List<BusDetails> selectBusDetailsByTravelsName(String travels_name) throws BusDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select b from BusDetails b where b.travels_name = :vtravels_name");
		query.setParameter("vtravels_name", travels_name);
		List<BusDetails>  busDetailsByBusTravelsName= query.getResultList();
		return busDetailsByBusTravelsName;

	}

	@Transactional
	public int selectCostPerSeat(String bus_no) throws BusDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select b from BusDetails b where b.bus_no = :vbus_no");
		query.setParameter("vbus_no", bus_no);
		BusDetails  busDetails= (BusDetails) query.getSingleResult();
		System.out.println("Cost per seat "+busDetails.getCost_per_seat() );
		return busDetails.getCost_per_seat() ;
	}

	@Transactional
	public int selectNoOfSeates(String bus_no) throws BusDetailsNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select b from BusDetails b where b.bus_no = :vbus_no");
		query.setParameter("vbus_no", bus_no);
		BusDetails  busDetails= (BusDetails) query.getSingleResult();
		System.out.println("Cost per seat "+busDetails.getNo_of_seates() );
		return busDetails.getNo_of_seates() ;
		
	}
	
	@Transactional 
	public void addBusDetails(BusDetails bus) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		entityManager.persist(bus);				
	}
	

}
