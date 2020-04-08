package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Interfaz extends JPanel {
	private JTextField px;
	private JTextField py;
	private JTextField wx;
	private JTextField hy;
	private JTextField edges;
	private JPanel container_Head;
	PanelPaint pPaint;
	
	public Interfaz() {
		setLayout(new BorderLayout());
		setBackground(new Color(30, 30, 30));
		initComponents();
	}

	public void initComponents() {
		initControlLeft();
		initWork();
	}

	public void initWork() {
		pPaint     = new PanelPaint(201,0);
		pPaint.setBackground(new Color(248, 248, 255));
		add(pPaint, BorderLayout.CENTER);
	}

	public void initControlLeft() {
		JPanel container_Value = new JPanel();

		GridLayout gl_container_Value = new GridLayout(0, 1);
		container_Value.setLayout(gl_container_Value);
		add(container_Value, BorderLayout.NORTH);

		container_Head = new JPanel();
		container_Head.setBackground(Color.WHITE);

		container_Value.add(container_Head);
		container_Head.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
		
		JPanel pPosition= components("COORDENADAS: ",100, px,py);
		container_Head.add(pPosition);
		
		JPanel pSize= components("TAMAÑO: ",60, wx,hy);
		container_Head.add(pSize);
		
		JPanel pEdges= components("ARISTAS: ",60, edges);
		container_Head.add(pEdges);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(Color.BLACK);
		container_Head.add(btnAceptar);
	}

	public JPanel components(String name_function,int width, JTextField one, JTextField two) {
		JPanel p = new JPanel();
		FlowLayout fl_p = new FlowLayout();
		fl_p.setHgap(0);
		fl_p.setAlignment(FlowLayout.LEFT);
		fl_p.setVgap(0);
		p.setLayout(fl_p);
		p.setBackground(Color.WHITE);

		JLabel label = new JLabel(name_function);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setAlignmentX(Component.RIGHT_ALIGNMENT);
		p.add(label);

		one = new JTextField();
		two = new JTextField();
		
		View_Styles.styles_Input(one);
		View_Styles.styles_Input(two);
		View_Styles.styles_Label(label,width);
		
		p.add(one);
		p.add(two);
		
		return p;
	}

	
	public JPanel components(String name_function,int width, JTextField one) {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.setBackground(Color.WHITE);
		
		JLabel label = new JLabel(name_function);
		p.add(label);

		one = new JTextField();
		
		View_Styles.styles_Input(one);
		View_Styles.styles_Label(label,width);
		
		p.add(one);
		
		return p;
	}

	public void conect_controller(Controller control) {

	}
}
