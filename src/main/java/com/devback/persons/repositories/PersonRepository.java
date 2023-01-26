package com.devback.persons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devback.persons.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
