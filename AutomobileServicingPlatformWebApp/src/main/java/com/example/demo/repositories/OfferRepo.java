package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Offer;

@Repository
public interface OfferRepo extends JpaRepository<Offer,Integer> {

	@Query("select o from Offer o where o.vendorid= :id ")
	public List<Offer> getOffers(int id);
}
