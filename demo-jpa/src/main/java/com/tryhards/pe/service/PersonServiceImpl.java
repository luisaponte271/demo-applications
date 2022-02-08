package com.tryhards.pe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.tryhards.pe.entity.Person;
import com.tryhards.pe.repository.PersonRepository;

@Component("personaService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Iterable<Person> findAll() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	public Page<Person> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return personRepository.findAll(pageable);
	}

	@Override
	public Optional<Person> findById(Long id) {
		// TODO Auto-generated method stub
		return personRepository.findById(id);
	}

	@Override
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return personRepository.save(person);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		personRepository.deleteById(id);
	}

}
