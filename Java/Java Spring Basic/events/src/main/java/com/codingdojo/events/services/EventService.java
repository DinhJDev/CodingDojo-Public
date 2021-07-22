package com.codingdojo.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	
	// Display All
	public List<Event> AllEvents(){
		return this.eRepo.findAll();
	}
	
	// Display In State Events
	public List<Event> InStateEvents(String state){
		return this.eRepo.findByState(state);
	}
	
	// Create
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	// Read
	public Event getOneEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	// Update
	public Event updateEvent(Long id, Event event) {
		Optional<Event> optionalE = eRepo.findById(id);
		if(optionalE.isPresent()) {
			return eRepo.save(event);
		} else {
			return null;
		}
	}
	
	// Delete
	public void deleteEvent(Long id) {
		this.eRepo.deleteById(id);
	}
}
