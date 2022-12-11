package projecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;

public class Autopista {

    private Graphics limite, pista, pasto, tierra;
    private float pastomas;
    private int largopasto;
    private int altopasto;
    private Image mas;
    private Image menos;

    public Autopista() {
  
    }

    public void paint(Graphics g) {
        this.limite = g;
        this.pista = g;
        this.pasto = g;
        this.tierra = g;
    }

    

    
    public void imagenmas(){
        this.mas=new ImageIcon("mas.jpg").getImage();;
    }
    public void imagenmenos(){
        this.menos=new ImageIcon("menos.jpg").getImage();;
    }

    public Graphics retornarlimite() {
        return limite;
    }
public Graphics retornarpista() {
        return pista;
    }
public Graphics retornarpasto() {
        return pasto;
    }
public Graphics retornartierra() {
        return tierra;
    }


 public Image retornamenos(){
        return menos;
    }
  public Image retornanmas(){
        return mas;
    }
} 