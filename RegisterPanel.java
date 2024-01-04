import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JFrame{
    private JTextField fullNameField;
    private JTextField phoneNumberField;
    
    public RegisterPanel(){
        JFrame frame = new JFrame("Register");
        JLabel phoneNumberLabel = new JLabel("Phone number:");
        phoneNumberField = new JTextField(10);
        JLabel fullNameLabel = new JLabel("Fullname:");
        fullNameField = new JTextField(45);
        JButton registerButton = new JButton("Register");

        //panel component
        frame.setSize(400, 230);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(phoneNumberLabel);
        frame.add(phoneNumberField);
        frame.add(fullNameLabel);
        frame.add(fullNameField);
        frame.add(registerButton);

        //button
        fullNameLabel.setBounds(20, 20, 100, 20);
        fullNameField.setBounds(125, 10, 250, 45);
        phoneNumberLabel.setBounds(20, 75, 100, 20);
        phoneNumberField.setBounds(125, 65, 250, 45);
        registerButton.setBounds(20, 125, 360, 50);

        //action
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                register();
            }
        });

    }

    private void register(){
        String fullName = fullNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        if (isValidPhoneNumber(phoneNumber)){
            System.out.println("Full Name: " + fullName);
            System.out.println("Phone Number: "+ phoneNumber);

            dispose();
            SwingUtilities.invokeLater(() -> {
                new LoginPanel();
            });
        }else{
            JOptionPane.showMessageDialog(this, "Invalid phone number. Please enter a 8 to 10 digits number.");
        }
    }
    private boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber.matches("\\d{8,11}");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new RegisterPanel();
        });
    }
}
