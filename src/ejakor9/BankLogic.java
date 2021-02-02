package ejakor9;

//namn: Jens Karlsson
//ltu användarnamn: ejakor-9

import java.util.ArrayList;

public class BankLogic {
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();

	// skapar en ny lista med strängrepresentationer av alla kunder
	public ArrayList<String> getAllCustomers() {
		ArrayList<String> stringList = new ArrayList<String>();

		for (Customer c : customerList) {
			String s = c.toString();
			stringList.add(s);
			String formattedString = stringList.toString().replace(",", "").replace("[", "").replace("]", "").trim();
		}
		return stringList;
	}

	// Skapa en ny kund
	public boolean createCustomer(String name, String surname, String pNo) {
		boolean isCreated = false;

		if (customerExists(pNo) == false) {
			Customer customer = new Customer(name, surname, pNo);
			customerList.add(customer);
			System.out.println("Customer named " + name + " " + surname + " was created");
			isCreated = true;
		} else {
			System.out.println("A customer with that personal number already exists");
			isCreated = false;
		}
		return isCreated;
	}

	// Få information om en kund på ett visst personnummer
	public ArrayList<String> getCustomer(String pNo) {
		ArrayList<String> customerInfo = new ArrayList<String>();

		for (Customer c : customerList) {
			if (c.getPersonalID().equals(pNo)) {
				customerInfo.add(c.toString());
			}
		}
		return customerInfo;
	}

	// public int createSavingsAccount(String pNo){return 1};

	// ändra en kunds namn på ett visst personnumer
	public boolean changeCustomerName(String name, String surname, String pNo) {
		boolean nameChanged = false;

		for (Customer c : customerList) {
			if (c.getPersonalID().contains(pNo)) {
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
			}
		}
		return nameChanged;
	}

	// Skapar ett nytt konto åt kund med idnummer
	public int createSavingsAccount(String pNo) {
		int accountNumber = -1;
		Customer customer = getCustomerObject(pNo);
		if (customer != null) {
			accountNumber = customer.createAccount();
		} else {
			System.out.println("The customer with that id number doesnt exist");
		}

		return accountNumber;
	}

	public String getAccount(String pNo, int accountId) {
		Customer customer = getCustomerObject(pNo);
		String output = null;

		if (customer != null) {
			output = customer.getAccountInformation(accountId);
		}
		return output;
	}

	public boolean deposit(String pNo, int accountId, double amount) {
		boolean depositAccepted = false;

		Customer customer = getCustomerObject(pNo);
		Account account = customer.getAccountObject(accountId);

		if (account != null) {
			if(account.deposit(amount)){
			depositAccepted = true;
			}
		} else {
			System.out.println("Either personal ID or account ID was incorrect");
		}
		return depositAccepted;
	}

	public boolean withdraw(String pNo, int accountId, double amount) {
		boolean withdrawalAccepted = false;

		Customer customer = getCustomerObject(pNo);
		Account account = customer.getAccountObject(accountId);

		if (account != null && customer != null) {
			if(account.withdraw(amount)){
				withdrawalAccepted = true;
			}
			
		} else {
			System.out.println("Either personal ID or account ID was incorrect");
		}
		return withdrawalAccepted;
	}

	public String closeAccount(String pNr, int accNr) {
		String output = "";

		if (customerExists(pNr)) {
			Customer customer = getCustomerObject(pNr);
			Account account = customer.getAccountObject(accNr);

			if (customer != null && account != null) {
				double interest = account.getInterest();
				customer.closeAccount(account);
				output = "The account with nr " + account.getAccountNr() + " "
						+ " has been closed, the final interest is; " + interest + " kr";
			}
		} else {
			System.err.println("Wrong input");
		}
		// try {
		// Customer customer = getCustomerObject(pNr);
		// Account account = customer.getAccountObject(accNr);
		// double interest = account.getInterest();

		// customer.closeAccount(account);
		// output = "The account with nr " + account.getAccountNr() + " " + " has been
		// closed, the final interest is; "
		// + interest + " kr";
		// } catch (NullPointerException e) {
		// System.err.println("Error: " + e);
		// output = null;
		// }

		return output;
	}

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

	public Customer getCustomerObject(String pNr) {

		Customer customer = null;

		for (Customer c : customerList) {

			if (c.getPersonalID().equals(pNr)) {
				customer = c;
			}

		}
		return customer;
	}

	// private Customer getCustomerObject(String pNr) {
	// Customer customer = null;

	// for (Customer c : customerList) {
	// if (c.getPersonalID().equals(pNr)) {
	// customer = c;
	// }
	// }
	// return customer;
	// }

}
