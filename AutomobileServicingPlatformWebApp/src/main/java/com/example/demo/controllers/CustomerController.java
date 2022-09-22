package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Customer;
import com.example.demo.entities.CustomerUser;
import com.example.demo.entities.User;
import com.example.demo.services.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController
{
	@Autowired
	CustomerService cs;
	@PostMapping("savecustomer")
	public boolean saveCustomer(@RequestBody CustomerUser cuser,HttpServletRequest res) {
 
	res.getSession();
	boolean flag=false;
	User u=new User(cuser.getUsername(),cuser.getPassword(),cuser.getRole());
	Customer c=new Customer(cuser.getFirstname(),cuser.getLastname(),cuser.getContactno(),cuser.getEmailid(),u);
	flag=cs.saveCustomer(c);
	return flag;
	}
	@GetMapping("getCustomerByUserid/{userid}")
	public ResponseEntity<Customer> getCustomerByUserid(@PathVariable("userid") int userid)
	{
		Customer c=cs.getCustomer(userid);
		if(c!=null)
			return new ResponseEntity<Customer>(c,HttpStatus.FOUND);
		else
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
 
}
