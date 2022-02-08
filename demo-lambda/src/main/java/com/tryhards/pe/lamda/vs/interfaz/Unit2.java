package com.tryhards.pe.lamda.vs.interfaz;

import java.util.Arrays; 
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.tryhards.pe.type.models.Person;

public class Unit2 {
  
	public static void main(String[] args) {
		List<Person> p = Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Carroll",42),
				new Person("Thomas","Carlyle",51),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)
				);
	
		Collections.sort(p, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		 
		//printLastNameBeginningWithC(p);
		System.out.println("printing all persons");
		performConditional(p, p1 -> true, p2 -> System.out.println(p2)); 
		System.out.println("printing all persons with first name beginning with C");
		performConditional(p, p1 -> p1.getFirstName().startsWith("C"), p2 -> System.out.println(p2));
		System.out.println("printing all persons with last name beginning with C");
		performConditional(p, p1 ->  p1.getLastName().startsWith("C"), p2 -> System.out.println(p2.getFirstName())); 
	}

	private static void performConditional(List<Person> p, Predicate<Person> predicate, Consumer<Person> consumer) {
		// TODO Auto-generated method stub
		for(Person p1 : p) { 
			if(predicate.test(p1)) { 
				consumer.accept(p1); 
			}
		}
	}
 
}
 