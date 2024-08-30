package com.example.tourism.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tourism.entity.Admin;
import com.example.tourism.entity.Hotel;
import com.example.tourism.entity.Transport;
import com.example.tourism.entity.User;
import com.example.tourism.service.userservice;
import com.example.tourism.services.impl.Hotelservicimpl;
import com.example.tourism.services.impl.Transportserimpl;

import jakarta.validation.Valid;


@Controller

public class userController {
	@Autowired
	private userservice userser;
	@Autowired
	private Hotelservicimpl hser;
	@Autowired
	private Transportserimpl tser;
	
	public userController(userservice userser, Hotelservicimpl hser, Transportserimpl tser) {
		super();
		this.userser = userser;
		this.hser = hser;
		this.tser = tser;
	}

	
             @GetMapping("/tour")
                public String home() {
                  return "Home";
              }

	

	
	@GetMapping("/login")
	public String login() {
		return "Login";
		
	}
	
	@GetMapping("/registration")
	public String Newregister(Model mod)
	{
		User user =new User();
		mod.addAttribute("user", user);
		return "Account";
		
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") @Valid User user ,Model model)
	{
		  try {
	            userser.saveUser(user);
	            return "redirect:/getacount";
	        } catch (DataIntegrityViolationException e) {
	          
	            e.printStackTrace();

	           
	            model.addAttribute("error", "Username or email is already in use. Please choose a different one.");
                return "Registration";
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e);
                model.addAttribute("error", "An error occurred during user registration. Please try again.");
	            return "Registration";
	        }
	    
		
		
	}
	
	
            @PostMapping("/login")
	    public String login(@RequestParam String username, @RequestParam String password ,Model mod) {
	        User user = userser.username(username);
             try {
	        if (user != null && password.equals(user.getPassword())) {
	            // Successful login
	            return "Userdash";
	        } else {
	            // Failed login
	        	 mod.addAttribute("error", "Invalid username or password");
	            return "redirect:/getacount";
	        }
	    }
             catch (Exception e) {
                 e.printStackTrace();
                 mod.addAttribute("errors", "An unexpected error occurred. Please try again.");
                 return "Account";
                 
                 
             }
        }
            
            

            @GetMapping("/getAllhotels")
     	   public String GetAllhotel(Model model) {
     		   java.util.List <Hotel> hotel=hser.GetAllhotel();
     		   model.addAttribute("hotel", hotel);
     		return "Showcase";
     		   
     	   }
            @GetMapping("/getAllTransp")
     	   public String GetAllTransport (Model model) {
     		   java.util.List <Transport> transport=tser.GetAllTransport();
     		   model.addAttribute("transport", transport);
     		return "Vehicle";
     		   
     	   }
            @GetMapping("/getacount")
            public String Getaccount(Model mod) {
            	User user =new User();
        		mod.addAttribute("user", user);
        		
				return "Account";
            	
            }
	}

	
	
	





