import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {
    private static String generateRandomId() {
        int randomUserId = new Random().nextInt(9999) + 1;

        return String.format("%04d", randomUserId);
    }

    public static void registerUser(String fullName, String phoneNumber, String walletAddress){
        Scanner sc = new Scanner(System.in);
        String filePath = "accounts.txt";
        String userId = generateRandomId();
        String otp = generateRandomId();

        String WritingContent = userId + "/" + fullName + "/" + phoneNumber + "/" + otp + "/" + 0.0 + "/" + walletAddress;

        System.out.println("OTP: " + otp);

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
