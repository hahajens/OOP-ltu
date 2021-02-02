package ejakor9;

// namn: Jens Karlsson
// ltu användarnamn: ejakor-9

public class Account {

	private double balance;
	private final double rate;
	private String typeOfAccount = "Savings account";
	private int accountNumber;
	private static int lastNumber = 1000;

	public Account() {
		this.balance = 0;
		this.rate = 1.1;
		lastNumber++;
		this.accountNumber = lastNumber;
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("deposit completed! \nYour balance is now: " + this.balance);
			return true;
		} else {
			System.out.println("Amount to be deposited should be positive");
			return false;
		}
		
	}

	public boolean withdraw(double amount) {
		if (amount > this.balance || amount < 0) {
			System.out.println("You dont have enough balance on your account to withdraw " + amount + " kr, your balance is: " + this.balance);
			return false;
		} else {
			this.balance -= amount;
			System.out.println("Withdraw completed! \nYour balance is now: " + this.balance);
			return true;
		}
	}

	// Getter & setters

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterest() {

		double r = this.balance * rate / 100;
		return r;
	}

	public String getAccountType(){
		return this.typeOfAccount;
	}

	public int getAccountNr() {
		return this.accountNumber;
	}

	public String toString() {
		return "Account number: " + this.accountNumber + "\n" + "Balance: " + this.balance + "\n" + "Type: "
				+ this.typeOfAccount + "\n" + "Rate: " + rate;

	}
}
