
public class Cliente
{
   public static void main(String [] args){
        int n = 400;
        Picture picture1 = new Picture("baboon.jpg");   // begin picture
        Picture picture2 = new Picture("darwin.jpg");   // end picture
        int m = 3;
        int w = 2;
        FadeModificado.fade(n, picture1, picture2, m, w);}
}
