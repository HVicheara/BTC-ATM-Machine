import java.util.List;

public class Admin extends User {
    // Full Constructor
    public Admin(String userID, String fullName, String phoneNumber, String otp) {
        this.userID = userID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.role = "admin";
    }
    
    public Admin(String phoneNumber, String otp) {
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.role = "admin";
    }
    
    public String getCustomerInfo (Customer customer){
        String tmp = "User is created \n"
        + "User ID is: " + customer.userID 
        + "\nThe Full name is: " + customer.fullName 
        + "\nThe Phone Number is: " + customer.phoneNumber
        + "\n User role: " + customer.role;
        return tmp;
    }

    @Override
    public void displayAllTransactions() {
        List<TransactionReader.Transaction> allTransactions = TransactionReader.readAllTransactions("transactions.txt");
        System.out.println("All transactions:");
        for (TransactionReader.Transaction transaction : allTransactions) {
            System.out.println(transaction);
        }
    }    
}
