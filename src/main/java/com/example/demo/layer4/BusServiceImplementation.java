package com.example.demo.layer4;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer3.BusRepositoryImplementation;



@Service
public class BusServiceImplementation implements BusService {
	
	@Autowired
	BusRepositoryImplementation busRepoImpl;

	@Override
	public boolean updatebusRoute(int journeyid, String source, String destination) {
		// TODO Auto-generated method stub
		return busRepoImpl.updatebusRoute(journeyid, source, destination);
	}



}
