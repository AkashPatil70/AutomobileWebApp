package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="orders")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int orderid;
  @Column
  @JsonFormat(pattern = "yyyy-mm-dd")
  private Date servicedate;
  @Column
  private int customerid;
  @Column
  private Integer vendorid;
  @Column
  private int offerid;

  @Column
  private int userid;
  @Column
  private int vehicleid;
  
  @Column(name="status",columnDefinition = "varchar(20) NOT NULL DEFAULT 'pending'")
  private String status="pending";
  
  @Column(name="is_active",columnDefinition = "TINYINT(1)",length=1)
  private boolean isActive;
   @Column
  private float totalamount;
  
  
public Order() {

	
}
public Order(int orderid, Date servicedate, int customerid, Integer vendorid, int offerid, int userid, int vehicleid,
		String status, boolean isActive, float totalamount) {
	super();
	this.orderid = orderid;
	this.servicedate = servicedate;
	this.customerid = customerid;
	this.vendorid = vendorid;
	this.offerid = offerid;
	this.userid = userid;
	this.vehicleid = vehicleid;
	this.status = status;
	this.isActive = isActive;
	this.totalamount = totalamount;
}


public int getOrderid() {
	return orderid;
}

public void setOrderid(int orderid) {
	this.orderid = orderid;
}

public Date getServicedate() {
	return servicedate;
}

public float getTotalamount() {
	return totalamount;
}
public void setTotalamount(float totalamount) {
	this.totalamount = totalamount;
}
public void setServicedate(Date servicedate) {
	this.servicedate = servicedate;
}

public int getCustomerid() {
	return customerid;
}

public void setCustomerid(int customerid) {
	this.customerid = customerid;
}

public Integer getVendorid() {
	return vendorid;
}

public void setVendorid(Integer vendorid) {
	this.vendorid = vendorid;
}

public int getOfferid() {
	return offerid;
}

public void setOfferid(int offerid) {
	this.offerid = offerid;
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public int getVehicleid() {
	return vehicleid;
}

public void setVehicleid(int vehicleid) {
	this.vehicleid = vehicleid;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public boolean getisActive() {
	return isActive;
}

public void setActive(boolean isActive) {
	this.isActive = isActive;
}
@Override
public String toString() {
	return "Order [orderid=" + orderid + ", servicedate=" + servicedate + ", customerid=" + customerid + ", vendorid="
			+ vendorid + ", offerid=" + offerid + ", userid=" + userid + ", vehicleid=" + vehicleid + ", status="
			+ status + ", isActive=" + isActive + ", totalamount=" + totalamount + "]";
}

  
}
