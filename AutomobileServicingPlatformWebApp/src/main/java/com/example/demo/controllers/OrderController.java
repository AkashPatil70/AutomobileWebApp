package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BookingTemp;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Order;
import com.example.demo.services.CustomerService;
import com.example.demo.services.OrderService;



@CrossOrigin(origins="http://localhost:3000")
@RestController
public class OrderController
{
	@Autowired
	OrderService os;
	@Autowired
	CustomerService cs;
	@PostMapping("/addorder")
	public ResponseEntity<Order> addOrder(@RequestBody Order o)
	{
		Order Corder=os.save(o);
		if(Corder!=null)
		return new ResponseEntity<Order>(Corder,HttpStatus.CREATED);
		else
			return new ResponseEntity<Order>(o,HttpStatus.NOT_ACCEPTABLE);
	}
	
	//getOrdersByVendorId
	@GetMapping("/getOrdersByVendorId/{vid}")
	public ResponseEntity<List<Order>> getOrdersByVendorId(@PathVariable("vid") Integer vid)
	{
		List<Order> orders=os.getByID(vid);
		if(orders!=null)
		{
			
			return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<Order>>(HttpStatus.BAD_REQUEST);
			
	}
	
	@GetMapping("/getOrdersDetailsByVendorId/{vid}")
	public ResponseEntity<List<BookingTemp>> getOrdersDetailsByVendorId(@PathVariable("vid") Integer vid)
	{
		   List<Order> l=os.getOrderDetails(vid);
			   List<BookingTemp>bk=new ArrayList<BookingTemp>();
			   for(int i=0;i<l.size();i++) {
				   Order o=l.get(i);
				 Customer c = cs.getCustomer(o.getCustomerid());
				
				 int oid=o.getOrderid();
				 Date date=(Date)o.getServicedate();
				 boolean b=o.getisActive();
				 String fname=c.getFirstname();
				 String lname=c.getLastname();
				 String cnt=c.getContactno();
				   BookingTemp bb=new BookingTemp(oid,date,b,fname,lname,cnt);
				   bk.add(bb);
			   }
			   if(bk!=null) {
				  
				   return new ResponseEntity<List<BookingTemp>>(bk,HttpStatus.CREATED);
			   }
			
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
				
		}

	@PatchMapping("/updateStatus/{orderid}")
	public ResponseEntity<Object> updateStatus(@PathVariable("orderid") int orderid)
	{
		int noOfRowsAffected=os.updateStatus(orderid);
		if(noOfRowsAffected>0)
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@PatchMapping("/activateorder/{orderid}")
	public ResponseEntity<Object> activateOrder(@PathVariable("orderid") int orderid)
	{
		int noOfRowsAffected=os.updateIsActive(orderid);
		if(noOfRowsAffected>0)
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
