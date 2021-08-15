package com.example.demo.layer3;



import org.springframework.stereotype.Repository;



@Repository
public interface BusRepository {
	
	boolean updatebusRoute(int journeyid,String source,String destination);
	

}
