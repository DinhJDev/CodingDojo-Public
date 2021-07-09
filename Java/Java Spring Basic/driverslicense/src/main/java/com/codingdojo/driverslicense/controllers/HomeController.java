package com.codingdojo.driverslicense.controllers;

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

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.services.LicenseService;
import com.codingdojo.driverslicense.services.PersonService;

@Controller
public class HomeController {
	@Autowired
	private LicenseService lService;
	@Autowired
	private PersonService pService;
	
	// New Person
	@GetMapping("/persons/new")
	public String newPerson(Model viewModel) {
		viewModel.addAttribute("person", new Person());
		return "newperson.jsp";
	}
	@PostMapping("/addPerson")
	public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "newperson.jsp";
		}
		this.pService.createPerson(person);
		return "redirect:/licenses/new";
	}
	
	
	// New License
	@GetMapping("/licenses/new")
	public String newLicense(Model viewModel) {
		viewModel.addAttribute("allPersons", this.pService.AllPersons());
		viewModel.addAttribute("license", new License());
		return "newlicense.jsp";
	}
	@PostMapping("/addLicense")
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model viewModel, @RequestParam(value="person.id") Long id) {
		Person personForLicense = this.pService.getOnePerson(id);
		license.setPerson(personForLicense);
		String numberFormatted = String.format("%06d", id);
		license.setNumber(numberFormatted);
		this.lService.createLicense(license);
		return "redirect:/persons/" + id;
	}
	
	// View
	@GetMapping("/persons/{id}")
	public String viewPerson(Model viewModel, @PathVariable ("id") Long id) {
		Person person = pService.getOnePerson(id);
		
		viewModel.addAttribute("person", person);
		return "view.jsp";
	}
}
