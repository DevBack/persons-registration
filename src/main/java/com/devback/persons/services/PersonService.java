package com.devback.persons.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devback.persons.entities.Person;
import com.devback.persons.repositories.PersonRepository;
import com.devback.persons.services.exceptions.EmptyListException;
import com.devback.persons.services.exceptions.EntityNotFoundException;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> findAll() {
		try {
			return personRepository.findAll();
		}
		catch(NullPointerException exception) {
			throw new EmptyListException("Empty List.");
		}
	}
	
	public Person findById(Long id) {
		return personRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("ID: "+id+" Not Found."));
	}
	
	public Person remove(Long id) {
		Person person = findById(id);
		personRepository.delete(person);
		return person;
	}
}
