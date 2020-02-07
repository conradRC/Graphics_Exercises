
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Palette extends JPanel {
	private JPanel palette_Container;
	private JPanel panel_RGB;
	private JPanel panel_HEX;
	private JPanel container_Value;

	private JTextField txtR;
	private JTextField txtG;
	private JTextField txtB;
	private JTextField txtHex;
	public Palette() {
		setBackground(new Color(245, 245, 245));
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };

		initComponents();
	}

	
	public void initComponents() {

		JLabel lbHex = new JLabel("HEX: ");
		JLabel lbRGB = new JLabel("RBG: ");

		palette_Container = new Border_Radius(25, Color.WHITE);
		container_Value = new JPanel();
		panel_RGB = new JPanel();
		panel_HEX = new JPanel();
		txtR = new JTextField();
		txtG = new JTextField();
		txtB = new JTextField();
		txtHex = new JTextField();

		/* Styles */
		Styles.styles_Panel(panel_RGB);
		Styles.styles_Panel(panel_HEX);
		Styles.styles_Input(txtR);
		Styles.styles_Input(txtG);
		Styles.styles_Input(txtB);
		Styles.styles_Input(txtHex, 10);

		panel_RGB.add(lbRGB);
		panel_HEX.add(lbHex);

		panel_RGB.add(txtR);
		panel_RGB.add(txtG);
		panel_RGB.add(txtB);
		panel_HEX.add(txtHex);

		container_Value.add(panel_RGB);
		container_Value.add(panel_HEX);
		container_Value.setLayout(new GridLayout(0, 1));
		
		add(palette_Container, gbc_container_Palette());
		add(container_Value, gbc_panel_value());
	}
	
	

	public GridBagConstraints gbc_panel_value() {
		GridBagConstraints gbc_container_Value = new GridBagConstraints();
		gbc_container_Value.insets = new Insets(10, 10, 5, 5);
		gbc_container_Value.gridwidth = 2;
		gbc_container_Value.fill = GridBagConstraints.BOTH;
		return gbc_container_Value;
	}

	public GridBagConstraints gbc_container_Palette() {
		GridBagConstraints gbc_container_Colors = new GridBagConstraints();
		gbc_container_Colors.insets = new Insets(20, 15, 40, 15);
		gbc_container_Colors.gridwidth = 2;
		gbc_container_Colors.gridy = 1;
		gbc_container_Colors.fill = GridBagConstraints.BOTH;
		return gbc_container_Colors;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Cruz Mejía Conrado");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setMinimumSize(new Dimension(450, 300));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(new Palette());
		frame.setVisible(true);
	}
}
