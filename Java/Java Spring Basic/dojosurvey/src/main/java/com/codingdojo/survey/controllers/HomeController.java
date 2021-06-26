package com.codingdojo.survey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	public class Survey {
		private String name;
		private String location;
		private String language;
		private String comment;
		
		public String getName() {
			return name;
		}
		public void setName(String n) {
			name = n;
		}
		
		public String getLocation() {
			return location;
		}
		public void setLocation(String l) {
			location = l;
		}
		
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String l) {
			language = l;
		}
		
		public String getComment() {
			return comment;
		}
		public void setComment(String c) {
			comment = c;
		}
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView showIndex() {
		return new ModelAndView("index.jsp" ,"survey", new Survey());
	}
	@RequestMapping(value="/result", method=RequestMethod.POST)
    public String result(@ModelAttribute("survey")Survey survey, BindingResult result, ModelMap model) {
		model.addAttribute("name", survey.getName());
		model.addAttribute("location", survey.getLocation());
		model.addAttribute("language", survey.getLanguage());
		model.addAttribute("comment", survey.getComment());
		return "result.jsp";
	}
}
