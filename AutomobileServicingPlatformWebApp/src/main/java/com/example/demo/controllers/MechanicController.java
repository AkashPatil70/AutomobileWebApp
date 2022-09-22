package com.example.demo.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Mechanic;
import com.example.demo.entities.MechanicTemp;
import com.example.demo.entities.Vendor;
import com.example.demo.services.MechanicService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MechanicController {
	@Autowired
	private MechanicService mserv;

	@PostMapping("/addmechanic")
	public ResponseEntity<Mechanic> addMechanic(@RequestBody Mechanic mech) {

		if(mserv.addMechanic(mech)) {
			return new ResponseEntity<Mechanic>(mech, HttpStatus.CREATED);
		}

		return new ResponseEntity<Mechanic>(mech,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@GetMapping("/deleteById")
	public ResponseEntity<Optional<Mechanic>> deleteById(@RequestParam("id")int id){
		Optional<Mechanic> m=mserv.deleteMechanic(id);
		if(m!=null) {
			return new ResponseEntity<Optional<Mechanic>>(m,HttpStatus.OK);
		}
		return new ResponseEntity<Optional<Mechanic>>(m,HttpStatus.UNAUTHORIZED);
	}

}
