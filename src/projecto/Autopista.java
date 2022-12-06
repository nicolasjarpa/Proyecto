
package projecto;

import java.awt.Color;
import java.awt.Graphics;


public class Autopista {
    private Graphics limite, pista, pasto, tierra;
    public float pastomas = 0f, pastomenos = 0f;
   public int largopasto=0;
    public int altopasto=0;
    private Interfaz interfaz;
    public Autopista(){
        
        
    }
    public void paint(Graphics g){
        limite = g;
        pista = g;
        pasto = g;
        tierra = g;
        limite.setColor(Color.blue);
        limite.fillRect(0, 0, 1600, 900);
        pista.setColor(Color.DARK_GRAY);
        pista.fillRect(50, 50, 1450 , 750 );
        pasto.setColor(Color.green);
        pasto.fillRect(200 - (int) pastomas + (int) pastomenos, 200 - (int) pastomas + (int) pastomenos, 1160 + (int) pastomas*2 - (int) pastomenos*2, 480+ (int) pastomas*2 - (int) pastomenos*2);
        tierra.setColor(Color.black);
        tierra.fillRect(350, 350, 880, 200);
        largopasto= 1100 + (int) pastomas - (int) pastomenos;
        altopasto=500+ (int) pastomas - (int) pastomenos;
        
    }

  
}

