package com.example.setup_junit_eclipse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountConditionalTest {

	@Test
	@EnabledOnOs({OS.MAC})
	public void testOnMac() {
		
	}
	
	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void testOnWindows() {
		
	}
	
	@Test
	@EnabledOnJre({JRE.JAVA_11})
	public void testOnJre11() {
		
	}
	
	@Test
	@EnabledOnJre({JRE.JAVA_8})
	public void testOnJre16() {
		
	}
	
}
