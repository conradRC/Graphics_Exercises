package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import paint.Draw;

public class SistemaControl extends JPanel {

	public SistemaControl() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths 	= new int[]{80};
		gridBagLayout.rowHeights 	= new int[]{60};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowWeights 	= new double[]{0.0, 1.0};
		setLayout(gridBagLayout);
		
		Menu panelLateral = new Menu();
		
		GridBagConstraints gbcPanelLateral = new GridBagConstraints();
		gbcPanelLateral.fill = GridBagConstraints.BOTH;
		gbcPanelLateral.insets = new Insets(0, 10, 10, 5);
		gbcPanelLateral.gridx = 0;
		gbcPanelLateral.gridy = 1;
		add(panelLateral, gbcPanelLateral);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		GridBagConstraints gbcPanelCentral = new GridBagConstraints();
		gbcPanelCentral.insets = new Insets(0, 0, 10, 10);
		gbcPanelCentral.fill = GridBagConstraints.BOTH;
		gbcPanelCentral.gridx = 1;
		gbcPanelCentral.gridy = 1;
		add(new Draw(), gbcPanelCentral);
		
	}

}
