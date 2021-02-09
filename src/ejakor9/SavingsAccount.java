package ejakor9;
/**
 * Klass för att hantera kundens sparkonto,
 * @author Jens Karlsson, ejakor-9
 */

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends Account {
    private double balance;
    private double rate = 1.0;
    private String typeOfAccount = "Savings Account";
    static int withdrawLimit = 1;
    private int nrOfWithdrawals;

    public SavingsAccount() {
        super();
        nrOfWithdrawals = 0;
    }

    @Override
    // Insättning på ett konto
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
        if (amount > this.balance || amount < 0) {
            System.out.println("You dont have enough balance on your account to withdraw " + amount
                    + " kr, your balance is: " + this.balance);
            return false;
        } else {
            if (nrOfWithdrawals >= withdrawLimit) {
                this.balance -= (amount * 1.02);
                nrOfWithdrawals++;
                System.out.println("Withdraw completed! \nYour balance is now: " + this.balance + "\nsince you excessed your withdrawal limit there is a 2% rate");
                Transaction transaction = new Transaction((amount*-1));
                transactions.add(transaction);
                return true;
            } else {
                this.balance -= amount;
                nrOfWithdrawals++;
                System.out.println("Withdraw completed! \nYour balance is now: " + this.balance);
                Transaction transaction = new Transaction((amount*-1));
                transactions.add(transaction);
                return true;
            }
        }
    }
    public double getInterest() {
		return this.balance * this.rate / 100;
    }
    
        // Strängrepresentation av ett kontoobjekt
        @Override
	public String toString() {
		return "\n\n" + "Account number: " + this.accountNumber + "\n" + "Type: " + this.typeOfAccount + "\n" + "Balance: " + this.balance + "\n" + "rate: " + rate;

    }
    
    public ArrayList<String> getTransactions(){
        ArrayList<String> strTransactions = new ArrayList<>();
        for(Transaction transaction : transactions){
            strTransactions.add(transaction.getInfo() + "\nBalance: " + this.balance+ "\n");
        }
        return strTransactions;
    }


    //FIXME Sätt till noll efter ett år?!
    public void zeroWithdrawal(){
        this.nrOfWithdrawals = 0; 
    }

}
