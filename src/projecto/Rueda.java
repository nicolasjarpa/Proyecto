package projecto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


public class Rueda {
    Polygon p = new Polygon();
    float x = 155f;
    float y = 205f;
    float angle = 0f;
    auto auto;
    
    public Rueda(float x, float y, auto a){
        this.x = x;
        this.y = y;
        auto = a;
    }
    
    public void paint(Graphics g){
        update_rueda();
        g.setColor(Color.black);
        g.fillPolygon(p);
    }
    
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


