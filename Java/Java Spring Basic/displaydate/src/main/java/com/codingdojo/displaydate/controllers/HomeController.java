package com.codingdojo.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	public java.util.Date date = new java.util.Date();
	
	String datePattern = "EEEEE, 'the' dd 'of' MMMMM, yyyy";
	String timePattern = "KK:mm aa";
	
	public java.text.SimpleDateFormat simpleDate = new java.text.SimpleDateFormat(datePattern);
	public java.text.SimpleDateFormat simpleTime = new java.text.SimpleDateFormat(timePattern);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/date", method=RequestMethod.GET)
	public String date(Model model) {
		model.addAttribute("date", simpleDate.format(date));
		return "date.jsp";
	}
	
	@RequestMapping(value="/time", method=RequestMethod.GET)
	public String time(Model model) {
		model.addAttribute("time", simpleTime.format(date));
		return "time.jsp";
	}
}
