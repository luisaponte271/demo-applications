package com.tryhards.pe.type.inference;

public class TypeInference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StringLengthLambda myLambda = s -> s.length();
		//System.out.println(myLambda.getLengt("hello lambda"));
		printlnLambda(s -> s.length());
		printlnSuma((s,y) -> s+y );
	}
	
	public static void printlnLambda(StringLengthLambda l) { 
		System.out.println(l.getLengt("Hello Lambda"));
	}
	
	public static void printlnSuma(SumaLambda s) { 
		System.out.println("La suma es : " + s.getSuma(3, 2));
	}
	
	interface StringLengthLambda { 
		int getLengt(String s);
	}
	
	interface SumaLambda { 
		int getSuma(int num1, int num2);
	}

}
