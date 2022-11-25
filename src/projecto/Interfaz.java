package projecto;

import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.event.*;

public class Interfaz extends JPanel implements ActionListener, KeyListener {

    public JPanel juego = new JPanel();
    private auto auto = new auto();
    public String direction = null;
    float x = 20f;   // posicion x auto
    float y = 20f;   // posicion y auto
    float angle = 0f;
    private Colisiones coli;
    private boolean w, a, s, d, up, down, right, left;
    Polygon p = new Polygon();

    public void actionPerformed(ActionEvent e) {

    }

    public Interfaz() {

        this.setSize(960, 780);

    }

    public int Colisiones() {
        if (x <= 10) {
            x = x + 10;

        }
        if (x >= 950) {
            x = x - 10;
        }
        if (y <= 45) {
            y = y + 10;
        }
        if (y >= 755) {
            y = y - 10;
        }
        return 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (w) {
            x += 0.1f * Math.cos(Math.toRadians(angle));
            y += 0.1f * Math.sin(Math.toRadians(angle));
        }
        if (s) {
            x -= 0.1f * Math.cos(Math.toRadians(angle));
            y -= 0.1f * Math.sin(Math.toRadians(angle));
        }
        if (a) {
            angle -= 0.05f;
        }
        if (d) {
            angle += 0.05f;
        }
        
        update_auto();
        /*p = new Polygon();
        p.addPoint((int)x+5, (int)y+10);
        p.addPoint((int)x+5, (int)y-10);
        p.addPoint((int)x-5, (int)y-10);
        p.addPoint((int)x-5, (int)y+10); 
        System.out.println(p.npoints); */
        g.setColor(Color.red);
        g.fillPolygon(p);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            w = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            a = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            s = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            d = true;
        }
        /*if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }*/
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            w = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            a = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            s = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            d = false;
        }

        /*if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }*/
    }

    public void update_auto() {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));

        p = new Polygon();


        float px = 10f;
        float py = -20f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));


        px = -20f;
        py = -5f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));


        px = -10f;
        py = 20f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));


        px = 20f;
        py = 5f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));
    }

}
