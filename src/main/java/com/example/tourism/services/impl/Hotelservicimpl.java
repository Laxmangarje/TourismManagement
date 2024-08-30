package com.example.tourism.services.impl;

import java.util.List;



import org.springframework.stereotype.Service;

import com.example.tourism.entity.Hotel;
import com.example.tourism.entity.Transport;
import com.example.tourism.repository.Hotelrepository;
import com.example.tourism.service.Hotelservic;
@Service
public class Hotelservicimpl  implements Hotelservic {

private Hotelrepository hrepo;
	
	
	public Hotelservicimpl(Hotelrepository hrepo) {
		super();
		this.hrepo = hrepo;
	}
	@Override
	public Hotel SaveHotel(Hotel hotel) {
		
		return hrepo.save(hotel);
	}
	@Override
	public List<Hotel> GetAllhotel() {
		// TODO Auto-generated method stub
		return hrepo.findAll();
	}
	@Override
	public void deletehotelById(long id) {
		hrepo.deleteById(id);
		
	}
	@Override
	public Hotel gethotelById(long id) {
		// TODO Auto-generated method stub
		return hrepo.getById(id);
	}
	
	
	
	
	
	

}
