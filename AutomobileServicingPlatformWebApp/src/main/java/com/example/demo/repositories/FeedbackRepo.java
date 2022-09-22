package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {

	@Query(value="select * from feedback where vendorid= :vid",nativeQuery = true)
	public List<Feedback>getFeedbackByVId(int vid);
}
