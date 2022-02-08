package com.tryhards.pe;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.tryhards.pe.model.Person;
import com.tryhards.pe.model.Product;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Person p1 = new Person(1, "Mito", LocalDate.of(1991, 1, 21));
	        Person p2 = new Person(2, "Code", LocalDate.of(1990, 2, 21));
	        Person p3 = new Person(3, "Jaime", LocalDate.of(1980, 6, 23));
	        Person p4 = new Person(4, "Duke", LocalDate.of(2019, 5, 15));
	        Person p5 = new Person(5, "James", LocalDate.of(2010, 1, 4));
	        Person p6 = new Person(6, "Luis", LocalDate.of(2021, 9, 23));

	        Product pr1 = new Product(1, "Ceviche", 15.0);
	        Product pr2 = new Product(2, "Chilaquiles", 25.50);
	        Product pr3 = new Product(3, "Bandeja Paisa", 35.50);
	        Product pr4 = new Product(4, "Ceviche", 15.0);
	        Product pr5 = new Product(5, "Dead by daylight", 150.0);

	        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
	         
	        List<Product> products = Arrays.asList(pr1, pr2, pr3, pr4);
	        
	        //lambda - methodos de reference
	        //persons.forEach(p -> System.out.println(p)); 
	        //  persons.forEach(System.out::println);
	          
	        //1 - filters (param:predicate) parallelStream
	         List<Person> filterList1 = persons.stream()
	        		 						.filter(p -> App.getAge(p.getBirthDate())>= 18)
	        		 						.collect(Collectors.toList());
	         
	         //App.printList(filterList1);
	        //2 - Map (param: function)
	        Function<String, String> coderFunction = name -> "Coder " + name;
	        List<String> filterList2 =  persons.stream()
	        							//	.filter(p -> App.getAge(p.getBirthDate())>= 18) 
								        //  .map(p -> App.getAge(p.getBirthDate()))
	        							//	.map(p -> "Coder " + p.getName())
	        								//.map(p -> p.getName())
	        								.map(Person::getName)
	        								.map(coderFunction)
								          	.collect(Collectors.toList());
	        //App.printList(filterList2);		
	        
	        //3- Sorted(Param: Comparator) 
	        Comparator<Person> byNameAsc = (Person o1, Person o2) -> o1.getName().compareTo(o2.getName());
	        Comparator<Person> byNameDesc = (Person o1, Person o2) -> o2.getName().compareTo(o1.getName());
	        Comparator<Person> byBirtdate = (Person o1, Person o2) -> o1.getBirthDate().compareTo(o2.getBirthDate());
	        List<Person> filterList3 = persons.stream()
							        		.sorted(byNameAsc)
							        		.collect(Collectors.toList());
	        //App.printList(filterList3);		
	        
	        //4 - match (param: predicate)
	        Predicate<Person> startWithPRedicate = person -> person.getName().startsWith("J");
	        //anymatch : No evalua todo el stream, termina en la coincidencia
	        boolean rpta1 = persons.stream() 
	        					.anyMatch(startWithPRedicate);
	        
	        //System.out.println(rpta1);
	        // allMatch : Evalua todo el stream bajo la coincidencia.
	        boolean rpta2 = persons.stream() 
					.allMatch(startWithPRedicate);
	        
	        // noneMatch : Evalua todo el stream bajo la condicion
	        
	        boolean rpta3 = persons.stream() 
					.noneMatch(startWithPRedicate);
	        
	        // 5- Limit/Skip 
	        int pageNumber = 0;
	        int pageSize = 2;
	        List<Person> filteredList4 = persons.stream()
	        								.skip(pageNumber * pageSize)
	        								.limit(pageSize)
	        								.collect(Collectors.toList());
	        
	        //App.printList(filteredList4);
	        
	        // 6- Collectors 
	        Map<Double, List<Product>> collect1 = products.stream()
	        			.filter(p -> p.getPrice() > 20)
	        			.collect(Collectors.groupingBy(Product::getPrice));
	       // System.out.println(collect1);
	       // Counting 
	        Map<String, Long> collect2 = products.stream() 
	        			.collect(Collectors.groupingBy(
	        					Product::getName, Collectors.counting()));
	        //System.out.println(collect2);
	        
	        //Agrupando  por nombre producto y sumando
	        Map<String, Double> collect3 = products.stream() 
        			.collect(Collectors.groupingBy(
        					Product::getName, Collectors.summingDouble(Product::getPrice)));
	       // System.out.println(collect3);
        	//obteniendo suma y resumen
	        DoubleSummaryStatistics statistics =  products.stream()
	        			.collect(Collectors.summarizingDouble(Product::getPrice));
	        
	        //System.out.println(statistics);
	        
	        // 7. reduce 
	        Optional<Double> sum =	products.stream() 
	        				.map(Product::getPrice)
	        				.reduce(Double::sum);
	        System.out.println(sum.get());
	}
	
	public static int getAge(LocalDate birthdate) { 
		return Period.between(birthdate, LocalDate.now()).getYears();
	}
	
	public static void printList(List<?> list) { 
		list.forEach(System.out::println);
	}

}
