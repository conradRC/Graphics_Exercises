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
import java.awt.geom.Line2D.Float;
import java.util.LinkedList;

import javax.swing.JComponent;

public class Draw extends JComponent {
	private Graphics2D g2;
	private Point origen;
	private Point destino;
	private int xinit;
	private int yinit;
	private IFigures drag = null;
	private boolean flag = false;
	private LinkedList<IFigures> lineas1 = new LinkedList<IFigures>();

	public Draw() {
		Controller control = new Controller();
		addMouseListener(control);
		addMouseMotionListener(control);
		test();
	}

	public void addFigures(IFigures figura) {
		lineas1.add(figura);
	}

	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		BasicStroke bs2 = new BasicStroke(10, BasicStroke.JOIN_MITER, BasicStroke.JOIN_MITER);
		g2.setStroke(bs2);

		g2.setColor(Color.BLUE);

		for (IFigures figure : lineas1) {
			figure.paint_figure(g2);
		}
		
		
		if (origen != null && destino != null && !flag) {
			Shape linea = new Line2D.Float(origen.x, origen.y, destino.x, destino.y);
			g2.draw(linea);
		}
	}

	public void test() {
		IFigures linea = new DrawLine(0, 0, 0, 0);
		addFigures(linea);
	}
	
	public IFigures checkFigure(MouseEvent e) {
		for (IFigures iFigures : lineas1) {
			if (iFigures.fInside(e.getX(), e.getY())) {
				System.out.println("check");
				return iFigures;
			}
		}
		return null;
	}

	class Controller implements MouseMotionListener, MouseListener {
		@Override
		public void mouseDragged(MouseEvent e) {
			if(!flag) {
				drag=null;
				destino = new Point(e.getX(), e.getY());
				repaint();
			}
			
			if(flag) {
				try {
					System.out.println(drag);
					if (drag == null) {
						xinit = e.getX();
						yinit = e.getY();
						drag = checkFigure(e);
					}
					else {
						drag.setPosicion(drag.getX() + (e.getX() - xinit),drag.getY() + (e.getY() - yinit));
						xinit = e.getX();
						yinit = e.getY();
						System.out.println(drag);
						repaint();
					}	
				}catch (Exception ex) {
					System.out.println("error");
				}
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if(flag==true) {
				drag = null;
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (!flag) {
				origen = new Point(e.getX(), e.getY());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!flag) {
				IFigures linea = new DrawLine(origen.x, origen.y, e.getX(), e.getY());
				addFigures(linea);
			}
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