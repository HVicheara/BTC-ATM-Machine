import java.util.Scanner;

public class Login{
    private String phone_number;
    private String otp;

    public Login(String phone_number){
        this.phone_number = phone_number;
        performLogin();
    }

    private void performLogin() {
        sendOtp();
        getOtp();
        verifyOtp();
    }

    private void sendOtp (){
        System.out.println("OTP has been sent!");
    }

    private void getOtp(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter OTP: ");
        this.otp = in.nextLine();
        in.close();
    }

    private void verifyOtp(){
        System.out.println("Verifying OTP");
    }

}