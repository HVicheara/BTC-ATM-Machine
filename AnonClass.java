public class AnonClass {
    public static void main(String[] args) {
        Admin admin = new Admin("a_0001", "John Doe", "012345678", "1234") {
            @Override
            public String getCustomerInfo(Customer customer) {
                return "Customer ID: " + customer.userID;
            }
        };

        Customer customer = new Customer("cus_0004", "Jake Doe", "012567893", "1234");

        String customerData = admin.getCustomerInfo(customer);

        System.out.println(customerData);
    }
}
