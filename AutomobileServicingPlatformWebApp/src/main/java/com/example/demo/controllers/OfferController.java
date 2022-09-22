package com.example.demo.controllers;



import java.util.List;

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

import com.example.demo.entities.Offer;
import com.example.demo.services.OfferService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OfferController {
	
	@Autowired
	private OfferService ofserv;
	

	@PostMapping("/addoffer")
	public ResponseEntity<Offer> addOffer(@RequestBody Offer off)
	{
		Offer Coffer=ofserv.addOffer(off);
		if(Coffer!=null)
		return new ResponseEntity<Offer>(Coffer,HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Offer>(Coffer,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getOffersByVendorID/{vendorid}")
	public ResponseEntity<List<Offer>> getOffersByVendorId(@PathVariable("vendorid") int vendorid)
	{
		List<Offer> offers=ofserv.getOffersById(vendorid);
		if(offers!=null)
		return new ResponseEntity<List<Offer>>(offers,HttpStatus.OK);
		else
			return new ResponseEntity<List<Offer>>(offers,HttpStatus.BAD_REQUEST);
	}


}
