public class Customer extends User {
    // Add Currency
    Currency btc = Currency.getCurrencyByCode("BTC");
    Currency usd = Currency.getCurrencyByCode("USD");
    Currency khr = Currency.getCurrencyByCode("KHR");

    // Full Constructor
    public Customer(String userID, String fullName, String phoneNumber, String otp, double balance, String walletAddress) {
        this.userID = userID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.balance = balance;
        this.role = "customer";
        this.walletAddress = walletAddress;
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
            Transaction.addTrx(this.userID, "Withdraw", btcAmount, "BTC");
            System.out.println("Customer withdrawn: " + btcAmount + "successfully");
            System.out.println(btcAmount + " BTC = " + btcAmount * btc.getExchangeRate());
        }else{
            System.out.println("Insufficient fund.");
        }
    }

    public void deposit(double usdAmount){
        if(usdAmount > 0.0){
            balance += usdAmount / btc.getExchangeRate();
            Transaction.addTrx(this.userID, "Deposit", usdAmount / btc.getExchangeRate(), "BTC");
        }else{
            System.out.println("Please deposit fund.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance + " BTC");
    }

    public void checkBalance(String currencyCode) {
        try {
            Currency targetCurrency = Currency.getCurrencyByCode(currencyCode);
            if (targetCurrency == null) {
                throw new UnsupportedOperationException("Unsupported currency: " + currencyCode);
            }else{
                switch (currencyCode){
                    case "KHR":
                        System.out.println("Current Balance: " + balance * btc.getExchangeRate() * khr.getExchangeRate() + " " + currencyCode);
                        break;
                    case "USD":
                        System.out.println("Current Balance: " + balance * btc.getExchangeRate() + " " + currencyCode);
                        break;
                    default:
                        System.out.println("Current Balance: " + balance * btc.getExchangeRate() + " " + currencyCode);
                        break;
                }
            }
            
        } catch (UnsupportedOperationException e) {
            System.out.println("Unsupported currency: " + currencyCode);
        }
    }

    @Override
    public void displayAllTransactions() {
        System.out.println("Loading purchase detail of customer.");
    }
}
