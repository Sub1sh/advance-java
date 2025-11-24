import javax.swing.*; import java.awt.*; import java.awt.event.*; public class App extends JFrame implements ItemListener { 
    JRadioButton r = new JRadioButton("Red"), g = new JRadioButton("Green"), b = new JRadioButton("Blue");     public App() {         setTitle("Color Changer");         setSize(400, 300);         setLayout(new FlowLayout());         setDefaultCloseOperation(EXIT_ON_CLOSE);         ButtonGroup bg = new ButtonGroup();         for (JRadioButton btn : new JRadioButton[]{r,g,b}) {             bg.add(btn);             add(btn);             btn.addItemListener(this); 
        } 
        setVisible(true); 
    } 
    public void itemStateChanged(ItemEvent e) {         if (r.isSelected()) getContentPane().setBackground(Color.RED);         else if (g.isSelected()) getContentPane().setBackground(Color.GREEN);         else if (b.isSelected()) getContentPane().setBackground(Color.BLUE); 
    } 
 
    public static void main(String[] args) { new App(); } 
} 
