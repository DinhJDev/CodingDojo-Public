package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository aRepo;
	
	// Display All
	public List<Answer> AllAnswers(){
		return this.aRepo.findAll();
	}
	
	// Create
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	// Read
	public Answer getOneAnswer(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	// Update
	public Answer updateAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	// Delete
	public String deleteAnswer(Long id) {
		this.aRepo.deleteById(id);
		return "Answer " + id + " has been deleted.";
	}
}
