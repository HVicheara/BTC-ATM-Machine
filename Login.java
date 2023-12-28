import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    static ArrayList<Customer> userList = new ArrayList<Customer>(); 
    
    public static void getUserList() {
        String filePath = "./accounts.txt";
        try {
            // Create a FileReader
            FileReader fileReader = new FileReader(filePath);
            // Wrap the FileReader in a BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Read each line from the file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Process the line as needed
                // System.out.println(line);
                String[] parts = line.split("/");
                Customer newCustomer = new Customer(parts[0], parts[1], parts[2], parts[3]);
                userList.add(newCustomer);
            }

            // Close the BufferedReader
            bufferedReader.close();

        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be read
            e.printStackTrace();
        }
    }


    private static void sendOtp() {
        System.out.println("OTP has been sent!");
    }

    public static boolean verifyOtp(String phoneNumber, String enteredOtp) {
        getUserList();

        for (Customer customer : userList) {
            if (customer.getPhoneNumber().equals(phoneNumber) && customer.getOtp().equals(enteredOtp)) {
                return true;
            }
        }

        return false;
    }

    public static boolean verifyPhoneNumber(String phoneNumber) {
        getUserList();

        for (Customer customer : userList) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }

        return false;
    }

    public static void loginUser(Customer loginUser) {
        sendOtp();
        getUserList();

        boolean isAuthenticated = verifyOtp(loginUser.getPhoneNumber(), loginUser.getOtp());
        
        loginUser.setIsLoggedIn(isAuthenticated);

        if (isAuthenticated) {
            
            System.out.println("User is logged in successfully.");
        } else {
            System.out.println("Please enter a valid OTP.");
        }
    }
}
