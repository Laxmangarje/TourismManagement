package com.example.tourism.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tourism.entity.Transport;
import com.example.tourism.repository.Transportrepo;
import com.example.tourism.service.Transportservice;
@Service
public class Transportserimpl implements Transportservice {
private Transportrepo trepo;

public Transportserimpl(Transportrepo trepo) {
	super();
	this.trepo = trepo;
}

@Override
public Transport SaveTransp(Transport transport) {
	
	return trepo.save(transport);
}

@Override
public List<Transport> GetAllTransport() {
	// TODO Auto-generated method stub
	return trepo.findAll();
}

@Override
public void deleteById(long id) {
	trepo.deleteById( id);
	
}

@Override
public Transport getBookById(long id) {
	// TODO Auto-generated method stub
	return trepo.getById(id);
}


}
