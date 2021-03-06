package com.codingdojo.events.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.events.models.Comment;
import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.User;
import com.codingdojo.events.services.CommentService;
import com.codingdojo.events.services.EventService;
import com.codingdojo.events.services.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	@Autowired
	EventService eventService;
	@Autowired
	CommentService commentService;
	
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
		
		// In-State Table
		model.addAttribute("stateEvents", this.eventService.InStateEvents(u.getState()));
		
		// Out-of-State Table
		List<Event> nStateEvents = this.eventService.AllEvents();
		nStateEvents.removeAll(this.eventService.InStateEvents(u.getState()));
		model.addAttribute("nonStateEvents", nStateEvents);
		return "eventsPage.jsp";
	}
	
	@PostMapping("/createEvent")
	public String createEvent(@Valid @ModelAttribute("event") Event event, Model model, BindingResult result, HttpSession session, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		if (result.hasErrors()) {
			Long sessionId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(sessionId);
			model.addAttribute("user", u);
			model.addAttribute("stateEvents", this.eventService.InStateEvents(u.getState()));
			List<Event> nStateEvents = this.eventService.AllEvents();
			nStateEvents.removeAll(this.eventService.InStateEvents(u.getState()));
			model.addAttribute("nonStateEvents", nStateEvents);
			return "eventsPage.jsp";
		}
		Long sessionId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(sessionId);
		event.setHost(u);
		this.eventService.createEvent(event);
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long sessionId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(sessionId);
		model.addAttribute("user", u);
		Event event = eventService.getOneEvent(id);
		
		if (sessionId == event.getHost().getId()) {
			model.addAttribute("event", event);
			return "editPage.jsp";
		} else { 
			return "redirect:/events";
		}
	}
	
	@PostMapping("/edit/{id}")
	public String updateEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
		if (result.hasErrors()) {
			return "redirect:/events/{id}/edit";
		} else {
			Long sessionId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(sessionId);
			event.setHost(u);
			eventService.updateEvent(id, event);
			return "redirect:/events";
		}
	}
	
	@GetMapping("/event/{id}")
	public String eventProfile(@PathVariable("id") Long id, Model model, HttpSession session, @ModelAttribute("comment") Comment comment) {
		Long sessionId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(sessionId);
		model.addAttribute("user", u);
		Event event = eventService.getOneEvent(id);
		model.addAttribute("event", event);
		model.addAttribute("participants", this.userService.EventAttendees(event));
		model.addAttribute("comments", this.commentService.EventComments(id));
		
		return "eventProfilePage.jsp";
	}
	
	@PostMapping("/sendComment/{id}")
	public String sendComment(@PathVariable("id") Long id, @Valid @ModelAttribute("comment") Comment comment, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "redirect:/event/{id}";
		} else {
			Long sessionId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(sessionId);
			comment.setEvent(this.eventService.getOneEvent(id));
			comment.setCommenter(u);
			commentService.createComment(comment);
			return "redirect:/event/" + id;
		}
	}
	
	@GetMapping("/join/{id}")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Long sessionId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(sessionId);
		Event event = eventService.getOneEvent(id);
		this.eventService.AddAttendee(u, event);
		
		return "redirect:/events";
	}
	
	@GetMapping("/cancel/{id}")
	public String unjoinEvent(@PathVariable("id") Long id, HttpSession session) {
		Long sessionId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(sessionId);
		Event event = eventService.getOneEvent(id);
		this.eventService.RemoveAttendee(u, event);
		
		return "redirect:/events";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEvent(@PathVariable("id") Long id) {
		this.eventService.deleteEvent(id);
		return "redirect:/events";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
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
