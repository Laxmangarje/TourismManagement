package com.example.tourism.services.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Authentication;

import org.springframework.stereotype.Service;

import com.example.tourism.entity.User;
import com.example.tourism.repository.UserRepository;

import com.example.tourism.service.userservice;
@Service
public class userserviceimpl  implements userservice{
	@Autowired
    private UserRepository userepo;
	
	public userserviceimpl(UserRepository userepo ) {
		super();
		this.userepo = userepo;
		
	}
	@Override
	public User saveUser(User user) {
		
		return userepo.save(user);
	}
	
	@Override
	
	public User username(String username) {
		
		return userepo.username(username);
	}
	@Override
	public List<User> GetAlluser() {
		// TODO Auto-generated method stub
		return userepo.findAll();
	}
	
	
	
	

}
