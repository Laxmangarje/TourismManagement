package com.example.tourism.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tourism.entity.Hotel;
@Repository
public interface Hotelrepository extends JpaRepository <Hotel, Long>{
	

}
