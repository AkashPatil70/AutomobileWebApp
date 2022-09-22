package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Offer;

import com.example.demo.repositories.OfferRepo;

@Service
public class OfferService {
	
	@Autowired
	private OfferRepo ofrep;
	
/*public boolean addOffer(Offer off) {
		Offer o=ofrep.save(off);
		if(o!=null){
			return true;
		}
		return false;
	}*/
	
	public Offer addOffer(Offer off)
	{
		return ofrep.save(off);
	}
	
	public List<Offer> getOffersById(int oid)
	{
		return ofrep.getOffers(oid);
	}

}
