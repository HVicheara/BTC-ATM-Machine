public class Test {
    public static void main(String args[]){
        Customer john = new Customer("1234", "John DOe", "012345678", "1234");
        john.deposit(100);
        System.out.println("Balance: " + john.getTotalBalance());
        john.checkBalance();
        john.checkBalance("USD");
    }
}
