package com.codingdojo.driverslicense.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository lRepo;
	
	// Display All Albums
		public List<License> AllLicenses(){
			return this.lRepo.findAll();
		}
		
		// Create
		public License createLicense(License license) {
			return this.lRepo.save(license);
		}
		
		// Read
		public License getOneLicense(Long id) {
			return this.lRepo.findById(id).orElse(null);
		}
		
		// Update
		public License updateLicense(Long id, String number, Date expiration_date, String state) {
			Optional<License> optionalL = lRepo.findById(id);
			if(optionalL.isPresent()) {
				License updateL = optionalL.get();
				updateL.setNumber(number);
				updateL.setExpiration_date(expiration_date);
				updateL.setState(state);
				
				return lRepo.save(updateL);
			} else {
				return null;
			}
		}
		
		// Delete
		public String deleteLicense(Long id) {
			this.lRepo.deleteById(id);
			return "License " + id + " has been deleted.";
		}
}
