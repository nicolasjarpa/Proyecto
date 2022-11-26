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
    public JPanel juego = new JPanel();
    private auto auto = new auto();
    public String direction = null;
    // posicion y auto
    float angle = 0f;
    private Colisiones coli = new Colisiones();
    private boolean w, a, s, d, up, down, right, left;
    float vel = 0f;
    private float pastomas = 0f, pastomenos = 0f;/*borrar despues, pasar a autopista */
    private float width = getWidth() - 400;
    private float height = getHeight() - 400;
    public Autopista autopista=new Autopista();
    public JButton aumento = new JButton();
    public JButton decrease = new JButton();
    public ButtonGroup grupo = new ButtonGroup();
    Polygon p = new Polygon();    
    public Interfaz() {

        /* fondo = new ImageIcon("pista3.png").getImage(); */
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
       autopista.paint(g);

        /*g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);*/
        
        
        config();

        if (w) {
            vel += 0.01f;

        }
        if (s) {
            vel -= 0.01f;

        }
        if (a) {
            angle -= 0.5f;

        }
        if (d) {
            angle += 0.5f;

        }
        if (vel > 0.8f) {
            vel = 0.8f;
        }
        vel *= 0.995f;
        coli.x += vel * Math.cos(Math.toRadians(angle));
        coli.y += vel * Math.sin(Math.toRadians(angle));
        coli.Colisiones();
        coli.Colisionestierra();
        if(coli.colision==true){
            System.out.println("colision"+this.coli.x);
            System.out.println("colision"+this.coli.y);
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

        float px = 15f; // der adelante
        float py = -10f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));

        px = -20f;
        py = -20f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));

        px = -20f;
        py = 20f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));

        px = 15f; // izq adelante
        py = 10f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aumento) {
            pastomas += 1f;
            
            if (getWidth() - 400 + (int) pastomas - (int) pastomenos == getWidth() - 400 && getHeight() - 400 + (int) pastomas - (int) pastomenos == getHeight() - 400) {
                pastomas = 0f;
            }
        } else if (e.getSource() == decrease) {
            pastomenos += 1f;
            
            if (getWidth() - 400 + (int) pastomas - (int) pastomenos == getWidth() - 400 && getHeight() - 400 + (int) pastomas - (int) pastomenos == getHeight() - 400) {
                pastomenos = 0f;
            }
        }
    }

    public void config() {
        juego.setLayout(null);
        grupo.add(aumento);
        aumento.setBounds(100, 100, 150, 150);
        juego.add(aumento);
        aumento.addActionListener(this);
        aumento.setVisible(true);

    }

}
