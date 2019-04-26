package com.ssi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.CityDAO;
import com.ssi.entities.City;

@Controller
public class CityController {
	
	@Autowired
	private CityDAO cityDAO;
	
	@RequestMapping("savecity")
	public ModelAndView saveCity(@ModelAttribute("city") City city){
		cityDAO.saveCity(city);
		ModelAndView mv=new ModelAndView("citysaveconfirm");
		return mv;
	}
	
	@RequestMapping("newcity")
	public ModelAndView showCityEntryForm(){
		ModelAndView mv=new ModelAndView("cityentry");
		mv.addObject("city",new City());
		List<String> states=new ArrayList<String>();
		states.add("MP");
		states.add("MH");
		states.add("UP");
		states.add("RJ");
		states.add("Delhi");
		states.add("AP");
		states.add("TN");
		mv.addObject("states",states);
		return mv;
	}
}
