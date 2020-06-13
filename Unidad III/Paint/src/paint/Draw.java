package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Draw extends JComponent {
	static Graphics2D g2;
	public Point origen;
	public Point destino;
	public ArrayList<Shape> lineas = new ArrayList<Shape>();

	public Draw() {
		controller();
	}

	public void controller() {
		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				origen = new Point(e.getX(), e.getY());
				destino = origen;
				System.out.println(origen);
			}

			public void mouseReleased(MouseEvent e) {
				Shape linea = Line.drawLine(origen.x, origen.y, e.getX(), e.getY());
				System.out.println(linea.getBounds());
				lineas.add(linea);
			}
		};

		MouseMotionAdapter mouseMotion = new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				destino = new Point(e.getX(), e.getY());
				repaint();
			}
			
		};
		
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseMotion);
	}

	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		BasicStroke bs2 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
		g2.setStroke(bs2);

		g2.setColor(Color.BLUE);
		for (Shape linea : lineas)
			g2.draw(linea);

		if (origen != null && destino != null) {
			Shape linea = Line.drawLine(origen.x, origen.y, destino.x, destino.y);
			g2.draw(linea);
		}
	}

		public void remover() {
		if (lineas.size() - 1 >= 0) {
			lineas.remove(lineas.size() - 1);
			for (Shape linea : lineas) 
				g2.draw(linea);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.add(new Draw());
		frame.setVisible(true);
	}
	
}