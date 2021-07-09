package com.codingdojo.lookify.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.LookifyService;

@Controller
public class HomeController {
	@Autowired
	private LookifyService lService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("allSongs", this.lService.AllSongs());
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@PostMapping("/addRecord")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		this.lService.createSong(song);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.lService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/songs/{id}")
	public String song(Model viewModel, @PathVariable("id") Long id) {
		Song song = lService.getOneSong(id);
		viewModel.addAttribute("song", song);
		return "song.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model viewModel) {
		
		return "topten.jsp";
	}
}
