package Model;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import View.PanelPaint;

public class Trazar{
	private Punto tp, auxp;
	boolean dibujo = false, btrasladar = false;
	float x, y, tx, ty, ttx, tty, b, t1, t2;
	ArrayList puntos;
	ListIterator iterador;
	String figuraActual;
	PanelPaint pPaint;


	public ArrayList dibujar() {
		try {
			tp = new Punto(0, 0);
			puntos = trazarPol();
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Inserta x,y y el numero de aristas");
		}
		return puntos;
	}

	public void rotar() {
		if (dibujo == false)
			puntos = trazarPol();
		try {
			double ang = Math.toRadians(Float.parseFloat(JOptionPane.showInputDialog("Angulo a rotar:")));
			String inf = JOptionPane.showInputDialog("¿Girar sobre su centro?[S][N]");
			if (inf.equals("N")) {
				x = Float.parseFloat(JOptionPane.showInputDialog("Coordenada en X:"));
				y = Float.parseFloat(JOptionPane.showInputDialog("Coordenada en Y :")) * -1;
				tp = new Punto(x, y);
			} else
				tp = new Punto(ttx, tty);

			iterador = puntos.listIterator();
			if (btrasladar == true) {
				/** generamos los nuevos puntos */
				while (iterador.hasNext()) {
					auxp = (Punto) iterador.next();
					iterador.set(new Punto(auxp.getX() - tx, auxp.getY() - ty));
				}
				btrasladar = false;
			}
			puntos = Transformar.rotar(puntos, ang);
			pPaint.dibujar(puntos, tp);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ingrese nuevamente los datos correctamente");
		}
	}

	public void trasladar() {
		if (dibujo == false)
			puntos = trazarPol();
		try {
			tx = Float.parseFloat(JOptionPane.showInputDialog("Traslacion en x"));
			ty = Float.parseFloat(JOptionPane.showInputDialog("Traslacion en y")) * -1;
			puntos = Transformar.trasladar(puntos, tx, ty);
			pPaint.dibujar(puntos);
			btrasladar = true;
			ttx = tx + ttx;
			tty = ty + tty;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ingrese nuevamente los datos correctamente");
		}
	}

	public void sesgado() {
		if (dibujo == false)
			puntos = trazarPol();
		try {
			b = Float.parseFloat(JOptionPane.showInputDialog("Grado de Sesgado "));
			puntos = Transformar.sesgar(puntos, b);
			pPaint.dibujar(puntos);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ingrese nuevamente los datos correctamente");
		}
	}

	public void escalar() {
		if (dibujo == false)
			puntos = trazarPol();
		try {
			t1 = Float.parseFloat(JOptionPane.showInputDialog("Escala en x"));
			t2 = Float.parseFloat(JOptionPane.showInputDialog("Escala en y")) * -1;
			puntos = Transformar.escalar(puntos, t1, t2);
			pPaint.dibujar(puntos);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ingrese nuevamente los datos correctamente");
		}
	}

	public void limpiar() {
		if (dibujo == true)
			puntos = trazarPol();
	}

	public ArrayList trazarPol() {
		x = Float.parseFloat(JOptionPane.showInputDialog("Coordenada en x"));
		y = Float.parseFloat(JOptionPane.showInputDialog("Coordenada en y")) * -1;
		int nAristas = Integer.parseInt(JOptionPane.showInputDialog("Numero de aristas:"));
		puntos = Transformar.trazarPol(x, y, nAristas);
		dibujo = true;
		return puntos;
	}
}
