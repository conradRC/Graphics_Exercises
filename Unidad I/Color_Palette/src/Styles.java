import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Styles {
	
	
	public static void styles_Panel(JPanel panel) {
		Color bg_panel = new Color(245, 245, 245);
		panel.setBackground(bg_panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	public static void styles_Input(JTextField txt) {
		txt.setPreferredSize(new Dimension(6, 23));
    	txt.setAlignmentY(Component.BOTTOM_ALIGNMENT);
    	txt.setColumns(3);
    	txt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
	}
	public static void styles_Input(JTextField txt, int columns) {
		txt.setPreferredSize(new Dimension(6, 23));
    	txt.setAlignmentY(Component.BOTTOM_ALIGNMENT);
    	txt.setColumns(columns);
    	txt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
	}
}

