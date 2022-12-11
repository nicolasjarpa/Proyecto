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
    private float pastx, pasty;

    public Colisiones(auto a) {
        auto = a;
        pastx = auto.x;
        pasty = auto.y;
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
        if ((auto.x >= 320 && auto.x <= 1220) && (auto.y >= 285 && auto.y <= 295)) {
            auto.y = auto.y - 1; // y por arriba
          
        }

        if ((auto.x >= 320 && auto.x <= 1220) && (auto.y <= 574 && auto.y >= 564)) {
            auto.y = auto.y + 1; // y por abajo
            
        }

        if ((auto.x >= 290 && auto.x <= 300) && (auto.y >= 320 && auto.y <= 565)) {
            auto.x = auto.x - 1; // x por la izquierda
            
        }

        if ((auto.x <= 1261 && auto.x >= 1251) && (auto.y >= 320 && auto.y <= 565)) {
            auto.x = auto.x + 1; // x por la derecha
            
        }

        return false;
    }
    // pasto.fillRect(190 - (int) pastomas, 190 - (int) pastomas, 1160 + (int) pastomas * 2 , 480 + (int) pastomas * 2);
    public boolean roce(float pastito) {
        if (auto.x >= 190 - (int) pastito && auto.y >= 190 - (int) pastito && auto.x <= 1350 + (int) pastito * 2 && auto.y <= 670 + (int) pastito * 2) {

            return roce = true;
        }

        return roce = false;
    }
}
