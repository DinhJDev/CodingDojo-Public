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
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		lService.deleteLanguage(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = lService.getOneLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id,
			@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
		if (result.hasErrors()) {
			return "/edit/{id}";
		} else {
			lService.updateLanguage(id, name, creator, currentVersion);
			return "redirect:/";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String language(Model viewModel, @PathVariable("id") Long id) {
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
