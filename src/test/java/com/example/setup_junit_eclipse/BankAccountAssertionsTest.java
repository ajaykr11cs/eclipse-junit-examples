package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountAssertionsTest {

	@Test
	@DisplayName("Withdraw will lead to negative balance")
	public void testWithdrawNotStuckAtZero() {
		BankAccount bankAccount = new BankAccount(500, -500);
		bankAccount.withdraw(800);
		
		assertNotEquals(0, bankAccount.getBalance());
	}
	
	@Test
	@DisplayName("Account active after creation with > 0 balance")
	public void testActive() {
		BankAccount bankAccount = new BankAccount(500, 0);
		
		assertTrue(bankAccount.isActive());		
	}

	@Test
	@DisplayName("Account Holder Name is Set")
	public void testAccountHolderName() {
		BankAccount bankAccount = new BankAccount(550, 50);
		bankAccount.setHolderName("Ajay");
		
		assertNotNull(bankAccount.getHolderName());
	}
	
	@Test
	@DisplayName("Test that we can't withdraw below minimum")
	public void testNoWithdrawBelowMinimum() {
		BankAccount bankAccount = new BankAccount(100, -500);
		
		assertThrows( RuntimeException.class, () -> bankAccount.withdraw(1000));
			
	}
	
	@Test
	@DisplayName("Test no exceptions on deposit and withdraw")
	public void testNoExceptionsOnDepositAndWithdraw() {
		BankAccount bankAccount = new BankAccount(100, 0);
		
		assertAll(
				() -> bankAccount.deposit(500),
				() -> bankAccount.withdraw(250));
	}
	
	@Test
	@DisplayName("Test the speed for Deposit")
	public void testDepostSpeed() {
		BankAccount bankAccount = new BankAccount(500, 100);
		
		assertTimeout( Duration.ofNanos(10), () -> bankAccount.deposit(1500));
	}
	
}
