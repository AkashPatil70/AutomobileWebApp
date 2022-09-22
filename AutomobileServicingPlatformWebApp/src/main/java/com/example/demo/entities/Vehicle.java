package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="vehicle")
public class Vehicle {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int vehicleid;
		@Column
		String vehiclename;
		@Column
		String vehiclemodel;
		@Column
		String vehicleno;
		@Column
		int customerid;
		
		
				
		public Vehicle() {
			super();
		}

		public Vehicle(String vehiclename, String vehiclemodel, String vehicleno, int customerid, int vendorid) {
			super();
			this.vehiclename = vehiclename;
			this.vehiclemodel = vehiclemodel;
			this.vehicleno = vehicleno;
			this.customerid = customerid;
			
		}

		public int getVehicleid() {
			return vehicleid;
		}

		public void setVehicleid(int vehicleid) {
			this.vehicleid = vehicleid;
		}

		public String getVehiclename() {
			return vehiclename;
		}

		public void setVehiclename(String vehiclename) {
			this.vehiclename = vehiclename;
		}

		public String getVehiclemodel() {
			return vehiclemodel;
		}

		public void setVehiclemodel(String vehiclemodel) {
			this.vehiclemodel = vehiclemodel;
		}

		public String getVehicleno() {
			return vehicleno;
		}

		public void setVehicleno(String vehicleno) {
			this.vehicleno = vehicleno;
		}

		public int getCustomerid() {
			return customerid;
		}

		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}
	}


