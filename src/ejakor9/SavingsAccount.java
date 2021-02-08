package ejakor9;

public class SavingsAccount extends Account{
    private double balance;
    private double rate; 
    private String typeOfAccount = "Savings Account";
    private int accountNumber;

    public SavingsAccount(){
        super();
    }
    @Override
    // Insättning på ett konto
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
		if (amount > this.balance || amount < 0) {
			System.out.println("You dont have enough balance on your account to withdraw " + amount
					+ " kr, your balance is: " + this.balance);
			return false;
		} else {
			this.balance -= amount;
			System.out.println("Withdraw completed! \nYour balance is now: " + this.balance);
			return true;
		}
	}

}
