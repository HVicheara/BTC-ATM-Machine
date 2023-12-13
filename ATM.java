// public class ATM {
//     private User currentUser;
//     private Transaction currentTransaction;


//     public void loginCustomer(String phoneNumber, String otp) {
//         if (currentUser instanceof Customer) {
//             Customer customer = (Customer) currentUser;
//             customer.isLoggedIn();
//             System.out.println("Authentication successful. Welcome, " + customer.getFullName() + "!");
//         } else {
//             System.out.println("Invalid user type.");
//         }
//     }

//     public void inputCustomerDetails(String fullName, String phoneNumber, String otp) {
//         if (currentUser instanceof Customer) {
//             Customer customer = (Customer) currentUser;
//             customer.inputDetails(fullName, phoneNumber, otp);
//             System.out.println("Customer details updated.");
//         } else {
//             System.out.println("Invalid user type.");
//         }
//     }

//     // Override the abstract methods
//     public boolean checkInactivity() {
//         if (currentUser != null) {
//             return currentUser.checkInactivity();
//         } else {
//             System.out.println("No user selected.");
//             return false;
//         }
//     }

//     public void displayPurchaseDetails() {
//         if (currentTransaction != null) {
//             currentTransaction.displayPurchaseDetails();
//         } else {
//             System.out.println("No transaction selected.");
//         }
//     }
// }
