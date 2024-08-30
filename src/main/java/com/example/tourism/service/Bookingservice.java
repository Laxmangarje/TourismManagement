package com.example.tourism.service;

import java.util.List;

import com.example.tourism.entity.Booking;
import com.example.tourism.entity.Hotel;
import com.example.tourism.entity.Transport;
import com.example.tourism.entity.User;

public interface Bookingservice {
	
	 Booking getBookingById(Long id);
	 public void saveBooking(Booking booking);
	 public void deleteBooking(Long id);
	 List<Booking>Getbooking();
	 
}
