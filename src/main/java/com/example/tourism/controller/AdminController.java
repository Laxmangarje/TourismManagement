package com.example.tourism.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.tourism.entity.Admin;
import com.example.tourism.entity.Hotel;
import com.example.tourism.entity.Transport;
import com.example.tourism.entity.User;

import com.example.tourism.service.adminservice;
import com.example.tourism.service.userservice;
import com.example.tourism.services.impl.Hotelservicimpl;
import com.example.tourism.services.impl.Transportserimpl;

@Controller
public class AdminController {
	@Autowired
	 private adminservice adser;
	private Hotelservicimpl hser;
	private Transportserimpl tser;
	@Autowired
	private userservice users;

	
	public AdminController(adminservice adser ,Hotelservicimpl hser, Transportserimpl tser,userservice users) {
		super();
		this.adser = adser;
		this.hser=hser;
		this.tser=tser;
		this.users=users;
	}
	@GetMapping("/admin")
	public String addregister(Model mod)
	{
		 Admin admin =new Admin();
		mod.addAttribute("admin",admin);
		return "Adhome";
		
	}
	@GetMapping("/getsignin")
	
	  public String homein() {
		return "Adminlog";
	}
	
	   @PostMapping("/adminlogin")
	    public String login(@RequestParam (name = "username") String username, @RequestParam String password ,Model mod) {
	        Admin admin = adser.username(username);

	        if (admin != null && password.equals(admin.getPassword())) {
	            // Successful login
	            return "Admindash";
	        } else {
	            // Failed login
	        	 mod.addAttribute("error", "Invalid username or password");
	            return "Adminlog";
	        }
	    }
	   @GetMapping("/addnewhotels")
	   public String Addhotel(Model model) {
		   Hotel hotel = new Hotel();
			model.addAttribute("hotel",hotel);
		return "Hotel";
		   
	   }
	   @PostMapping("/admin/addHotel")
	   public String SaveHotel(@ModelAttribute("hotel")Hotel hotel) {
		   hser.SaveHotel(hotel);
		return   "Admindash" ;
		   
	   }
	   
	  
	   @GetMapping("/addtransport")
	   public String AddTransport(Model model) {
		   Transport transport=new Transport();
		   model.addAttribute("transport",transport);
		return "Transport";
		   
	   }
	   @PostMapping("/addTransport")
	   public String SaveTransp(@ModelAttribute("transport")Transport transport) {
		   tser.SaveTransp(transport);
		return  "Admindash";
		   
	   }
	  
	   
@RequestMapping("/getAllhoteladmin")
	   public String GetAllhotel(Model model) {
		   java.util.List <Hotel> hotel=hser.GetAllhotel();
		   model.addAttribute("hotel", hotel);
		return "AdShowcase";
		   
	   }
      @RequestMapping("/getAllTranspadmin")
    public String GetAllTransport (Model model) {
	   java.util.List <Transport> transport=tser.GetAllTransport();
	   model.addAttribute("transport", transport);
	return "Vehicleadmin";
	   
 }
      
      
      @GetMapping("/deletetransport/{id}")
  	public String  deleteById(@PathVariable("id")long id) {
  		tser.deleteById(id);
  		return "redirect:/getAllTranspadmin";
  	}
      @GetMapping("/deletehotel/{id}")
      public String deletbyid(@PathVariable("id")long id) {
    	  hser.deletehotelById(id);
		return "redirect:/getAllhoteladmin";
      }
      
      @RequestMapping("/edithotel/{id}")
      public String edithotel(@PathVariable("id") long id ,Model model) {
		   Hotel hotel = hser.gethotelById(id);
			model.addAttribute("hotel",hotel);
		return "Hotel";
		   
	   }
      
      
      @RequestMapping("/edittransport/{id}")
  	public String editBook(@PathVariable("id") long id,Model model) {
  		Transport b=tser.getBookById(id);
  		model.addAttribute("transport",b);
  		return "Transport";
  	}
      
      
      @RequestMapping("/getAlluser")
      public String GetAlluser(Model model) {
     java.util.List <User>user=users.GetAlluser();
     model.addAttribute("user", user);
     
	return  "userAdmin" ;
    	  
      }
     
      
      
  }
	   
	  

