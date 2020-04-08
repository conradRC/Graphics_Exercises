package View;

 import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interfaz extends JPanel {

	public Interfaz() {

	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		JFrame frame = new JFrame("");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.add(new Interfaz());
		frame.setVisible(true);
	}
}


