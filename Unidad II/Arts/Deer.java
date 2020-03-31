import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Deer extends JPanel {
	Graphics2D g2d;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		BasicStroke bs2 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
		g2d.setStroke(bs2);
		
		// triangle fondo
				int[] x29 = {285,181,388};
				int[] y29 = {226,447,447};
				Polygon poly = new Polygon(x29, y29, x29.length);
				g2d.setColor(Color.white);
				g2d.drawPolygon(poly);
				g2d.fill(poly);
				
		// triangle 1
		int[] x = { 222, 181, 176 };
		int[] y = { 95, 135, 176 };
		draw(x, y);

		// triangle 2
		int[] x1 = { 175, 185, 194 };
		int[] y1 = { 178, 193, 145 };
		draw(x1, y1);

		// triangle 3
		int[] x2 = { 184, 188, 173, 154 };
		int[] y2 = { 194, 221, 197, 151 };
		draw(x2, y2);

		// triangle 4
		int[] x3 = { 171, 140, 152, 153 };
		int[] y3 = { 194, 152, 120, 150 };
		draw(x3, y3);

		// triangle 5
		int[] x4 = { 172, 177, 190, 188 };
		int[] y4 = { 198, 225, 236, 222 };
		draw(x4, y4);

		// triangle 6
		int[] x5 = { 189, 209, 213, 181, 178 };
		int[] y5 = { 235, 255, 274, 240, 226 };
		draw(x5, y5);

		// triangle 7
		int[] x6 = { 180, 158, 167, 204 };
		int[] y6 = { 239, 226, 248, 266 };
		draw(x6, y6);

		// triangle 8
		int[] x7 = { 159, 157, 147, 167 };
		int[] y7 = { 226, 194, 231, 249 };
		draw(x7, y7);

		// triangle 9
		int[] x8 = { 151, 137, 147 };
		int[] y8 = { 220, 212, 231 };
		draw(x8, y8);

		// triangle 10
		int[] x9 = { 151, 133, 137 };
		int[] y9 = { 220, 173, 212 };
		draw(x9, y9);

		// triangle 11
		int[] x10 = { 228, 219, 225, 208, 213 };
		int[] y10 = { 290, 238, 211, 234, 273 };
		draw(x10, y10);

		// triangle 12
		int[] x11 = { 224, 253, 246, 244, 234 };
		int[] y11 = { 266, 307, 312, 315, 317 };
		draw(x11, y11);

		// triangle 13
		int[] x12 = { 254, 264, 266, 260, 245, 238, 230, 234, 243, 245 };
		int[] y12 = { 308, 308, 337, 349, 353, 329, 324, 317, 317, 313 };
		draw(x12, y12);

		// triangle 14
		int[] x13 = { 234, 227, 231, 244, 237 };
		int[] y13 = { 327, 342, 351, 353, 330 };
		draw(x13, y13);

		// triangle 15
		int[] x14 = { 234, 227, 150, 219 };
		int[] y14 = { 327, 342, 303, 318 };
		draw(x14, y14);

		// triangle 16
		int[] x15 = { 150, 181, 203, 231, 227 };
		int[] y15 = { 303, 333, 350, 351, 342 };
		draw(x15, y15);

		// triangle 17
		int[] x16 = { 231, 241, 234, 230, 229 };
		int[] y16 = { 351, 364, 376, 368, 354 };
		draw(x16, y16);

		// triangle 18
		int[] x17 = { 231, 247, 256, 260, 258 };
		int[] y17 = { 351, 356, 363, 356, 349 };
		draw(x17, y17);

		// triangle 19
		int[] x18 = { 266, 272, 267, 256 };
		int[] y18 = { 337, 362, 389, 363 };
		draw(x18, y18);

		// triangle 20
		int[] x19 = { 243, 254, 266, 255, 234 };
		int[] y19 = { 364, 364, 390, 409, 375 };
		draw(x19, y19);

		// triangle 21
		int[] x20 = {264,285,285,272,266};
		int[] y20 = {308,301,367,362,337};
		draw(x20, y20);

		// triangle 22
		int[] x21 = {271,267,256,257,265,285,285};
		int[] y21 = {361,389,412,420,425,425,367};
		draw(x21, y21);

		// triangle 23
		int[] x22 = {285,265,270,285};
		int[] y22 = {425,425,438,438};
		draw(x22, y22);
		
		// triangle 24
		int[] x23 = {265,257,256,250,213,226};
		int[] y23 = {425,420,411,402,463,516};
		draw(x23, y23);
		
		// triangle 25
		int[] x24 = {250,242,218,218};
		int[] y24 = {402,390,435,452};
		draw(x24, y24);
	
		// triangle 26
		int[] x25 = {265,254,285,285,270};
		int[] y25 = {425,454,585,438,435};
		draw(x25, y25);
	
	
		// triangle 27
		int[] x26 = {254,285,226};
		int[] y26 = {454,590,516};
		draw(x26, y26);
		
		// triangle 28 nariz
		int[] x27 = {285,270,266,276,285};
		int[] y27 = {400,400,406,419,419};
		draw(x27, y27);
	}

	
	public void draw(int[] x, int y[]) {
		Polygon poly = new Polygon(x, y, x.length);
		g2d.setColor(rgb());
		g2d.drawPolygon(poly);
		g2d.fill(poly);
		int[] x1 =x;
		for (int i = 0; i < x.length; i++)
			x1[i] = 285+(285-x[i]);
		
		Polygon poly2 = new Polygon(x1, y, x1.length);
		g2d.drawPolygon(poly2);
		g2d.fill(poly2);
	}
	
		public Color rgb() {
		int r = (int) (Math.random() * 200);
		int b = (int) (Math.random() * 255);
		return new Color(r, 0, b);
	}

	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);
		frame.setLocationRelativeTo(null);
		Deer d = new Deer();
		d.setBackground(Color.BLACK);
		frame.add(d);
		frame.setVisible(true);
	}
}


