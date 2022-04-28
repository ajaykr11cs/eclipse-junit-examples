package com.example.setup_junit_eclipse;

public class BankAccount {
	
	private double balance;
	private double minimumBalance;
	private boolean isActive = false; 
	private String holderName;
	
	public BankAccount(double balance, double minimumBalance) {
		this.balance = balance;
		this.minimumBalance = minimumBalance;
		if( this.balance > 0 ) {
			this.setActive(true);
		}
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
		if( this.balance > 0 )
			this.setActive(true);
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	public double withdraw(double amount) {
		
		if( this.balance - amount >= this.minimumBalance ) {
			return this.balance -= amount;
		}else {
			throw new RuntimeException("Can't Withdraw, minimum balance wil be breached!");
		}
	}
	
	public double deposit(double amount) {
		this.balance += amount; 
		if( this.balance > 0 )
			this.setActive(true);
		return this.balance;
	}
	
}
