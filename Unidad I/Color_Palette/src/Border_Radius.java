import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Border_Radius extends JPanel {
	private Color backgroundColor;
	private int cornerRadius;

	public Border_Radius(int radius, Color color) {
		cornerRadius = radius;
		backgroundColor = color;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Dimension dimension = new Dimension(cornerRadius, cornerRadius);
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (backgroundColor != null)
			graphics.setColor(backgroundColor);
		else
		graphics.setColor(getBackground());// paint background
		graphics.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, dimension.width, dimension.height); 
		graphics.setColor(Color.white);// paint border
		graphics.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, dimension.width, dimension.height); 
	}
}
