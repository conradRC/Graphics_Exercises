
public class Background {
   
    public static void background(double x, double y, double size) {
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;
        int red= (int)(Math.random()*100);
        int green= (int)(Math.random()*100);
        int blue= (int)(Math.random()*100);
        
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.circle(x0,y0,0.2);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.circle(x1,y0,0.2);
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.circle(x1,y1,0.2);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.circle(x0,y1,0.2);
    }
   
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;
        background(x, y, size);

        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;
        int red= (int)(Math.random()*100);
        int green= (int)(Math.random()*100);
        int blue= (int)(Math.random()*100);
        StdDraw.setPenColor(red,green,blue);
        
        draw(n-1, x0, y0, size/2);   
        StdDraw.setPenColor(red,green,blue);
        draw(n-1, x0, y1, size/2);   
        StdDraw.setPenColor(red,green,blue);
        draw(n-1, x1, y0, size/2);   
        StdDraw.setPenColor(red,green,blue);
        draw(n-1, x1, y1, size/2);   
    }

    public static void eje(){
        double x = 0.5, y = 0.5;  
        double size = 0.5;     
        draw(3, x, y, size);
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5;  
        double size = 0.5;       
        draw(n, x, y, size);
    }
}
