package paint;

import java.awt.Color;
import java.awt.Graphics2D;

public interface IFigures {
	public void dibujate(Graphics2D g);
	
	public boolean fInside(int x, int y);

	public void setPosicion(int x, int y);
	
	public void setColor(Color color);
	
	public int getX();

	public int getY();
}
