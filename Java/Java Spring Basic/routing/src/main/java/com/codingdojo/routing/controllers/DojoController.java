package com.codingdojo.routing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/dojo")
public class DojoController {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String dojo() {
		return "The dojo is awesome!";
	}
	
	@RequestMapping(value = "/{location}", method = RequestMethod.GET)
	@ResponseBody
	public String getLocation(@PathVariable final String location) {
		if (location.equals("burbank")) {
			return "Burbank Dojo is located in Southern California";
		} else if (location.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		} else {
			return "The dojo is awesome";
		}
	}
}
