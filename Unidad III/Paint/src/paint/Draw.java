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
	private Point origen ;
	private Point destino;
	private int xinit;
	private int yinit;
	private static IFigures drag = null;
	private boolean flag = false;
	private Color c;
	private LinkedList<IFigures> lineas = new LinkedList<IFigures>();

	private int choosed_figure=0;
	public Draw() {
		Controller control = new Controller();
		addMouseListener(control);
		addMouseMotionListener(control);
		c= Color.BLUE;
		setC(c);
	}

	public void addFigures(IFigures figura) {
		lineas.add(figura);
		repaint();
	}

	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		BasicStroke bs2 = new BasicStroke(2, BasicStroke.JOIN_MITER, BasicStroke.JOIN_MITER);
		g2.setStroke(bs2);

		g2.setColor(Color.BLUE);

		if (!lineas.isEmpty()) {
			for (IFigures figure : lineas)
				figure.paint_figure(g2);
		}

		if (origen != null && destino != null && !flag) {
			if(choosed_figure==0) {
				Shape s = new Line2D.Float(origen.x, origen.y, destino.x, destino.y);
				g2.draw(s);
			}
			else {
				if (origen != null && destino != null && !flag) {
					g2.drawRect(origen.x, origen.y, destino.x, destino.y);
				}
			}
			
		}
	}

	public IFigures checkFigure(MouseEvent e) {
		for (IFigures iFigures : lineas) {
			if (iFigures.fInside(e.getX(), e.getY())) {
				flag = true;
				return iFigures;
			}
		}
		return null;
	}

	public void mouseDF(MouseEvent e) {
		if(choosed_figure==0) {
			destino = new Point(e.getX(), e.getY());
			repaint();
			drag = null;
		}
		else {
			int a = origen.x;
			int b = origen.y;
			int x = e.getX()-a;
			int y = e.getY()-b;
			destino = new Point(x,y); 
			
			repaint();
		}
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
			if(choosed_figure==1) {
				if (flag) {
					mouseDT(e);
				}
				else {
					mouseDF(e);
				}
			}
			if(choosed_figure==0) {
				if (flag) {
					mouseDT(e);
				}
				else {
					mouseDF(e);
				}
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (flag)
				drag = null;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (!flag) {
				origen = new Point(e.getX(), e.getY());
				System.out.println(origen.getX());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!flag) {
				switch (choosed_figure) {
				case 0:
					addFigures(new DrawLine(origen.x, origen.y, destino.x, destino.y, c));
					break;
				case 1:
					addFigures(new DrawRectangle(origen.x, origen.y, destino.x, destino.y, c));
					break;
				default:
					
					break;
				}
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
		lineas.clear();
		repaint();
		updateUI();
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

		this.flag = flag;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public int getChoosed_figure() {
		return choosed_figure;
	}

	public void setChoosed_figure(int choosed_figure) {
		this.choosed_figure = choosed_figure;
	}
	
	
	
}