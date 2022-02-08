package com.tryhards.pe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tryhards.pe.model.Person;

@Repository
@Transactional
public class PersonDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public void savePerson(Person person) { 
		getSession().save(person);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPerson() { 
		return getSession().createCriteria(Person.class).list(); 
	}
	
	
	private Session getSession()   { 
		Session session = factory.getCurrentSession();
		if(session==null) { 
			session = factory.openSession();
		}
		return session;
	}
}
