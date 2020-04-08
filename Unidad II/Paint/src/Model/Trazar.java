package Model;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JLabel;
import javax.swing.JTextField;

import View.PanelPaint;

public class Trazar{
	private Punto tp, auxp;
	public boolean dibujo = false, btrasladar = false;
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
	String txt;
	
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
				 txt = "Coordenadas no validas, poligono dibujado en el origen. ¡Solo de admiten numeros!";
				warning.setText(txt);
			}
			puntos = trazarPol();
		return puntos;
	}
	
	public Punto getPoinst() {
		return tp;
	}
	
	public ArrayList rotar(JTextField textF) {
		double ang=0.0;
		if (dibujo == false)
			puntos = trazarPol();
		try {
			 ang = Math.toRadians(Float.parseFloat(textF.getText()));
		}catch (Exception e) {
			txt = "Ingrese un angulo valido";
			warning.setText(txt);
		}
		try {
			String inf = "N";
			if (inf.equals("N")) {
				tp = new Punto(x, y);
			} else {
				tp = new Punto(ttx, tty);
			}
			
			iterador = puntos.listIterator();
			if (btrasladar == true) {
				/** generamos los nuevos puntos */
				while (iterador.hasNext()) {
					auxp = (Punto) iterador.next();
					iterador.set(new Punto(auxp.getX() - tx, auxp.getY() - ty));
				}
				btrasladar = false;
			}

		} catch (Exception ex) {}
		return puntos = Transformar.rotar(puntos, ang);
	}

	public void trasladar(JTextField txx, JTextField tyy) {
		tx =0;
		ty =0;
		if (dibujo == false)
			puntos = trazarPol();
		try {
			tx = Float.parseFloat(txx.getText());
			ty = Float.parseFloat(tyy.getText());
		} catch (Exception ex) {
			txt = "Coordenadas no validas, ¡Solo de admiten numeros!";
			warning.setText(txt);
		}
		
		try {
			puntos = Transformar.trasladar(puntos, tx, ty);
			pPaint.dibujar(puntos);
			btrasladar = true;
			ttx = tx + ttx;
			tty = ty + tty;
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void sesgado(JTextField txs) {
		b=(float)0.0;
		if (dibujo == false)
			puntos = trazarPol();
		try {
			b = Float.parseFloat(txs.getText());
		} catch (Exception ex) {
			txt = "Valor no valido, ¡Solo de admiten numeros!";
			warning.setText(txt);
		}
		try {
		puntos = Transformar.sesgar(puntos, b);
		pPaint.dibujar(puntos);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void escalar(JTextField txx, JTextField tyy) {
		t1=0;
		t2=0;
		if (dibujo == false)
			puntos = trazarPol();
		try {
			t1 = Float.parseFloat(txx.getText());
			t2 = Float.parseFloat(tyy.getText());
		}catch (Exception e) {
			txt = "Valores no validos, ¡Solo de admiten numeros!";
			warning.setText(txt);
		}
		try {
			puntos = Transformar.escalar(puntos, t1, t2);
			pPaint.dibujar(puntos);
		} catch (Exception ex) {
			
		}
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


