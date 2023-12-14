abstract class User {
    protected String userID;
    protected String fullName;
    protected String phoneNumber;
    protected String otp;
    protected boolean isLoggedIn;
    protected double balance;

    // Accessor methods
    public String getuserID() {
        return this.userID;
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

    @Override
    public String toString() {
        String tmp = "User is created \n"
        + "User ID is: "+this.userID 
        + "\nThe Full name is: "+this.fullName 
        + "\nThe Phone Number is: "+this.phoneNumber;

        return tmp;
    }

    @Override
    public boolean equals(Object obj) {
        User tmpUser = (User) obj;
       
        if( this.fullName.equals(tmpUser.fullName) && this.phoneNumber.equals(tmpUser.phoneNumber) )
        {
            return true;
        }
        return false;
    }
}
