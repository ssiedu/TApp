package com.ssi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.entities.Customer;

@Controller
public class CustomerController {

	@RequestMapping("customerentry")
	public ModelAndView showCustomerEntryForm(){
		ModelAndView mv=new ModelAndView("customerentry");
		mv.addObject("customer", new Customer());
		return mv;
	}
}
