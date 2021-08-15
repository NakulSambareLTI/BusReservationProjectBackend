package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.BusDetails;
import com.example.demo.layer2.BusDetailsNotFoundException;
import com.example.demo.layer3.BusDetailRepositoryImpl;
@Service
public class BusDetailsServiceImpl implements BusDetailsService{
	@Autowired
	BusDetailRepositoryImpl busDetailRepositoryImpl;
	@Override
	public List<BusDetails> selectAllBusDetails() {
		// TODO Auto-generated method stub
		return busDetailRepositoryImpl.selectAllBusDetails();
	}

	@Override
	public BusDetails selectBusDetailsService(String bus_no) {
		// TODO Auto-generated method stub
		return busDetailRepositoryImpl.selectBusDetails(bus_no);
	}

	@Override
	public List<BusDetails> selectBusDetailsByBusTypeService(String bus_type) throws BusDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busDetailRepositoryImpl.selectBusDetailsByBusType(bus_type);
	}

	@Override
	public List<BusDetails> selectBusDetailsByTravelsNameService(String travels_name)
			throws BusDetailsNotFoundException {
		// TODO Auto-generated method stub
		
		return busDetailRepositoryImpl.selectBusDetailsByTravelsName(travels_name);
	}

	@Override
	public int selectCostPerSeatService(String bus_no) throws BusDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busDetailRepositoryImpl.selectCostPerSeat(bus_no);
	}

	@Override
	public int selectNoOfSeatsService(String bus_no) throws BusDetailsNotFoundException {
		// TODO Auto-generated method stub
		return busDetailRepositoryImpl.selectNoOfSeates(bus_no);
	}
	@Override
	public void addBusDetails(BusDetails bus) {
		// TODO Auto-generated method stub
		busDetailRepositoryImpl.addBusDetails(bus);
		
	}

}
