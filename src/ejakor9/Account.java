package ejakor9;

import java.util.ArrayList;

/**
 * Klass för att hantera kundens konto
 * @author Jens Karlsson, ejakor-9
 */

abstract class Account {

	protected double balance;
	protected String typeOfAccount;
	protected int accountNumber;
	protected static int lastNumber = 1000;
	protected ArrayList<Transaction> transactions = new ArrayList<>();

	// Konstruktor för konto
	protected Account() {
		this.balance = 0;
		lastNumber++;
		this.accountNumber = lastNumber;
	}

	// Insättning på ett konto
	abstract boolean deposit(double amount);

	// Uttag på ett konto
	abstract boolean withdraw(double amount);

	// Getters & Setters

	abstract ArrayList<String> getTransactions();

	public double getBalance() {
		return this.balance;
	}

	abstract double getInterest();

	public String getAccountType() {
		return this.typeOfAccount;
	}

	public int getAccountNr() {
		return this.accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// Strängrepresentation av ett kontoobjekt
	public String toString() {
		return "Account number: " + this.accountNumber + "\n" + "Balance: " + this.balance;

	}
}
