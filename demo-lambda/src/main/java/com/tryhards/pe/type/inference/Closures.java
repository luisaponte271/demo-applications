package com.tryhards.pe.type.inference;

public class Closures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a  = 10; 
		int b  = 20;
		/*doProcess(a, new Process() {
			
			@Override
			public void process(int i) {
				// TODO Auto-generated method stub
				b = 40;
				System.out.println(i + b);
			}
		}); */
		
		System.out.println("usando lambda");
		doProcess(a, i -> System.out.println(i+b));
	}
	
	public static void doProcess(int i, Process p) { 
		p.process(i);
	}
	
}
	
	interface Process { 
		void process(int i);
	}


