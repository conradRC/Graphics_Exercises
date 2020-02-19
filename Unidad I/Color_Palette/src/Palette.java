import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Palette extends JPanel {
	private JPanel container_Head;
	private JPanel color_selected;
	private JLabel warning;
	private JTextField txtR;
	private JTextField txtG;
	private JTextField txtB;
	private JTextField txtHex;
	private JPanel container_Colors;
	private static int quantity;

	public Palette() {
		quantity = 15;	
		setLayout(new BorderLayout(30, 40));
		setBackground(new Color(30, 30, 30));
		initComponents();
	}

	public void initComponents() {
		JPanel palette_Container = new Border_Radius(35, Color.WHITE);
		JPanel container_Value = new JPanel();
		JSeparator separator_left = new JSeparator();
		JSeparator separator_rigth = new JSeparator();
		JSeparator separator_down = new JSeparator();
		
		container_Head = new JPanel();
		container_Colors = new JPanel();
		container_Head.setBackground(Color.WHITE);
		container_Colors.setLayout(new GridLayout(0, quantity));
		container_Value.setLayout(new GridLayout(0, 1));
		container_Head.setLayout(new GridLayout(2, 0, 0, 2));
		
		JPanel control_panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) control_panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		control_panel.setBackground(Color.WHITE);
		container_Head.add(control_panel);
		
		JLabel lbRGB = new JLabel("RBG: ");
		JLabel lbHex = new JLabel("HEX:  #");
		
		txtHex = new JTextField("BE1E43");
		txtR = new JTextField("190");
		txtG = new JTextField("30");
		txtB = new JTextField("67");
		
		control_panel.add(lbRGB);
		control_panel.add(txtR);
		control_panel.add(txtG);
		control_panel.add(txtB);
		control_panel.add(lbHex);
		control_panel.add(txtHex);
		
		
		lbRGB.setForeground(Color.GRAY);
		lbHex.setForeground(Color.GRAY);
		
		View_Styles.styles_Input(txtR);
		View_Styles.styles_Input(txtG);
		View_Styles.styles_Input(txtB);
		View_Styles.styles_Input(txtHex,5);
		
		warning = new JLabel("");
		container_Head.add(warning);
		container_Value.add(container_Head);
		
		palette_Container.setLayout(View_positions.gbl_palette_Container());
		
		add(separator_left, BorderLayout.WEST);
		add(separator_rigth, BorderLayout.EAST);
		add(separator_down, BorderLayout.SOUTH);
		add(container_Value, BorderLayout.NORTH);
		add(palette_Container, BorderLayout.CENTER);	
		
		JPanel container_Tonos = new JPanel();
		container_Tonos.setLayout(new BorderLayout());
		
		palette_Container.add(container_Tonos, View_positions.gbc_container_Colors());
		
		color_selected = new JPanel();
		color_selected.setPreferredSize(new Dimension(10, 70));
		container_Tonos.add(color_selected, BorderLayout.NORTH);
		container_Tonos.add(container_Colors, BorderLayout.CENTER);
		addTonos(190,30,67);
	}

	
	public void addTonos(int r, int g, int b) {
		container_Colors.removeAll();
		color_selected.setBackground(new Color(r,g,b));
		int s=r, t=g, u=b;
		int change=10;
		Stack<Color> blackColors = new Stack<Color>();
		for (int i = 0; i < quantity/2; i++) {
			s= black_Color(s,change);
			t= black_Color(t,change);
			u= black_Color(u,change);
			blackColors.push(new Color(s,t,u)); 
		}
		
		
		for (int i = 0; i < quantity; i++) {
			if(i<quantity/2) {
				Color c = blackColors.pop();
				int r1= c.getRed();
				int g1= c.getGreen();
				int b1= c.getBlue();
				String colorH= Model.convertToHex(r1,g1,b1);
				JPanel one_tono = tono(colorH, new Color(r1, g1, b1));	
				container_Colors.add(one_tono);
				
			}
			else {
				String colorH= Model.convertToHex(r,g,b);
				JPanel one_tono = tono(colorH, new Color(r, g, b));	
				container_Colors.add(one_tono);
				r = white(r,change);
				g = white(g,change);
				b = white(b,change);
			}
			
			
		}
	}
	

	
	public int white(int a, int change) {
		return a = (a > 255 - change) ? a = 255 : a + change;
	}
	
	public int black_Color(int a, int change) {		
		return a = (a < change) ? a : a - change;
	}

	public static int getQuantity() {
		return quantity;
	}
	
	public JPanel tono(String name_Color, Color backColor){
		JLabel lbColor = new JLabel(name_Color);
		JPanel container = new JPanel();
		
		container.setLayout(new BorderLayout());
		container.setBackground(backColor);
		
		View_Styles.styles_Label(lbColor);
		container.add(lbColor, BorderLayout.NORTH);
		return container;
	}

	public void conect_controller(Controller control) {
		txtR.addKeyListener(control);
		txtG.addKeyListener(control);
		txtB.addKeyListener(control);
		txtHex.addKeyListener(control);
	}	

	public JLabel getWarning() {
		return warning;
	}
	
	public JTextField getTxtR() {
		return txtR;
	}

	public JTextField getTxtG() {
		return txtG;
	}

	public JTextField getTxtB() {
		return txtB;
	}

	public JTextField getTxtHex() {
		return txtHex;
	}
}
