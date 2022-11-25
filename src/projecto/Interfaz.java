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

public class Interfaz extends JPanel implements  KeyListener {
    private Image fondo;
    public JPanel juego = new JPanel();
    private auto auto = new auto();
    public String direction = null;
       // posicion y auto
    float angle = 0f;
    private Colisiones coli=new Colisiones();
    private boolean w, a, s, d, up, down, right, left;
    Polygon p = new Polygon();
    

    public Interfaz() {
        
    fondo = new ImageIcon("pista3.png").getImage();
        
    }
    


    @Override
    public void paint(Graphics g) {
         
    
        super.paint(g);
       g.drawImage(fondo,0,0,getWidth(),getHeight(), null);
        setOpaque(false);
        if (w) {
            coli.x += 1.9f * Math.cos(Math.toRadians(angle));
            coli.y += 1.9f * Math.sin(Math.toRadians(angle));
            coli.Colisiones();
        }
        if (s) {
            coli.x -= 0.9f * Math.cos(Math.toRadians(angle));
            coli.y -= 0.9f * Math.sin(Math.toRadians(angle));
            coli.Colisiones();
        }
        if (a) {
            angle -= 0.9f;
            coli.Colisiones();
        }
        if (d) {
            angle += 0.9f;
            coli.Colisiones();
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
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));


        px = -20f;
        py = -5f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));


        px = -10f;
        py = 20f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));


        px = 20f;
        py = 5f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));
    }

}
