public class BitcoinATM {
    public void checkMembership(User user) {
        System.out.println("Checking membership...");
        if (user instanceof Customer) {
            Customer customer = (Customer) user;
            String welcomeMsg = "Welcome back " + customer.getFullName() + "\n"
        + "Current Balance: " + customer.getTotalBalance() + " BTC"
        + "\nCurrent Membership: " + customer.getMembership() 
        + "\nLoyalty Points: " + customer.getLoyaltyPoints();

            System.out.println(welcomeMsg);
        } else if (user instanceof Admin) {
            Admin admin = (Admin) user;
            String welcomeMsg = "Welcome back " + admin.getFullName();
            System.out.println(welcomeMsg);
        }
    }

    public static void main(String arg[]){
        BitcoinATM bitcoinATM = new BitcoinATM();
        Auth.start();
        /*Customer john = new Customer("0157", "John Doe", "01234567", "6718");
        System.out.println(john.isLoggedIn());
        Login.loginUser(john);
        System.out.println(john.isLoggedIn());
        bitcoinATM.checkMembership(null);*/
    }
}
