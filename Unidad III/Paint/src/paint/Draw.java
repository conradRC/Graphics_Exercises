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
	private  Point origen;
	private Point destino;
	private int xinit;
	private int yinit;
	private IFigures drag = null;
	private boolean flag= false;
	
	private LinkedList<IFigures> lineas1 = new LinkedList<IFigures>();
	
	public Draw() {
		Controller control = new Controller();
		addMouseListener(control);
		addMouseMotionListener(control);
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
		g2.setColor(new Color(50, 50, 50));
		BasicStroke bs4 = new BasicStroke(0.5f, BasicStroke.JOIN_MITER, BasicStroke.JOIN_MITER);
		g2.setStroke(bs4);

		
		g2.setStroke(bs2);
		g2.setColor(Color.BLUE);
		
		if(!flag) {
			if (origen != null && destino != null) {
				Shape linea = new Line2D.Float(origen.x, origen.y, destino.x, destino.y);
				g2.draw(linea);
			}
		}
	}

	public IFigures check(MouseEvent e) {
		for (IFigures iFigures : lineas1) {
			if (iFigures.fInside(e.getX(), e.getY())) 
				return iFigures;
		}
		return null;
	}
	
	class Controller implements MouseMotionListener, MouseListener {
		@Override
		
		public void mouseDragged(MouseEvent e) {
			if(!flag) {
				System.out.println("dragged :"+flag);
				destino = new Point(e.getX(), e.getY());
				repaint();
			}
			
			if(flag) {
				if (drag == null) {
					xinit = e.getX();
					yinit = e.getY();
					drag = check(e);
				}
				else {
					drag.setPosicion(drag.getX() + (e.getX() - xinit),drag.getY() + (e.getY() - yinit));
					xinit = e.getX();
					yinit = e.getY();
					repaint();
				}
			}
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			drag=null;
			/*if (!lineas.isEmpty()) {
				insidef(e.getX(), e.getY());
				if (drag) {
					setCursor(new Cursor(13));
				} else {
					setCursor(new Cursor(0));
				}
			}*/
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(!flag) {
				System.out.println("pressed :"+flag);
				origen = new Point(e.getX(), e.getY());
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			if(!flag) {
				System.out.println("released :"+flag);
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

	public void test() {
		
	}
	
	public boolean isFlag() {		
		return flag;
	}

	public void setFlag(boolean flag) {
		System.out.println(flag);
		this.flag = flag;
	}

	
	
}