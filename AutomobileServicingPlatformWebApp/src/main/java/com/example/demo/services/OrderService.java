package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepo;


@Service
public class OrderService 
{
	@Autowired
	OrderRepo or;
	public Order save(Order o)
	{
       return or.save(o);
	}
	public List<Order> getByID(int id)
	{
		return or.getOrders(id);
	}
	public int updateStatus(int id)
	{
		return or.updateStatus(id);
	}
	
	public int updateIsActive(int orderid)
	{
		return or.updateIsActive(orderid);
	}
	public List<Order> getOrderDetails(int vid)
	{
		return or.getOrderDetais(vid);
	}

}
