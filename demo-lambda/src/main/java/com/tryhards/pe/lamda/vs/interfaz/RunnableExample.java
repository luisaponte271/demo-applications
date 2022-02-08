package com.tryhards.pe.lamda.vs.interfaz;

public class RunnableExample {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Printed inside Runnable");
			}
		});
		t.run();
		
		Thread tLambda = new Thread(() -> System.out.println("Printed inside Lambda Runnable"));
		tLambda.run();
	}
}
