package com.example.tourism.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

;

@Entity
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicleType")
    private String vehicleType;

    @Column(name = "vehicleName")
    private String vehicleName;

    private String city;

    public Transport() {
		super();
	}

	public Transport(Long id, String vehicleType, String vehicleName, String city, double cost, Set<Booking> bookings) {
		super();
		this.id = id;
		this.vehicleType = vehicleType;
		this.vehicleName = vehicleName;
		this.city = city;
		this.cost = cost;
		this.bookings = bookings;
	}

	public Transport(Long transportId) {
		// TODO Auto-generated constructor stub
	}

	private double cost;

    @OneToMany(mappedBy = "transport", cascade = CascadeType.ALL)
    private Set<Booking> bookings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
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

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

    
}
