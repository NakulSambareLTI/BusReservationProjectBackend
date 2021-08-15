package com.example.demo.layer4;



import org.springframework.stereotype.Service;




@Service
public interface BusService {
	boolean updatebusRoute(int journeyid,String source,String destination);
	

}
