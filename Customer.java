public class Customer extends User {
    // Full Constructor
    public Customer(String userID, String fullName, String phoneNumber, String otp, double balance) {
        this.userID = userID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.balance = balance;
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

    // Override the abstract methods
    @Override
    public boolean checkInactivity() {
        return false;
    }

    @Override
    public void displayPurchaseDetails() {
        System.out.println("Purchase details: No purchase details available for customers.");
    }

    public void inputDetails(String fullName, String phoneNumber, String otp) {
        if (!isLoggedIn) {
            this.fullName = fullName;
            this.phoneNumber = phoneNumber;
            this.otp = otp;
        } else {
            System.out.println("Cannot modify details while logged in. Logout first.");
        }
    }
}
