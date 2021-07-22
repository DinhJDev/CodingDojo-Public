package com.codingdojo.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.events.models.Comment;
import com.codingdojo.events.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository cRepo;
	
	// Create
	public Comment createComment(Comment comment) {
		return this.cRepo.save(comment);
	}
	
	// Display Event's Comments
	public List<Comment> EventComments(Long eventId) {
		return this.cRepo.findByEventId(eventId);
	}
}
