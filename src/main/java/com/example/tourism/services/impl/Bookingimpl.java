package com.example.tourism.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tourism.entity.Booking;
import com.example.tourism.repository.Bookingrepo;
import com.example.tourism.service.Bookingservice;

@Service
public class Bookingimpl implements Bookingservice{
	private Bookingrepo bkrepo;

	public Bookingimpl(Bookingrepo bkrepo) {
		super();
		this.bkrepo = bkrepo;
	}

	@Override
	public Booking getBookingById(Long id) {
	
		return bkrepo.getById(id);
	}

	@Override
	public void saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		bkrepo.save(booking);
	}

	@Override
	public void deleteBooking(Long id) {
		// TODO Auto-generated method stub
		bkrepo.deleteById(id);
		
	}

	@Override
	public List<Booking> Getbooking() {
		
		return bkrepo.findAll();
	}
	
}
