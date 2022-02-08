package com.tryhards.pe.lamda.vs.interfaz;

public class Greeter {
	
	public void greet(Greeting greeting) { 
		greeting.perfom();
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		//HelloWorldGreeting hw = new HelloWorldGreeting();
		//greeter.greet(hw); 
		Greeting myLambdaFunction = () -> System.out.println("Hello world");
		//MyLambda myLambdaFunction = () -> System.out.println("Hello world"); 
		//MyAdd addFunction = (int a, int b) -> a + b;
		//myLambdaFunction.perfom();
	 
		Greeting innerClassGreeting = new Greeting() { 
			@Override
			public void perfom() {
				// TODO Auto-generated method stub
				System.out.println("Hello world");
			}
		};
		
		greeter.greet(innerClassGreeting);
		greeter.greet(myLambdaFunction);
	}
}


//interface MyLambda { 
//	void foo();
//}
//interface MyAdd { 
//	int add(int x, int y);
//}
