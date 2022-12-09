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
import java.awt.Shape;

public class Interfaz extends JPanel implements KeyListener, ActionListener {

    private Image fondo;
    private auto auto;
    public String direction = null;
    // posicion y auto
    float angleruedas = 0f;
    private Colisiones coli;
    private boolean w, a, s, d, up, down, right, left;
    private float width = getWidth() - 400;
    private float height = getHeight() - 400;
    public Autopista autopista = new Autopista();
    public JButton aumento = new JButton("aumentar");
    public JButton decrease = new JButton();
    public ButtonGroup grupo = new ButtonGroup();
    Polygon p = new Polygon();

    public Interfaz() {
        auto = new auto(150, 200);
        coli = new Colisiones(auto);

        /* fondo = new ImageIcon("pista3.png").getImage(); */
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        autopista.paint(g);

        /*g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);*/
        if (w) {
            if (coli.roce == true) {
                auto.vel += 0.0025f;
            } else {
                auto.vel += 0.005f;
            }
        }
        if (s) {
            if (coli.roce == true) {
                auto.vel -= 0.0025f;
            } else {
                auto.vel -= 0.005f;

            }
        }
        if (a) {
            auto.angle -= 0.5f;
        }
        auto.a = a;
        
        if (d) {
            auto.angle += 0.5f;
        }
        auto.d = d;
        
        if (coli.roce == true) {
            if (auto.vel > 0.4f) {
                auto.vel = 0.4f;
            } else if (auto.vel > 0.8f) {
                auto.vel = 0.8f;
            }
        }

        auto.mover();
        coli.roce();
        coli.Colisiones();
        coli.Colisionestierra();
        if (coli.roce == true) {
            System.out.println("roce");
        }
        if (coli.colision == true) {
            System.out.println("" + autopista.largopasto);
            System.out.println("" + autopista.altopasto);
            System.out.println("colision" + this.auto.x);
            System.out.println("colision" + this.auto.y);
        }
        
        auto.paint(g);

        
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aumento) {
            autopista.pastomas += 5f;

            if (getWidth() - 400 + (int) autopista.pastomas - (int) autopista.pastomenos == getWidth() - 400 && getHeight() - 400 + (int) autopista.pastomas - (int) autopista.pastomenos == getHeight() - 400) {
                autopista.pastomas = 0f;
            }
        } else if (e.getSource() == decrease) {
            autopista.pastomenos += 5f;

            if (getWidth() - 400 + (int) autopista.pastomas - (int) autopista.pastomenos == getWidth() - 400 && getHeight() - 400 + (int) autopista.pastomas - (int) autopista.pastomenos == getHeight() - 400) {
                autopista.pastomenos = 0f;
            }
        }
    }

    public void config() {
        this.setLayout(null);
        grupo.add(aumento);
        aumento.setBounds(0, 0, 150, 150);
        this.add(aumento);
        aumento.addActionListener(this);
        aumento.setVisible(true);
        aumento.setFocusable(false);

    }

    public int getpanelHeight() {
        return getHeight();
    }

    public int getpanelWidth() {
        return getWidth();
    }

}
