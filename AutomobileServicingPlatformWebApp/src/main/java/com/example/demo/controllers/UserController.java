package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Login;
import com.example.demo.entities.User;
import com.example.demo.services.CustomerService;
import com.example.demo.services.UserService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class UserController 
{
	@Autowired
	private UserService us;
	
	@Autowired
	private CustomerService cs;
	
	
	@PostMapping("/logincheck")
  public ResponseEntity<User> validate(@RequestBody Login l){
	User Cuser=us.validateUser(l.getUsername(),l.getPassword());
	 if(Cuser!=null)
	 {
	   return new ResponseEntity<User>(Cuser,HttpStatus.OK);
     }
	 return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
	
  }
}

