package com.codingdojo.hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(@RequestParam(value="q", required=false) String searchQuery, Model model) {
		model.addAttribute("search", searchQuery);
		return "index.jsp";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showName(@PathVariable("username") String userName, Model model) {
		model.addAttribute("userName", userName);
		return "name.jsp";
	}
}
