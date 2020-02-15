import java.awt.Dimension;

import javax.swing.JFrame;

public class Cliente {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Cruz Mejía Conrado");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);
		Palette p = new Palette();
		Controller c = new Controller(p);
		p.conect_controller(c);
		frame.setMinimumSize(new Dimension(900, 300));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(p);
		frame.setVisible(true);
	}
}
