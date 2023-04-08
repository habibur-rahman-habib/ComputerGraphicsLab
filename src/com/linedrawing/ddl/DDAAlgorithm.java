package com.linedrawing.ddl;

import javax.swing.*;
import java.awt.*;

public class DDAAlgorithm extends JPanel{
	
	private int x1, y1, x2, y2;
	
	public DDAAlgorithm(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        int dx = x2 - x1; // change in x
        int dy = y2 - y1; // change in y
        int steps = Math.max(Math.abs(dx), Math.abs(dy)); // number of steps

        float xIncrement = (float) dx / steps; // increment in x for each step
        float yIncrement = (float) dy / steps; // increment in y for each step

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 1, 1); // plot the point
            x += xIncrement; // update x
            y += yIncrement; // update y
        }
    }
	
	public static void main(String[] args) {
		int x1 = 50;
		int y1 = 100;
		int x2 = 200;
		int y2 = 50;
		
		JFrame frame = new JFrame("DDA Line Drawing Algoright");
		DDAAlgorithm ddaAlgorithm = new DDAAlgorithm(x1, y1, x2, y2);
		frame.add(ddaAlgorithm);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
