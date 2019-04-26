package com.ssi.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.CityDAO;
import com.ssi.dao.TransporterDAO;
import com.ssi.entities.Transporter;

@Controller
public class TransporterController {
	
	@Autowired
	private TransporterDAO transporterDAO;
	
	@Autowired
	private CityDAO cityDAO;
	
	@RequestMapping("savetransporter")
	public ModelAndView saveCity(@ModelAttribute("transporter") Transporter transporter){
		transporterDAO.saveTransporter(transporter);
		ModelAndView mv=new ModelAndView("transportersaveconfirm");
		return mv;
	}
	
	@RequestMapping("transporterentry")
	public ModelAndView showTransporterEntryForm(){
		ModelAndView mv=new ModelAndView("transporterentry");
		mv.addObject("transporter",new Transporter());
		List<String> cities=cityDAO.getAllCityNames();
		Set<String> states=cityDAO.getAllStateNames();
		mv.addObject("cities",cities);
		mv.addObject("states",states);
		return mv;
		
	}
}
