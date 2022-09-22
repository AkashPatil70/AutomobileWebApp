package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entities.Customer;



public interface CustomerRepo extends JpaRepository<Customer,Integer> 
{
  @Query(value="select * from customer where userid= :id",nativeQuery =true)
  public Customer getCustomer(int id);
}

