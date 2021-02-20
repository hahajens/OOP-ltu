package ejakor9;

import java.util.ArrayList;

/**
 * Klass för att hantera kundens kreditkonto,
 * 
 * @author Jens Karlsson, ejakor-9
 */

public class CreditAccount extends Account {
    private double balance;
    private double creditLimit = -5000.0;
    private double rate;
    private String typeOfAccount = "Credit Account";
    ArrayList<Transaction> transactions = new ArrayList<>();

    public CreditAccount() {
        super();
    }

    @Override
    // Insättning på konto
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("deposit completed! \nYour balance is now: " + this.balance);
            Transaction transaction = new Transaction(amount);
            transactions.add(transaction);
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
                    + ". You can withdraw maxiumum " + Math.abs(this.creditLimit - this.balance));
            return false;
        } else {
            this.balance -= amount;
            System.out.println("Withdraw completed! \nYour balance is now: " + this.balance);
            Transaction transaction = new Transaction((amount * -1));
            transactions.add(transaction);
            return true;
        }
    }

    @Override
    // Hämta transaktioner på kontot
    public ArrayList<String> getTransactions() {
        ArrayList<String> strTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            strTransactions.add(transaction.getInfo() + "\nBalance: " + this.balance);
        }
        return strTransactions;
    }

    @Override
    // få intjänad ränta på kontot
    public double getInterest() {
        this.rate = this.balance > 0.0 ? 0.5 : 7.0;
        return this.balance * this.rate / 100;
    }

    @Override
    // Få kontots balans
    public double getBalance() {
        return this.balance;
    }

    @Override
    // Få kontots nummer
    public int getAccountNr() {
        return this.accountNumber;
    }

    @Override
    // Hämta kontotyp
    public String getAccountType() {
        return this.typeOfAccount;
    }

    // Ändra balans på kontot
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Strängrepresentation av ett kontoobjekt
    @Override
    public String toString() {
        return "\n\n" + "Account number: " + this.accountNumber + "\n" + "Type of Account: " + this.typeOfAccount + "\n"
                + "Balance: " + this.balance;

    }

}
