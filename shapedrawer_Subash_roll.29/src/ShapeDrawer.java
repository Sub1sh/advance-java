import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class ShapeDrawer extends JFrame {
    private String currentShape = "Circle"; // Default shape
    private final int SHAPE_SIZE = 100; // Size of the shapes
    
    // Colors for each shape
    private final Color CIRCLE_COLOR = Color.RED;
    private final Color SQUARE_COLOR = Color.BLUE;
    private final Color TRIANGLE_COLOR = Color.GREEN;

    public ShapeDrawer() {
        setTitle("Shape Drawer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        
        // Create the drawing panel
        DrawingPanel drawingPanel = new DrawingPanel();
        
        // Create buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        // Create buttons
        JButton circleButton = new JButton("Circle");
        JButton squareButton = new JButton("Square");
        JButton triangleButton = new JButton("Triangle");
        
        // Add action listeners to buttons
        circleButton.addActionListener(e -> {
            currentShape = "Circle";
            drawingPanel.repaint();
        });
        
        squareButton.addActionListener(e -> {
            currentShape = "Square";
            drawingPanel.repaint();
        });
        
        triangleButton.addActionListener(e -> {
            currentShape = "Triangle";
            drawingPanel.repaint();
        });
        
        // Add buttons to panel
        buttonPanel.add(circleButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(triangleButton);
        
        // Set layout and add components
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);
        
        // Set button colors to match their shapes
        circleButton.setBackground(CIRCLE_COLOR);
        circleButton.setOpaque(true);
        circleButton.setBorderPainted(false);
        
        squareButton.setBackground(SQUARE_COLOR);
        squareButton.setOpaque(true);
        squareButton.setBorderPainted(false);
        
        triangleButton.setBackground(TRIANGLE_COLOR);
        triangleButton.setOpaque(true);
        triangleButton.setBorderPainted(false);
        
        // Make text white for better visibility on colored buttons
        circleButton.setForeground(Color.WHITE);
        squareButton.setForeground(Color.WHITE);
        triangleButton.setForeground(Color.WHITE);
    }
    
    // Custom panel for drawing shapes
    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // Set anti-aliasing for smoother shapes
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Get center coordinates
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            
            // Draw the appropriate shape based on current selection
            switch (currentShape) {
                case "Circle":
                    drawCircle(g2d, centerX, centerY);
                    break;
                case "Square":
                    drawSquare(g2d, centerX, centerY);
                    break;
                case "Triangle":
                    drawTriangle(g2d, centerX, centerY);
                    break;
            }
        }
        
        private void drawCircle(Graphics2D g2d, int centerX, int centerY) {
            g2d.setColor(CIRCLE_COLOR);
            int x = centerX - SHAPE_SIZE / 2;
            int y = centerY - SHAPE_SIZE / 2;
            g2d.fillOval(x, y, SHAPE_SIZE, SHAPE_SIZE);
            
            // Add a black border
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawOval(x, y, SHAPE_SIZE, SHAPE_SIZE);
        }
        
        private void drawSquare(Graphics2D g2d, int centerX, int centerY) {
            g2d.setColor(SQUARE_COLOR);
            int x = centerX - SHAPE_SIZE / 2;
            int y = centerY - SHAPE_SIZE / 2;
            g2d.fillRect(x, y, SHAPE_SIZE, SHAPE_SIZE);
            
            // Add a black border
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRect(x, y, SHAPE_SIZE, SHAPE_SIZE);
        }
        
        private void drawTriangle(Graphics2D g2d, int centerX, int centerY) {
            g2d.setColor(TRIANGLE_COLOR);
            
            // Calculate triangle points (equilateral triangle)
            int[] xPoints = {
                centerX,                          // Top point
                centerX - SHAPE_SIZE / 2,         // Bottom left
                centerX + SHAPE_SIZE / 2          // Bottom right
            };
            
            int[] yPoints = {
                centerY - SHAPE_SIZE / 2,         // Top point
                centerY + SHAPE_SIZE / 2,         // Bottom left
                centerY + SHAPE_SIZE / 2          // Bottom right
            };
            
            // Create and fill the triangle
            Path2D triangle = new Path2D.Double();
            triangle.moveTo(xPoints[0], yPoints[0]);
            triangle.lineTo(xPoints[1], yPoints[1]);
            triangle.lineTo(xPoints[2], yPoints[2]);
            triangle.closePath();
            
            g2d.fill(triangle);
            
            // Add a black border
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(triangle);
        }
        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Set system look and feel
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            ShapeDrawer shapeDrawer = new ShapeDrawer();
            shapeDrawer.setVisible(true);
        });
    }
}