package ejakor9;

import java.util.ArrayList;

public class CreditAccount extends Account {
    private double balance;
    private double creditLimit = -5000.0;
    private double interestRate = 1.05;
    private double debthRate = 1.07;
    private String typeOfAccount = "Credit Account";
    private int accountNumber;
    ArrayList<Transaction> transactions = new ArrayList<>();

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
                    + " you can withdraw maxiumum " + (this.creditLimit-this.balance));
            return false;
        } else {
            this.balance -= amount;
            System.out.println("Withdraw completed! \nYour balance is now: " + this.balance);
            return true;
        }
    }
}
