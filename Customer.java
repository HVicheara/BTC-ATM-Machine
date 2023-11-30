public class Customer extends User {

    // Full Constructor
    public Customer(String customerID, String fullName, String phoneNumber, String otp) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.isLoggedIn = false;
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
