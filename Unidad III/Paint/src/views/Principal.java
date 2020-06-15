package views;

import javax.swing.JFrame;

public class Principal extends JFrame{
	
	public Principal() {
		setSize(800, 600);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		add(new SistemaControl());
	}
	
	public static void main(String[] args) {	
		new Principal().setVisible(true);
	}

}




