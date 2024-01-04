import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawPanel extends JFrame{

    private JTextField amountField;

    private Customer currentUser;

    public WithdrawPanel(Customer user) {
        this.currentUser = user;
        JFrame frame = new JFrame("Withdraw");
        JButton withdrawButton = new JButton("Withdraw");
        JLabel amountLabel = new JLabel("Withdraw Amount:");
        JLabel btcLabel = new JLabel("BTC");
        JLabel equalLabel = new JLabel("=");
        JLabel usdLabel = new JLabel("USD");
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
        frame.add(withdrawButton);
        frame.add(returnButton);

        //button
        returnButton.setBounds(20, 105, 150, 50);
        amountLabel.setBounds(23, 17, 150, 20);
        amountField.setBounds(20, 40, 255, 40);
        btcLabel.setBounds(280, 48, 50, 20);
        usdLabel.setBounds(180, 83, 50, 20);
        equalLabel.setBounds(23, 80, 50, 20);
        withdrawButton.setBounds(177, 105, 150, 50);
        equalLabel.setForeground(Color.GRAY);
        usdLabel.setForeground(Color.GRAY);

        //action
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                withdraw();
            }
        }); 
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                setVisible(false);
                dispose();
                SwingUtilities.invokeLater(() -> {
                    new MenuPanel(currentUser);
                });
            }
            
        });
    }

    private void withdraw(){
        double amount = Double.valueOf(amountField.getText());

        if (amount > 0){
            currentUser.withdraw(amount);
            JOptionPane.showMessageDialog(this, "Withdrawal Successful");
        }else{
            JOptionPane.showMessageDialog(this, "Please input valid amount.");
        }
    }
}
