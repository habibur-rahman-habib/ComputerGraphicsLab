package com.hyperabola;

import java.awt.*;
import javax.swing.*;

public class HyperbolaPlot extends JFrame {

    public HyperbolaPlot() {
        // Set up the JFrame
        setTitle("Hyperbola Plot");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a custom JPanel for drawing the hyperbola
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                double a = 2; // value of 'a' parameter
                double b = 3; // value of 'b' parameter
                double scaleX = getWidth() / 20.0; // scale factor for x-axis
                double scaleY = getHeight() / 20.0; // scale factor for y-axis

                // Draw the hyperbola points
                g.setColor(Color.BLUE);
                for (double x = -10; x <= 10; x += 0.1) {
                    double y = Math.sqrt((x * x * b * b) / (a * a) - b * b);
                    int screenX = (int) (x * scaleX + getWidth() / 2.0);
                    int screenY = (int) (-y * scaleY + getHeight() / 2.0);
                    g.fillRect(screenX, screenY, 2, 2);
                    screenY = (int) (y * scaleY + getHeight() / 2.0);
                    g.fillRect(screenX, screenY, 2, 2);
                }
            }
        };

        // Add the panel to the JFrame
        add(panel);

        // Show the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new HyperbolaPlot();
    }
}

