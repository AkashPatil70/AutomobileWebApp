package com.example.demo.services;


import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entities.Login;


@Service
public class UserService
{
  @Autowired
  UserRepo up;
  
  public User validateUser(String username,String password){
	  return up.validateUser(username,password);
  }
}
