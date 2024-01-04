import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProfilePanel {
    private JLabel amountLabel;
    private JLabel membershipLabel;
    private JLabel loyaltyLabel;
    private JTextField balanceField;
    private JTextField memberField;
    private JTextField loyaltyField;

    private Customer currentUser;
   
    public ProfilePanel(Customer user){
        this.currentUser = user;
        JFrame frame = new JFrame("User Profile");
        amountLabel = new JLabel("Current Amount: ");
        membershipLabel = new JLabel("Membership: ");
        loyaltyLabel = new JLabel("Loyalty Score: ");
        balanceField = new JTextField(12);
        memberField = new JTextField(12);
        loyaltyField = new JTextField(12);
        JButton returnButton = new JButton("Previous");

        //component
        frame.setSize(300, 225);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(amountLabel);
        frame.add(membershipLabel);
        frame.add(loyaltyLabel);
        frame.add(returnButton);
        frame.add(memberField);
        frame.add(loyaltyField);
        frame.add(balanceField);

        //button
        balanceField.setBounds(125, 10, 175, 45);
        amountLabel.setBounds(20, 20, 150, 20);
        memberField.setBounds(125, 50, 175, 45);
        membershipLabel.setBounds(20, 60, 100, 20);
        loyaltyField.setBounds(125, 90, 175, 40);
        loyaltyLabel.setBounds(23, 100, 150, 20);
        returnButton.setBounds(50, 135, 200, 50);

        SwingUtilities.invokeLater(() -> {
            balanceField.setText(currentUser.getTotalBalance() + " BTC");
            memberField.setText(currentUser.getMembership());
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                SwingUtilities.invokeLater(() -> {
                    new MenuPanel(currentUser);
                });
            }
            
        });
        

        loadBalanceFromFile();

    }

    
    private void loadBalanceFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/vichearaheng/Desktop/UI/balance.txt"))) {//file path
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                double balance = Double.parseDouble(line);
                updateBalanceField(balance);
            } else {
                updateBalanceFieldError();
            }
        } catch (IOException | NumberFormatException ex) {
            updateBalanceFieldError();
        }
    }

    private void updateBalanceField(double balance) {
        SwingUtilities.invokeLater(() -> {
            balanceField.setText(String.valueOf(balance));
        });
    }

    private void updateBalanceFieldError() {
        SwingUtilities.invokeLater(() -> {
            balanceField.setText("Error loading balance");
        });
    }
}
