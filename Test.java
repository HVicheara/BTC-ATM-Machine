public class Test {
    public static void main(String args[]){
        Customer john = new Customer("1234", "John DOe", "012345678", "1234");
        john.deposit(100);
        System.out.println("Balance: " + john.getTotalBalance());
        john.checkBalance();
        john.displayAllTransactions();

        Admin admin = new Admin("01234567", "1234");
        admin.displayAllTransactions();
    }
}
