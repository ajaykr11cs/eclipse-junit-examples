package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BankAccountNestedTest {

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
	
	@Nested
	class WhenBalanceIsZero{
		
		@Test
		@DisplayName("Withdrawing below minimum balance : Exception")
		public void testWithdrawMinimumBalanceIs0() {
			BankAccount bankAccount = new BankAccount(0, 0);
			assertThrows( RuntimeException.class , () -> bankAccount.withdraw(500));
		}
		
		@Test
		@DisplayName("Withdrawing upto minimum balance : Success")
		public void testWithdrawMinimumBalanceNegative1000() {
			BankAccount bankAccount = new BankAccount(0, -1000);
			bankAccount.withdraw(500);
			assertEquals(-500, bankAccount.getBalance());
			
		}
	}
	
}
