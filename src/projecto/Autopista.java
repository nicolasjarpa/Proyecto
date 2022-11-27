
package projecto;

import java.awt.Color;
import java.awt.Graphics;


public class Autopista {
    private Graphics limite, pista, pasto, tierra;
    public float pastomas = 0f, pastomenos = 0f;
    public float largotierra=0f;
    public float altotierra=0f;
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
        pasto.fillRect(200, 200, 1100 + (int) pastomas - (int) pastomenos, 500+ (int) pastomas - (int) pastomenos);
        tierra.setColor(Color.black);
        tierra.fillRect(350, 350, 900, 200);
        
    }
}

