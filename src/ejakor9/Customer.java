package ejakor9;

import ejakor9.*;

import java.util.ArrayList;

//namn: Jens Karlsson
//ltu användarnamn: ejakor-9

public class Customer {

	private String firstName;
	private String lastName;
	private String personalID;
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public Customer(String firstName, String lastName, String personalID) {
		this.firstName = firstName;
		this.lastName = lastName;

		if (personalID.length() != 10) {
			System.out.println("Social number must be in format YYMMDDXXXX");
		} else {
			this.personalID = personalID;

		}
	}

	public int createAccount() {
		Account newAcc = new Account();
		accounts.add(newAcc);
		return newAcc.getAccountNr();
	}

	// Getters och setters

	public String getFirstName() {
		return firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public String getPersonalID() {
		return this.personalID;
	}

	public String getCustomerInformation() {
		return this.firstName + " " + this.lastName + " " + this.personalID;
	  }

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String toString() {
		return"Name: " + this.firstName + " " + this.lastName + "\n" + "ID number: "
				+ this.personalID + "\n" + 
				"Accounts: " + this.accounts;
	}

	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}

	public ArrayList<String> getAccountsAsStrings(){
		ArrayList<String> output = new ArrayList<>();

		for(Account account : accounts){
			output.add(account.getAccountNr() + " " + account.getBalance() + " " + account.getAccountType() + " " + account.getInterest());
		}
		return output;
	}

	public String getAccountInformation(int accNr){
		String output = null;
		for(Account account : accounts){
			if(account.getAccountNr() == accNr){
				output = account.toString();
				break;
			}
		}
		return output;
	}
	
	public Account getAccountObject(int accNr){
		Account account = null;

		for(Account a : accounts){
 			if(a.getAccountNr() == accNr){
				account = a;
				break;
			}
		}
		return account;
	}

	public boolean accountExists(int accNr) {
		boolean exists = false;
		for (Account account : accounts) {
			if (account.getAccountNr()==(accNr)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	public boolean closeAccount(Account account){
		boolean isClosed;

		try {
			accounts.remove(account);
			isClosed = true;
		}catch(IndexOutOfBoundsException e){
			System.err.println("Error" + e);
			isClosed = false;
		}
		return isClosed;
	}
}
