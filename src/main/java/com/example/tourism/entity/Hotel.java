package com.example.tourism.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

;

	@Entity
	public class Hotel {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String description;
	    private String address;
	    private String city;
	    private double cost;

	    // Constructors, getters, and setters

	    // Default constructor
	    public Hotel() {
	    }

	    // Parameterized constructor
	    public Hotel(String name, String description, String address, String city, double cost) {
	        this.name = name;
	        this.description = description;
	        this.address = address;
	        this.city = city;
	        this.cost = cost;
	    }

	    // Getters and Setters for all fields


		public Hotel(Long hotelId) {
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public double getCost() {
	        return cost;
	    }

	    public void setCost(double cost) {
	        this.cost = cost;
	    }
	    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	    private Set<Booking> bookings;
	}


