package Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComponentDesing extends JPanel{
	
	public ComponentDesing() {
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		
		ComponentDesing c = new ComponentDesing();
		
		frame.add(c);
		frame.setVisible(true);
	}

}
