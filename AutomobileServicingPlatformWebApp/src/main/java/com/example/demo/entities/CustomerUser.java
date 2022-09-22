package com.example.demo.entities;

public class CustomerUser {
	
    private String firstname;
	
    private String lastname;
	
    private String contactno;
	
    private String emailid;
	
    private String username;
    
    private String password;
    
    private String role;

	public CustomerUser(String firstname, String lastname, String contactno, String emailid, String username,
			String password, String role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactno = contactno;
		this.emailid = emailid;
		this.username = username;
		this.password = password;
		this.role = role;
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
    
    
    
    
	
	

}