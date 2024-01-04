abstract class User {
    protected String userID;
    protected String fullName;
    protected String phoneNumber;
    protected String otp;
    protected String role;
    protected String walletAddress;
    protected boolean isLoggedIn;
    protected double balance;
    protected String membership;

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

    public String getRole() {
        return this.role;
    }

    public String getWalletAddress() {
        return this.walletAddress;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public double getTotalBalance() {
        return this.balance;
    }

    public void setIsLoggedIn(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }

    public void setWalletAddress(String newAddress){
        this.walletAddress = newAddress;
    }

    // Abstract method for displaying all transactions
    public abstract void displayAllTransactions();

    public String toString() {
        String tmp = "User is created \n"
        + "User ID is: "+this.userID 
        + "\nThe Full name is: "+this.fullName 
        + "\nThe Phone Number is: "+this.phoneNumber
        + "\n User role: " + this.role;

        return tmp;
    }

    public boolean equals(Object obj) {
        User tmpUser = (User) obj;
       
        if(this.fullName.equals(tmpUser.fullName) && this.phoneNumber.equals(tmpUser.phoneNumber) )
        {
            return true;
        }
        return false;
    }

    //Overloading
    public void inputDetails(String fullName, String phoneNumber, String otp) {
        if (!isLoggedIn) {
            this.fullName = fullName;
            this.phoneNumber = phoneNumber;
            this.otp = otp;
        } else {
            System.out.println("Cannot modify details while logged in. Logout first.");
        }
    }

    //Overloading
    public void inputDetails(String fullName, String phoneNumber) {
        if (!isLoggedIn) {
            this.fullName = fullName;
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Cannot modify details while logged in. Logout first.");
        }
    }
}
