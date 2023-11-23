// Deposit.java

public class Deposit {
    private String depositType;
    private double totalDepositAmount;

    // Full Constructor
    public Deposit(String depositType, double totalDepositAmount) {
        this.depositType = depositType;
        this.totalDepositAmount = totalDepositAmount;
    }

    // Accessor methods
    public String getDepositType() {
        return depositType;
    }

    public double getTotalDepositAmount() {
        return totalDepositAmount;
    }

    // Mutator methods
    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

}
