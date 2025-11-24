import javax.swing.*; import java.awt.*; import java.awt.event.*; public class App extends JFrame {     public App() {         setTitle("Toolbar Example");         setSize(400, 200);         setDefaultCloseOperation(EXIT_ON_CLOSE); 
        JToolBar tb = new JToolBar(); 
        String[] btns = {"New", "Login", "Logout"};         for (String t : btns) { 
            JButton b = new JButton(t); 
            b.addActionListener(e -> JOptionPane.showMessageDialog(this, t + (t.equals("New") ? " File Created" : t.equals("Login") ? " Successful" : "ed Out"))); 
            tb.add(b); 
        } 
        add(tb, BorderLayout.NORTH);         setVisible(true); 
    } 
    public static void main(String[] args) { new App(); } 
} 
