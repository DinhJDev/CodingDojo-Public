package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;
	
	// Display All
	public List<Question> AllQuestions(){
		return this.qRepo.findAll();
	}
	
	// Create
	public Question createQuestion(Question question) {
		return this.qRepo.save(question);
	}
	
	// Read
	public Question getOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	// Update
	public Question updateQuestion(Question question) {
		return this.qRepo.save(question);
	}
	
	// Delete
	public String deleteQuestion(Long id) {
		this.qRepo.deleteById(id);
		return "Question " + id + " has been deleted.";
	}
	
	// Tag to Question
	public void addTag(Question question, Tag tag) {
		List<Tag> currentTags = question.getTags();
		currentTags.add(tag);
		this.qRepo.save(question);
	}
}
