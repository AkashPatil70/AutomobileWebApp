package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Vendor;


@Repository
public interface VendorRepo extends JpaRepository<Vendor,Integer> {

	@Query(value="select * from vendor  where userid= :id",nativeQuery = true)
	public Vendor getActiveVendor(int id);
	
	@Query("select v from Vendor v where isActive='true'")
	public List<Vendor> getAllVendors();
	@Modifying
	@Query(value="update vendor set isactive='true' where userid= :id",nativeQuery = true)
	public void changeStatus(int id);

}
