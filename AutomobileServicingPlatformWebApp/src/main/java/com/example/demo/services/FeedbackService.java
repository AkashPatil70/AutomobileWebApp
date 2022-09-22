package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Feedback;
import com.example.demo.repositories.FeedbackRepo;


@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepo frepo;
	
	public List<Feedback>getAllFeedback(){
		return frepo.findAll();  
	}
	
	
	public List<Feedback>getAllFeedback(int id){
		return frepo.getFeedbackByVId(id);
	}
}
