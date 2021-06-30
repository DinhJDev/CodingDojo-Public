package com.codingdojo.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository lRepo;
	public LanguageService(LanguageRepository lRepo) {				// Imports methods from LanguageRepository
		this.lRepo = lRepo;
	}
	
	// Display All Albums
	public List<Language> AllLanguages(){
		return this.lRepo.findAll();
	}
	
	// Create
	public Language createLanguage(Language language) {
		return this.lRepo.save(language);
	}
	
	// Read
	public Language getOneLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	// Update
	public Language updateLanguage(Language language) {
		return this.lRepo.save(language);
	}
	
	// Delete
	public String deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
		return "Language " + id + " has been deleted.";
	}
}
