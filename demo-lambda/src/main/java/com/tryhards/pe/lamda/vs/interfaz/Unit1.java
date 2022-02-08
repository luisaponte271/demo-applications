package com.tryhards.pe.lamda.vs.interfaz;

import java.util.Arrays; 
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tryhards.pe.type.models.Person;

public class Unit1 {
  
	public static void main(String[] args) {
		List<Person> p = Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Carroll",42),
				new Person("Thomas","Carlyle",51),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)
				);
	
		Collections.sort(p,new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		System.out.println("printing all persons");
		printAll(p);
		
		//printLastNameBeginningWithC(p);
		System.out.println("printing all persons with first name beginning with C");
		printConditional(p, new Condition() {
			
			@Override
			public boolean test(Person p) {
				// TODO Auto-generated method stub
				return p.getLastName().startsWith("C");
			}
		});
	}

	private static void printConditional(List<Person> p, Condition condition) {
		// TODO Auto-generated method stub
		for(Person p1 : p) { 
			if(condition.test(p1)) { 
				System.out.println(p1);
			}
		}
	}

	private static void printAll(List<Person> p) {
		// TODO Auto-generated method stub
		for(Person p1 : p) { 
			System.out.println(p1);
		}
		
	}
	

}

interface Condition { 
	boolean test(Person p);
}
 