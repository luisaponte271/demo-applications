package com.tryhards.pe.type.inference;

public class ThisReference {
	
	
	public static void doProcess(int i, Process p) { 
		p.process(i);
	}
	
	public void execute() { 
		// this === ?
		doProcess(10, i -> {
			System.out.println("value of is i is " + i);
			System.out.println(this);
		});
	}
	
	public static void main(String[] args) {
		ThisReference thisReference = new ThisReference();
	/*thisReference.doProcess(10, new Process() {
			
			@Override
			public void process(int i) {
				// TODO Auto-generated method stub
				System.out.println("value of i is "  + i);
				System.out.println(this);
			}
			
			public String toString() { 
				return "this is the anoymous inner class";
			}
		}); */
		/*
		thisReference.doProcess(10, i -> {
			System.out.println("value of is i is " + i);
			//System.out.println(this); this will not work
		}); */
		
		thisReference.execute();
	}
	
	public String toString() { 
		return "This is the main thisReference class instance";
	}
}
