package com.example.tourism.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tourism.entity.Booking;

public interface Bookingrepo extends JpaRepository <Booking ,Long>{
	

	
}
