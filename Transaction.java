public class Transaction {
    private String transactionID;
    private String customerID;
    private String type;
    private double totalAmount;


    // Full Constructor
    public Transaction(String transactionID, String customerID, String type, double totalAmount) {
        this.transactionID = transactionID;
        this.customerID = customerID;
        this.type = type;
        this.totalAmount = totalAmount;
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

    // Mutator methods
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
