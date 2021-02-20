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

	// Få transaktioner, känns rimligt att en kund måste kunna få detta oavsett konto
	abstract ArrayList<String> getTransactions();

	// Få ränta, känns rimligt att en kund måste kunna få detta oavsett konto
	abstract double getInterest();

	// Få kontotyp, känns rimligt att en kund måste kunna få detta oavsett konto
	abstract String getAccountType(); 
	
	// Få kontonummer, känns rimligt att en kund måste kunna få detta oavsett konto
	abstract int getAccountNr();

	// Få balans, känns rimligt att en kund måste kunna få detta oavsett konto
	abstract double getBalance();
  
	// Strängrepresentation av ett kontoobjekt
	public String toString() {
		return "Account number: " + this.accountNumber + "\n" + "Balance: " + this.balance;

	}
}
