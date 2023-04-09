package com.translation2;

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

            // Create transformation matrix
            AffineTransform transform = new AffineTransform();
            double angle = Math.PI / 4;
            double dx = 100;
            double dy = 50;
            double shx = 0.5;
            double shy = -0.3;
            double sx = 1.5;
            double sy = 2;
            transform.rotate(angle, getWidth() / 2, getHeight() / 2);
            transform.translate(dx, dy);
            transform.shear(shx, shy);
            transform.scale(sx, sy);

            // Apply the transformation matrix
            g2d.setTransform(transform);

            // Draw the transformed shapes
            g2d.setColor(Color.RED);
            g2d.drawLine((int) x, (int) y, (int) x + 50, (int) y);

            g2d.setColor(Color.BLUE);
            g2d.drawRect((int) x, (int) y, 50, 50);

            g2d.setColor(Color.GREEN);
            g2d.fillOval((int) x, (int) y, 50, 50);

            g2d.setColor(Color.ORANGE);
            g2d.drawLine((int) x, (int) y, (int) x + 50, (int) y + 50);

            g2d.setColor(Color.PINK);
            g2d.fillRoundRect((int) x, (int) y, 50, 50, 10, 10);
        }
    }
}
