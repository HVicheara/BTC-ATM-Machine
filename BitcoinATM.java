import java.util.Scanner;

public class BitcoinATM {
    private User user;
    private Scanner sc = new Scanner(System.in);

    public void checkMembership(User user) {
        System.out.println("Checking membership...");
        if (user instanceof Customer) {
            Customer customer = (Customer) user;
            String welcomeMsg = "Welcome back " + customer.getFullName() + "\n"
                    + "Current Balance: " + customer.getTotalBalance() + " BTC" + "\nCurrent Membership: "
                    + customer.getMembership() + "\nLoyalty Points: " + customer.getLoyaltyPoints() + "\n";

            System.out.println(welcomeMsg);
        } else if (user instanceof Admin) {
            Admin admin = (Admin) user;
            String welcomeMsg = "Welcome back " + admin.getFullName() + "\n";
            System.out.println(welcomeMsg);
        }
    }

    public User getUser() {
        return user;
    }

    public User auth() {
        user = Auth.start();
        return user;
    }

    public void startBitcoinATM() {
        User user = auth();
        if(user != null){
            int choice;
            printMenu();
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkMembership(user);
                    break;
                case 4:
                    System.out.println("Exiting Bitcoin ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            } 
            
            sc.close();
        }
        
        // try{
        //     do {
        //         printMenu();
        //         choice = sc.nextInt();
        //         sc.nextLine();

        //         switch (choice) {
        //             case 1:
        //                 withdraw();
        //                 break;
        //             case 2:
        //                 deposit();
        //                 break;
        //             case 3:
        //                 checkMembership(user);
        //                 break;
        //             case 4:
        //                 System.out.println("Exiting Bitcoin ATM. Goodbye!");
        //                 break;
        //             default:
        //                 System.out.println("Invalid choice. Please enter a valid option.");
        //         }
        //     } while (choice != 4);
        // }finally {
        //     sc.close(); // Close the Scanner when done with input
        // }
    }

    private void printMenu() {
        System.out.println("Bitcoin ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Membership");
        System.out.println("4. Exit");
        System.out.println("");
        System.out.print("Enter your choice: ");
    }

    private void withdraw() {
        if (user instanceof Customer) {
            Customer customer = (Customer) user;

            System.out.print("Enter withdrawal amount (BTC): ");

            if (sc.hasNextDouble()) {
                double amount = sc.nextDouble();
                
                customer.withdraw(amount);
                sc.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a valid amount.");
                sc.nextLine(); // Consume the invalid input
            }
        } else {
            System.out.println("Only customers can withdraw funds.");
        }
    }

    private void deposit() {
        if (user instanceof Customer) {
            Customer customer = (Customer) user;

            System.out.print("Enter deposit amount (USD): ");
            if (sc.hasNextDouble()) {
                double amount = sc.nextDouble();
                
                customer.deposit(amount);
                sc.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a valid amount.");
                sc.nextLine(); // Consume the invalid input
            }
        } else {
            System.out.println("Only customers can deposit funds.");
        }
    }

    public static void main(String[] args) {
        BitcoinATM bitcoinATM = new BitcoinATM();
        System.out.println("Bitcoin ATM Machine");
        System.out.println("");
        bitcoinATM.startBitcoinATM();
    }
}