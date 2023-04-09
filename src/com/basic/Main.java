package com.basic;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    private int x1, y1, x2, y2;

    public Main(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the line
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x1, y2 - 50);
        g.drawLine(x1, y2 - 50, x1, y1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Line Drawing Example");
        Main lineDrawingExample = new Main(50, 50, 200, 200); // Specify the coordinates for the line
        frame.add(lineDrawingExample);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
