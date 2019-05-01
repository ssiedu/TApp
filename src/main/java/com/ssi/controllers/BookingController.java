package com.ssi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.BookingDAO;
import com.ssi.dao.CityDAO;
import com.ssi.dao.VehicleDAO;
import com.ssi.entities.Booking;

@Controller
public class BookingController {
	@Autowired
	private CityDAO cityDAO;
	@Autowired
	private VehicleDAO vehicleDAO;
	
	@Autowired
	private BookingDAO bookingDAO;
	
	@RequestMapping("viewmybookings")
	public ModelAndView showBookingForTransporter(@SessionAttribute("email") String email){
		List<Booking> bookings=bookingDAO.getAllBookingByTransporter(email);
		ModelAndView mv=new ModelAndView("bookinglist");
		mv.addObject("bookings",bookings);
		return mv;
	}
	
	@RequestMapping("bookingentry")
	public ModelAndView showBookingEntryForm(@SessionAttribute("email") String email){
		ModelAndView mv=new ModelAndView("bookingentryform");
		mv.addObject("booking", new Booking());
		List<String> cities=cityDAO.getAllCityNames();
		List<String> regnos=vehicleDAO.getAllRegnos(email);
		mv.addObject("cities",cities); 
		mv.addObject("regnos",regnos);
		return mv;
	}
	@RequestMapping("savebooking")
	public ModelAndView saveBookingData(@ModelAttribute("booking") Booking booking){
		bookingDAO.saveBooking(booking);
		ModelAndView mv=new ModelAndView("bookingsaveconfirm");
		return mv;
	}
}
