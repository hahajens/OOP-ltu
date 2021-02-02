// package ejakor9;

// import ejakor9.Customer;

// public class Test {
// 	public static void main(String[] args) {
// 		// Customer c1 = new Customer("Jens", "Karlsson", "9405308835");
// 		// Customer c2 = new Customer("Ann", "Johne", "9052308835");

// 		BankLogic b = new BankLogic();
// 		b.createCustomer("Jens", "Karlsson", "9405308835");
// 		b.createCustomer("Victor", "Wik", "9302048823");
// 		System.out.println("GET ALL CUSTOMERS:");
// 		System.out.println(b.getAllCustomers());
// 		System.out.println("GET CUSTOEMR METOHD");
// 		System.out.println(b.getCustomer("9302048823"));

// 		System.out.println("CHANGE CUSTOMER NAME........");
// 		System.out.println("GET ALL CUSTOMERS:");

// 		System.out.println(b.changeCustomerName("WWWictor", "Wikstrom", "9302048823"));
// 		System.out.println(b.getAllCustomers());

// 		System.out.println("");
// 		System.out.println("SKAPA ETT KONTO: ");
// 		System.out.println(b.createSavingsAccount("9405308835"));
// 		System.out.println(b.getCustomer("9405308835"));
// 		System.out.println(b.createSavingsAccount("9302048823"));
// 		System.out.println(b.getCustomer("9302048823"));

// 		System.out.println("GET ACCOUNT.....");
// 		System.out.println(b.getAccount("9405308835", 1001));
		
// 		System.out.println("");
// 		System.out.println("DEPOSIT .....");
// 		System.out.println(b.deposit("9405308835", 1001, 700.0));
// 		System.out.println(b.getAccount("9405308835", 1001));
// 		System.out.println("NY INSÄTTNING");
// 		System.out.println(b.deposit("9405308835", 1001, 800.0));
// 		System.out.println(b.getAccount("9405308835", 1001));
// 		System.out.println("");
// 		System.out.println("UTTAG....");
// 		System.out.println(b.withdraw("9405308835", 1001, 554.0));
// 		System.out.println(b.getAccount("9405308835", 1001));
// 		System.out.println("UTTAG IGEN...");
// 		System.out.println(b.withdraw("9405308835", 1001, 1000.0));
// 		System.out.println(b.getAccount("9405308835", 1001));
// 		System.out.println("");

// 		// System.out.println("CLOSING ACCOUNT....");
// 		// System.out.println(b.closeAccount("9405308835", 1001));
// 		// System.out.println(b.getCustomer("9405308835"));

// 		System.out.println("");
// 		System.out.println("ALL CUSTOMERS" + b.getAllCustomers());
// 		System.out.println("");
// 		System.out.println("DELETING CUSTOMER: " + b.deleteCustomer("9405308835"));
// 		System.out.println("");
// 		System.out.println("ALL CUSTOMERS AFTER DELETE" + b.getAllCustomers());

// 		System.out.println("");
// 		System.out.println("");






// 	}
// }
