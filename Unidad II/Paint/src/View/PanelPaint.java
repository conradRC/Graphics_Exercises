package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

import Model.Punto;

public class PanelPaint extends JPanel {
    
    ArrayList puntos;
    Punto p,tp;
    boolean boolDibujar = false;
    private Color[] colors = { Color.white, Color.blue, Color.red,
                               Color.yellow,Color.green, Color.pink,
                               Color.gray };
    
    public PanelPaint() {
        setBackground(Color.white);
    }
    
    public void dibujar(ArrayList puntos) {
        this.puntos = puntos;     
        boolDibujar = true;
        tp          = new Punto(100,100);
        repaint();
    }
    
    public void dibujar(ArrayList puntos,Punto tp) {
        this.puntos = puntos;
        this.tp     = tp;
        boolDibujar = true;
        repaint();
    }
    
    public void dibujar() {
        boolDibujar = false;
        repaint();
    }
    
    public void paint (Graphics g) {     
    	super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        int ancho = getWidth();
        int alto = getHeight();
        /** Mover el origen al centro */
        g2.translate(ancho/2, alto/2);
        g2.setPaint(Color.WHITE);
        g2.fill(new Rectangle2D.Double(-ancho/2,-alto/2,ancho,alto));
        
        /** Trazar los ejes de coordenadas */
        g2.setPaint(colors[1]);        
        g2.drawLine((int)  -ancho/2,0,(int) ancho/2,0);
        g2.drawLine(0,(int)-alto/2,0, (int) alto/2);
        
        if (boolDibujar) {
        	g2.translate(tp.getX(),tp.getY());        
            
            /** Creacion del GeneralPath */
            GeneralPath gp = new GeneralPath();                       
            /** ligar un iterador a la lista de objetos Punto */
            Iterator  it= puntos.iterator();        
            /** colocar el trazador en el primer punto */
            if(it.hasNext()) {
                p = (Punto) it.next();
                gp.moveTo(p.getX(),p.getY());
            }
            /** recorrer la lista de objetos Punto y dibujar las lineas */
            while (it.hasNext()) {
                p = (Punto) it.next();
                gp.lineTo(p.getX(),p.getY());
            }  
            gp.closePath();
            g2.setPaint(colors[(int) (Math.random() * 6) + 1]);
            g2.fill(gp);
        }
    }    
}