package com.boundaryfill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class BoundaryFillAlgorithm extends JFrame {

    private BufferedImage image;
    private int fillColor;
    private int borderColor;
    private int startX, startY;

    public BoundaryFillAlgorithm() {
        setTitle("Boundary Fill Algorithm");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create an image with a white background
        image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 400, 400);
        g2d.dispose();

        // Set up mouse listener to capture start point
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                boundaryFill(startX, startY);
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, null);
    }

    public void boundaryFill(int x, int y) {
        if (x >= 0 && x < 400 && y >= 0 && y < 400) {
            int currentColor = image.getRGB(x, y);
            if (currentColor != borderColor && currentColor != fillColor) {
                image.setRGB(x, y, fillColor);
                boundaryFill(x - 1, y);
                boundaryFill(x + 1, y);
                boundaryFill(x, y - 1);
                boundaryFill(x, y + 1);
            }
        }
    }

    public static void main(String[] args) {
        
        BoundaryFillAlgorithm bfa = new BoundaryFillAlgorithm();
        bfa.fillColor = Color.YELLOW.getRGB();
        bfa.borderColor = Color.BLACK.getRGB();
        bfa.setVisible(true);

    }
}
