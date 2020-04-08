package Controller;
import javax.swing.*;

import Model.Punto;
import Model.Transformar;
import View.PanelPaint;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Trazar extends JFrame {
    int ancho,alto;    
    boolean dibujo = false, btrasladar = false;
    String figuraActual;
    float x, y, tx, ty, ttx, tty, b, t1, t2;
    private Punto tp, auxp;
    JPanel panel;
    PanelPaint pPaint;
    ArrayList puntos;
    ListIterator iterador;
    
    JButton JBdibujar,JBtrasladar, JBrotar, JBescalar, JBsesgado,
            JBlimpiar,Bcerrar; 
    JLabel te; 
    
    
    public Trazar() {
    setTitle("Trazador de figuras geometricas");
    
    Toolkit dimensiones = Toolkit.getDefaultToolkit();
    Dimension d = dimensiones.getScreenSize();
    alto        = d.height/2;
    ancho       = d.width/2;        
    setSize(ancho + (ancho/4), alto + 28);
    setLocation(ancho/4,    alto/4);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(true);
    setVisible(true);
    getContentPane().setLayout(null);
        
    pPaint      = new PanelPaint(650,400,201,0);
    
    getContentPane().add(pPaint);        
    panel       = new JPanel();
    JBdibujar   = new JButton("Dibujar");
    JBtrasladar = new JButton("Trasladar");
    JBrotar     = new JButton("Rotar");
    JBescalar   = new JButton("Escalado");
    JBsesgado   = new JButton("Sesgado");
    JBlimpiar   = new JButton("Limpiar");
    Bcerrar     = new JButton("Cerrar programa");
        
    te = new JLabel("****MENU****");
        
    panel.setSize(200,500);
    panel.setLocation(0,0);
    panel.setLayout(null);
    panel.setBackground(Color.GRAY);
        
    /** Posiciones de los botones */
    JBdibujar.setBounds(40,50,100,30);
    JBrotar.setBounds(40,100,100,30);
    JBtrasladar.setBounds(40,150,100,30);
    JBescalar.setBounds(40,200,100,30);
    JBsesgado.setBounds(40,250,100,30);
    JBlimpiar.setBounds(40,300,100,30);
    Bcerrar.setBounds(20,350,130,30);
        
    te.setBounds(50,15,100,30);
        
    /** Agregacion de elementos al panel */
    getContentPane().add(panel);
    panel.add(JBtrasladar);
    panel.add(JBdibujar);
    panel.add(JBrotar);
    panel.add(JBescalar);
    panel.add(JBsesgado);
    panel.add(JBlimpiar);
    panel.add(Bcerrar);
        
    panel.add(te);
        
    JBdibujar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ee) {                
            try {
                tp     = new Punto(0,0);
                puntos = trazarPol();
                pPaint.dibujar(puntos);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Inserta x,y y el numero de aristas");   
            }                        
        }
    });
        
    JBrotar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ee) {
            if(dibujo == false)
                puntos = trazarPol();                
            try {
                double ang = Math.toRadians(Float.parseFloat(JOptionPane.showInputDialog("Angulo a rotar:")));
                String inf = JOptionPane.showInputDialog("¿Girar sobre su centro?[S][N]");
                if (inf.equals("N")) {
                    x = Float.parseFloat(JOptionPane.showInputDialog("Coordenada en X:"));
                    y = Float.parseFloat(JOptionPane.showInputDialog("Coordenada en Y :")) * -1;                
                    tp = new Punto(x,y);
                }
                else
                    tp = new Punto(ttx,tty);
                    
                iterador = puntos.listIterator();
                if (btrasladar == true)
                {
                /** generamos los nuevos puntos */
                    while(iterador.hasNext())
                    {   
                        auxp       = (Punto)iterador.next();
                        iterador.set(new Punto(auxp.getX()-tx,auxp.getY()-ty)); 
                    }   btrasladar = false;
                }
                    puntos = Transformar.rotar(puntos,ang);
                    pPaint.dibujar(puntos,tp);
            }                
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Ingrese nuevamente los datos correctamente");   
            }                    
        }
    });
            
    JBtrasladar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ee) {
            if(dibujo == false)
                puntos = trazarPol();                
            try {
                tx     = Float.parseFloat(JOptionPane.showInputDialog("Traslacion en x"));
                ty     = Float.parseFloat(JOptionPane.showInputDialog("Traslacion en y"))*-1;
                puntos = Transformar.trasladar(puntos,tx,ty);
                pPaint.dibujar(puntos);
                btrasladar = true;
                ttx    = tx + ttx;
                tty    = ty + tty;
            }                
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Ingrese nuevamente los datos correctamente");   
            }
        }
    });
             
    JBsesgado.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ee) {
            if (dibujo == false)
            puntos = trazarPol();
            try {                    
                b      = Float.parseFloat(JOptionPane.showInputDialog("Grado de Sesgado "));
                puntos = Transformar.sesgar(puntos,b);
                pPaint.dibujar(puntos);                    
            }                        
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Ingrese nuevamente los datos correctamente");   
            }
        }
    });
                
    JBescalar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ee) {
            if (dibujo == false)
                puntos = trazarPol();                   
            try {
                t1 = Float.parseFloat(JOptionPane.showInputDialog("Escala en x"));
                t2 = Float.parseFloat(JOptionPane.showInputDialog("Escala en y"))*-1;
                puntos = Transformar.escalar(puntos,t1,t2);
                pPaint.dibujar(puntos);
            }                    
            catch(Exception ex) {
                JOptionPane.showMessageDialog(null,"Ingrese nuevamente los datos correctamente");   
            }
        }
    });
             
    JBlimpiar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ee) {
            if (dibujo == true)
                puntos = trazarPol();
        }
    });
             
    Bcerrar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ee) {
            System.exit(0);
        }
    });         
   }
   
   public ArrayList trazarPol() {        
       x = Float.parseFloat(JOptionPane.showInputDialog("Coordenada en x"));
       y = Float.parseFloat(JOptionPane.showInputDialog("Coordenada en y"))*-1;
       int nAristas =Integer.parseInt(JOptionPane.showInputDialog("Numero de aristas:"));
       puntos = Transformar.trazarPol(x,y,nAristas);
       dibujo = true;
       return puntos;
   }
    
   public static void main(String[] figura){
       Trazar v = new Trazar();
    }
}





