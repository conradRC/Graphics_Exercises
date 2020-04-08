package View;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

import View.Interfaz;
public class Paint {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Trazador de figuras geometricas");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.width * 0.7);
		int height = (int) (screenSize.height * 0.9);
		frame.setSize(width, height);
		frame.add(new Interfaz());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}








