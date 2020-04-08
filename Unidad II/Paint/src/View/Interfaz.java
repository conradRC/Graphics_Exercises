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

public class Interfaz extends JPanel {
	private JTextField px;
	private JTextField py;
	private JTextField wx;
	private JTextField hy;
	private JTextField edges;
	private JPanel container_Head;
	static JLabel warning;
	PanelPaint pPaint;
	private JButton btnAceptar;

	private ComponentDesing pPosition,pSize,pEdges;
	
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

		px = new JTextField();
		py = new JTextField();
		wx = new JTextField();
		hy = new JTextField();
		edges = new JTextField();
		
		pPosition = new ComponentDesing("COORDENADAS: ", 100, px, py);
		container_Head.add(pPosition);

		pSize = new ComponentDesing("TAMAÑO: ", 60, wx);
		container_Head.add(pSize);

		pEdges = new ComponentDesing("ARISTAS: ", 60, edges);
		container_Head.add(pEdges);

		btnAceptar = new JButton("Aceptar");

		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(Color.BLACK);
		container_Head.add(btnAceptar);
		
		ControllerInterfaz c = new ControllerInterfaz(this);
		btnAceptar.addActionListener(c);
		btnAceptar.setActionCommand("DIBUJAR");
		
		warning = new JLabel("");
		warning.setHorizontalAlignment(SwingConstants.CENTER);
		warning.setOpaque(true);
		warning.setForeground(Color.BLACK);
		warning.setBackground(Color.WHITE);
		container_Value.add(warning, BorderLayout.SOUTH);
	}
	
	public PanelPaint getpPaint() {
		return pPaint;
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
	
}
