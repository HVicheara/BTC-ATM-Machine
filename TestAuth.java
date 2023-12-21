import java.util.Scanner;

public class TestAuth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmpFullName;
        String tmpPhoneNumber;
        String tmpOtp;
        int choice;

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("Other. Quit");
        System.out.print("Input: ");
        choice = sc.nextInt();
        System.out.println("");
        String tmp = sc.nextLine();
        

        switch (choice) {
            case 1:
                System.out.print("Input Full Name: ");
                tmpFullName = sc.nextLine();
                System.out.println("");
                do
                {
                    System.out.print("Input Phone Number: ");
                    tmpPhoneNumber = sc.nextLine();
                    System.out.println("");
                }while(Login.verifyPhoneNumber(tmpPhoneNumber));
                
                Register.registerUser(tmpFullName, tmpPhoneNumber);
                
                break;

            case 2:

                System.out.print("Input Phone Number: ");
                tmpPhoneNumber = sc.nextLine();
                System.out.println("");

                System.out.print("Input OTP: ");
                tmpOtp = sc.nextLine();
                System.out.println("");

                Customer tmpUser = new Customer(tmpPhoneNumber, tmpOtp);
                Login.loginUser(tmpUser);
            default:
                break;
        }

        sc.close();
    }
}
