package paint;

import java.awt.geom.Line2D;

public class Line {
	public static Line2D.Float drawLine(int x1, int y1, int x2, int y2) {
		return new Line2D.Float(x1, y1, x2, y2);
	}
}
