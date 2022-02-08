package com.tryhards.pe.lamda.vs.interfaz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.tryhards.pe.type.models.Person;

public class Unit4 {

	public static void main(String[] args) {
		List<Person> p = Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Carroll",42),
				new Person("Thomas","Carlyle",51),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)
				);
	 
		System.out.println("printing all persons");
		performConditional(p, p1 -> true,System.out::println); //p -> method(p)
	 
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
