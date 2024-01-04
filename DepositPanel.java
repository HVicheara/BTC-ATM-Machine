import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositPanel extends JFrame{
    private JTextField amountField;
    private Customer currentUser;

    public DepositPanel(Customer user){
        this.currentUser = user;
        JFrame frame = new JFrame("Deposit");
        JButton depositButton = new JButton("Deposit");
        JLabel amountLabel = new JLabel("Deposit Amount:");
        JLabel usdLabel = new JLabel("USD");
        JLabel equalLabel = new JLabel("=");
        JLabel btcLabel = new JLabel("BTC");
        amountField = new JTextField(6);
        JButton returnButton = new JButton("Previous");

        //panel component
        frame.setSize(350, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(btcLabel);
        frame.add(equalLabel);
        frame.add(usdLabel);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(depositButton);
        frame.add(returnButton);

        //button
        returnButton.setBounds(20, 105, 150, 50);
        amountLabel.setBounds(23, 17, 150, 20);
        amountField.setBounds(20, 40, 275, 40);
        usdLabel.setBounds(300, 48, 50, 20);
        btcLabel.setBounds(180, 83, 50, 20);
        equalLabel.setBounds(23, 80, 50, 20);
        depositButton.setBounds(177, 105, 150, 50);
        equalLabel.setForeground(Color.GRAY);
        btcLabel.setForeground(Color.GRAY);

        //action
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                deposit();
            }
        });   
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                dispose();
                SwingUtilities.invokeLater(() -> {
                    new MenuPanel(currentUser);
                });
            }
            
        });
    }
    

    private void deposit(){
        double amount = Double.valueOf(amountField.getText());
        if (amount > 0){
            currentUser.deposit(amount);
            JOptionPane.showMessageDialog(this, "Deposit Successful");
        }else{
            JOptionPane.showMessageDialog(this, "Please deposit valid amount.");
        }
    }
    
}
