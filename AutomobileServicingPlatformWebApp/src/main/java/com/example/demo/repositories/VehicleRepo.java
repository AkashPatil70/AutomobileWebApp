package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Integer> {
	
	@Query("select veh from Vehicle veh where customerid= :id ")
	public List<Vehicle> getVehicles(int id);

}
