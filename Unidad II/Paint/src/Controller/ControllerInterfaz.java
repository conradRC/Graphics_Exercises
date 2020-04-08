package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import Model.Punto;
import Model.Trazar;
import View.Interfaz;

public class ControllerInterfaz implements ActionListener{
 
	Trazar trazar;
	Interfaz i;
	public ControllerInterfaz(Interfaz i) {
		this.i=i;
		trazar = new Trazar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando  = e.getActionCommand();
		trazar.loadWarning(i.getWarning());
		ArrayList puntos;
		
		switch (comando) {
		case "DIBUJAR":
			 
			puntos =trazar.dibujar(i.getPx(),i.getPy(),i.getWx(),i.getEdges());
			Punto p =trazar.getPoinst();
			i.getpPaint().dibujar(puntos,p);
			break;
		case "ROTAR":
			
			break;
		case "TRASLADAR":
			
			break;
		case "ESCALADO":
			
			break;
		case "SESGADO":
			
			break;
		case "BORRAR":
			
			break;
		case "LIMPIAR":
			
			break;
		case "CERRAR":
			 
			break;
		default:
			break;
		}
	}
	
}
