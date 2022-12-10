package projecto;

import javax.swing.JFrame;
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

public class frame extends JFrame{

    Interfaz ventana = new Interfaz();

    public frame() {
        this.setSize(1600, 1000);
        this.add(ventana);
        this.setTitle(" Super Auto");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);

        this.addKeyListener(ventana);
        ventana.config();
    }


}
