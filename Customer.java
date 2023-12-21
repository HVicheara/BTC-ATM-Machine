public class Customer extends User {
    // Full Constructor
    public Customer(String userID, String fullName, String phoneNumber, String otp, double balance) {
        this.userID = userID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.balance = balance;
        this.role = "customer";
    }

    public Customer(String userID, String fullName, String phoneNumber, String otp) {
        this.userID = userID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
    }
    
    public Customer(String phoneNumber, String otp) {
        this.phoneNumber = phoneNumber;
        this.otp = otp;
    }

    @Override
    public void displayAllTransactions() {
        System.out.println("Loading purchase detail of customer.");
    }
}
