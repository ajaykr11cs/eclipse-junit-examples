package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountBeforeAndAfterTest {

	static BankAccount bankAccount;
	
	@BeforeAll
	public static void prepTest() {
		System.out.println("preTest");
		bankAccount = new BankAccount(500, 0);
	}
	
	@BeforeEach
	public void preEachTest() {
		System.out.println("preEachTest");
		bankAccount.deposit(100);
	}
	
	@Test
	public void testWithdraw() {
		double prevBal = bankAccount.getBalance();
		bankAccount.withdraw(250);
		assertEquals(prevBal - 250, bankAccount.getBalance());
	}
	
	
	@Test
	public void testDeposit() {
		double prevBal = bankAccount.getBalance();
		bankAccount.deposit(350);
		
		assertEquals(350 + prevBal, bankAccount.getBalance());
	}
	
	@AfterEach
	public void afterEachTest() {
		System.out.println("afterEachTest");
		bankAccount.withdraw(100);
	}
	
	@AfterAll
	public static void afterTest() {
		System.out.println("afterTest");
	}
}
