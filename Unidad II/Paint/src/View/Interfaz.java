package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Component.ComponentDesing;
import Controller.ControllerInterfaz;
import javax.swing.JComboBox;

public class Interfaz extends JPanel {
	private JTextField px;
	private JTextField py;
	private JTextField wx;
	private JTextField hy;
	private JTextField edges;
	private JTextField trans,trans2;
	private JPanel container_Head;
	static JLabel warning;
	PanelPaint pPaint;
	private JButton btnAceptar;

	private ComponentDesing pPosition, pSize, pEdges, transf;
	private JComboBox<String> transformaciones;
	private JPanel pReserved;
	private JLabel label;
	private JButton btClear;

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
		pPaint = new PanelPaint();
		pPaint.setBackground(new Color(248, 248, 255));
		add(pPaint, BorderLayout.CENTER);
	}

	public void initControlLeft() {
		JPanel container_Value = new JPanel();
		add(container_Value, BorderLayout.NORTH);
		container_Value.setLayout(new BorderLayout(0, 0));

		container_Head = new JPanel();
		container_Head.setBackground(Color.WHITE);

		container_Value.add(container_Head, BorderLayout.NORTH);
		container_Head.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));

		px = new JTextField("-200");
		py = new JTextField("50");
		wx = new JTextField("100");
		hy = new JTextField("10");
		edges = new JTextField("4");
		trans = new JTextField();
		trans2 = new JTextField();
		pPosition = new ComponentDesing("COORDENADAS: ", 100, px, py);
		container_Head.add(pPosition);

		pSize = new ComponentDesing("TAMAÑO: ", 60, wx);
		container_Head.add(pSize);

		pEdges = new ComponentDesing("ARISTAS: ", 60, edges);
		container_Head.add(pEdges);

		transformaciones = new JComboBox<String>();
		transformaciones.setEditable(true);
		transformaciones.setBackground(Color.WHITE);
		transformaciones.setMaximumRowCount(55);

		transformaciones.addItem("NONE");
		transformaciones.addItem("ROTAR");
		transformaciones.addItem("TRASLADAR");
		transformaciones.addItem("ESCALADO");
		transformaciones.addItem("SESGADO");

		container_Head.add(transformaciones);
		
		pReserved = new JPanel();
		pReserved.setBackground(Color.WHITE);
		container_Head.add(pReserved);
		pReserved.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAceptar = new JButton("DIBUJAR");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(Color.BLACK);
		container_Head.add(btnAceptar);

		ControllerInterfaz c = new ControllerInterfaz(this);
		btnAceptar.addActionListener(c);
		btnAceptar.setActionCommand("DIBUJAR");
		transformaciones.addActionListener(c);
		transformaciones.setActionCommand("CHOOSED");
		
		btClear = new JButton("BORRAR");
		btClear.setForeground(Color.WHITE);
		btClear.setBackground(Color.BLACK);
		btClear.addActionListener(c);
		btClear.setActionCommand("CLEAR");
		container_Head.add(btClear);
		
		warning = new JLabel("");
		warning.setHorizontalAlignment(SwingConstants.CENTER);
		warning.setOpaque(true);
		warning.setForeground(Color.BLACK);
		warning.setBackground(Color.WHITE);
		container_Value.add(warning, BorderLayout.SOUTH);
	}

	public void showChoosed(int key) {
		trans.setText("");
		trans2.setText("");
		pReserved.removeAll();
		switch (key) {
		case 1:
			transf = new ComponentDesing(5, trans);
			pReserved.add(transf);
			break;
		case 2:
			transf = new ComponentDesing(5, trans,trans2);
			pReserved.add(transf);
			break;
		case 3:
			transf = new ComponentDesing(5, trans,trans2);
			pReserved.add(transf);
			break;
			
		case 4:
			transf = new ComponentDesing(5, trans);
			pReserved.add(transf);
			break;
		default:
			break;
		}
		
		updateUI();
	}

	public PanelPaint getpPaint() {
		return pPaint;
	}

	public int getTransformaciones() {
		return transformaciones.getSelectedIndex();
	}

	public static JLabel getWarning() {
		return warning;
	}

	public JTextField getPx() {
		return px;
	}

	public JTextField getPy() {
		return py;
	}

	public JTextField getWx() {
		return wx;
	}

	public JTextField getHy() {
		return hy;
	}

	public JTextField getEdges() {
		return edges;
	}

	public JTextField getTrans() {
		return trans;
	}
	
	public JTextField getTrans2() {
		return trans2;
	}

	
}
