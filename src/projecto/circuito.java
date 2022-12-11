/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecto;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Nicolás Jarpa
 */
public class circuito {

    private Autopista autopista;
    public int largo=0;
    public int alto=0;
    public float pastomas=0f;

    public circuito() {
        autopista=new Autopista();
        
     autopista.imagenmas();
     autopista.imagenmenos();
    }

    public void paint(Graphics g) {
        autopista.paint(g);
        autopista.retornarlimite().setColor(Color.blue);
        autopista.retornarlimite().fillRect(0, 0, 1600, 1000);
        autopista.retornarpista().setColor(Color.DARK_GRAY);
        autopista.retornarpista().fillRect(50, 50, 1450, 750);
        autopista.retornarpasto().setColor(Color.green);
        autopista.retornarpasto().fillRect(190 - (int) pastomas, 190 - (int) pastomas, 1160 + (int) pastomas * 2 , 480 + (int) pastomas * 2);
        autopista.retornartierra().setColor(Color.black);
        autopista.retornartierra().fillRect(330, 330, 880, 200);
        largo = 1100 + (int) pastomas;
        alto = 500 + (int) pastomas;
        g.drawImage(autopista.retornanmas(), 100, 835, 100, 100, null);
        g.drawImage(autopista.retornamenos(), 300, 835, 100, 100, null);
    }

}
