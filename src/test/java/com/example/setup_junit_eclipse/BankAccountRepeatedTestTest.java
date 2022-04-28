package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {

	@RepeatedTest(5)
	public void testDepositRepetitionInfo(BankAccount account, RepetitionInfo repInfo) {
		
		account.deposit(500);
		assertEquals(500, account.getBalance());
		System.out.println("Number of Repetition : "+ repInfo.getCurrentRepetition());
	}
}
