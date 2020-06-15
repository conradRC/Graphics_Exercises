package paint;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawRectangle implements IFigures {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private Color color;

	public DrawRectangle(int x, int y, int ancho, int alto, Color color) {
		this.x= x;
		this.y=y;
		this.ancho = ancho;
		this.alto = alto;
		this.color = color;
	}

	@Override
	public void setPosicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void paint_figure(Graphics2D g) {
		g.setColor(color);
		g.drawRect(x, y, ancho, alto);;
	}

	@Override
	public boolean fInside(int x, int y) {
		if ((x > this.x) && (x < (this.x + ancho)) && (y > this.y) && (y < (this.y + alto)))
			return true;
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void setColor(Color color) {}
}
