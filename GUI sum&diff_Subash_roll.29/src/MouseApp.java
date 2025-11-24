import java.awt.*;
import java.awt.event.*;
public class MouseApp implements MouseListener {
    Label lblOutput;
    TextField txtOne, txtTwo;
    MouseApp() {
        Frame f = new Frame("Sum and Difference using Mouse Events");
        lblOutput = new Label("Result will be shown here");
        lblOutput.setBounds(20, 50, 200, 20);
        txtOne = new TextField();
        txtOne.setBounds(20, 80, 100, 20);
        txtTwo = new TextField();
        txtTwo.setBounds(20, 110, 100, 20);
        f.addMouseListener(this);
        f.add(lblOutput);
        f.add(txtOne);
        f.add(txtTwo);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true); }
    public void mousePressed(MouseEvent e) {
        try {
            int a = Integer.parseInt(txtOne.getText());
            int b = Integer.parseInt(txtTwo.getText());
            int sum = a + b;
            lblOutput.setText("Sum = " + sum);
        } catch (Exception ex) {
            lblOutput.setText("Invalid Input!"); }  }
    public void mouseReleased(MouseEvent e) {
        try {
            int a = Integer.parseInt(txtOne.getText());
            int b = Integer.parseInt(txtTwo.getText());
            int diff = a - b;
            lblOutput.setText("Difference = " + diff);
        } catch (Exception ex) {
            lblOutput.setText("Invalid Input!");  }}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public static void main(String[] args) {
        new MouseApp();  }   }
