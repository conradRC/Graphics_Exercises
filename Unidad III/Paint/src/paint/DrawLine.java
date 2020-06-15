package paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

public class DrawLine implements IFigures{
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color color;
	private Line2D.Float line;

	public DrawLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = Color.blue;
	}

	public boolean fInside(int x, int y) {
		boolean flag = false;
		double lx1 = line.getBounds().getX();
		double ly1 = line.getBounds().getY();
		double width = line.getBounds().getWidth();
		double heigth = line.getBounds().getHeight();
		if ((x > lx1) && (x < (lx1 + width)) && (y > ly1) && (y < (ly1 + heigth))) {
			flag = true;
		}
		return flag;
	}

	public void paint_figure(Graphics2D g) {
		Graphics2D g2d = (Graphics2D) g;
		line = new Line2D.Float(x1, y1, x2, y2);
		g2d.draw(line);
	}

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPosicion(int x, int y) {
		int a = x - x1;
		int b = y - y1;
		x1 = x;
		y1 = y;
		x2 += a;
		y2 += b;
	}

	public int getX() {
		return x1;
	}

	public int getY() {
		return y1;
	}

}
