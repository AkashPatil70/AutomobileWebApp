package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Offer;
import com.example.demo.entities.Vehicle;

import com.example.demo.services.VehicleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class VehicleController {
	
	@Autowired
	VehicleService vserv;
	
	/*@PostMapping("/addvehicle")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleTemp v,HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		Vehicle vehicle=null;
		if(session!=null) {
			Customer customer=(Customer)session.getAttribute("customer");
			int id=customer.getCustomerid();
			vehicle=new Vehicle(v.getVehiclename(),v.getVehiclemodel(),v.getVehicleno(),id,id);
			if(vserv.addVehicle(vehicle)) {
				return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("/deletevehicle")
	public ResponseEntity<Optional <Vehicle>> deletevehicle (@RequestParam("id") int id) { 
		Optional<Vehicle> v=vserv.deleteVehicle(id);
		
		if (v!=null) {
			return new ResponseEntity<Optional<Vehicle>> (v, HttpStatus.OK); }
		Z
		return new ResponseEntity<Optional <Vehicle>> (v,HttpStatus.UNAUTHORIZED);
		}*/
	
	@PostMapping("/addvehicle")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle veh)
	{
		Vehicle Cvehicle=vserv.addVehicle(veh);
		if(Cvehicle!=null)
		return new ResponseEntity<Vehicle>(Cvehicle,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Vehicle>(Cvehicle,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getVehiclesByCustomerID/{custmerid}")
	public ResponseEntity<List<Vehicle>> getVehiclesByCustomerId(@PathVariable("custmerid") int customerid)
	{
		List<Vehicle> vehicles=vserv.getVehiclesById(customerid);
		if(vehicles!=null)
		return new ResponseEntity<List<Vehicle>>(vehicles,HttpStatus.OK);
		else
			return new ResponseEntity<List<Vehicle>>(vehicles,HttpStatus.BAD_REQUEST);
	}


}
