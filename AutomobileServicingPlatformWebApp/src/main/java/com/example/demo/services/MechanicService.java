package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Mechanic;
import com.example.demo.repositories.MechanicRepo;

@Service
public class MechanicService {
	
	@Autowired
	private MechanicRepo mrepo;
	
	public boolean addMechanic(Mechanic mech) {
		Mechanic m=mrepo.save(mech);
		if(m!=null){
			return true;
		}
		return false;
	}
	
	public Optional<Mechanic> deleteMechanic(int id) {
		Optional<Mechanic>mech =mrepo.findById(id);
		if(mech!=null) {
			mrepo.deleteById(id);
		}
		return mech;
	}
}
