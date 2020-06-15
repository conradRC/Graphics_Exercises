package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class Draw extends JComponent {
	private Graphics2D g2;
	private  Point origen;
	private Point destino;
	private int xinit;
	private int yinit;
	private int rect;
	private Shape s = null;
	private boolean flag;
	private ArrayList<Shape> lineas = new ArrayList<Shape>();
	private boolean drag = false;
	private LinkedList<Shape> lineas1 = new LinkedList<Shape>();
	
	public Draw() {
		
		Controller control = new Controller();
		addMouseListener(control);
		addMouseMotionListener(control);
		test();
	}
	

	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		BasicStroke bs2 = new BasicStroke(10, BasicStroke.JOIN_MITER, BasicStroke.JOIN_MITER);
		g2.setStroke(bs2);

		g2.setColor(Color.BLUE);
		for (Shape linea : lineas)
			g2.draw(linea);

		g2.setColor(new Color(50, 50, 50));
		BasicStroke bs4 = new BasicStroke(0.5f, BasicStroke.JOIN_MITER, BasicStroke.JOIN_MITER);
		g2.setStroke(bs4);

		
		g2.setStroke(bs2);
		g2.setColor(Color.BLUE);
		if (origen != null && destino != null) {
			Shape linea = drawLine(origen.x, origen.y, destino.x, destino.y, 1);
			g2.draw(linea);
		}
	}

	public ArrayList<Shape> getLineas() {
		return lineas;
	}

	public Line2D.Float drawLine(int x1, int y1, int x2, int y2, int a) {
		return new Line2D.Float(x1, y1, x2, y2);
	}
	
	public void test() {
		Shape linea = drawLine(50, 50, 100, 100, 1);
		lineas.add(linea);
	}

	public void remover() {
		if (lineas.size() - 1 >= 0) {
			lineas.remove(lineas.size() - 1);
			for (Shape linea : lineas)
				g2.draw(linea);
		}
	}

	public Shape insidef(int x, int y) {
	
		for (int i = 0; i < lineas.size(); i++) {
			Shape shape = lineas.get(i);
			double x1 = shape.getBounds().getX();
			double y1 = shape.getBounds().getY();
			double x2 = shape.getBounds().getWidth();
			double y2 = shape.getBounds().getHeight();
			if ((x > x1) && (x < (x1 + x2)) && (y > y1) && (y < (y1 + y2))) {
				Rectangle2D.Double r = new Rectangle2D.Double(x1, y1, x2, y2);
				
				g2.draw(r);
				
				rect = i;
				drag=true;
				return shape;
			}
			else {
				drag= false;
			}
		}
		return null;
	}

	class Controller implements MouseMotionListener, MouseListener {
		@Override
		public void mouseDragged(MouseEvent e) {
			destino = new Point(e.getX(), e.getY());
			repaint();
			
		}
		

		@Override
		public void mouseMoved(MouseEvent e) {
			if (!lineas.isEmpty()) {
				insidef(e.getX(), e.getY());
				if (drag) {
					setCursor(new Cursor(13));
				} else {
					setCursor(new Cursor(0));
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			origen = new Point(e.getX(), e.getY());
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			Shape linea = drawLine(origen.x, origen.y, e.getX(), e.getY(), 1);
			lineas.add(linea);
			flag=false;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(new Draw());
		frame.setVisible(true);
	}
}