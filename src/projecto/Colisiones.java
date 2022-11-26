
package projecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Colisiones{
  float x = 150f;   // posicion x auto
    float y = 200f;   
    boolean colision;
public boolean Colisiones(){
    if (x <= 60) {
            x = x + 2;
            return colision=true;
           
        }
        if (x >= 1485 ){
            x = x - 2;
            return colision=true;
        }
        if (y <= 60 ) {
            y = y + 2;
            return colision=true;
        }
        if (y >= 785){
            y = y - 2;
            return colision=true;
        }
     
   
       
return colision=false;
}
public boolean Colisionestierra(){
    if((x>= 350 && x<=1250)&&(y>=349 && y <=350)){
        y = y-1;
        return colision=true;}
       if((x>= 350 && x<=1250)&&(y>=549 && y <=550)){
        y = y+1;
        return colision=true;
       }
       if((x>= 350 && x<351)&&(y>=350 && y <=549)){
        x = x-1;
        return colision=true;
       }
        if((x>= 1250 && x<1251)&&(y>=350 && y <=549)){
        x = x+1;
        return colision=true;
       }
      
    return false;
}
public boolean Efectoroce(){
    return false;
}
}