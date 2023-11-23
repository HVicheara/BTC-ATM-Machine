public class Customer {
    private String customerID;
    private String fullName;
    private String phoneNumber;
    private String otp;
    private boolean isLoggedIn;

    // Full Constructor
    public Customer(String customerID, String fullName, String phoneNumber, String otp) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.isLoggedIn = false;
    }

    // Accessor methods
    public String getCustomerID() {
        return customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOtp() {
        return otp;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    // Mutator methods
    public void login() {
        isLoggedIn = true;
    }

    public void logout() {
        isLoggedIn = false;
    }

}
