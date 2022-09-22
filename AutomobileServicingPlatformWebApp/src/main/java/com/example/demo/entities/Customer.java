package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String contactno;
	
	@Column
	private String emailid;
	
	
	@OneToOne
	@JoinColumn(name="userid",referencedColumnName ="userid")
	@Cascade(CascadeType.ALL)
	private User userid;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Customer(String firstname, String lastname, String contactno, String emailid, User userid) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactno = contactno;
		this.emailid = emailid;
		this.userid = userid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
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

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	
	
}
