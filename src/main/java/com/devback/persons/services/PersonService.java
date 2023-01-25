package com.devback.persons.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devback.persons.entities.Person;
import com.devback.persons.repositories.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		return personRepository.findById(id).get();
	}
	
	public Person remove(Long id) {
		Person person = findById(id);
		personRepository.delete(person);
		return person;
	}
}
