package com.tryhards.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tryhards.pe.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
