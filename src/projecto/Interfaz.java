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
    private auto auto = new auto();
    public String direction = null;
    // posicion y auto
    float angle = 0f;
    float angleruedas = 0f;
    private Colisiones coli = new Colisiones();
    private boolean w, a, s, d, up, down, right, left;
    float vel = 0f;
    /*borrar despues, pasar a autopista */
    private float width = getWidth() - 400;
    private float height = getHeight() - 400;
    public Autopista autopista = new Autopista();
    public JButton aumento = new JButton("aumentar");
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
        

        if (w) {
            if(coli.roce ==true){
                auto.vel+=0.0025f;
            }
            else{
            auto.vel += 0.005f;
            

        }
    }
        if (s) {
            if(coli.roce==true){
                auto.vel-=0.0025f;
            }
            else{
            auto.vel -= 0.005f;

        }
        }
        if (a) {
            angle -= 0.5f;
            angleruedas -= 0.6f;

        }
        if (d) {
            angle += 0.5f;
            angleruedas -= 0.6f;

        }
        if(coli.roce==true){
           if(auto.vel>0.4f){
               auto.vel=0.4f;
           }
        
        else if (vel > 0.8f) {
            auto.vel = 0.8f;
        }
        }
        
        auto.vel *= 0.995f;
        coli.x += auto.vel * Math.cos(Math.toRadians(angle));
        coli.y += auto.vel * Math.sin(Math.toRadians(angle));
        coli.roce();
        coli.Colisiones();
        coli.Colisionestierra();
        if(coli.roce ==true){
            System.out.println("roce");
        }
        if (coli.colision == true) {
            System.out.println(""+autopista.largopasto);
     System.out.println(""+autopista.altopasto);
            System.out.println("colision" + this.coli.x);
            System.out.println("colision" + this.coli.y);
        }
        update_auto();

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

        px = -20f; // atras izq
        py = -20f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));

        px = -20f; // atras der
        py = 20f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));

        px = 15f; // izq adelante
        py = 10f;
        p.addPoint((int) (coli.x + px * cos - py * sin), (int) (coli.y + px * sin + py * cos));
        
        
    }
    
    public void update_ruedas(){
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        
        float px = 17f; // adelante der
        float py = -12f;
        p.addPoint((int) (coli.x + px * cos - py * sin)+2, (int) (coli.y + px * sin + py * cos)-2);

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
    
    public  int getpanelHeight(){
        return getHeight();
    }
    
    public  int getpanelWidth(){
        return getWidth();
    }

}
