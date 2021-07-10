package com.codingdojo.dojo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.Ninja;
import com.codingdojo.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	
	// Display All
		public List<Ninja> AllNinjas(){
			return this.nRepo.findAll();
		}
		
		// Create
		public Ninja createNinja(Ninja ninja) {
			return this.nRepo.save(ninja);
		}
		
		// Read
		public Ninja getOneNinja(Long id) {
			return this.nRepo.findById(id).orElse(null);
		}
		
		
		// Delete
		public String deleteNinja(Long id) {
			this.nRepo.deleteById(id);
			return "Ninja " + id + " has been deleted.";
		}
}
