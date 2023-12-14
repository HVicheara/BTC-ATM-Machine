import java.time.LocalDateTime;

abstract class Transaction {
    private String transactionID;
    private String customerID;
    private String type;
    private double totalAmount;
    private LocalDateTime transactionDateTime;


    // Full Constructor
    public Transaction(String transactionID, String customerID, String type, double totalAmount) {
        this.transactionID = transactionID;
        this.customerID = customerID;
        this.type = type;
        this.totalAmount = totalAmount;
        this.transactionDateTime = LocalDateTime.now();
    }

    // Accessor methods
    public String getTransactionID() {
        return transactionID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getTransactionType() {
        return type;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    
    public LocalDateTime getTransactionDateTime(){
        return transactionDateTime;
    }
    // Mutator methods
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Abstract method for checking inactivity
    public abstract boolean checkInactivity();

    // Abstract method for displaying purchase details
    public abstract void displayPurchaseDetails();
}

