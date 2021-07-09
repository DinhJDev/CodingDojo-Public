package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	@Autowired
	private LookifyRepository lRepo;
	
	// Display All Albums
	public List<Song> AllSongs() {
		return this.lRepo.findAll();
	}
	
	// Create
	public Song createSong(Song song) {
		return this.lRepo.save(song);
	}
	
	// Read
	public Song getOneSong(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	// Update
	public Song updateSong(Long id, String title, String artist, int rating) {
		Optional<Song> optionalS = lRepo.findById(id);
		if(optionalS.isPresent()) {
			Song updateS = optionalS.get();
			updateS.setTitle(title);
			updateS.setArtist(artist);
			updateS.setRating(rating);
			
			return lRepo.save(updateS);
		} else {
			return null;
		}
	}
	
	// Delete
	public String deleteSong(Long id) {
		this.lRepo.deleteById(id);
		return "Language " + id + " has been deleted.";
	}
}