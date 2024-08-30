package com.example.tourism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tourism.entity.Booking;
import com.example.tourism.entity.Hotel;
import com.example.tourism.entity.Transport;
import com.example.tourism.service.userservice;
import com.example.tourism.services.impl.Bookingimpl;
import com.example.tourism.services.impl.Hotelservicimpl;
import com.example.tourism.services.impl.Transportserimpl;

@Controller
public class BookingController {
	@Autowired
	private userservice userser;
	@Autowired
	private Hotelservicimpl hser;
	@Autowired
	private Transportserimpl tser;
	@Autowired 
	private Bookingimpl bser;
	
	

	public BookingController (userservice userser, Hotelservicimpl hser, Transportserimpl tser,Bookingimpl bser) {
		super();
		this.userser = userser;
		this.hser = hser;
		this.tser = tser;
		this.bser = bser;
		
	}

	
	 public BookingController() {
		super();
	}


	@GetMapping("/bookingForm")
	    public String showBookingForm(Model model) {
	        model.addAttribute("booking", new Booking());
	       
	        model.addAttribute("hotels", hser.GetAllhotel());
	        model.addAttribute("transports",tser.GetAllTransport());
	        return "bookingform";
	    }
	@PostMapping("/saveBooking")
	public String SaveBooking(@ModelAttribute("booking")Booking booking) {
		bser.saveBooking(booking);
		return "Userdash";
		  
	}
	@RequestMapping("/getAllbooked/{id}")
	   public String GetBooked(@PathVariable("id") Long id,Model model) {
		  // java.util.List <Booking> booking=bser.Getbooking();
		   Booking booking =bser.getBookingById(id);
		
		   model.addAttribute("booking",booking );
		return "Bookingtable";
		   
	   }
	@RequestMapping("/GetAllbooked")
	public String Getbooked(Model model) {
		java.util.List <Booking> booking=bser.Getbooking();
		model.addAttribute("booking",booking );
		return "Bookingtable";
		
	}
	
	 

}
