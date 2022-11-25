
package projecto;

import javax.swing.JFrame;


public class Projecto {

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setSize(960, 780);
        ventana.setTitle(" Super Auto");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ventana.setVisible(true);
        
        Interfaz panel = new Interfaz();
        ventana.add(panel);
        ventana.addKeyListener(panel);
    }
    
}
