package com.codingdojo.events.services;

import java.util.List;

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
	
}
