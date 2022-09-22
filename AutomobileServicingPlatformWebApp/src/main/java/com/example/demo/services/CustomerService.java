package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepo;

@Service
public class CustomerService 
{
	@Autowired
	CustomerRepo cr;
 public boolean saveCustomer(Customer c)
 {
	 boolean flag=false;
	 cr.save(c);
	 flag=true;
	 return flag;
 }
 
 public Customer getCustomer(int userid)
 {
	 Customer c=cr.getCustomer(userid);
	 return c;
 }
}
