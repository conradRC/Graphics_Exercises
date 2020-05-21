
/******************************************************************************
 *  Compilation:  javac Figure.java
 *  Execution:    java Figure
 *  Dependencies: StdDraw
 *******************************************************************************/
 
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.Point;
import java.awt.Color;
public class Figure
{
    static double x = 0.0;
    static double y = 0.0;
    static double x1= 0.0;
    static double y1= 0.0;
    static double a = 4;
    static double b=0.1;
    public static void figura (){
        StdDraw.setPenRadius(0.009);
        //Principal
        Point p1 = new Point(17,30);
        Point p2 = new Point(23,30);
        Point p3 = new Point(20,21);
        filledTriangle(p1,p2,p3);

        //Lado izquierdo abajo
        Point p4 = new Point(16,30);
        Point p5 = new Point(19,22);
        Point p6 = new Point(13,30);
        filledTriangle(p4,p5,p6);

        //Lado derecho abajo
        Point p7 = new Point(24,30);
        Point p8 = new Point(21,22);
        Point p9 = new Point(27,30);
        filledTriangle(p7,p8,p9);

        //Lado izquierdo arriba
        Point p10 = new Point(13,31);
        Point p11= new Point(15,34);
        Point p12 = new Point(16,31);
        filledTriangle(p10,p11,p12);

        //Lado derecho arriba   
        Point p13 = new Point(24,31);
        Point p14= new Point(25,34);
        Point p15 = new Point(27,31);
        filledTriangle(p13,p14,p15);

        //Centro arriba
        Point2D.Double p16 = new Point2D.Double(17.5,31);
        Point2D.Double p17 = new Point2D.Double(22.5,31);
        Point2D.Double p18 = new Point2D.Double(20,34);
        filledTriangleD(p16,p17,p18);

        //Lado en medio izquierdo arriba
        Point2D.Double p19 = new Point2D.Double(16.7,31);
        Point2D.Double p20 = new Point2D.Double(16,34);
        Point2D.Double p21 = new Point2D.Double(19,34);
        filledTriangleD(p19,p20,p21);

        //Lado en medio derecho arriba
        Point2D.Double p22 = new Point2D.Double(23.3,31);
        Point2D.Double p23 = new Point2D.Double(24,34);
        Point2D.Double p24 = new Point2D.Double(21,34);
        filledTriangleD(p22,p23,p24);
    }

    public static void filledTriangleD(Point2D.Double  ...p){
        StdDraw.line(x+(p[0].getX()/a)*b,y+(p[0].getY()/a)*b,x+(p[1].getX()/a)*b,y+(p[1].getY()/a)*b);
        StdDraw.line(x+(p[1].getX()/a)*b,y+(p[1].getY()/a)*b,x+(p[2].getX()/a)*b,y+(p[2].getY()/a)*b);
        StdDraw.line(x+(p[0].getX()/a)*b,y+(p[0].getY()/a)*b,x+(p[2].getX()/a)*b,y+(p[2].getY()/a)*b);
    }

    public static void filledTriangle(Point ...p){
        Point2D.Double p1 = new Point2D.Double(x+(p[0].getX()/a)*b,y+(p[0].getY()/a)*b);
        Point2D.Double p2 = new Point2D.Double(x+(p[1].getX()/a)*b,y+(p[1].getY()/a)*b);
        Point2D.Double p3 = new Point2D.Double(x+(p[2].getX()/a)*b, y+(p[2].getY()/a)*b);
        StdDraw.line(p1.getX(),p1.getY(),p2.getX(),p2.getY());
        StdDraw.line(p2.getX(),p2.getY(),p3.getX(),p3.getY());
        StdDraw.line(p1.getX(),p1.getY(),p3.getX(),p3.getY());
    }

    public static void draw(){
        StdDraw.setPenRadius(0.001);
        StdDraw.enableDoubleBuffering();
        Background.eje();
        int r,g,b;
        for (double t = 0.0; true; t += 0.02) {
            
            r =(int) (Math.random()*255);
            g = (int)(Math.random()*220);
            b = (int)(Math.random()*220);
            
            StdDraw.setPenColor(new Color(r,g,b));
            figura();
            StdDraw.setPenRadius(0.01);
            Font font = new Font ("Bodoni MT Black", Font.BOLD, 30);
            StdDraw.setFont (font);
            StdDraw.text (0.5, 0.3, "Ruby on Rails");
        
        StdDraw.show();
        StdDraw.pause(1000);
        }
    }

    public static void main (String [] args){
        draw();
    }
}
