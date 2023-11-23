public class BTMMain {
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("123456", "John Doe", "555-1234", "123456");

        // Login the customer
        customer.login();

        // Display customer information
        System.out.println("Customer ID: " + customer.getCustomerID());
        System.out.println("Full Name: " + customer.getFullName());
        System.out.println("Phone Number: " + customer.getPhoneNumber());
        System.out.println("OTP: " + customer.getOtp());
        System.out.println("Is Logged In: " + customer.isLoggedIn());

        // Create a transaction
        Transaction transaction = new Transaction("T123", "123456", "Deposit", 1000.0, 0.005);

        // Display transaction information
        System.out.println("\nTransaction ID: " + transaction.getTransactionID());
        System.out.println("Customer ID: " + transaction.getCustomerID());
        System.out.println("Transaction Type: " + transaction.getTransactionType());
        System.out.println("Transaction Amount: " + transaction.getTotalAmount());

        // Create a withdrawal
        Deposit deposit = new Deposit("Cash", 1500.0);

        // Display withdrawal information
        System.out.println("\nDeposit Type: " + deposit.getDepositType());
        System.out.println("Total Deposit Amount: " + deposit.getTotalDepositAmount());

        // Create a deposit
        Withdraw withdrawal = new Withdraw(500.0, 2000.0);

        // Display deposit information
        System.out.println("\nTotal BTC Sold: " + withdrawal.getTotalBtcSold());
        System.out.println("Total Withdrawal Amount: " + withdrawal.getTotalWithdrawalAmount());

        // Logout the customer
        customer.logout();
        System.out.println("\nIs Logged In: " + customer.isLoggedIn());
    }
}
