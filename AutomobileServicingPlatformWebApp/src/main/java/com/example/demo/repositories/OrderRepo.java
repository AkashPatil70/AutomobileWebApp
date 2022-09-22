package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> 
{
	@Query("select o from Order o where vendorid=:id and status='pending'")
	public List<Order> getOrders(int id);
	
	@Transactional
	@Modifying
	@Query("update Order set status='completed' where orderid=:orderid")
	public int updateStatus(int orderid);
	
	@Transactional
	@Modifying
	@Query("update Order set isActive=1 where orderid=:orderid")
	public int updateIsActive(int orderid);
	@Query(value="select * from orders where vendorid= :vid and status='pending' and is_active=0",nativeQuery = true)
	public List<Order> getOrderDetais(int vid);

}
