package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

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
	public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		Optional<Language> optionalL = lRepo.findById(id);
		if(optionalL.isPresent()) {
			Language updateL = optionalL.get();
			updateL.setName(name);
			updateL.setCreator(creator);
			updateL.setCurrentVersion(currentVersion);
			
			return lRepo.save(updateL);
		} else {
			return null;
		}
	}
	
	// Delete
	public String deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
		return "Language " + id + " has been deleted.";
	}
}
