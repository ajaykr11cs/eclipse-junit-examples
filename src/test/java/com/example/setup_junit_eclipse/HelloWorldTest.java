package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
	
	@Test
	void testSayHello() {
		HelloWorld hw = new HelloWorld();
		assertEquals("Hello World!", hw.sayHello());		
	}
	
}
