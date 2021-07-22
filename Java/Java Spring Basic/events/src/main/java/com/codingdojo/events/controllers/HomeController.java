package com.codingdojo.events.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.User;
import com.codingdojo.events.services.EventService;
import com.codingdojo.events.services.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	@Autowired
	EventService eventService;
	/*
	@Autowired
	CommentService commentService;
	*/
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User u = userService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/events";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated == true) {
        	User u = userService.findByEmail(email);
        	session.setAttribute("userId", u.getId());
        	return "redirect:/events";
        } else {
        	model.addAttribute("error", "Invalid Credentials. Please try again.");
        	return "index.jsp";
        }
	}
	
	@GetMapping("/events")
	public String events(HttpSession session, Model model, @ModelAttribute("event") Event event) {
		Long sessionId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(sessionId);
		model.addAttribute("user", u);
		model.addAttribute("stateEvents", this.eventService.InStateEvents(u.getState()));
		return "eventsPage.jsp";
	}
	
	// Work-In-Progress
	@PostMapping("/createEvent")
	public String createEvent(@Valid @ModelAttribute("event") Event event, Model model, BindingResult result, HttpSession session, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		if (result.hasErrors()) {
			Long sessionId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(sessionId);
			model.addAttribute("user", u);
			model.addAttribute("stateEvents", this.eventService.InStateEvents(u.getState()));
			return "eventsPage.jsp";
		}
		Long sessionId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(sessionId);
		event.setHost(u);
		this.eventService.createEvent(event);
		return "redirect:/events";
	}
	
	@ModelAttribute("stateList")
	public Map<String, String> getStateList() {
	    
	    Map<String,String> stateList = new HashMap<String,String>();

	    stateList.put("AL", "AL");
	    stateList.put("AK", "AK");
	    stateList.put("AR", "AR");
	    stateList.put("AZ", "AZ");
	    stateList.put("CA", "CA");
	    stateList.put("CO", "CO");
	    stateList.put("CT", "CT");
	    stateList.put("DC", "DC");
	    stateList.put("DE", "DE");
	    stateList.put("FL", "FL");
	    stateList.put("GA", "GA");
	    stateList.put("HI", "HI");
	    stateList.put("IA", "IA");
	    stateList.put("ID", "ID");
	    stateList.put("IL", "IL");
	    stateList.put("IN", "IN");
	    stateList.put("KS", "KS");
	    stateList.put("KY", "KY");
	    stateList.put("LA", "LA");
	    stateList.put("MA", "MA");
	    stateList.put("MD", "MD");
	    stateList.put("ME", "ME");
	    stateList.put("MI", "MI");
	    stateList.put("MN", "MN");
	    stateList.put("MO", "MO");
	    stateList.put("MS", "MS");
	    stateList.put("MT", "MT");
	    stateList.put("NC", "NC");
	    stateList.put("NE", "NE");
	    stateList.put("NH", "NH");
	    stateList.put("NJ", "NJ");
	    stateList.put("NM", "NM");
	    stateList.put("NV", "NV");
	    stateList.put("NY", "NY");
	    stateList.put("ND", "ND");
	    stateList.put("OH", "OH");
	    stateList.put("OK", "OK");
	    stateList.put("OR", "OR");
	    stateList.put("PA", "PA");
	    stateList.put("RI", "RI");
	    stateList.put("SC", "SC");
	    stateList.put("SD", "SD");
	    stateList.put("TN", "TN");
	    stateList.put("TX", "TX");
	    stateList.put("UT", "UT");
	    stateList.put("VT", "VT");
	    stateList.put("VA", "VA");
	    stateList.put("WA", "WA");
	    stateList.put("WI", "WI");
	    stateList.put("WV", "WV");
	    stateList.put("WY", "WY");
	    
	    return stateList;
	}
}
