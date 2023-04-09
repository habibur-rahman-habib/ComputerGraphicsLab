package com.clepping;

import java.awt.*;
import javax.swing.*;

public class ClippingExample extends JFrame {

    public ClippingExample() {
        // Set up the JFrame
        setTitle("Clipping Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a custom JPanel for drawing the clipped rectangle
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Set the clipping region to a rectangular area
                g.setClip(50, 50, 200, 100);

                // Draw a rectangle that is clipped to the specified region
                g.setColor(Color.RED);
                g.fillRect(0, 0, getWidth(), getHeight());

                // Reset the clipping region
                g.setClip(null);

                // Draw a rectangle outside of the clipped region
                g.setColor(Color.BLUE);
                g.fillRect(250, 150, 100, 50);
            }
        };

        // Add the panel to the JFrame
        add(panel);

        // Show the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new ClippingExample();
    }
}
