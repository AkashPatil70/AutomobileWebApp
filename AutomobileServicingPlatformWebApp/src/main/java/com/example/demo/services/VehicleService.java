package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Offer;
import com.example.demo.entities.Vehicle;
import com.example.demo.repositories.VehicleRepo;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepo vrepo;
	
	/*public boolean addVehicle(Vehicle vehicle) {
		Vehicle v=vserv.save(vehicle);
		if(v!=null){
			return true;
		}
		return false;
	}
	
	 public Vehicle deleteVehicle(Vehicle vehicleid)
	 {
		 Vehicle v=vserv.remove(vehicleid);
		 return v;
	 }*/
	
	public Vehicle addVehicle(Vehicle veh)
	{
		return vrepo.save(veh);
	}
	
	public List<Vehicle> getVehiclesById(int vid)
	{
		return vrepo.getVehicles(vid);
	}

}
