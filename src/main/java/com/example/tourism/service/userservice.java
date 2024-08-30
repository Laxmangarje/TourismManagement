package com.example.tourism.service;

import java.util.List;

import com.example.tourism.entity.Hotel;
import com.example.tourism.entity.User;

public interface userservice {
	
	User saveUser(User user);
	User username(String username) ;
	 List<User>GetAlluser();
	  
	    

}
