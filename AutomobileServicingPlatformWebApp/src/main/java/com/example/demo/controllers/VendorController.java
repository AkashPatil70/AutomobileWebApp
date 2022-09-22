package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Mechanic;
import com.example.demo.entities.MechanicTemp;
import com.example.demo.entities.User;
import com.example.demo.entities.Vendor;
import com.example.demo.entities.VendorUser;
import com.example.demo.services.MechanicService;
import com.example.demo.services.VendorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class VendorController {

	@Autowired
	private VendorService vserv;
	@Autowired
	private MechanicService mserv;
	

	@PostMapping(value= "/register",consumes = {"application/json"})
	public ResponseEntity<Vendor> registerVendor(@RequestBody VendorUser v) {

		User user = new User(v.getUsername(),v.getPassword(),v.getRole());

		Vendor vendor = new Vendor(v.getShopname(),v.getAddress(),v.getContactno(),v.getEmail(),
				v.getShopactnumber(),v.getIsactive(),user,v.getCharges());


		if (vserv.registerVendor(vendor)) {
			return new ResponseEntity<Vendor>(vendor,HttpStatus.CREATED);
		}
		return new ResponseEntity<Vendor>(vendor,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getAllVendors")
	public List<Vendor> getAllVendors()
	{
		return vserv.getAllVendors();
	}
	@GetMapping("/getvendor")
	public Vendor getVendor(@RequestParam("id")int id) {
		return vserv.getActiveVendor(id);
	}

	
	@PutMapping("/updateVendor/{uid}")
	public ResponseEntity<Vendor> updateVendor(@RequestBody VendorUser v,@PathVariable("uid")int uid){
		
		Vendor vendor=vserv.getActiveVendor(uid);
		User user=vendor.getUser();
		
		user.setUsername(v.getUsername());
		user.setPassword(v.getPassword());
		user.setRole(v.getRole());
		
		vendor.setShopname(v.getShopname());
		vendor.setContactno(v.getContactno());
		vendor.setEmail(v.getEmail());
		vendor.setShopactnumber(v.getShopactnumber());
		vendor.setAddress(v.getAddress());
		vendor.setCharges(v.getCharges());
		vendor.setUser(user);
		
		Vendor vend=vserv.updateVendor(vendor);
		if(vend!=null) {
			return new ResponseEntity<Vendor>(vend,HttpStatus.CREATED);
		}
		return new ResponseEntity<Vendor>(vend,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PatchMapping("/changeStatus")
	public ResponseEntity<Vendor> changeStatus(@RequestParam("id")int id){
		Vendor v=vserv.getActiveVendor(id);
		if(vserv.changeStatuss(id)) {
			return new ResponseEntity<Vendor>(v,HttpStatus.CREATED);
		}
		return new ResponseEntity<Vendor>(v,HttpStatus.INTERNAL_SERVER_ERROR);

	}



}
