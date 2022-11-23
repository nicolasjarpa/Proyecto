
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
    

    public void actionPerformed(ActionEvent e){
        
    }
    
      public Interfaz(){

        this.setSize(1920, 1080);
        this.setTitle(" Super Auto");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(juego);
        
        KeyListener listener = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
                                if(KeyEvent.getKeyText(e.getKeyCode())=="D"){
                                    direction = "Right";
                                }
                                if(KeyEvent.getKeyText(e.getKeyCode())=="A"){
                                    direction = "Left";
                                }
                                if(KeyEvent.getKeyText(e.getKeyCode())=="W"){
                                    direction = "Up";
                                }
                                if(KeyEvent.getKeyText(e.getKeyCode())=="S"){
                                    direction = "Down";
                                }
			}

			
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
                                direction = null;
			}
        };
		addKeyListener(listener);
		setFocusable(true);

    }
    
    public void paint(Graphics g){
        super.paint(g);
        a.paint(g);
        int x = 950;
        int y = 540;
        
        Polygon p   = new Polygon();
        p.addPoint(x+200, y+100);
        p.addPoint(x+200, y+ -100);
        p.addPoint(x-200, y-100);
        p.addPoint(x-200, y+100);
        g.setColor(Color.red);
        g.fillPolygon(p);
        g.dispose();
        
    }
}
