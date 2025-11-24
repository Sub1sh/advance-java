import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LayoutManager extends JFrame implements ActionListener {
  private JTextField usernameField;
    private JPasswordField passwordField;
    public LayoutManager() {
        super("Layout Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10)); 
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        northPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));
        northPanel.add(new JLabel("Name:"));
        northPanel.add(new JLabel("Roll No:"));
        northPanel.add(new JLabel("Class:"));
        this.add(northPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Login Form"));
        this.usernameField = new JTextField(20);
        this.passwordField = new JPasswordField(20); 
        centerPanel.add(new JLabel("Username:"));
        centerPanel.add(this.usernameField);
        centerPanel.add(new JLabel("Password:"));
        centerPanel.add(this.passwordField);
        centerPanel.add(new JCheckBox("Remember Me"));
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        centerPanel.add(loginButton);
        this.add(centerPanel, BorderLayout.CENTER);
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton resetButton = new JButton("Reset");
        JButton exitButton = new JButton("Exit"); 
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);
        southPanel.add(resetButton);
        southPanel.add(exitButton);
        this.add(southPanel, BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Login":
                String username = usernameField.getText();
                JOptionPane.showMessageDialog(this, "Logged in as: " + username);
                break;
            case "Reset":
                usernameField.setText("");
                passwordField.setText("");
                break;
            case "Exit":
                System.exit(0);
                break;   } }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LayoutManager::new);
    }          }

