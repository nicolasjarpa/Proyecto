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
/** Interfaz grafica de la aplicacion, acá encontramos todo
lo relacionado con el movimiento y las acciones del teclado, botones, etc */
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
    public circuito circuito =new circuito();
    public JButton aumento = new JButton("aumentar");
    public JButton decrease = new JButton();
    public ButtonGroup grupo = new ButtonGroup();
    Polygon p = new Polygon();
    
    /** Constructor de nuestra interfaz, aca definimos nuestro vehiculo y las colisiones */
    
    public Interfaz() { 
        auto = new auto(150, 200);
        coli = new Colisiones(auto);
        
        /* fondo = new ImageIcon("pista3.png").getImage(); */
    }
    
    /** Aca se pinta todo lo que tiene que ver con la velocidad, incluyendo el roce y los angulos */

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        circuito.paint(g);


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
        coli.roce(circuito.pastomas);
        coli.Colisiones();
        coli.Colisionestierra();
        if (coli.roce == true) {
            System.out.println("roce");
        }
        if (coli.colision == true) {
            System.out.println("" + circuito.alto);
            System.out.println("" + circuito.largo);
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
    
    /** Comandos de una clase abstracta para que el juego reaccione ante el input wasd,
     * planeabamos tambien hacer que funcionen las flechas con otro auto, pero no alcanzamos
     * @param e 
     */
    
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

    /** Cuando sueltas las teclas */
    
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

    /** Esta es la clase en la cual configuramos los botones para aumentar o disminuir la pista */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aumento) {
            circuito.pastomas += 5f;


            if ((int) getWidth() - 400 - (int) circuito.pastomas == (int) getWidth() - 500) {
                System.out.println("The track can't be smaller!");
                circuito.pastomas = circuito.pastomas - 5f;
            }
        } else if (e.getSource() == decrease) {
            circuito.pastomas -= 5f;


            if (getWidth() - 400 + (int) circuito.pastomas == (int) getWidth() - 540) {
                System.out.println("The track can't be bigger!");
                circuito.pastomas = circuito.pastomas + 5f;
            }
        }
    }
    
    /** Esta clase es para añadir los botones a la pantalla, estos son invisibles y estan representados por una imagen sobrepuesta */

    public void config() {
        this.setLayout(null);
        grupo.add(aumento);
        grupo.add(decrease);
        decrease.setBounds(100, 835, 100, 100);
        aumento.setBounds(300, 835, 100, 100);
        this.add(aumento);
        this.add(decrease);
        decrease.addActionListener(this);
        decrease.setVisible(true);
        decrease.setFocusable(false);
        aumento.addActionListener(this);
        aumento.setVisible(true);
        aumento.setFocusable(false);

    }
    
    /** Estas clases se autodescriben */

    public int getpanelHeight() {
        return getHeight();
    }

    public int getpanelWidth() {
        return getWidth();
    }
    

}
