public class Customer extends User {
    private double btcUnitPrice = 43593.50;
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

    public void withDraw(double btcAmount){
        if(this.balance > btcAmount){
            balance -= btcAmount;
            System.out.println("Customer withdrawn: " + btcAmount + "successfully");
            System.out.println(btcAmount + " BTC = " + btcAmount * btcUnitPrice);
        }else{
            System.out.println("Insufficient fund.");
        }
    }

    public void deposit(double usdAmount){
        if(usdAmount > 0.0){
            balance += usdAmount / btcUnitPrice;
        }else{
            System.out.println("Please deposit fund.");
        }
    }

    @Override
    public void displayAllTransactions() {
        System.out.println("Loading purchase detail of customer.");
    }
}
