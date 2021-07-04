package com.codingdojo.languages.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class HomeController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/")
	public  String index(Model viewModel) {
		viewModel.addAttribute("allLanguages", this.lService.AllLanguages());
		return "index.jsp";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		lService.deleteLanguage(id);
		return "redirect:/";
	}
	
	
	@RequestMapping("/languages/{id}")
	public String language(Model viewModel, @PathVariable("id") long id) {
		Language language = lService.getOneLanguage(id);
		viewModel.addAttribute("language", language);
		return "language.jsp";
	}
	
	@PostMapping("/addRecord")
	public String addLanguage(@RequestParam("name") String name, @RequestParam("creator") String creator, @RequestParam("currentVersion") String currentVersion, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Please insert a name.");
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
