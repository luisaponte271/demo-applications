package com.tryhards.pe.controller;

 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tryhards.pe.entity.Person;
import com.tryhards.pe.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	@Autowired
	@Qualifier( value = "personaService")
	PersonService personService;
	
	@PostMapping 
	public ResponseEntity<?> create(@RequestBody Person person) { 
		System.out.println("personas : " + person.getId());
		System.out.println("personas : " + person.getName());
		System.out.println("personas : " + person.getDob());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long id){
		Optional<Person> person = personService.findById(id); 
		if(!person.isPresent()) { 
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(person);
		
		
	} 
	
	
	
}
