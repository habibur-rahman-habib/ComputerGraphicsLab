package brishenhem.linedrawing;

import java.awt.*;
import javax.swing.*;

public class BLDAlgorithm extends JPanel {
	
	private int x1, y1, x2, y2;
	
	public BLDAlgorithm(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		
		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);
		
		int sx = x1 < x2 ? 1 : -1;
		int sy = y1 < y2 ? 1 : -1;
		
		int x = x1;
		int y = y1;
		
		if (dx > dy) {
			int p = 2 * dy - dx;
			
			while (x != x2) {
				g.fillRect(x, y, 1, 1);
				x += sx;
				
				if (p < 0) {
					p += 2 * dy;
				} else {
					p += 2 * (dy - dx);
					y += sy;
				}
			}
		} else {
			int p = 2 * dx - dy;
			
			while (y != y2) {
				g.fillRect(x, y, 1, 1);
				y += sy;
				
				if (p < 0) {
					p += 2 * dx;
				} else {
					p += 2 * (dx - dy);
					x += sx;
				}
			}
		}
		
		g.fillRect(x2, y2, 1, 1);
	}
	
	public static void main(String[] args) {
		int x1 = 50;
		int y1 = 100;
		int x2 = 200;
		int y2 = 50;
		
		JFrame frame = new JFrame("Bresenham's Line Algorithm");
		BLDAlgorithm bldAlgorithm = new BLDAlgorithm(x1, y1, x2, y2);
		frame.add(bldAlgorithm);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
