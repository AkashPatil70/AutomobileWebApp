package com.example.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingTemp {
	
	private int oid;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date servicedate;
	private boolean is_active;
	private String firstname;
	private String lastname;
	private String contactno;

	public BookingTemp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingTemp(int oid,Date servicedate, boolean is_active, String firstname, String lastname, String contactno) {
		super();
		this.oid=oid;
		this.servicedate = servicedate;
		this.is_active = is_active;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactno = contactno;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Date getServicedate() {
		return servicedate;
	}

	public void setServicedate(Date servicedate) {
		this.servicedate = servicedate;
	}

	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	

	
}
