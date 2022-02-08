package com.tryhards.pe.lamda.vs.interfaz;

public class Unit3 {

	public static void main(String[] args) {
		//Thread t  = new Thread(()-> printMessage());
		Thread t  = new Thread(Unit3::printMessage); // () -> method()
		t.start();
	}
	
	public static void printMessage() { 
		System.out.println("Hello");
	}
}
