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


public class Menu extends JPanel {

	public Menu() {

		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		GridBagLayout gbl_panelLateral = new GridBagLayout();
		gbl_panelLateral.columnWidths = new int[]{61, 0};
		gbl_panelLateral.rowHeights = new int[]{29, 29, 29, 29, 29, 0};
		gbl_panelLateral.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelLateral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_panelLateral);
		
		JLabel lbRutas = new JLabel("Opciones");
		lbRutas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbRutas.setHorizontalAlignment(0);
		GridBagConstraints gbc_lbRutas = new GridBagConstraints();
		gbc_lbRutas.fill = GridBagConstraints.BOTH;
		gbc_lbRutas.insets = new Insets(0, 0, 5, 0);
		gbc_lbRutas.gridx = 0;
		gbc_lbRutas.gridy = 0;
		add(lbRutas, gbc_lbRutas);
		
		JButton btAgregar = new JButton("Add");
		btAgregar.setBackground(Color.WHITE);
		btAgregar.setIcon(new ImageIcon(SistemaControl.class.getResource("/Imagenes/Icons/agregar32.png")));
		btAgregar.setVerticalTextPosition(3);
		btAgregar.setHorizontalTextPosition(0);
		btAgregar.setBorder(null);
		btAgregar.setFocusable(false);
		GridBagConstraints gbc_btAgregar = new GridBagConstraints();
		gbc_btAgregar.fill = GridBagConstraints.BOTH;
		gbc_btAgregar.insets = new Insets(10, 0, 20, 0);
		gbc_btAgregar.gridx = 0;
		gbc_btAgregar.gridy = 1;
		add(btAgregar, gbc_btAgregar);
		
		JButton btRemover = new JButton("Delete");
		btRemover.setBackground(Color.WHITE);
		btRemover.setIcon(new ImageIcon(SistemaControl.class.getResource("/Imagenes/Icons/remover32.png")));
		btRemover.setVerticalTextPosition(3);
		btRemover.setHorizontalTextPosition(0);
		btRemover.setBorder(null);
		btRemover.setFocusable(false);
		GridBagConstraints gbc_btRemover = new GridBagConstraints();
		gbc_btRemover.fill = GridBagConstraints.BOTH;
		gbc_btRemover.insets = new Insets(0, 0, 20, 0);
		gbc_btRemover.gridx = 0;
		gbc_btRemover.gridy = 2;
		add(btRemover, gbc_btRemover);
		
		JButton btEditar = new JButton("Move");
		btEditar.setBackground(Color.WHITE);
		btEditar.setIcon(new ImageIcon(SistemaControl.class.getResource("/Imagenes/Icons/mover32.png")));
		btEditar.setVerticalTextPosition(3);
		btEditar.setHorizontalTextPosition(0);
		btEditar.setBorder(null);
		btEditar.setFocusable(false);
		GridBagConstraints gbc_btEditar = new GridBagConstraints();
		gbc_btEditar.fill = GridBagConstraints.BOTH;
		gbc_btEditar.insets = new Insets(0, 0, 20, 0);
		gbc_btEditar.gridx = 0;
		gbc_btEditar.gridy = 3;
		add(btEditar, gbc_btEditar);
		
		
		//ControlLateral control = new ControlLateral();
		//btRemover.addActionListener(control);
	}

}
