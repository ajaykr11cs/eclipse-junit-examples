package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderedExecutionTest {

	static BankAccount bankAccount = new BankAccount(0, 0);
	
	@Test
	@Order(2)
	public void testWithdraw() {
		bankAccount.withdraw(250);
		assertEquals(100, bankAccount.getBalance());
	}
	
	
	@Test
	@Order(1)
	public void testDeposit() {
		double prevBal = bankAccount.getBalance();
		bankAccount.deposit(350);
		
		assertEquals(350 + prevBal, bankAccount.getBalance());
	}
	
}
