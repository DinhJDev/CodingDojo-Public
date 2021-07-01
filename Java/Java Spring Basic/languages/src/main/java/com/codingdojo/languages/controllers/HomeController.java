package com.codingdojo.languages.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class HomeController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/")
	public  String index() {
		return "index.jsp";
	}
	@PostMapping("/addRecord")
	public String addLanguage(@RequestParam("name") String name, @RequestParam("creator") String creator, @RequestParam("currentVersion") String currentVersion, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Put a name");
		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("error", e);
			}
			return "redirect:/";
		}
		Language newLanguage = new Language(name, creator, currentVersion);
		this.lService.createLanguage(newLanguage);
		return "redirect:/";
	}
	
}
