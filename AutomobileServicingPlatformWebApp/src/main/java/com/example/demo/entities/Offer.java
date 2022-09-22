package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
	@Entity
	@Table(name="offer")
	public class Offer {
		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			int offerid;
			@Column
			String offername;
			@Column
			String offer_description;
			@Column
			int vendorid;
			public Offer() {
				super();
			}
			public Offer( String offername, String offer_description, int vendorid) {
				super();
				
				this.offername = offername;
				this.offer_description = offer_description;
				this.vendorid = vendorid;
			}
			public int getOfferid() {
				return offerid;
			}
			public void setOfferid(int offerid) {
				this.offerid = offerid;
			}
			public String getOffername() {
				return offername;
			}
			public void setOffername(String offername) {
				this.offername = offername;
			}
			public String getOffer_description() {
				return offer_description;
			}
			public void setOffer_description(String offer_description) {
				this.offer_description = offer_description;
			}
			public int getVendorid() {
				return vendorid;
			}
			public void setVendorid(int vendorid) {
				this.vendorid = vendorid;
			}
			
			

}
