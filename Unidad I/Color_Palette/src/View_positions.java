import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class View_positions {

	public static GridBagLayout gbl_palette_Container() {
		GridBagLayout gbl_palette_Container = new GridBagLayout();
		gbl_palette_Container.rowWeights = new double[] { 1.0 };
		gbl_palette_Container.columnWeights = new double[] { 1.0 };
		return gbl_palette_Container;
	}

	public static GridBagConstraints gbc_container_Colors() {
		GridBagConstraints gbc_container_Colors = new GridBagConstraints();
		gbc_container_Colors.gridx = 0;
		gbc_container_Colors.gridy = 0;
		gbc_container_Colors.insets = new Insets(15, 0, 25, 0);
		gbc_container_Colors.fill = GridBagConstraints.BOTH;
		return gbc_container_Colors;
	}
}
