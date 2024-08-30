package com.example.tourism.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	 @Column(name = "status")
	    private String status;
	


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Booking(Long id, Hotel hotel, Transport transport,User user,Admin admin,String status) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.transport = transport;
		this.user = user;
		this.admin=admin;
		this.status = status;
	}


	public Booking() {
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
	@ManyToOne
	@JoinColumn(name = "transport_id")
	private Transport transport;
	 @ManyToOne
	 @JoinColumn(name = "user_id")
	    private User user;
	 @ManyToOne
	    @JoinColumn(name = "admin_id")
	    private Admin admin;


	


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

    
}
