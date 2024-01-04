import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Customer extends User {
    protected String membership;
    protected int loyaltyPoints;


    // Add Currency
    Currency btc = Currency.getCurrencyByCode("BTC");
    Currency usd = Currency.getCurrencyByCode("USD");
    Currency khr = Currency.getCurrencyByCode("KHR");

    // Full Constructor
    public Customer(String userID, String fullName, String phoneNumber, String otp, double balance, String walletAddress, String membership) {
        this.userID = userID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.balance = balance;
        this.role = "customer";
        this.walletAddress = walletAddress;
        this.membership = membership;
        this.loyaltyPoints = 0;
    }

    public Customer(String userID, String fullName, String phoneNumber, String otp) {
        this.userID = userID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.balance = getBalanceFromAccountsFile();
        this.membership = "Silver";
        this.loyaltyPoints = 0;
    }
    
    public Customer(String phoneNumber, String otp) {
        this.phoneNumber = phoneNumber;
        this.otp = otp;
        this.loyaltyPoints = 0;
        this.membership = "Silver";
    }

    public void withdraw(double btcAmount){
        if(isLoggedIn){
            if(this.balance > btcAmount){
                balance -= btcAmount;
                Transaction.addTrx(this.userID, "Withdraw", btcAmount, "BTC");
                System.out.println("Withdrawn: " + btcAmount + " " + btc.getCode() + " successfully.");
                System.out.println(btcAmount + " " + btc.getCode() + " = " + usd.getSymbol() + btcAmount * btc.getExchangeRate());
                this.loyaltyPoints = new Random().nextInt(10);
                updateBalance();
            }else{
                System.out.println("Insufficient fund.");
            }   
        }else{
            System.out.println("You are not authorized to perform this operation. Please Login.");
        }
        
    }

    public void deposit(double usdAmount){
        if(isLoggedIn){
            if(usdAmount > 0.0){
                balance += usdAmount / btc.getExchangeRate();
                Transaction.addTrx(this.userID, "Deposit", usdAmount / btc.getExchangeRate(), "BTC");
                System.out.println("Deposit: " + usd.getSymbol() + usdAmount + " successfully.");
                System.out.println(usd.getSymbol() + usdAmount + " = " + (usdAmount / btc.getExchangeRate()) + " " + btc.getCode());
                this.loyaltyPoints = new Random().nextInt(10);
                updateBalance();
            }else{
                System.out.println("Please deposit fund.");
            }   
        }else{
            System.out.println("You are not authorized to perform this operation. Please Login.");
        }
    }

    // Overloading
    public void checkBalance() {
        System.out.println("Current Balance: " + balance + " BTC");
    }

    // Overloading
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
    public String toString(){
        String customerTmp = super.toString();
        customerTmp += "\n Balance: " + this.balance + " BTC";
        return customerTmp;
    }

    @Override
    public void displayAllTransactions() {
        List<TransactionReader.Transaction> userTransactions = TransactionReader.readAndFilterTransactions("transactions.txt", userID);
        System.out.println("Transactions for user " + userID + ":");
        for (TransactionReader.Transaction transaction : userTransactions) {
            System.out.println(transaction);
        }
    }

    private void updateBalance() {
        List<String> fileLines = new ArrayList<>();
        boolean isFirstRow = true;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    fileLines.add(line); // Add the first row to the list without modification
                    continue; // Skip the first row
                }
                String[] parts = line.split("/");
                if (parts.length == 6 && parts[0].equals(userID)) {
                    // Update the balance field with the new balance
                    parts[4] = String.valueOf(balance);
                    // Update the loyaltyPoint field with the new loyaltyPoints
                    parts[7] = String.valueOf(loyaltyPoints);
                    // Reconstruct the line with updated balance
                    line = String.join("/", parts);
                }
                fileLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the updated content back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt"))) {
            for (String updatedLine : fileLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double getBalanceFromAccountsFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            boolean isFirstRow = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue; // Skip the first row
                }

                String[] parts = line.split("/");
                if (parts.length == 6 && parts[0].equals(userID)) {
                    return Double.parseDouble(parts[4]); // Return the balance from the file
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Return 0.0 if the user is not found or if there's an error
        return 0.0;
    }

    public String getMembership() {
        return membership;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setMembership(String newMembership) {
        this.membership = newMembership;
    }
}



