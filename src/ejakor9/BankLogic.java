package ejakor9;

import java.util.ArrayList;


/**
 * Klass för att hantera funktionalitet i programmet,
 * @author Jens Karlsson, ejakor-9
 */


public class BankLogic {
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();

	// skapar en ny lista med strängrepresentationer av alla kunder
	public ArrayList<String> getAllCustomers() {
		ArrayList<String> stringList = new ArrayList<>();
		for (Customer c : customerList) {
			stringList.add(c.toString());
		}
		return stringList;
	}

	// Skapar en ny kund
	public boolean createCustomer(String name, String surname, String pNo) {
		if (!customerExists(pNo)) {
			Customer customer = new Customer(name, surname, pNo);
			customerList.add(customer);
			System.out.println("Customer named " + name + " " + surname + " was created");
			return true;
		} else {
			System.out.println("A customer with that personal number already exists");
			return false;
		}
	}

	// Få information om en kund med ett personnummer
	public ArrayList<String> getCustomer(String pNo) {
		ArrayList<String> customerInfo = new ArrayList<>();
		for (Customer c : customerList) {
			if (c.getPersonalID().equals(pNo)) {
				customerInfo.add(c.toString());
			}
		}
		return customerInfo;
	}

	// ändra en kunds namn med ett personnumer
	public boolean changeCustomerName(String name, String surname, String pNo) {
		boolean nameChanged = false;
		Customer c = getCustomerObject(pNo);
		if (c != null) {
			nameChanged = true;
			if (name.length() > 0) {
				c.setFirstName(name);
			} else {
				nameChanged = false;
			}
			if (surname.length() > 0) {
				c.setLastName(surname);
			} else {
				nameChanged = false;
			}
		} else {
			System.out.println("Couldn't find customer with that id nr");
		}
		return nameChanged;
	}

	// Skapar ett nytt sparkonto åt kund med idnummer
	public int createSavingsAccount(String pNo) {
		int accountNumber = -1;
		Customer customer = getCustomerObject(pNo);
		if (customer != null) {
			accountNumber = customer.createSavingsAccount();
		} else {
			System.out.println("The customer with that id number doesnt exist");
		}

		return accountNumber;
	}

	// Skapar ett nytt kreditkonto åt kund med dennes idnummer
	public int createCreditAccount(String pNo) {
		int accountNumber = -1;
		Customer customer = getCustomerObject(pNo);
		if (customer != null) {
			accountNumber = customer.createCreditAccount();
		} else {
			System.out.println("The customer with that id number doesnt exist");
		}

		return accountNumber;
	}

	// hämtar Kontoinformation med kundens id och kontots id
	public String getAccount(String pNo, int accountId) {
		Customer customer = getCustomerObject(pNo);
		String output = null;
		if (customer != null) {
			output = customer.getAccountInformation(accountId);
		}
		return output;
	}

	// Sätt in pengar på konto, anropar deposit i Customer
	public boolean deposit(String pNo, int accountId, double amount) {
		boolean depositAccepted = false;
		Customer customer = getCustomerObject(pNo);
		Account account = customer.getAccountObject(accountId);
		if (account != null) {
			if (account.deposit(amount)) {
				depositAccepted = true;
			}
		} else {
			System.out.println("Either personal ID or account ID was incorrect");
		}
		return depositAccepted;
	}

	// Tar ut pengar från konto, anropar withdraw i Customer
	public boolean withdraw(String pNo, int accountId, double amount) {
		boolean withdrawalAccepted = false;
		Customer customer = getCustomerObject(pNo);
		Account account = customer.getAccountObject(accountId);
		if (account != null) {
			if (account.withdraw(amount)) {
				withdrawalAccepted = true;
			}
		} else {
			System.out.println("Either personal ID or account ID was incorrect");
		}
		return withdrawalAccepted;
	}

	// Avslutar ett konto med kundens idnr och kontonummer
	public String closeAccount(String pNr, int accNr) {
		String output = "";
		if (customerExists(pNr)) {
			Customer customer = getCustomerObject(pNr);
			Account account = customer.getAccountObject(accNr);
			if (account != null) {
				double interest = account.getInterest();
				customer.closeAccount(account);
				output = "The account with nr " + account.getAccountNr() + " "
						+ " has been closed, the final interest is; " + interest + " kr";
			}
		} else {
			output = "Either personal ID or account ID was incorrect";
		}
		return output;
	}

	// Tar bort en kund
	public ArrayList<String> deleteCustomer(String pNo) {
		ArrayList<String> deletedCustomer = new ArrayList<>();
		if (customerExists(pNo)) {
			try {
				Customer customer = getCustomerObject(pNo);
				deletedCustomer.add(customer.getCustomerInformation());
				deletedCustomer.addAll(customer.getAccountsAsStrings());
			} catch (NullPointerException e) {
				System.err.println("Null Error: " + e);
			}
		}

		return deletedCustomer;
	}

	public ArrayList<String> getTransactions(String pNr, int accountId) {
		ArrayList<String> list = new ArrayList<>();
		try {
			Customer customer = getCustomerObject(pNr);
			Account account = customer.getAccountObject(accountId);
			if(account != null) {
				list = account.getTransactions();
			}
		} catch (NullPointerException e) {
			System.err.println("Null Error: " + e);
		}
		return list;
	}

	// Hjälpfunktion, kollar om en kund finns
	private boolean customerExists(String pNr) {
		boolean exists = false;
		for (Customer c : customerList) {
			if (c.getPersonalID().equals(pNr)) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	// hjälpfunktion, hämtar ett kundobjekt med idnr
	public Customer getCustomerObject(String pNr) {
		Customer customer = null;
		for (Customer c : customerList) {
			if (c.getPersonalID().equals(pNr)) {
				customer = c;
			}
		}
		return customer;
	}
}
