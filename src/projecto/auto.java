package projecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/** Clase donde armamos nuestro auto */

public class auto {

    float vel = 0f;
    float x, y;
    float angle;
    Polygon p;
    boolean a,d;
    
    //adelante
    Rueda rueda0;
    Rueda rueda1;
    
    //atras
    Rueda rueda2;
    Rueda rueda3;
    
    /** En el constructor, realmente lo mas descriptivo es decir que
     * construimos el auto, le añadimos sus coordenadas, su angulo
     * y finalmente las cuatro ruedas
     * @param x
     * @param y 
     */
    
    public auto(float x, float y){
        this.x = x;
        this.y = y ;
        angle = 0f;
        rueda0 = new Rueda(25, 18, this);
        rueda1 = new Rueda(25, -18, this);
        rueda2 = new Rueda(-25, -28, this);
        rueda3 = new Rueda(-25, 28, this);
    }
    
    /** Esta clase tiene la utilidad de mostrarnos el auto que estamos 
     * definiendo en el constructor en pantalla, ademas de utilizar las otras
     * clases que estan mas abajo
     * @param g 
     */

    public void paint(Graphics g) {
        
        update_auto();
        g.setColor(Color.red);
        g.fillPolygon(p);
        
        rueda0.angle = angle;
        rueda1.angle = angle;
        if(a){
            rueda0.angle -=35;
            rueda1.angle -= 35;
        }
        if(d){
            rueda0.angle += 35;
            rueda1.angle += 35;
        }
        rueda2.angle = angle;
        rueda3.angle = angle;
        rueda0.paint(g);
        rueda1.paint(g);
        rueda2.paint(g);
        rueda3.paint(g);
    }
    
    /** Clase para mover nuestro vehiculo, incluye el roce del viento como
     * un detalle adicional, ya que la velocidad es multiplicada por un
     * float inferior a 1
     */
    
    public void mover(){
        vel *= 0.995f;
        x += vel * Math.cos(Math.toRadians(angle));
        y += vel * Math.sin(Math.toRadians(angle));
    }
    
    /** Clase para rotar el vehiculo, esta trabaja con los angulos del mismo
     * 
     */
    
    public void update_auto() {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));

        p = new Polygon();

        float px = 15f; // der adelante
        float py = -10f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        px = -20f; // atras izq
        py = -20f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        px = -20f; // atras der
        py = 20f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        px = 15f; // izq adelante
        py = 10f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

    }
}
