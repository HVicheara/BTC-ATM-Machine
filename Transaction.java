import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Transaction {
    private static String generateRandomId() {
        int randomUserId = new Random().nextInt(9999) + 1;

        return String.format("%04d", randomUserId);
    }
    
    public static void addTrx(String userID, String type, double totalAmount, String currency){
        Scanner sc = new Scanner(System.in);
        String filePath = "transactions.txt";
        String trxID = generateRandomId();
        LocalDateTime transactionDateTime = LocalDateTime.now();

        String WritingContent = trxID + "/" + userID + "/" + type + "/" + totalAmount + "/" + currency + "/" + transactionDateTime;

        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(WritingContent);
            bufferedWriter.newLine(); // Add a new line for clarity

            // Close the BufferedWriter to ensure all data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been appended to the file successfully.");
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
        }


        sc.close();
    }
}

