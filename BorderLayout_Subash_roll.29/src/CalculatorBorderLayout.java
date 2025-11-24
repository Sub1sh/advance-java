
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CalculatorBorderLayout extends JFrame implements ActionListener {
    
    // Calculator components
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    
    public CalculatorBorderLayout() {
        // Set up the main frame
        setTitle("Calculator - BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create regions
        JPanel northPanel = createNorthPanel();
        JPanel eastPanel = createEastPanel();
        JPanel centerPanel = createCenterPanel();
        JPanel westPanel = createWestPanel();
        JPanel southPanel = createSouthPanel();
        
        // Add panels to main panel
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        
        // Add main panel to frame
        add(mainPanel);
    }
    
    private JPanel createNorthPanel() {
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(220, 240, 255));
        northPanel.setBorder(BorderFactory.createTitledBorder("Information Panel"));
        northPanel.setPreferredSize(new Dimension(0, 80));
        
        JLabel titleLabel = new JLabel("CALCULATOR APPLICATION", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 100, 200));
        
        JLabel descLabel = new JLabel("Perform arithmetic operations with ease", SwingConstants.CENTER);
        descLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        descLabel.setForeground(Color.DARK_GRAY);
        
        northPanel.setLayout(new BorderLayout());
        northPanel.add(titleLabel, BorderLayout.CENTER);
        northPanel.add(descLabel, BorderLayout.SOUTH);
        
        return northPanel;
    }
    
    private JPanel createEastPanel() {
        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(new Color(255, 240, 220));
        eastPanel.setBorder(BorderFactory.createTitledBorder("Operations Panel"));
        eastPanel.setPreferredSize(new Dimension(150, 0));
        eastPanel.setLayout(new GridLayout(4, 1, 5, 5));
        
        // Create buttons with icons (using emoji as simple icons)
        addButton = createIconButton("➕ Add", "Add two numbers");
        subtractButton = createIconButton("➖ Subtract", "Subtract second from first");
        multiplyButton = createIconButton("✖ Multiply", "Multiply two numbers");
        divideButton = createIconButton("➗ Divide", "Divide first by second");
        
        // Add action listeners
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        
        // Add buttons to panel
        eastPanel.add(addButton);
        eastPanel.add(subtractButton);
        eastPanel.add(multiplyButton);
        eastPanel.add(divideButton);
        
        return eastPanel;
    }
    
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(240, 255, 240));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Calculator Form"));
        centerPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // First Number
        JLabel firstLabel = new JLabel("First Number:");
        firstLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(firstLabel, gbc);
        
        firstNumberField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(firstNumberField, gbc);
        
        // Second Number
        JLabel secondLabel = new JLabel("Second Number:");
        secondLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(secondLabel, gbc);
        
        secondNumberField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(secondNumberField, gbc);
        
        // Result
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(resultLabel, gbc);
        
        resultField = new JTextField(15);
        resultField.setEditable(false);
        resultField.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 1; gbc.gridy = 2; gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(resultField, gbc);
        
        // Instructions
        JTextArea instructions = new JTextArea(
            "Instructions:\n" +
            "1. Enter numbers in the fields\n" +
            "2. Click an operation button\n" +
            "3. View result in the result field\n" +
            "4. All operations are performed in real-time"
        );
        instructions.setFont(new Font("Arial", Font.PLAIN, 12));
        instructions.setBackground(new Color(240, 255, 240));
        instructions.setEditable(false);
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
        centerPanel.add(instructions, gbc);
        
        return centerPanel;
    }
    
    private JPanel createWestPanel() {
        JPanel westPanel = new JPanel();
        westPanel.setBackground(new Color(255, 240, 255));
        westPanel.setBorder(BorderFactory.createTitledBorder("History"));
        westPanel.setPreferredSize(new Dimension(120, 0));
        
        JLabel historyLabel = new JLabel("<html><center>Recent<br>Operations<br>Will<br>Appear<br>Here</center></html>");
        historyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        westPanel.add(historyLabel);
        
        return westPanel;
    }
    
    private JPanel createSouthPanel() {
        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(220, 220, 255));
        southPanel.setBorder(BorderFactory.createTitledBorder("Status Bar"));
        southPanel.setPreferredSize(new Dimension(0, 60));
        
        JLabel statusLabel = new JLabel("Ready to calculate...");
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        
        JButton clearButton = new JButton("Clear All");
        clearButton.addActionListener(e -> clearFields());
        
        southPanel.setLayout(new FlowLayout());
        southPanel.add(statusLabel);
        southPanel.add(clearButton);
        
        return southPanel;
    }
    
    private JButton createIconButton(String text, String tooltip) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(200, 220, 240));
        button.setToolTipText(tooltip);
        button.setFocusPainted(false);
        return button;
    }
    
    private void clearFields() {
        firstNumberField.setText("");
        secondNumberField.setText("");
        resultField.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;
            String operation = "";
            
            if (e.getSource() == addButton) {
                result = num1 + num2;
                operation = "Addition";
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
                operation = "Subtraction";
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
                operation = "Multiplication";
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = num1 / num2;
                operation = "Division";
            }
            
            // Format result
            if (result == (long) result) {
                resultField.setText(String.format("%d", (long) result));
            } else {
                resultField.setText(String.format("%.4f", result));
            }
            
            // Show success message
            JOptionPane.showMessageDialog(this, 
                operation + " performed successfully!\n" +
                num1 + " " + getOperationSymbol(operation) + " " + num2 + " = " + resultField.getText(),
                "Calculation Complete",
                JOptionPane.INFORMATION_MESSAGE);
                
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numbers in both fields!", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String getOperationSymbol(String operation) {
        switch (operation) {
            case "Addition": return "+";
            case "Subtraction": return "-";
            case "Multiplication": return "×";
            case "Division": return "÷";
            default: return "";
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorBorderLayout().setVisible(true);
        });
    }
}