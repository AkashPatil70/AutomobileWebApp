package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Vendor;
import com.example.demo.repositories.VendorRepo;
  
@Service
public class VendorService {

	@Autowired
	private VendorRepo vrepo;
	
	
	public boolean registerVendor(Vendor v) {
		Vendor savedVendor=vrepo.save(v);
		if(savedVendor==null) {
			return false;
		}
		
		return true;
	}
	
	public Vendor getActiveVendor(int userid) {
		
		return vrepo.getActiveVendor(userid);
	}
	public List<Vendor> getAllVendors()
	{
		return vrepo.getAllVendors();
	}
	public Vendor updateVendor(Vendor v) {
		return vrepo.save(v);
	     
	}
	public boolean changeStatuss(int id) {
		vrepo.changeStatus(id);
		return true;
	}

}
