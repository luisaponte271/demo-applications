package com.tryhards.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tryhards.pe.dao.PersonDAO;
import com.tryhards.pe.model.Person;

@RestController
public class PersonController {
	
	@Autowired
	private PersonDAO dao;
	@PostMapping("/savePerson")
	public String save(@RequestBody Person person) {
		dao.savePerson(person);
		return "success";
	}
	@GetMapping("/getAll")
	public List<Person> getAllPersons() { 
		return dao.getPerson();
	}
 
}
