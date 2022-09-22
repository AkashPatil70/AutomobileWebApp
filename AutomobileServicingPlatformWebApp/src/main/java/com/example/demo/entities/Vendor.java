package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="vendor")
public class Vendor {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorid; 
	@Column
	private String shopname;
	@Column
	private String address;
	@Column
	private String contactno;
	@Column
	private String email;
	@Column
	private int shopactnumber;
	@Column
	private String isactive;
	@Column
	private float charges;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="userid",referencedColumnName ="userid")
	@Cascade(CascadeType.ALL)
    private User userid;
	

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendor(String shopname, String address, String contactno, String email, int shopactnumber, String isactive,
			User userid, float charges) {
		super();
		this.shopname = shopname;
		this.address = address;
		this.contactno = contactno;
		this.email = email;
		this.shopactnumber = shopactnumber;
		this.isactive = isactive;
		this.userid=userid;
		this.charges = charges;

	}

	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getShopactnumber() {
		return shopactnumber;
	}

	public void setShopactnumber(int shopactnumber) {
		this.shopactnumber = shopactnumber;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(float charges) {
		this.charges = charges;
	}

	public User getUser() {
		return userid;
	}

	public void setUser(User userid) {
		this.userid = userid;
	}
}
