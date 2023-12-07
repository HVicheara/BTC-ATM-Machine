import java.util.Objects;

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

    @Override
    public void displayPurchaseDetails() {
    }

    @Override
    public boolean checkInactivity(){
        return false;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "transactionID='" + getTransactionID() + '\'' +
                ", customerID='" + getCustomerID() + '\'' +
                ", type='" + getTransactionType() + '\'' +
                ", totalAmount=" + getTotalAmount() +
                ", depositType='" + depositType + '\'' +
                ", totalDepositAmount=" + totalDepositAmount +
                ", btcPrice=" + btcPrice +
                ", transactionDateTime=" + getTransactionDateTime() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Objects.equals(getTransactionID(), deposit.getTransactionID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionID());
    }
}
