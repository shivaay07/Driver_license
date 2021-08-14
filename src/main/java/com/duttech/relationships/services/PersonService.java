package com.duttech.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duttech.relationships.models.Person;
import com.duttech.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepo;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;

	}
	
//	create a person
	public Person newPerson(Person person) {
		return personRepo.save(person);
	}
	
//	retrieve all persons
	public List<Person> allPerson(){
		return personRepo.findAll();
	}
	
//	retrieve a person with id
	public Person aPerson(Long id) {
		Optional<Person> optionPerson = personRepo.findById(id);
		if(optionPerson.isPresent()) {
			return optionPerson.get();
		}else {
			return null;
		}
	}
	
//	update a person
	public Person updatedPerson(Person person) {
		return personRepo.save(person);
	}
	
//	Delete a person
	public void deletePerson(Long id) {
		Optional<Person> delPerson = personRepo.findById(id);
		if(delPerson.isPresent()) {
			personRepo.deleteById(id);
		}
	}
	
	
	
}
