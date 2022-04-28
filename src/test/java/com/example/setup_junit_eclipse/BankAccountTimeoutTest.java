package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

//for all test methods in the class(except lifecycle ones)
//@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void testDepositTimeoutAssertion( BankAccount account ) {
		try {
			Thread.sleep(50);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		account.deposit(450);
		assertEquals(450, account.getBalance());
		
	}
	
	@Test
	public void testDepositTimeoutAnnotation( BankAccount account ) {
		
		try {
			Thread.sleep(600);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		account.deposit(150);
		assertTimeout(Duration.ofMillis(500), () -> {
			Thread.sleep(50);
		});
	}
	
}
