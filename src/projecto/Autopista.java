package projecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;

public class Autopista {

    private Graphics limite, pista, pasto, tierra;
    public float pastomas = 0f;
    public int largopasto = 0;
    public int altopasto = 0;
    private Image mas;
    private Image menos;

    public Autopista() {
        mas = new ImageIcon("mas.jpg").getImage();
        menos = new ImageIcon("menos.jpg").getImage();
    }

    public void paint(Graphics g) {
        limite = g;
        pista = g;
        pasto = g;
        tierra = g;
        limite.setColor(Color.blue);
        limite.fillRect(0, 0, 1600, 1000);
        pista.setColor(Color.DARK_GRAY);
        pista.fillRect(50, 50, 1450, 750);
        pasto.setColor(Color.green);
        pasto.fillRect(190 - (int) pastomas, 190 - (int) pastomas, 1160 + (int) pastomas * 2 , 480 + (int) pastomas * 2);
        tierra.setColor(Color.black);
        tierra.fillRect(330, 330, 880, 200);
        largopasto = 1100 + (int) pastomas;
        altopasto = 500 + (int) pastomas;
        g.drawImage(mas, 100, 835, 100, 100, null);
        g.drawImage(menos, 300, 835, 100, 100, null);
    }

}
