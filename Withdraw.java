public class Withdraw {
    private double totalBtcSold;
    private double totalWithdrawalAmount;

    // Full Constructor
    public Withdraw (double totalBtcSold, double totalWithdrawalAmount) {
        this.totalBtcSold = totalBtcSold;
        this.totalWithdrawalAmount = totalWithdrawalAmount;
    }

    // Accessor methods
    public double getTotalBtcSold() {
        return totalBtcSold;
    }

    public double getTotalWithdrawalAmount() {
        return totalWithdrawalAmount;
    }

    // Mutator methods
    public void setTotalBtcSold(double totalBtcSold) {
        this.totalBtcSold = totalBtcSold;
    }
}
