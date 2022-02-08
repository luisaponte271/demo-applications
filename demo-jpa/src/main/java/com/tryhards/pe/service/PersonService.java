package com.tryhards.pe.service;

import java.util.Optional;

 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tryhards.pe.entity.Person;

@Service 
public interface PersonService {
	
	public Iterable<Person> findAll();
	
	public Page<Person> findAll(Pageable pageable);
	
	public Optional<Person> findById(Long id);
	
	public Person save(Person person); 
	
	public void deleteById(Long id);
} 
