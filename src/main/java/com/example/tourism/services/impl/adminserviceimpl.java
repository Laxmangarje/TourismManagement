package com.example.tourism.services.impl;


import org.springframework.stereotype.Service;

import com.example.tourism.entity.Admin;
import com.example.tourism.entity.Hotel;
import com.example.tourism.repository.adminrepository;
import com.example.tourism.service.adminservice;

import jakarta.transaction.Transactional;
@Service
public class adminserviceimpl implements adminservice {
	private adminrepository adrepo;
	
    
	public adminserviceimpl(adminrepository adrepo) {
		super();
		this.adrepo = adrepo;
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return  adrepo.save(admin);
	}

	@Override
	public Admin username(String username) {
		// TODO Auto-generated method stub
		return adrepo.username(username);
	}

	

}
