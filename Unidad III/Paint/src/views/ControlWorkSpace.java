package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.ControlLateral;
import paint.Draw;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class ControlWorkSpace extends JPanel {
	Draw draw;
	JButton btAgregar, btRemover, btnMove, btnColor;
	private JPanel panelSuperior;
	private JButton Rectangulo;
	private JButton btnLinea;
	private JLabel lblFiguras;
	public ControlWorkSpace() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths 	= new int[]{80};
		gridBagLayout.rowHeights 	= new int[]{60};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowWeights 	= new double[]{0.0, 1.0};
		setLayout(gridBagLayout);
		
		panelSuperior = new JPanel();
		panelSuperior.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSuperior.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelSuperior = new GridBagConstraints();
		gbc_panelSuperior.gridwidth = 2;
		gbc_panelSuperior.insets = new Insets(5, 10, 5, 10);
		gbc_panelSuperior.fill = GridBagConstraints.BOTH;
		gbc_panelSuperior.gridx = 0;
		gbc_panelSuperior.gridy = 0;
		add(panelSuperior, gbc_panelSuperior);
		GridBagLayout gbl_panelSuperior = new GridBagLayout();
		gbl_panelSuperior.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelSuperior.rowHeights = new int[]{0, 0, 0};
		gbl_panelSuperior.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelSuperior.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelSuperior.setLayout(gbl_panelSuperior);
		
		JPanel panelLateral = new JPanel();
		menu(panelLateral);
		GridBagConstraints gbcPanelLateral = new GridBagConstraints();
		gbcPanelLateral.fill = GridBagConstraints.BOTH;
		gbcPanelLateral.insets = new Insets(0, 10, 10, 5);
		gbcPanelLateral.gridx = 0;
		gbcPanelLateral.gridy = 1;
		add(panelLateral, gbcPanelLateral);
		
		lblFiguras = new JLabel("Figuras");
		lblFiguras.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiguras.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblFiguras.setBackground(SystemColor.menu);
		GridBagConstraints gbc_lblFiguras = new GridBagConstraints();
		gbc_lblFiguras.fill = GridBagConstraints.BOTH;
		gbc_lblFiguras.insets = new Insets(0, 0, 5, 0);
		gbc_lblFiguras.gridx = 0;
		gbc_lblFiguras.gridy = 4;
		panelLateral.add(lblFiguras, gbc_lblFiguras);
		
		Rectangulo = new JButton("Rectangulo");
		Rectangulo.setVerticalTextPosition(SwingConstants.BOTTOM);
		Rectangulo.setHorizontalTextPosition(SwingConstants.CENTER);
		Rectangulo.setFocusable(false);
		Rectangulo.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		Rectangulo.setBackground(Color.WHITE);
		Rectangulo.setActionCommand("MOVE");
		GridBagConstraints gbc_Rectangulo = new GridBagConstraints();
		gbc_Rectangulo.insets = new Insets(10, 0, 10, 0);
		gbc_Rectangulo.fill = GridBagConstraints.BOTH;
		gbc_Rectangulo.gridx = 0;
		gbc_Rectangulo.gridy = 5;
		panelLateral.add(Rectangulo, gbc_Rectangulo);
		
		btnLinea = new JButton("Linea");
		btnLinea.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLinea.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLinea.setFocusable(false);
		btnLinea.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnLinea.setBackground(Color.WHITE);
		btnLinea.setActionCommand("MOVE");
		GridBagConstraints gbc_btnLinea = new GridBagConstraints();
		gbc_btnLinea.fill = GridBagConstraints.BOTH;
		gbc_btnLinea.gridx = 0;
		gbc_btnLinea.gridy = 6;
		panelLateral.add(btnLinea, gbc_btnLinea);
		
		JPanel panelCentral = new JPanel();
		draw = new Draw();
		draw.setBorder(new LineBorder(Color.black));
		draw.setBackground(Color.WHITE);
		ControlLateral control = new ControlLateral(draw);
		conecta(control);
		panelCentral.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		GridBagConstraints gbcPanelCentral = new GridBagConstraints();
		gbcPanelCentral.insets = new Insets(0, 0, 10, 10);
		gbcPanelCentral.fill = GridBagConstraints.BOTH;
		gbcPanelCentral.gridx = 1;
		gbcPanelCentral.gridy = 1;
		add(draw, gbcPanelCentral);
	}
	
	public void menu (JPanel p) {
		p.setBackground(Color.WHITE);
		p.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		GridBagLayout gbl_panelLateral = new GridBagLayout();
		gbl_panelLateral.columnWidths = new int[]{61, 0};
		gbl_panelLateral.rowHeights = new int[]{29, 29, 29, 29, 0, 48, 30, 0};
		gbl_panelLateral.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelLateral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		p.setLayout(gbl_panelLateral);
		
		JLabel lbRutas = new JLabel("Opciones");
		lbRutas.setBackground(SystemColor.inactiveCaption);
		lbRutas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbRutas.setHorizontalAlignment(0);
		GridBagConstraints gbc_lbRutas = new GridBagConstraints();
		gbc_lbRutas.fill = GridBagConstraints.BOTH;
		gbc_lbRutas.insets = new Insets(0, 0, 5, 0);
		gbc_lbRutas.gridx = 0;
		gbc_lbRutas.gridy = 0;
		p.add(lbRutas, gbc_lbRutas);
		
		btAgregar = new JButton("Agregar");
		btAgregar.setBackground(Color.WHITE);
		btAgregar.setIcon(new ImageIcon(ControlWorkSpace.class.getResource("/Imagenes/Icons/agregar32.png")));
		btAgregar.setVerticalTextPosition(3);
		btAgregar.setHorizontalTextPosition(0);
		btAgregar.setBorder(null);
		btAgregar.setFocusable(false);
		GridBagConstraints gbc_btAgregar = new GridBagConstraints();
		gbc_btAgregar.fill = GridBagConstraints.BOTH;
		gbc_btAgregar.insets = new Insets(10, 0, 20, 0);
		gbc_btAgregar.gridx = 0;
		gbc_btAgregar.gridy = 1;
		p.add(btAgregar, gbc_btAgregar);
		
		btRemover = new JButton("Eliminar");
		btRemover.setBackground(Color.WHITE);
		btRemover.setIcon(new ImageIcon(ControlWorkSpace.class.getResource("/Imagenes/Icons/remover32.png")));
		btRemover.setVerticalTextPosition(3);
		btRemover.setHorizontalTextPosition(0);
		btRemover.setBorder(null);
		btRemover.setFocusable(false);
		GridBagConstraints gbc_btRemover = new GridBagConstraints();
		gbc_btRemover.fill = GridBagConstraints.BOTH;
		gbc_btRemover.insets = new Insets(0, 0, 20, 0);
		gbc_btRemover.gridx = 0;
		gbc_btRemover.gridy = 2;
		p.add(btRemover, gbc_btRemover);
		
		btnMove = new JButton("Mover");
		btnMove.setBackground(Color.WHITE);
		btnMove.setIcon(new ImageIcon(ControlWorkSpace.class.getResource("/Imagenes/Icons/mover32.png")));
		btnMove.setVerticalTextPosition(3);
		btnMove.setHorizontalTextPosition(0);
		btnMove.setBorder(null);
		btnMove.setFocusable(false);
		GridBagConstraints gbc_btnMove = new GridBagConstraints();
		gbc_btnMove.fill = GridBagConstraints.BOTH;
		gbc_btnMove.insets = new Insets(0, 0, 40, 0);
		gbc_btnMove.gridx = 0;
		gbc_btnMove.gridy = 3;
		p.add(btnMove, gbc_btnMove);
		
	}
	
	public void conecta(ControlLateral control) {
		btRemover.addActionListener(control);
		btRemover.setActionCommand("DELETE");
		btnMove.addActionListener(control);
		btnMove.setActionCommand("MOVE");
		btAgregar.addActionListener(control);
		btAgregar.setActionCommand("ADD");
		btnLinea.addActionListener(control);
		btnLinea.setActionCommand("LINEA");
		Rectangulo.addActionListener(control);
		Rectangulo.setActionCommand("RECTANGULO");
	}

}
