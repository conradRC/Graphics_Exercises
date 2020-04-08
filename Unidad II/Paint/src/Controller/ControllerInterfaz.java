package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Trazar;
import View.Interfaz;

public class ControllerInterfaz implements ActionListener{
 
	Trazar trazar;
	Interfaz i;
	public ControllerInterfaz(Interfaz i) {
		this.i=i;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando  = e.getActionCommand();
		trazar = new Trazar();
		int wx = 30;
		int hy = 30;
		int aristas = 4;
		ArrayList puntos;
		System.out.println(comando);
		switch (comando) {
		case "DIBUJAR":
			puntos = trazar.dibujar();
			i.getpPaint().dibujar(puntos);
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
