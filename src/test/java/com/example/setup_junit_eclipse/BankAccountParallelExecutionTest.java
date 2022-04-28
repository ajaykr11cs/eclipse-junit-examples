package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

	@Test
	@DisplayName("Deposit 250 Successfully")
	public void testDeposit1(BankAccount account) {
		try {
			Thread.sleep(200);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		account.deposit(250);
		assertEquals(250, account.getBalance());
	}
	
	@Test
	@DisplayName("Deposit 350 Successfully")
	public void testDeposit2(BankAccount account) {
		try {
			Thread.sleep(400);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		account.deposit(350);
		assertEquals(350, account.getBalance());
	}
	
	@Test
	@DisplayName("Deposit 450 Successfully")
	public void testDeposit3(BankAccount account) {
		try {
			Thread.sleep(600);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		account.deposit(450);
		assertEquals(450, account.getBalance());
	}
}
