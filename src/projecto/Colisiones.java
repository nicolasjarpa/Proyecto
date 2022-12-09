package projecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Colisiones {

    private auto auto;
    boolean colision;
    boolean roce;
    private Autopista autopista;
    
    public Colisiones(auto a){
        auto = a;
    }

    public boolean Colisiones() {
        if (auto.x <= 60) {
            auto.x = auto.x + 2;
            return colision = true;

        }
        if (auto.x >= 1485) {
            auto.x = auto.x - 2;
            return colision = true;
        }
        if (auto.y <= 60) {
            auto.y = auto.y + 2;
            return colision = true;
        }
        if (auto.y >= 785) {
            auto.y = auto.y - 2;
            return colision = true;
        }

        return colision = false;
    }

    public boolean Colisionestierra() {
        if ((auto.x >= 350 && auto.x <= 1250) && (auto.y >= 349 && auto.y <= 350)) {
            auto.y = auto.y - 1;
            return colision = true;
        }
        if ((auto.x >= 350 && auto.x <= 1250) && (auto.y >= 549 && auto.y <= 550)) {
            auto.y = auto.y + 1;
            return colision = true;
        }
        if ((auto.x >= 350 && auto.x < 351) && (auto.y >= 350 && auto.y <= 549)) {
            auto.x = auto.x - 1;
            return colision = true;
        }
        if ((auto.x >= 1250 && auto.x < 1251) && (auto.y >= 350 && auto.y <= 549)) {
            auto.x = auto.x + 1;
            return colision = true;
        }

        return false;
    }

    public boolean roce() {
        if (auto.x >= 200 && auto.y >= 200 && auto.x <= 1300 && auto.y <= 700) {

            return roce = true;
        }

        return roce = false;
    }
}
