package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BankAccountAssumptionsTest {
	
	@Test
	@DisplayName("Test activation account after creation")
	public void testActive() {

		BankAccount bankAccount = new BankAccount(500, 0);
		//Assume that the below should work only is Bank Account is not null
		assumeTrue(bankAccount != null);
		//assumeTrue(bankAccount == null, "Account is Null");
		assumeFalse(bankAccount == null);
		assertTrue(bankAccount.isActive());
	}

	@Test
	@DisplayName("Test activation account after creation")
	public void testActive2() {

		BankAccount bankAccount = new BankAccount(500, 0);
		//Assume that the below should work only is Bank Account is not null
		assumingThat( bankAccount != null, 
				() -> assertTrue(bankAccount.isActive()));
	}
}
