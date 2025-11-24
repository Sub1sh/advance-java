
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFormGrid extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JLabel message;

    public LoginFormGrid() {
        // Title
        setTitle("Login Form");

        // Set GridLayout (3 rows, 2 columns)
        setLayout(new GridLayout(3, 2, 10, 10));

        // Username
        add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        add(usernameField);

        // Password
        add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        add(passwordField);

        // Empty label for spacing
        add(new JLabel(""));

        // Login Button
        JButton loginButton = new JButton("Login");
        add(loginButton);

        // Message Label
        message = new JLabel("", SwingConstants.CENTER);
        add(message);

        // Button Action
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = new String(passwordField.getPassword());

                if (user.equals("admin") && pass.equals("1234")) {
                    message.setText("Login Successful!");
                } else {
                    message.setText("Invalid Username or Password");
                }
            }
        });

        // Frame settings
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Main Method
    public static void main(String[] args) {
        new LoginFormGrid();
    }
}
