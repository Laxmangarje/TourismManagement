package com.example.tourism.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="userdata")

public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
@NotNull
	    private String username;
	    public User(Long id, String username, String password, String email, Set<Booking> bookings) {
			super();
			this.id = id;
			
			this.username = username;
			this.password = password;
			this.email = email;
			this.bookings = bookings;
		}
	    @NotNull
		private String password;
	   
		
		public Long getId() {
			return id;
		}
		public User() {
			super();
		}

		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Email
		private String email;
		
		 @OneToMany
		 (mappedBy = "user", cascade = CascadeType.ALL)
		    private Set<Booking> bookings;
		public User(Set<Booking> bookings) {
			super();
			this.bookings = bookings;
		}

		public Set<Booking> getBookings() {
			return bookings;
		}

		
	    
	}



