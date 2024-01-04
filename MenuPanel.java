import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JFrame{
    private Customer currentUser;
   
    public MenuPanel(Customer user){
        this.currentUser = user;
        JFrame frame = new JFrame("Menu");
        JLabel textLabel = new JLabel("Please Choose Service:");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton profileButton = new JButton("View Profile");
        JButton returnButton = new JButton("Exit");



        //panel component
        frame.setSize(400, 230);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(returnButton);
        frame.add(profileButton);
        
        frame.add(textLabel);
        frame.add(depositButton);
        frame.add(withdrawButton);

        //position 
        textLabel.setBounds(125, 17, 150, 20);
        profileButton.setBounds(225, 70, 150, 50);
        returnButton.setBounds(225, 120, 150, 50);
        depositButton.setBounds(20, 70, 150, 50);
        withdrawButton.setBounds(20, 120, 150, 50);

        //action
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                dispose();
                SwingUtilities.invokeLater(()->{
                    new DepositPanel(currentUser).setVisible(true);

                });
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                dispose();
                SwingUtilities.invokeLater(()->{
                    new WithdrawPanel(currentUser).setVisible(true);

                });

            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                dispose();
                SwingUtilities.invokeLater(() -> {
                    new LoginPanel();
                });
            }
            
        });
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                dispose();
                SwingUtilities.invokeLater(() -> {
                    new ProfilePanel(currentUser);
                });
            }
            
        });

    }
    
}
