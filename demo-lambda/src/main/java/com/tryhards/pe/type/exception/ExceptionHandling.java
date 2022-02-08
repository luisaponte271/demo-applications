package com.tryhards.pe.type.exception;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int someNumbers[] = {1,2,3,4};
		int key = 2;
		
		process(someNumbers,key, (v,k) -> { try { System.out.println(v/k); } catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("An Arithmetic exception happened");
			}
		});
		System.out.println("Usando wapper");
		process(someNumbers,key, wrapperLambda((v,k) -> System.out.println(v/k)));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		// TODO Auto-generated method stub
		for (int i:someNumbers) {  
				 consumer.accept(i, key); 
		} 
	} 
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) { 
		return (a, b) ->  { 
			try { 
			consumer.accept(a, b);
			} 
			catch (ArithmeticException e) {
				// TODO: handle exception
				System.out.println("Exception caught in wrapper lambda");
			}
		};  
	}
}
 