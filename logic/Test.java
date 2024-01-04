public class Test {
    public static void main(String args[]){
        Customer john = new Customer("0157", "John Doe", "01234567", "6718");
        System.out.println(john.isLoggedIn());
        Login.loginUser(john);
        System.out.println(john.isLoggedIn());
        john.checkBalance();
        //john.withdraw(20);
        john.deposit(10000);
        //System.out.println("Balance: " + john.getTotalBalance());
        john.checkBalance();
        //john.displayAllTransactions();

        //Admin admin = new Admin("01234567", "1234");
        //admin.displayAllTransactions();
    }
}
