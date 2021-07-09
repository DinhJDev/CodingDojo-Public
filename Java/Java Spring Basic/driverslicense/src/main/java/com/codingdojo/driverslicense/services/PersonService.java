package com.codingdojo.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pRepo;
	
	// Display All Albums
			public List<Person> AllPersons(){
				return this.pRepo.findAll();
			}
			
			// Create
			public Person createPerson(Person license) {
				return this.pRepo.save(license);
			}
			
			// Read
			public Person getOnePerson(Long id) {
				return this.pRepo.findById(id).orElse(null);
			}
			
			// Update
			public Person updatePerson(Long id, String first_name, String last_name) {
				Optional<Person> optionalP = pRepo.findById(id);
				if(optionalP.isPresent()) {
					Person updateP = optionalP.get();
					updateP.setFirst_name(first_name);
					updateP.setLast_name(last_name);
					
					return pRepo.save(updateP);
				} else {
					return null;
				}
			}
			
			// Delete
			public String deletePerson(Long id) {
				this.pRepo.deleteById(id);
				return "Person " + id + " has been deleted.";
			}
}
