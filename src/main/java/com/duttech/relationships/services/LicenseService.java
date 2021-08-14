package com.duttech.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duttech.relationships.models.License;
import com.duttech.relationships.models.Person;
import com.duttech.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepository licRepo;
	
	

//	create a license
	public License newLicense(License license) {
		return licRepo.save(license);
	}
	
//	retrieve all License
	public List<License> allPerson(){
		return licRepo.findAll();
	}
	
//	retrieve a License with id
	public License aLicense(Long id) {
		Optional<License> optionLicense = licRepo.findById(id);
		if(optionLicense.isPresent()) {
			return optionLicense.get();
		}else {
			return null;
		}
	}
	
//	update a License
	public License updatedLicense(License license) {
		return licRepo.save(license);
	}
	
//	Delete a License
	public void deleteLicense(Long id) {
		Optional<License> delLicense = licRepo.findById(id);
		if(delLicense.isPresent()) {
			licRepo.deleteById(id);
		}
	}
	
	


}