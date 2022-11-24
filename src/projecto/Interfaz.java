
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


public class Interfaz extends JFrame implements ActionListener{

    public JPanel juego = new JPanel();
    private auto a = new auto();
    public String direction = null;
    int x=50;
    int y=140;
    private Colisiones coli;
    public void actionPerformed(ActionEvent e){
        
    }
    
      public Interfaz(){

        this.setSize(960, 780);
        this.setTitle(" Super Auto");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(juego);
        
        KeyListener listener = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			
			public void keyPressed(KeyEvent e) {
				
                                if(KeyEvent.getKeyText(e.getKeyCode())=="Right"){
                                    x=x+10;
                                    direction = "Right";
                                    Colisiones();
                                    repaint();
                                }
                                if(KeyEvent.getKeyText(e.getKeyCode())=="Left"){
                                    x=x-10;
                                    direction = "Left";
                                    Colisiones();
                                    repaint();
                                }
                                if(KeyEvent.getKeyText(e.getKeyCode())=="Up"){
                                    y=y-10;
                                    direction = "Up";
                                    Colisiones();
                                    repaint();
                                }
                                if(KeyEvent.getKeyText(e.getKeyCode())=="Down"){
                                    y=y+10;
                                    direction = "Down";
                                    Colisiones();
                                    repaint();
                                }
                                
			}

			
			public void keyReleased(KeyEvent e) {
				
                                direction = null;
			}
        };
		addKeyListener(listener);
		setFocusable(true);

    }
      public int Colisiones(){
          if(x<=10){
              x=x+10;
              repaint();
          }
          if(x>=950){
          x=x-10;
          }
          if(y<=45){
              y=y+10;
          }
          if(y>=755){
              y=y-10;
          }
          return 0;
      }
      
    
    public void paint(Graphics g){
        super.paint(g);
        a.paint(g);

        Polygon p   = new Polygon();
        p.addPoint(x+10, y+20);
        p.addPoint(x+10, y+ -20);
        p.addPoint(x-10, y-20);
        p.addPoint(x-10, y+20);
        g.setColor(Color.red);
        g.fillPolygon(p);
        g.dispose();
        repaint();
        
    }
}
