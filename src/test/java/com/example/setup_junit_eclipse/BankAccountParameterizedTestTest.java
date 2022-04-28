package com.example.setup_junit_eclipse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.DayOfWeek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {

	@ParameterizedTest
	@ValueSource(ints = {500, 250, 300})
	@DisplayName("Depositing Successfully")
	public void testDeposit(int amount, BankAccount account) {
		account.deposit(amount);
		assertEquals(amount, account.getBalance());
	}
	
	//Sample Test for enum
	@ParameterizedTest
	@EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
	public void testDayOfWeek( DayOfWeek day) {
		assertTrue(day.toString().startsWith("T"));
	}
	
	@ParameterizedTest
	//@CsvSource({"100, Ajay", "250, Sachin", "0, Sudhir"})
	@CsvFileSource( resources = "/details.csv")
	public void testDepositAndName(double amount, String name, BankAccount account) {
		account.deposit(amount);
		account.setHolderName(name);
		//account.setActive(active);
		assertEquals(amount, account.getBalance());
		assertNotNull(account.getHolderName());
		assertEquals(name, account.getHolderName());
		//assumingThat( account.getBalance() > 0 , () -> assertTrue(account.isActive()));
		
	}
	
}
