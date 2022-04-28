package com.example.setup_junit_eclipse;

public class HelloWorld {
	
	String greeting;
	
	public String sayHello() {
		greeting += " Ajay";
		System.out.println("Greeting: "+ greeting);
		return "Hello World!";
	}

}
