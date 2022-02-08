package com.tryhards.pe.lamda.vs.interfaz;

import java.util.Arrays;
import java.util.List;

import com.tryhards.pe.type.models.Person;

public class Unit6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Carroll",42),
				new Person("Thomas","Carlyle",51),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)
				);
		
//		for(int i = 0; i<people.size();i++) {
//			 System.out.println(people.get(i));
//		}
		
		people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.forEach(p -> System.out.println(p.getFirstName()));
		

		long count  = people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.count();
		
		System.out.println(count);
		
	}

}
