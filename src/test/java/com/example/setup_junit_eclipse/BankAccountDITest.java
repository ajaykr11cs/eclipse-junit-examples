package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDITest {

	@Test
	@DisplayName("Deposit 250 Successfully")
	public void testDeposit(BankAccount account) {
		account.deposit(250);
		assertEquals(250, account.getBalance());
	}
	
}
