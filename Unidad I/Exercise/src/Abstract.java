import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

public class Abstract extends JFrame {
	int width, height;

	public Abstract() {
		super("Dibujo de figuras en 2D");
		setSize(1005, 660);

		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		width = getWidth();
		height = getHeight();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Point2D.Double p[] = calcularCoordenadas(width / 2, height / 2, 90, true, 400, 360);
		Color[] colors = { rgb(), new Color(0, 255, 255), rgb(), new Color(255, 0, 255), rgb(), new Color(0, 255, 255),rgb() };
		for (int i = 0; i < p.length; i++) {
			double x = p[i].x;
			double y = p[i].y;
			Point2D.Double point[] = calcularCoordenadas((int) x, (int) y, 180, true, 400, 360);
			esfera(g2d, point, colors);
		}

		/*
		 * Point2D.Double pp[] = calcularCoordenadas(width / 2, height / 2, 6,
		 * true,200,1); Color[] color = { new Color(0,255,0), new Color(0,255,0), new
		 * Color(0,255,0), new Color(0,255,0), rgb(), new Color(0,255,0), new
		 * Color(0,255,0)}; esfera(g2d, pp,color);
		 * 
		 * for (int i = 0; i < pp.length; i++) { double x = pp[i].x; double y = pp[i].y;
		 * Point2D.Double point[] = calcularCoordenadas((int) x, (int) y, 180,
		 * false,200,4); esfera(g2d, point,colors); }
		 */
	}

	public void esfera(Graphics2D g2d, Point2D.Double[] point, Color[] colors) {
		int radius = 20;
		for (int i = 0; i < point.length; i++) {
			int x = (int) point[i].getX();
			int y = (int) point[i].getY();
			Point2D center = new Point2D.Float(x + (radius / 2), y + (radius / 2));
			float[] dist = { 0.1f, 0.2f, 0.4f, 0.5f, 0.7f, 0.8f, 1.0f };
			g2d.setPaint(new RadialGradientPaint(center, radius / 2, dist, colors));
			g2d.fill(new Ellipse2D.Double(x, y, radius, radius));
		}
	}

	public Color rgb() {
		int r = (int) (Math.random() * 255);
		int g = (int) (Math.random() * 255);
		int b = (int) (Math.random() * 255);
		return new Color(r, g, b);
	}

	public int random(int limit) {
		int l = (int) (Math.random() * limit) + 10;
		return l;
	}

	public Point2D.Double[] calcularCoordenadas(int w, int h, int points, boolean flags, int radio, int limit) {
		Point2D.Double[] point = new Point.Double[points];

		double origenx, origeny;
		origenx = w;
		origeny = h;
		double x, y;

		for (int c = 0; c < points; c++) {
			double grados = (limit / points * c);
			double convert = (double) Math.toRadians(grados);
			if (flags) {
				x = radio * Math.cos(convert) + origenx;
				y = radio * Math.sin(convert) + origeny;
			}
			else {
				x = radio * Math.sin(convert) + origeny;
				y = radio * Math.cos(convert) + origenx;
			}
			point[c] = new Point2D.Double(x, y);
		}
		return point;
	}

	public static void main(String[] args) {
		Abstract aplicacion = new Abstract();
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
