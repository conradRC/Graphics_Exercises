import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	Palette vista;

	public Controller(Palette vista) {
		this.vista = vista;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		String warning = "Valores introducidos no validos, rango aceptado (0-255)";
		if (e.getSource() == vista.getTxtHex()) {
			if(!vista.getTxtHex().getText().isEmpty()) {
				String h = vista.getTxtHex().getText();
				
				if(Model.regex(h) && h.length()==6) {
					int [] array= Model.converToDecimal(h);
					System.out.println(array[0] + " - " + array[1] + " :" + array[2] );
					vista.getWarning().setText("");
					vista.getTxtR().setText(""+array[0]);
					vista.getTxtG().setText(""+array[1]);
					vista.getTxtB().setText(""+array[2]);
					vista.addTonos(array[0],array[1],array[2]);
					vista.updateUI();
					
				}
				else {
					vista.getWarning().setText("  Valor hexadecimal no v�lido, solo n�meros y letras en el rango (A-F) con una longitud igual a 6 ");
				}
			}
		}
		else {

		if (!(vista.getTxtR().getText().isEmpty() || vista.getTxtG().getText().isEmpty() || vista.getTxtB().getText().isEmpty())) {
			String x = vista.getTxtR().getText();
			String y = vista.getTxtG().getText();
			String z = vista.getTxtB().getText();
			
			try {
				int r = Integer.parseInt(x);
				int g = Integer.parseInt(y);
				int b = Integer.parseInt(z);

				if (Model.isValid(r) || Model.isValid(g) || Model.isValid(b)) {
					vista.getWarning().setText("");
					String colorH= Model.convertToHex(r,g,b);
					vista.getTxtHex().setText(colorH);
					vista.addTonos(r, g, b);
					vista.updateUI();
				} else {
					vista.getWarning().setText("  " + warning);
				}
			} catch (Exception ex) {
				vista.getWarning().setText(" " + warning);
			}
		}
		}
		
	}
}
