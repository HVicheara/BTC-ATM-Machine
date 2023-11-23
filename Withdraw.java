public class Withdraw extends Transaction{
    private double totalBtcSold;
    private double totalWithdrawalAmount;

    // Full Constructor
    public Withdraw(String transactionID, String customerID, double btcPrice, double totalBtcSold) {
        super(transactionID, customerID, "Withdraw", btcPrice * totalBtcSold);
        this.totalBtcSold = totalBtcSold;
        this.totalWithdrawalAmount = btcPrice * totalBtcSold;
    }

    // Accessor methods
    public double getTotalBtcSold() {
        return this.totalBtcSold;
    }

    public double getTotalWithdrawalAmount() {
        return this.totalWithdrawalAmount;
    }

    // Mutator methods
    public void setTotalBtcSold(double totalBtcSold) {
        this.totalBtcSold = totalBtcSold;
    }
    
}
