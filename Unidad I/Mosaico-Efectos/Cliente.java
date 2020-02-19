/**
 * @author (Conrado Cruz Mejía) 
 * @version (1.0)
 * 
 *  Compilation:  javac Cliente.java
 *  Execution:    java Cliente
 */

import java.awt.Color;
public class Cliente
{
    private static void paint(Picture output, Picture picture, int i, int j) {
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                Color color = picture.get(col, row);
                output.set(picture.width() * j + col, picture.width() * i + row, color);
            }
        }
    }

    public static void main(String[] args) {
        int m = Integer.parseInt("2");
        int n = Integer.parseInt("4");

        Picture input = new Picture("baboon.jpg"); 
        Picture input1 = new Picture("arbol.jpg"); 
        Picture input2 = new Picture("arte.jpg");
        Picture input3 = new Picture("iroman.jpg"); 
        Picture input5 = new Picture("music.jpeg");
        Picture input6= new Picture("flores.jpg"); 
        Picture input7 = new Picture("ruby.jpg"); 
        Picture input8 = new Picture("cohetes.jpg");

        Picture [] pictures = new Picture [] {input,input1,input2,input3,input5,input6,input7,input8};

        int height = input.height();
        int width = input.width();

        for (int i = 0; i < pictures.length; i++) {
            pictures[i] = Efects.scale(pictures[i], height, width);
        }		

        byte count = 0;
        Picture output = new Picture(n * width, m * height);
        Picture[] array = new Picture[m*n];

        array[0] = Efects.scale(pictures[0], 200, 200);
        array[1] = Efects.glass(pictures[1]);
        array[2] = Efects.wave(pictures[2]);
        array[3] = Efects.colorSeparation(pictures[3]);
        array[4] = Efects.rotation(pictures[4], "30");
        array[5] = Efects.brighter(pictures[5]);
        array[6] = Efects.flipX(pictures[6]);
        array[7] = Efects.grayscale(pictures[7]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                paint(output, array[count], i, j);
                count++;
            }
        }	
        output.show();
    }  
}
