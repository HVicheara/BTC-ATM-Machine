abstract class User {
    protected String customerID;
    protected String fullName;
    protected String phoneNumber;
    protected String otp;
    protected boolean isLoggedIn;
    protected double balance;

    // Accessor methods
    public String getCustomerID() {
        return this.customerID;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getOtp() {
        return this.otp;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public double getTotalBalance() {
        return this.balance;
    }

    // Abstract method for checking inactivity
    public abstract boolean checkInactivity();

    // Abstract method for displaying purchase details
    public abstract void displayPurchaseDetails();

     // Method for logging in
     public void login() {
        if (!isLoggedIn) {
            isLoggedIn = true;
            System.out.println("User logged in.");
        } else {
            System.out.println("User is already logged in.");
        }
    }

    // Method for logging out
    public void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            System.out.println("User logged out.");
        } else {
            System.out.println("User is not logged in.");
        }
    }
}
