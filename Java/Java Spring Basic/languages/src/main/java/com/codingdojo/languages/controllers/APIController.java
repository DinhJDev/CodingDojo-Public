package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@RestController
@RequestMapping("/api")
public class APIController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("")
	public List<Language> allLanguages(){
		return this.lService.AllLanguages();
	}
	
	@GetMapping("/languages/{id}")
	public Language getOneLanguage(@PathVariable("id") Long id) {
		return this.lService.getOneLanguage(id);
	}
	
	@PostMapping("/languages")
	public Language createLanguage(Language language) {
		return this.lService.createLanguage(language);
	}
	
	@DeleteMapping("/languages/{id}")
	public void deleteLanguage(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
	}
	
	@PutMapping("/languages/{id}")
	public void updateLanguage(@PathVariable("id") Long id, Language language) {
		this.lService.updateLanguage(language);
	}
}
