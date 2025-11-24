/*
 * Write a program to Create a Form Below using Swing and perform Add, Subtract, Multiply and Divide as user click button with selected option.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorDropDown extends JFrame implements ActionListener {
    JTextField num1Field, num2Field, resultField;
    JComboBox<String> operationBox;
    JButton calcBtn;

    public CalculatorDropDown() {
        // Frame settings
        setTitle("Calculator with DropDown");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels
        JLabel num1Label = new JLabel("Enter First Number:");
        JLabel num2Label = new JLabel("Enter Second Number:");
        JLabel operationLabel = new JLabel("Select Operation:");
        JLabel resultLabel = new JLabel("Result:");

        // TextFields
        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        // DropDown (ComboBox)
        String[] operations = {"Add", "Subtract", "Multiply", "Divide"};
        operationBox = new JComboBox<>(operations);

        // Button
        calcBtn = new JButton("Calculate");
        calcBtn.addActionListener(this);

        // Adding components to frame
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(operationLabel);
        add(operationBox);
        add(new JLabel("")); // empty space
        add(calcBtn);
        add(resultLabel);
        add(resultField);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            String operation = (String) operationBox.getSelectedItem();

            switch (operation) {
                case "Add":
                    result = num1 + num2;
                    break;
                case "Subtract":
                    result = num1 - num2;
                    break;
                case "Multiply":
                    result = num1 * num2;
                    break;
                case "Divide":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Division by zero not allowed!");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            resultField.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new CalculatorDropDown();
    }
}
