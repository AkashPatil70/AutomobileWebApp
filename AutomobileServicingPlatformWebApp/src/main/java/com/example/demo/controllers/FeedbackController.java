package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.entities.Feedback;
import com.example.demo.services.FeedbackService;


@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class FeedbackController {
	@Autowired
	FeedbackService fserv;
	
	@GetMapping("/getAllFeedback")
	public ResponseEntity<List<Feedback>>getallFeedbak(){
		List<Feedback>l=new ArrayList<Feedback>();
		l=fserv.getAllFeedback();
		if(l!=null) {
			return new ResponseEntity<List<Feedback>>(l,HttpStatus.CREATED);
		}
		return new ResponseEntity<List<Feedback>>(l,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("/getAllFeedbackById/{vid}")
	public ResponseEntity<List<Feedback>>getallFeedbakById(@PathVariable int vid){
	
		List<Feedback>l=fserv.getAllFeedback(vid);
		if(l!=null) {
			return new ResponseEntity<List<Feedback>>(l,HttpStatus.CREATED);
		}
		return new ResponseEntity<List<Feedback>>(l,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
