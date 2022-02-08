package com.tryhards.pe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal")
public class Personal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name",nullable = false)
	private String name;
	@Column(name = "firstname",nullable = false)
	private String firstname;
	@Column(name = "lastname",nullable = false)
	private String lastname;
	@Column(name = "email",nullable = false)
	private String email;
	
	public Personal() {
		// TODO Auto-generated constructor stub
	}
	 
	public Personal(String name, String firstname, String lastname, String email) {
		this.name = name;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
  
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + ", name=" + name + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + "]";
	}
	 
}
