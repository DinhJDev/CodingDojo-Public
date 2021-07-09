package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {
	List<Song> findAll(); // SELECT * FROM songs
    /*List<Song> findByDescriptionContaining(String search);*/
}
