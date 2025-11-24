
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFormGridBag extends JFrame {
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;
    
    public LoginFormGridBag() {
        // Set up the frame
        setTitle("Login Form - GridBagLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        
        // Create main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Title Label
        JLabel titleLabel = new JLabel("LOGIN FORM", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 100, 200));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);
        
        // Username Label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(userLabel, gbc);
        
        // Username Field
        usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(usernameField, gbc);
        
        // Password Label
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(passLabel, gbc);
        
        // Password Field
        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(passwordField, gbc);
        
        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 5, 5, 5); // Extra top margin
        mainPanel.add(loginButton, gbc);
        
        // Message Label
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        messageLabel.setOpaque(true);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 5, 5, 5);
        mainPanel.add(messageLabel, gbc);
        
        // Add action listener to login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        
        // Add Enter key support in password field
        passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        
        // Add main panel to frame
        add(mainPanel);
    }
    
    private void performLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        
        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Please enter both username and password!", Color.RED, new Color(255, 200, 200));
            return;
        }
        
        // Simple authentication (you can replace this with your logic)
        if (username.equals("admin") && password.equals("1234")) {
            showMessage("Login successful! Welcome, " + username + "!", Color.GREEN, new Color(200, 255, 200));
        } else {
            showMessage("Invalid username or password!", Color.RED, new Color(255, 200, 200));
        }
    }
    
    private void showMessage(String text, Color foreground, Color background) {
        messageLabel.setText(text);
        messageLabel.setForeground(foreground);
        messageLabel.setBackground(background);
    }
    
    public static void main(String[] args) {
        // Use SwingUtilities for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginFormGridBag loginForm = new LoginFormGridBag();
                loginForm.setVisible(true);
            }
        });
    }
}