package com.pkg1;

public class Test {
	//public access modifier
	//class keyword to define class
	//
	//within package(same folder), another package (another folder)
	int i=10;
	String name="I am class varaiable";
	public static void main(String[] args) {
		/*String name1="I am method variable";
		System.out.println("helloworld  "+name1); //syso ctrl+space
		Test obj1=new Test();
		System.out.println("HelloWorld "+obj1.name);*/
		System.out.println("Number of args:  "+args.length);
		
		
		for (int i = 0; i < args.length; i++) {
		System.out.println(i+"th argument is ::: "+args[i]);	
		}
		
		//new for loop
		for (String x : args) {
		System.out.println(" x value is :: "+x);	
		}
	
	}
	//type main and ctrl+space to get methods automatically
	//'+' String Concatenation operator
	//ctrl+shift+/ to put code in comments
}
