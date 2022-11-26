
package projecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Colisiones{
  float x = 150f;   // posicion x auto
    float y = 200f;   

public int Colisiones(){
 if (x <= 40 || ( x>= 1215&&x<=1220 && y>=180 && y <= 640)) {
            x = x + 10;

        }
        if (x >= 1460 || ( x<=305 &&x>=300 && y>=180 && y <= 640)){
            x = x - 10;
        }
        if (y <= 50 ||( y>=640 &&y<=645  && x>=300 && x <= 1220)) {
            y = y + 5;
        }
        if (y >= 805||(  y>=180 && y <=186&& x>=300 && x <= 1220)) {
            y = y - 10;
        }
     
   
       
return 0;
}


}