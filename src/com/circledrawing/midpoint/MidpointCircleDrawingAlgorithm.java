package com.circledrawing.midpoint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MidpointCircleDrawingAlgorithm extends JFrame {
	private int centerX, centerY, radius;
	
	public MidpointCircleDrawingAlgorithm() {
		setTitle("Midpoint Circle Drawing Algorightm");
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
		int d = 1 - radius;
		
		while (x <= y) {
			plotPoints(g, x, y);
			x++;
			
			if (d < 0) {
				d += 2 * x + 1;
			} else {
				d += 2 * (x - y) + 1;
				y--;
			}
		}
	}
	
	private void plotPoints(Graphics g, int x, int y) {
		int cx = centerX;
		int cy = centerY;
		g.setColor(Color.BLACK);
		// plot points in all eight octants
		g.fillRect(cx + x, cy + y, 1, 1);
		g.fillRect(cx - x, cy + y, 1, 1);
		g.fillRect(cx + x, cy - y, 1, 1);
		g.fillRect(cx - x, cy - y, 1, 1);
		g.fillRect(cx + y, cy + x, 1, 1);
		g.fillRect(cx - y, cy + x, 1, 1);
		g.fillRect(cx + y, cy - x, 1, 1);
		g.fillRect(cx - y, cy - x, 1, 1);
	}
	
	public static void main(String[] args) {
		new MidpointCircleDrawingAlgorithm();
	}
}
