package com.codingdojo.dojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	
	// Display All
		public List<Dojo> AllDojos(){
			return this.dRepo.findAll();
		}
		
		// Create
		public Dojo createDojo(Dojo dojo) {
			return this.dRepo.save(dojo);
		}
		
		// Read
		public Dojo getOneDojo(Long id) {
			return this.dRepo.findById(id).orElse(null);
		}
		
		
		// Delete
		public String deleteDojo(Long id) {
			this.dRepo.deleteById(id);
			return "Dojo " + id + " has been deleted.";
		}
}
