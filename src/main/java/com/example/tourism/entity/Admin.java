package com.example.tourism.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")

public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String username;
	public Admin() {
		super();
	}
	public Admin(long id, String username, String password, String email, Set<Booking> bookings) {
		super();
		this.id = id;
		this.username = username;
		this.Password = password;
		this.email = email;
		this.bookings = bookings;
	}
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Booking> bookings;
	public Set<Booking> getBookings() {
		return bookings;
	}
	
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String Password;
	private String email;

}
