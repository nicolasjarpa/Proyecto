
package projecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Colisiones{
  float x = 150f;   // posicion x auto
    float y = 200f; 
    float r1 = 155f;
    float r2 = 205f;
    float r3 = 0f;
    float r4 = 0f;
    boolean colision;
    boolean roce;
    private Autopista autopista;
public boolean Colisiones(){
    if (x <= 60) {
            x = x + 2;
            r1 = r1 + 3;
            return colision=true;
           
        }
        if (x >= 1485 ){
            x = x - 2;
            r1 = r1-3;
            return colision=true;
        }
        if (y <= 60 ) {
            y = y + 2;
            r2 = r2 + 3;
            return colision=true;
        }
        if (y >= 785){
            y = y - 2;
            r2 = r2 - 3;
            return colision=true;
        }
     
   
       
return colision=false;
}
public boolean Colisionestierra(){
    if((x>= 350 && x<=1250)&&(y>=349 && y <=350)){
        y = y-1;
        r2 = r2-2;
        return colision=true;}
       if((x>= 350 && x<=1250)&&(y>=549 && y <=550)){
        y = y+1;
        r2 = r2+2;
        return colision=true;
       }
       if((x>= 350 && x<351)&&(y>=350 && y <=549)){
        x = x-1;
        r1 = r1-2;
        return colision=true;
       }
        if((x>= 1250 && x<1251)&&(y>=350 && y <=549)){
        x = x+1;
        r1 = r1+2;
        return colision=true;
       }
      
    return false;
}
public boolean roce(){
     if(x>=200 && y>=200 && x <=1300 && y<=700){
         
         return roce=true;
     }
     
    return roce=false;
}
}