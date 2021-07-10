package com.codingdojo.dojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.models.Ninja;
import com.codingdojo.dojo.services.DojoService;
import com.codingdojo.dojo.services.NinjaService;

@Controller
public class HomeController {
	@Autowired
	private NinjaService nService;
	@Autowired
	private DojoService dService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("allDojos", this.dService.AllDojos());
		viewModel.addAttribute("dojo", new Dojo());
		return "index.jsp";
	}
	
	@PostMapping("/viewDojo")
	public String viewDojo(@RequestParam(value="id") Long id) {
		return "redirect:/dojos/" + id;
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(Model viewModel) {
		viewModel.addAttribute("dojo", new Dojo());
		return "newdojo.jsp";
	}
	@PostMapping("/addDojo")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newdojo.jsp";
		}
		this.dService.createDojo(dojo);
		return "redirect:/ninjas/new";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(Model viewModel) {
		viewModel.addAttribute("ninja", new Ninja());
		viewModel.addAttribute("allDojos", this.dService.AllDojos());
		return "newninja.jsp";
	}
	@PostMapping("/addNinja")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model viewModel, @RequestParam(value="dojo.id") Long id) {
		Dojo dojoForNinja = this.dService.getOneDojo(id);
		ninja.setDojo(dojoForNinja);
		this.nService.createNinja(ninja);
		return "redirect:/";
	}
	
	@GetMapping("/dojos/{id}")
	public String displayDojo(Model viewModel, @PathVariable("id") Long id) {
		Dojo dojo = dService.getOneDojo(id);
		viewModel.addAttribute("dojo", dojo);
		return "showdojo.jsp";
	}
}
