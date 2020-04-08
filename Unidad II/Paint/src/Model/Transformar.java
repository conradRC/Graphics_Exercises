package Model;
import java.util.*;

public class Transformar {

    public static ArrayList trazarPol(float x, float y, int nAristas) {
        /** copiamos las coordenadas iniciales */
        float x1 = x, y1 = y;
        
        /** creamos la lista de puntos */
        ArrayList p = new ArrayList();
        
        /** calculamos el angulo de rotacion en radianes */
        double ang = Math.toRadians(360.0 / nAristas);
        
        /** Agregamos a la lista las coordenadas iniciales */
        p.add(new Punto(x1, y1));
        int nA = 1;
        
        /** calculamos las coordenadas siguientes */
        while (nA < nAristas) {
            x1 = (float) (x * Math.cos(ang) - y * Math.sin(ang));
            y1 = (float) (x * Math.sin(ang) + y * Math.cos(ang));
            p.add(new Punto(x1, y1));
            
            x  = x1;
            y  = y1;
            nA++;
        }        
        return p;
    }
    
    public static ArrayList rotar(ArrayList puntos, double ang) {
        ListIterator lit = puntos.listIterator();
        float x1, y1, x, y;
        Punto p;
      
        /** generamos los nuevos puntos */
        while(lit.hasNext())
        { 
            p  = (Punto) lit.next();
            x  = p.getX();
            y  = p.getY();
            x1 = (float) (x * Math.cos(ang) - y * Math.sin(ang));
            y1 = (float) (x * Math.sin(ang) + y * Math.cos(ang));
            lit.set(new Punto(x1,y1));
            x  = x1;
            y = y1;                
        }
        
        return puntos;
    }
    
    public static ArrayList trasladar(ArrayList puntos2, float tx, float ty) {
        /** copiamos las coordenadas iniciales */        
        ListIterator lit = puntos2.listIterator();
        float x1, x, y1, y;
        Punto p;
        
        /** generamos los nuevos puntos */
        while(lit.hasNext())
        { 
            p  = (Punto) lit.next();
            x  = p.getX();
            y  = p.getY();
            x1 = (float) x + tx;
            y1 = (float) y + ty;
            
            lit.set(new Punto(x1, y1));
            x  = x1;
            y  = y1; 
        }
        
        return puntos2;
    }
     
    public static ArrayList escalar(ArrayList puntos2, float ex, float ey) {
        /** copiamos las coordenadas iniciales */
        float x1, x, y1, y;
        Punto p;
        /** generamos los nuevos puntos */
        ListIterator lit = puntos2.listIterator();
        while(lit.hasNext())
        {   
            p  = (Punto) lit.next();
            x  = p.getX();
            y  = p.getY();
            x1 = (float) x * ex;
            y1 = (float) y * ey;
            lit.set(new Punto(x1, y1));
            x  = x1;
            y  = y1;
        }
        
        return puntos2;
    }
        
    public static ArrayList sesgar(ArrayList puntos2, float a) {
        /** copiamos las coordenadas iniciales */
        float x1, x, y1, y;
        Punto p;
        /** generamos los nuevos puntos */
        ListIterator lit = puntos2.listIterator();
        while(lit.hasNext())
        {   
            p  = (Punto)lit.next();
            x  = p.getX();
            y  = p.getY();
            x1 = (float)x+(a*y);
            y1 = (float) y;
            lit.set(new Punto(x1, y1));
        }
        
        return puntos2;
    }
}
