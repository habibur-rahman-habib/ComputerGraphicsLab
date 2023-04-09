package com.translation;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Main extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Main() {
        setTitle("2D Transformations Example");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new TransformationsPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }

    static class TransformationsPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Set up initial point
            double x = 100;
            double y = 100;
            
            // rectangle 
            g2d.setColor(Color.GREEN);
            g2d.drawRect((int)x, (int)y, (int)x + 50, (int)y);
            
            
            // Perform rotation
            double angle = 45;
            AffineTransform rotation = AffineTransform.getRotateInstance(angle, getWidth(), getHeight());
            g2d.setTransform(rotation);
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawLine((int) x, (int) y, (int) x + 50, (int) y);

            // Perform translation
            double dx = 100;
            double dy = 50;
            AffineTransform translation = AffineTransform.getTranslateInstance(dx, dy);
            g2d.setTransform(translation);
            g2d.setColor(Color.BLUE);
            g2d.drawRect((int) x, (int) y, 50, 50);

            // Perform reflection
            AffineTransform reflection = new AffineTransform(-1, 0, 0, 1, getWidth() / 2, 0);
            g2d.setTransform(reflection);
            g2d.setColor(Color.GREEN);
            g2d.fillOval((int) x, (int) y, 50, 50);

            // Perform shearing
            double shx = 0.5;
            double shy = -0.3;
            AffineTransform shearing = AffineTransform.getShearInstance(shx, shy);
            g2d.setTransform(shearing);
            g2d.setColor(Color.ORANGE);
            g2d.drawLine((int) x, (int) y, (int) x + 50, (int) y + 50);

            // Perform scaling
            double sx = 1.5;
            double sy = 2;
            AffineTransform scaling = AffineTransform.getScaleInstance(sx, sy);
            g2d.setTransform(scaling);
            g2d.setColor(Color.PINK);
            g2d.fillRoundRect((int) x, (int) y, 50, 50, 10, 10);
        }
    }
}

