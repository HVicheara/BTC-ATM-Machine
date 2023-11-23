// Deposit.java

public class Deposit extends Transaction{
    private String depositType;
    private double totalDepositAmount;
    private double btcPrice;

    // Full Constructor
    public Deposit(String transactionID, String customerID, double btcPrice, double totalAmount,  String depositType) {
        super(transactionID, customerID, "Deposit", totalAmount);
        this.depositType = depositType;
        this.totalDepositAmount = totalAmount;
        this.btcPrice = btcPrice;
    }

    // Accessor methods
    public String getDepositType() {
        return this.depositType;
    }

    public double getTotalDepositAmount() {
        return this.totalDepositAmount;
    }

    public double getTotalBtcBought() {
        return this.totalDepositAmount / this.btcPrice;
    }

    // Mutator methods
    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

}
