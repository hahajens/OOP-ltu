package ejakor9;

import java.util.ArrayList;
/**
 * Klass för att hantera kunden
 * @author Jens Karlsson, ejakor-9
 */

public class Customer {

	private String firstName;
	private String lastName;
	private String personalID;
	private ArrayList<Account> accounts = new ArrayList<>();

	// Skapar ett kundobjekt, gör en väldigt enkel koll på personnr
	public Customer(String firstName, String lastName, String personalID) {
		this.firstName = firstName;
		this.lastName = lastName;
		if (personalID.length() != 10) {
			System.out.println("Social number must be in format YYMMDDXXXX");
		} else {
			this.personalID = personalID;
		}
	}

	// Skapar ett bankkonto tillhörande en kund
	public int createAccount() {
		Account account = new Account();
		accounts.add(account);
		return account.getAccountNr();
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public String getPersonalID() {
		return this.personalID;
	}

	// används i deletecustomer
	public String getCustomerInformation() {
		return this.firstName + " " + this.lastName + " " + this.personalID;
	}

	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// returnerar strängrepresentaton av kundobjekt
	public String toString() {
		return "Name: " + this.firstName + " " + this.lastName + "\n" + "ID number: " + this.personalID + "\n"
				+ "Accounts: " + this.accounts;
	}

	// returnerar en lista på de konton som tillhör en specifik kund
	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}

	// returnerar en lista på kontoinformation i typ String
	public ArrayList<String> getAccountsAsStrings() {
		ArrayList<String> output = new ArrayList<>();
		for (Account account : accounts) {
			output.add(account.getAccountNr() + " " + account.getBalance() + " " + account.getAccountType() + " "
					+ account.getInterest());
		}
		return output;
	}

	// returnerar en strängrepresentation av ett konto.
	public String getAccountInformation(int accNr) {
		String output = null;
		for (Account account : accounts) {
			if (account.getAccountNr() == accNr) {
				output = account.toString();
				break;
			}
		}
		return output;
	}

	// Returnerar en kund konto
	public Account getAccountObject(int accNr) {
		Account account = null;
		for (Account a : accounts) {
			if (a.getAccountNr() == accNr) {
				account = a;
				break;
			}
		}
		return account;
	}

	// Stänger ett konto som tillhör en kund
	public boolean closeAccount(Account account) {
		boolean isClosed;
		try {
			accounts.remove(account);
			isClosed = true;
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Error" + e);
			isClosed = false;
		}
		return isClosed;
	}
}
