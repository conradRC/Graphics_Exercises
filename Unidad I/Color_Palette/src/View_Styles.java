import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class View_Styles {
	
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
	
	public static void styles_Label(JLabel label) {
		label.setPreferredSize(new Dimension(50, 50));
		label.setFont(new Font("Arial", Font.PLAIN, 11));
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setOpaque(true);
	}
}

