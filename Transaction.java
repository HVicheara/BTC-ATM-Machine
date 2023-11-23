public class Transaction {
    private String transactionID;
    private String customerID;
    private String type;
    private double totalAmount;
    private double trxPrice;

    // Full Constructor
    public Transaction(String transactionID, String customerID, String type, double totalAmount, double trxPrice) {
        this.transactionID = transactionID;
        this.customerID = customerID;
        this.type = type;
        this.totalAmount = totalAmount;
        this.trxPrice = trxPrice;
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

    
    public double gettrxPrice() {
        return trxPrice;
    }

    // Mutator methods
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
