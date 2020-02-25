import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Joins extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs1);
		g2d.drawLine(15, 15, 80, 50);

		BasicStroke bs2 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
		g2d.setStroke(bs2);
		g2d.drawLine(125, 15, 80, 50);
		
		BasicStroke bs3 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs3);
		g2d.drawLine(235, 15, 80, 50);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Joins");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(340, 110);
		frame.setLocationRelativeTo(null);
		frame.add(new Joins());
		frame.setVisible(true);
	}
}

