package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test BankAccount Class")
public class BankAccountTest {
	
	@Test
	@DisplayName("Withdraw 400 Successfully")
	public void testWithdraw() {
		BankAccount account = new BankAccount(500, 100);
		account.withdraw(400);
		
		assertEquals(100, account.getBalance());
	}
	
	@Test
	@DisplayName("Deposit 250 Successfully")
	public void testDeposit() {
		BankAccount account = new BankAccount(1250, 0);
		account.deposit(250);
		
		assertEquals(1500, account.getBalance());
	}
	
}
