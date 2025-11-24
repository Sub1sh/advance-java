import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButtonForm extends JFrame implements ActionListener {

    private JButton redButton, blueButton, greenButton;
    private JLabel statusLabel;

    public ColorButtonForm() {
        // Set up the frame
        setTitle("Color Button Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create title label
        JLabel titleLabel = new JLabel("COLOR BUTTON", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(50, 50, 150));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 15, 15));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Click Buttons to Change Color"));

        // Create buttons
        redButton = createColorButton("RED", Color.RED);
        blueButton = createColorButton("BLUE", Color.BLUE);
        greenButton = createColorButton("GREEN", Color.GREEN);

        // Add buttons to panel
        buttonPanel.add(redButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(greenButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Create status label
        statusLabel = new JLabel("Click any button to see its color change!", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        mainPanel.add(statusLabel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    private JButton createColorButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.GRAY); // Initial color
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 50));

        // Add hover effects
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.brighter());
                statusLabel.setText("Hovering over " + text + " button");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!button.getBackground().equals(color)) {
                    button.setBackground(Color.GRAY);
                }
                statusLabel.setText("Click any button to see its color change!");
            }
        });

        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String buttonText = clickedButton.getText();
        Color buttonColor = Color.GRAY;

        // Determine which color to set based on button text
        switch (buttonText) {
            case "RED":
                buttonColor = Color.RED;
                break;
            case "BLUE":
                buttonColor = Color.BLUE;
                break;
            case "GREEN":
                buttonColor = Color.GREEN;
                break;
        }

        // Change the button's background color
        clickedButton.setBackground(buttonColor);

        // Reset other buttons to default color
        resetOtherButtons(clickedButton);

        // Update status message
        statusLabel.setText(buttonText + " button clicked! Color changed to " + buttonText);

        // Change status label color to match button color temporarily
        statusLabel.setForeground(buttonColor);

        // Reset status label color after a delay
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setForeground(Color.BLACK);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void resetOtherButtons(JButton activeButton) {
        if (activeButton != redButton) {
            redButton.setBackground(Color.GRAY);
        }
        if (activeButton != blueButton) {
            blueButton.setBackground(Color.GRAY);
        }
        if (activeButton != greenButton) {
            greenButton.setBackground(Color.GRAY);
        }
    }

    public static void main(String[] args) {
        // Use SwingUtilities for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ColorButtonForm form = new ColorButtonForm();
                form.setVisible(true);
            }
        });
    }
}
