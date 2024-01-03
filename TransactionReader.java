import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionReader {

    public static class Transaction {
        private String trxId;
        private String userId;
        private String type;
        private double amount;
        private String currency;
        private String timestamp;

        public Transaction(String trxId, String userId, String type, double amount, String currency, String timestamp) {
            this.trxId = trxId;
            this.userId = userId;
            this.type = type;
            this.amount = amount;
            this.currency = currency;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "trxId='" + trxId + '\'' +
                    ", userId='" + userId + '\'' +
                    ", type='" + type + '\'' +
                    ", amount=" + amount +
                    ", currency='" + currency + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    '}';
        }
    }

    public static List<Transaction> readAndFilterTransactions(String filePath, String userID) {
        List<Transaction> userTransactions = new ArrayList<>();
        boolean isFirstRow = true;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue; // Skip the first row
                }
                String[] parts = line.split("/");
                if (parts.length == 6 && parts[1].equals(userID)) {
                    Transaction transaction = new Transaction(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), parts[4], parts[5]);
                    userTransactions.add(transaction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userTransactions;
    }

    public static List<Transaction> readAllTransactions(String filePath) {
        List<Transaction> allTransactions = new ArrayList<>();
        boolean isFirstRow = true;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue; // Skip the first row
                }
                String[] parts = line.split("/");
                if (parts.length == 6) {
                    Transaction transaction = new Transaction(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), parts[4], parts[5]);
                    allTransactions.add(transaction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allTransactions;
    }
}
