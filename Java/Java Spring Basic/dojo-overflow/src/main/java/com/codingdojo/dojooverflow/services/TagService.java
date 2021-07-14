package com.codingdojo.dojooverflow.services;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	// Display All
	public List<Tag> AllTags(){
		return this.tRepo.findAll();
	}
	
	// Create
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	// Read
	public Tag getOneTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	// Update
	public Tag updateTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	// Delete
	public String deleteTag(Long id) {
		this.tRepo.deleteById(id);
		return "Tag " + id + " has been deleted.";
	}
	
	// Question to Tag
	public void addQuestion(Tag tag, Question question) {
		List<Question> currentQuestions = tag.getQuestions();
		currentQuestions.add(question);
		this.tRepo.save(tag);
	}
	
	// Converts String to List
	
	public List<String> convertTags(String tags) {
		List<String> convertedTagList = new LinkedList<String>(Arrays.asList(tags.split(",",-1)));
		return convertedTagList;
	}
	
	// Checks and Creates New Tags
	public void mergeTags(List<String> tags) {
		List<String> tagsList = AllTags().stream().map(Tag::getSubject).collect(Collectors.toList());
		
		for (String x : tags) {
			if (tagsList.contains(x))
				tags.remove(x);
		}
		
		for (String tag : tags) {
			Tag newTag = new Tag();
			newTag.setSubject(tag);
			tRepo.save(newTag);
		}
	}
	
	// Convert String List to Tag List
	public List<Tag> getTagList(List<String> tags) {
			return tRepo.findBySubjectIn(tags);
	}
}
