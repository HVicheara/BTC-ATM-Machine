public class BTMMain {
    public static void main(String[] args) {
        //Bitcoin Price
        double btcPrice = 37342.20;

        // Create a customer
        Customer customer = new Customer("cus_123456", "John Doe", "(855) 12 345 678", "1850");

        // Login the customer
        customer.login();

        // Display customer information
        System.out.println("Customer ID: " + customer.getCustomerID());
        System.out.println("Full Name: " + customer.getFullName());
        System.out.println("Phone Number: " + customer.getPhoneNumber());
        System.out.println("OTP: " + customer.getOtp());
        System.out.println("Is Logged In: " + customer.isLoggedIn());

        // Create a deposit
        Deposit deposit = new Deposit("trx_00001", customer.getCustomerID(), btcPrice, 5000.0, "KHQR");

        // Display deposit information
        System.out.println("\nTransaction ID: " + deposit.getTransactionID());
        System.out.println("Customer ID: " + deposit.getCustomerID());
        System.out.println("Transaction Type: " + deposit.getTransactionType());
        System.out.println("Transaction Amount: $" + deposit.getTotalAmount());
        System.out.println("Deposit Type: " + deposit.getDepositType());
        System.out.println("Total Deposit Amount: $" + deposit.getTotalDepositAmount());
        System.out.println("Total BTC Bought: " + deposit.getTotalBtcBought() + " BTC");

        // Create a withdraw
        Withdraw withdrawal = new Withdraw("trx_00002", customer.getCustomerID(), btcPrice, 0.002 );

        // Display withdraw information
        System.out.println("\nTransaction ID: " + withdrawal.getTransactionID());
        System.out.println("Customer ID: " + withdrawal.getCustomerID());
        System.out.println("Transaction Type: " + withdrawal.getTransactionType());
        System.out.println("Transaction Amount: $" + withdrawal.getTotalAmount());
        System.out.println("Total BTC Sold: " + withdrawal.getTotalBtcSold() + " BTC");
        System.out.println("Total Withdrawal Amount: $" + withdrawal.getTotalWithdrawalAmount());

        // Logout the customer
        customer.logout();
        System.out.println("\nIs Logged In: " + customer.isLoggedIn());
    }
}
