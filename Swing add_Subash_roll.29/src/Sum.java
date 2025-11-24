import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sum extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton;

    public Sum() {
        // Set up the frame
        setTitle("Add Two Numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Create components
        JLabel num1Label = new JLabel("First Number:");
        JLabel num2Label = new JLabel("Second Number:");
        JLabel resultLabel = new JLabel("Result:");

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false); // Make result field read-only

        addButton = new JButton("Add Numbers");
        addButton.addActionListener(this);

        // Add components to frame
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(new JLabel()); // Empty space
        add(addButton);

        // Center the window
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                // Get input values
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());

                // Calculate sum
                double sum = num1 + num2;

                // Display result
                resultField.setText(String.valueOf(sum));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid numbers!",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        // Create and show the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Sum().setVisible(true);
            }
        });
    }
}