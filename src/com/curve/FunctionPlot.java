package com.curve;

import java.awt.*;
import javax.swing.*;

public class FunctionPlot extends JFrame {

    public FunctionPlot() {
        // Set up the JFrame
        setTitle("Function Plot");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a custom JPanel for drawing the function curve
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                double scaleX = getWidth() / 20.0; // scale factor for x-axis
                double scaleY = getHeight() / 20.0; // scale factor for y-axis

                // Define the function equation
                // Example: y = x^2 + 2x + 3
                for (double x = -10; x <= 10; x += 0.1) {
                    double y = x * x * x + 2 * x * x + x - 13;
                    int screenX = (int) (x * scaleX + getWidth() / 2.0);
                    int screenY = (int) (-y * scaleY + getHeight() / 2.0);
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
        new FunctionPlot();
    }
}
