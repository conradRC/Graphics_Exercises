import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class G01 extends JPanel{
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		Dimension size = new Dimension();
		Insets insets = getInsets();
		int w = size.width-insets.left-insets.right;
		int h = size.height-insets.top-insets.bottom;
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int x = Math.abs(r.nextInt())%w;
			int y = Math.abs(r.nextInt())%h;
			g2d.drawLine(x, y, x, y);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pixeles");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.add(new G01());
		frame.setVisible(true);
	}
}
