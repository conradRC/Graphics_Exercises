package Model;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import View.PanelPaint;

public class Trazar{
	private Punto tp, auxp;
	boolean dibujo = false, btrasladar = false;
	float x, y, tx, ty, ttx, tty, b, t1, t2;
	float positionx,positiony;
	int nAristas;
	ArrayList puntos;
	ListIterator iterador;
	String figuraActual;
	PanelPaint pPaint;
	JLabel warning;
	Punto p;
	JTextField wx,hy,edges;
	
	public void loadWarning(JLabel lb) {
		warning = lb;
		warning.setText("");
	}

	public ArrayList dibujar(JTextField ...t) {
			tp = new Punto(0, 0);
			wx = t[2];
			edges = t[3];
			try {
				positionx = Float.parseFloat(t[0].getText());
				positiony = Float.parseFloat(t[1].getText());
				tp = new Punto(positionx, positiony);
			} catch (Exception e) {
				String txt = "Coordenadas no validas, poligono dibujado en el origen. ¡Solo de admiten numeros!";
				warning.setText(txt);
			}
			puntos = trazarPol();
		return puntos;
	}
	
	public Punto getPoinst() {
		return tp;
	}
	
	public void rotar() {
		if (dibujo == false)
			puntos = trazarPol();
		try {
			double ang = Math.toRadians(Float.parseFloat(JOptionPane.showInputDialog("Angulo a rotar:")));
			String inf = JOptionPane.showInputDialog("Â¿Girar sobre su centro?[S][N]");
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
		try {
			x = Float.parseFloat(wx.getText());
		    y = x*-1;
		    nAristas =Integer.parseInt(edges.getText());    
		    if(nAristas<=2)
		    	warning.setText("Buen intento, pero ese no puede ser un poligono");
		} catch (Exception e) {
			warning.setText("Los valores no son validos, ¡Solo se admiten números!");
		}
		puntos = Transformar.trazarPol(x, y, nAristas);
		dibujo = true;
		return puntos;
	}
}


