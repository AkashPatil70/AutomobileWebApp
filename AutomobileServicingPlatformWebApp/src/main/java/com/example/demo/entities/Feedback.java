package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int fid;
	@Column
	String description;
	@Column
	int customerid;
	@Column
	int vendorid;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Feedback(String description, int customerid, int vendorid) {
		super();
		this.description = description;
		this.customerid = customerid;
		this.vendorid = vendorid;
	}

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	
	
}
