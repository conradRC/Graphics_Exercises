package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import Model.Punto;
import Model.Trazar;
import View.Interfaz;

public class ControllerInterfaz implements ActionListener {

	Trazar trazar;
	Interfaz i;
	int transformacion;

	public ControllerInterfaz(Interfaz i) {
		this.i = i;
		trazar = new Trazar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		ArrayList puntos = new ArrayList<>();
		Punto p = new Punto(0,0);
		if (command.equalsIgnoreCase("CHOOSED")) {
			transformacion = i.getTransformaciones();
			i.showChoosed(transformacion);
		}

		if (command.equalsIgnoreCase("DIBUJAR")) {
				trazar.loadWarning(i.getWarning());
				 puntos = trazar.dibujar(i.getPx(), i.getPy(), i.getWx(), i.getEdges());
				 p = trazar.getPoinst();
				i.getpPaint().dibujar(puntos, p);

			if (transformacion != 0) {
				switch (transformacion) {
				case 1:
					puntos =trazar.rotar(i.getTrans());
					i.getpPaint().dibujar(puntos, p);
					break;
				case 2:
					trazar.trasladar(i.getTrans(),i.getTrans2());
					break;
				case 3:
					trazar.escalar(i.getTrans(),i.getTrans2());
					break;
				case 4:
					trazar.sesgado(i.getTrans());
					break;
				default:
					break;
				}
			}
		}
		
		if(command.equalsIgnoreCase("CLEAR")) {
			i.getpPaint().dibujar();
		}
	}

}
