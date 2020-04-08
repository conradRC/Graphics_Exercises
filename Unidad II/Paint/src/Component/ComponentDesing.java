package Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import View.View_Styles;

public class ComponentDesing extends JPanel{
	
	public  ComponentDesing(String name_function, int width, JTextField one, JTextField two) {
		
		FlowLayout fl_p = new FlowLayout();
		fl_p.setHgap(0);
		fl_p.setAlignment(FlowLayout.LEFT);
		fl_p.setVgap(0);
		setLayout(fl_p);
		setBackground(Color.WHITE);

		JLabel label = new JLabel(name_function);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(label);
		
		View_Styles.styles_Input(one);
		View_Styles.styles_Input(two);
		View_Styles.styles_Label(label, width);

		add(one);
		add(two);
	}

	public ComponentDesing(String name_function, int width, JTextField one) {
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);

		JLabel label = new JLabel(name_function);
		add(label);

		View_Styles.styles_Input(one);
		View_Styles.styles_Label(label, width);

		add(one);
	}
}
