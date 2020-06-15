package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.LinkedList;

import javax.swing.JComponent;

public class Draw extends JComponent {
	private Graphics2D g2;
	private Point origen;
	private Point destino;
	private int xinit;
	private int yinit;
	private static IFigures drag = null;
	private boolean flag = true;
	private LinkedList<IFigures> lineas1 = new LinkedList<IFigures>();

	public Draw() {
		Controller control = new Controller();
		addMouseListener(control);
		addMouseMotionListener(control);
		//test();
	}

	public void addFigures(IFigures figura) {
		lineas1.add(figura);
		repaint();
	}

	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		BasicStroke bs2 = new BasicStroke(10, BasicStroke.JOIN_MITER, BasicStroke.JOIN_MITER);
		g2.setStroke(bs2);

		g2.setColor(Color.BLUE);

		if (!lineas1.isEmpty()) {
			for (IFigures figure : lineas1)
				figure.paint_figure(g2);
		}

		if (origen != null && destino != null && !flag) {
			Shape s =  new Line2D.Float(origen.x, origen.y, destino.x, destino.y);
			g2.draw(s);
		}
		
	}

	public IFigures checkFigure(MouseEvent e) {
		System.out.println(lineas1.size());
		for (IFigures iFigures : lineas1) {
			if (iFigures.fInside(e.getX(), e.getY())) {
				return iFigures;
			}
		}
		return null;
	}
	
	public void test() {
		IFigures d = new DrawLine(50, 50, 400, 300);
		addFigures(d);
	}

	public void mouseDF(MouseEvent e) {
		destino = new Point(e.getX(), e.getY());
		repaint();
		drag=null;
	}

	public void mouseDT(MouseEvent e) {
		try {
			if (drag == null) {
				xinit = e.getX();
				yinit = e.getY();
				drag = checkFigure(e);
			} else {
				drag.setPosicion(drag.getX() + (e.getX() - xinit), drag.getY() + (e.getY() - yinit));
				xinit = e.getX();
				yinit = e.getY();
				repaint();
			}
		} catch (Exception ex) {
		}
	}

	class Controller implements MouseMotionListener, MouseListener {
		@Override
		public void mouseDragged(MouseEvent e) {

			if (flag) {
				mouseDT(e);
			} else {
				mouseDF(e);
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (flag)
				drag = null;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (!flag) origen = new Point(e.getX(), e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!flag) addFigures(new DrawLine(origen.x, origen.y, destino.x, destino.y));
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

	public void reset() {
		lineas1.clear();
		repaint();
	}

	public boolean isFlag() {
		return flag;
	}

	public IFigures getDrag() {
		return drag;
	}

	public void setDrag(IFigures drag) {
		this.drag = drag;
	}

	public void setFlag(boolean flag) {
		System.out.println(flag);
		this.flag = flag;
	}

}