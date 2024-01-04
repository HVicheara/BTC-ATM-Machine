import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame {
    private JTextField phoneNumberField;
    private JTextField otpField;

    private static final int LABEL_WIDTH = 100;
    private static final int FIELD_WIDTH = 255;
    private static final int LABEL_HEIGHT = 40;
    private static final int FIELD_HEIGHT = 40;
    private static final int BUTTON_WIDTH = 125;
    private static final int BUTTON_HEIGHT = 50;
    private static final int GET_OTP_BUTTON_WIDTH = 76;
    

    public LoginPanel(){
        //component
        JFrame frame = new JFrame("Authentication");
        JButton logInButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton getOtpButton = new JButton("Get OTP");
        JLabel phoneNumberLabel = new JLabel("Phone number:");
        JLabel otpLabel = new JLabel("OTP:");
        phoneNumberField = new JTextField(11);
        otpField = new JTextField(11);
        

        //panel frame
        frame.setSize(300, 220);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(phoneNumberLabel);
        frame.add(phoneNumberField);
        frame.add(otpLabel);
        frame.add(otpField);
        frame.add(logInButton);
        frame.add(registerButton);
        frame.add(getOtpButton);

        //button position
        phoneNumberLabel.setBounds(23, 10, LABEL_WIDTH, LABEL_HEIGHT);
        phoneNumberField.setBounds(20, 35, 180, FIELD_HEIGHT);
        getOtpButton.setBounds(200, 35, GET_OTP_BUTTON_WIDTH, FIELD_HEIGHT);  
        otpLabel.setBounds(23, 63, LABEL_WIDTH, LABEL_HEIGHT);
        otpField.setBounds(20, 90, FIELD_WIDTH, FIELD_HEIGHT);
        logInButton.setBounds(20, 130, BUTTON_WIDTH, BUTTON_HEIGHT);
        registerButton.setBounds(150, 130, BUTTON_WIDTH, BUTTON_HEIGHT);

        //action for login button
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                openMenuPanel();
            }
        });

        //action for register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                dispose();
                SwingUtilities.invokeLater(()->{
                    new RegisterPanel().setVisible(true);

                });
            }
        });

        // action for "Get OTP" button
        getOtpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String phoneNumber = phoneNumberField.getText();
                if(phoneNumber.length() >= 8){
                    Login.sendOtp(phoneNumber);
                }
            }
        });
    }

    private void openMenuPanel(){
        String phoneNumber = phoneNumberField.getText();
        String otp = otpField.getText();
        if (isValidPhoneNumber(phoneNumber)){
            Customer tmpUser = new Customer(phoneNumber, otp);
            Login.loginUser(tmpUser);

            if(tmpUser.isLoggedIn()){
                dispose();
                SwingUtilities.invokeLater(()->{
                    new MenuPanel(tmpUser).setVisible(true);
                });
            }
        }else{
            JOptionPane.showMessageDialog(this, "Invalid phone number. Please enter a 8 to 10 digits number.");
        }
        
    }


    private boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber.matches("\\d{8,11}");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new LoginPanel();
        });
    }
}



    
