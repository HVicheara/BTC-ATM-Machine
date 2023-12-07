import java.util.Objects;
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
    
    @Override
    public void displayPurchaseDetails() {
    }

    @Override
    public boolean checkInactivity(){
        return false;
    }
    @Override
    public String toString() {
        return "Withdraw{" +
                "transactionID='" + getTransactionID() + '\'' +
                ", customerID='" + getCustomerID() + '\'' +
                ", type='" + getTransactionType() + '\'' +
                ", totalAmount=" + getTotalAmount() +
                ", totalBtcSold=" + totalBtcSold +
                ", totalWithdrawalAmount=" + totalWithdrawalAmount +
                ", transactionDateTime=" + getTransactionDateTime() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Withdraw withdraw = (Withdraw) o;
        return Objects.equals(getTransactionID(), withdraw.getTransactionID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionID());
    }
}
