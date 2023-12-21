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

    @Override
    public void displayAllTransactions() {
        System.out.println("No transactions for Admin");
    }

    @Override
    public double getTotalBalance() {
        System.out.println("No Balance for Admin");
        return 0.0;
    }

    
}
