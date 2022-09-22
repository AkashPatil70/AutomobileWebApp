package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mechanic")
public class Mechanic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int mechanicid;
	@Column
	String name;
	@Column
	int experience;
	@Column
	int vendorid;
	public Mechanic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mechanic(String name, int experience,int vendorid) {
		super();
		this.name = name;
		this.experience = experience;
		this.vendorid = vendorid;
	}
	public int getMechanicid() {
		return mechanicid;
	}
	public void setMechanicid(int mechanicid) {
		this.mechanicid = mechanicid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	
	
}
