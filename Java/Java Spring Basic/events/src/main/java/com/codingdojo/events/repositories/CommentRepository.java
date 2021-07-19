package com.codingdojo.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.events.models.Comment;
import com.codingdojo.events.models.Event;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	List<Event> findByEventId(Long eventId);
}
