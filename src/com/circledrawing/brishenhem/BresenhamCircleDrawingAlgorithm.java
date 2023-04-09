package com.circledrawing.brishenhem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BresenhamCircleDrawingAlgorithm extends JFrame{
	private int centerX, centerY, radius;
	
	public BresenhamCircleDrawingAlgorithm() {
		setTitle("Bresenham Circle Drawing Algorightm");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel drawingPanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawCircle(g);
			}
		};
		
		add(drawingPanel);
		
		String inputX = JOptionPane.showInputDialog("Enter centerX: ");
		String inputY = JOptionPane.showInputDialog("Enter centerY: ");
		String inputRadius = JOptionPane.showInputDialog("Enter radius: ");
	
		centerX = Integer.parseInt(inputX);
		centerY = Integer.parseInt(inputY);
		radius = Integer.parseInt(inputRadius);
		
		setVisible(true);
	}
	
	private void drawCircle(Graphics g) {
		int x = 0;
		int y = radius;
		int d = 3 - 2 * radius;
		
		while (x <= y) {
			plotPoints(g, x, y);
			x++;
			
			if (d < 0) {
				d += 4 * x + 6;
			} else {
				d += 4 * (x - y) + 10;
				y--;
			}
		}
	}
	
	private void plotPoints(Graphics g, int x, int y) {
		int cx = centerX;
		int cy = centerY;
		
		// plot points in all eight octants
		g.drawLine(cx + x, cy + y,  cx + x, cx + y);
		g.drawLine(cx - x, cy + y,  cx - x, cx + y);
		g.drawLine(cx + x, cy - y,  cx + x, cx - y);
		g.drawLine(cx - x, cy - y,  cx - x, cx - y);
		g.drawLine(cx + y, cy + x,  cx + y, cx + x);
		g.drawLine(cx - y, cy + x,  cx - y, cx + x);
		g.drawLine(cx + y, cy - x,  cx + y, cx - x);
		g.drawLine(cx - y, cy - x,  cx - y, cx - x);
	}
	
	public static void main(String[] args) {
		new BresenhamCircleDrawingAlgorithm();
	}
}
