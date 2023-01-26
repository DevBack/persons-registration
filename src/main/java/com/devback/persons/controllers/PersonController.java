package com.devback.persons.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devback.persons.entities.Person;
import com.devback.persons.services.PersonService;

@RestController
@RequestMapping(value = "persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		return ResponseEntity.ok().body(personService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Person person = personService.findById(id);
		return ResponseEntity.ok().body(person);
	}
	
	
}
