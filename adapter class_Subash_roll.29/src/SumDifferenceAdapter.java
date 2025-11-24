
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumDifferenceAdapter extends JFrame {

    JTextField t1, t2;
    JLabel result;

    public SumDifferenceAdapter() {
        // Title
        setTitle("Sum and Difference Finder (Adapter)");

        // Layout
        setLayout(new FlowLayout());

        // Input fields
        t1 = new JTextField(10);
        t2 = new JTextField(10);

        // Output label
        result = new JLabel("Result will be displayed here");

        // Add components
        add(new JLabel("First Number:"));
        add(t1);
        add(new JLabel("Second Number:"));
        add(t2);
        add(result);

        // Add mouse adapter (instead of MouseListener)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int n1 = getNumber(t1);
                int n2 = getNumber(t2);
                result.setText("Sum = " + (n1 + n2));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int n1 = getNumber(t1);
                int n2 = getNumber(t2);
                result.setText("Difference = " + (n1 - n2));
            }
        });

        // Frame settings
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Helper method to read numbers safely
    private int getNumber(JTextField field) {
        try {
            return Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            return 0;  // default if empty/invalid
        }
    }

    // Main method
    public static void main(String[] args) {
        new SumDifferenceAdapter();
    }
}
