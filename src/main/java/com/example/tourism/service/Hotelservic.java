package com.example.tourism.service;

import java.util.List;

import com.example.tourism.entity.Hotel;
import com.example.tourism.entity.Transport;
import com.example.tourism.entity.User;

public interface Hotelservic {
	Hotel SaveHotel(Hotel hotel);
    List<Hotel>GetAllhotel();
    public void deletehotelById(long id);
	public Hotel gethotelById(long id);
    
   
   
}
