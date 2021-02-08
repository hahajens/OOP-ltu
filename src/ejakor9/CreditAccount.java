package ejakor9;

import java.util.ArrayList;

public class CreditAccount extends Account {
    private double balance;
    private double creditLimit = -5000.0;
    private double rate;
    private String typeOfAccount = "Credit Account";
    ArrayList<Transaction> transactions = new ArrayList<>();

    public CreditAccount(){
        super();
    }

    @Override
    //Insättning på konto
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

    @Override
    // Uttag på ett konto
    public boolean withdraw(double amount) {
        if (this.balance - amount < creditLimit || amount < 0) {
            System.out.println("You dont have enough balance on your account to withdraw " + amount
                    + ". You can withdraw maxiumum " + Math.abs(this.creditLimit-this.balance));
            return false;
        } else {
            this.balance -= amount;
            System.out.println("Withdraw completed! \nYour balance is now: " + this.balance);
            return true;
        }
    }
    public double getInterest() {
        this.rate = this.balance > 0.0 ? 0.5 : 7.0;
		return this.balance * this.rate / 100;
    }

  // Strängrepresentation av ett kontoobjekt
    @Override
	public String toString() {
		return "\n\n" + "Account number: " + this.accountNumber + "\n" + "Type of Account: " + this.typeOfAccount + "\n" + "Balance: " + this.balance;

	}

}
