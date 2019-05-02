package com.ssi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.CustomerDAO;
import com.ssi.dao.TransporterDAO;
import com.ssi.entities.Customer;
import com.ssi.entities.Transporter;

@Controller
@SessionAttributes(value={"email"})
public class UserController {

	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	TransporterDAO transporterDAO;
	
	

	@RequestMapping("customerhome")
	public String showCustomerHome(){
		return "customerhome";
	}

	@RequestMapping("verify")
	public ModelAndView verifyUser(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("utype") String utype){
		
		if(utype.equalsIgnoreCase("admin")){
			ModelAndView mv=new ModelAndView("adminhome");
			return mv;
		}else if(utype.equalsIgnoreCase("customer")){
			Customer customer=new Customer();
			customer.setEmail(email);
			customer.setPassword(password);
			boolean result=customerDAO.verifyCustomer(customer);
			if(result){
				ModelAndView mv=new ModelAndView("customerhome");
				mv.addObject("email",email);
				return mv;
			}else{
				ModelAndView mv=new ModelAndView("wronguser");
				return mv;
			}
		}else{
			Transporter transporter=new Transporter();
			transporter.setEmail(email);
			transporter.setPassword(password);
			boolean result=transporterDAO.verifyTransporter(transporter);
			if(result){
				ModelAndView mv=new ModelAndView("transporterhome");
				mv.addObject("email",email);
				return mv;
			}else{
				ModelAndView mv=new ModelAndView("wronguser");
				return mv;
			}
		}
	}
}
