package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.*;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

 @Query("select u from User u where u.username= :username and u.password= :password")
 public User validateUser(String username,String password);

}
