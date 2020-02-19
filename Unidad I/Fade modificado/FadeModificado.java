
/******************************************************************************
 *  Compilation:  javac FadeMoficado.java
 *  Execution:    java FadeMoficado n image1.jpg image2.jpg col row

 *  Example:
 *   "200","baboon.jpg","darwin.jpg","4","3"
 *
 ******************************************************************************/

import java.awt.Color;

public class FadeModificado {

    public static Color combine(Color c1, Color c2, double alpha) {
        int r = (int) (alpha * c1.getRed() + (1 - alpha) * c2.getRed());
        int g = (int) (alpha * c1.getGreen() + (1 - alpha) * c2.getGreen());
        int b = (int) (alpha * c1.getBlue() + (1 - alpha) * c2.getBlue());
        return new Color(r, g, b);
    }

    public static void fade(int n,Picture picture1,Picture picture2, int m, int w){
        int countx = 0;
        int county = 0;
        int c= n/(m*w);
        int width = picture1.width();
        int height = picture1.height();
        Picture picture = new Picture(width, height);
        Picture output = new Picture(m * picture.width(), w * picture.height());
        for (int k = 0; k <= n; k++) {
            double alpha = 1.0 * k / n;
            for (int col = 0; col < width; col++) {
                for (int row = 0; row < height; row++) {
                    Color c1 = picture1.get(col, row);
                    Color c2 = picture2.get(col, row);
                    picture.set(col, row, combine(c2, c1, alpha));
                }
            }
            if (k%c==0 && k!=0) {
                for (int col = 0; col < width; col++) {
                    for (int row = 0; row < height; row++) {
                        Color color = picture.get(col, row);
                        output.set(width * countx + col, height * county + row, color);
                    }
                }
                if(countx<m)countx++;
                if(countx==m) {
                    countx=0;
                    county++;
                }
            }
        }
        output.show();
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);         // # of frames
        Picture picture1 = new Picture(args[1]);   // begin picture
        Picture picture2 = new Picture(args[2]);   // end picture
        int m = Integer.parseInt(args[3]);
        int w = Integer.parseInt(args[4]);
        fade(n, picture1, picture2, m, w);
    }
}
