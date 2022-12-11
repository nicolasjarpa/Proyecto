package projecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Esta clase es la clase donde construimos y le damos sentido a cada rueda
 * individualmente, es decir, construimos solo una rueda
 *
 */
public class Rueda {

    Polygon p = new Polygon();
    float x = 155f;
    float y = 205f;
    float angle = 0f;
    auto auto;

    /**
     * Las ruedas al ser algo independiente de la carroceria del auto, deben
     * tener sus propias coordenadas y un auto del cual formen parte, en este
     * constructor, les damos esas caracteristicas
     *
     * @param x
     * @param y
     * @param a
     */
    public Rueda(float x, float y, auto a) {
        this.x = x;
        this.y = y;
        auto = a;
    }
            
    /** En este paint armamos todo lo que hacemos con las otras clases 
     * 
     * @param g 
     */
    
    public void paint(Graphics g) {
        update_rueda();
        g.setColor(Color.black);
        g.fillPolygon(p);
    }
    
    /** Clase para que las ruedas funcionen en todo angulo correctamente, de 
     * manera que no queden estaticas cuando doblas
     */
    
    public void update_rueda() {
        float cos = (float) Math.cos(Math.toRadians(auto.angle));
        float sin = (float) Math.sin(Math.toRadians(auto.angle));

        float nx = x * cos - y * sin;
        float ny = x * sin + y * cos;

        p = new Polygon();
        cos = (float) Math.cos(Math.toRadians(angle));
        sin = (float) Math.sin(Math.toRadians(angle));

        float px = 11f; // adelante izq
        float py = -6f;
        p.addPoint((int) (auto.x + nx + px * cos - py * sin), (int) (auto.y + ny + px * sin + py * cos));

        px = -11f; // atras izq
        py = -6f;
        p.addPoint((int) (auto.x + nx + px * cos - py * sin), (int) (auto.y + ny + px * sin + py * cos));

        px = -11f; // atras der
        py = 6f;
        p.addPoint((int) (auto.x + nx + px * cos - py * sin), (int) (auto.y + ny + px * sin + py * cos));

        px = 11f; // atras izq
        py = 6f;
        p.addPoint((int) (auto.x + nx + px * cos - py * sin), (int) (auto.y + ny + px * sin + py * cos));
    }
}
