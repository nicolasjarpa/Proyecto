package projecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;

/**
 * Clase con patron builder que nos servira para construir todo lo relacionado
 * con la pista
 *
 * @author tes
 */
public class Autopista {

    private Graphics limite, pista, pasto, tierra;
    private float pastomas;
    private int largopasto;
    private int altopasto;
    private Image mas;
    private Image menos;

    /**
     * El constructor esta vacio ya que al ser un patron builder no necesitamos
     * hacer uso del mismo
     */
    public Autopista() {

    }

    /**
     * Definimos en el paint cada uno de los parametros para que estos mismos se
     * aprecien graficamente en la aplicacion
     *
     * @param g
     */
    public void paint(Graphics g) {
        this.limite = g;
        this.pista = g;
        this.pasto = g;
        this.tierra = g;
    }

    /**
     * La clase imagenmas y la clase imagenmenos sirven para sencillamente
     * mostrar las imagenes de aumento y disminucion de la pista
     */
    public void imagenmas() {
        this.mas = new ImageIcon("mas.jpg").getImage();;
    }

    public void imagenmenos() {
        this.menos = new ImageIcon("menos.jpg").getImage();;
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

    public Image retornamenos() {
        return menos;
    }

    public Image retornanmas() {
        return mas;
    }
}
