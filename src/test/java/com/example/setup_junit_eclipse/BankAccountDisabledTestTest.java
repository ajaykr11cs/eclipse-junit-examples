package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDisabledTestTest {

	@Test
	@Disabled("Temporarily Disabled: WIP")
	public void testDeposit(BankAccount bankAccount) {
		double prevBal = bankAccount.getBalance();
		bankAccount.deposit(350);
		
		assertEquals(350 + prevBal, bankAccount.getBalance());
	}
}
