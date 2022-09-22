package com.example.demo.entities;

public class VendorUser {


    private String shopname;
	
    private String address;
	
    private String contactno;
	
    private String email;
    
    private int shopactnumber;
    
    private String isactive;
	
    private String username;
    
    private String password;
    
    private String role;
    private float charges;
    
    

	public VendorUser() {
		super();
	}

	public VendorUser(String shopname, String address, String contactno, String email, int shopactnumber,
			String username, String password, String role,float chrages) {
		this.shopname = shopname;
		this.address = address;
		this.contactno = contactno;
		this.email = email;
		this.shopactnumber = shopactnumber;
		this.username = username;
		this.password = password;
		this.role = role;
		this.charges=chrages;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public float getCharges() {
		return charges;
	}

	public void setCharges(float charges) {
		this.charges = charges;
	}
	
	
    
}
