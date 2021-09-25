/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplograficos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ramssrez
 */
public class Ventana extends JFrame {

    JButton button;
    JPanelConFondo jPanel;

    public Ventana() {
        this.setBounds(0, 0, 400, 400);
        this.setTitle("Ventana");
        Container container = getContentPane();
        container.setLayout(null);
        this.setVisible(true);

        //button = new JButton("Pulsar");
        button = new JButton();
        button.setBounds(0, 0, 150, 150);
        //Image icon = new ImageIcon("C:/Users/ramss/Downloads/limpiar.png").getImage();
        //
        //Image icon = new ImageIcon(getClass().getResource("satelite.jpg")).getImage();
        ImageIcon icon = new ImageIcon(getClass().getResource("limpiar.png"));
        System.out.println("" + getClass().getResource("limpiar.png"));
        //System.out.println(""+getClass().getClassLoader().getResources("limpiarDos."));

        button.setIcon(icon);
        jPanel = new JPanelConFondo();
        jPanel.setBounds(0, 200, 400, 200);
        //jPanel.setImagen(icon);
        jPanel.setBackground(Color.red);
        container.add(button);
        container.add(jPanel);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        String ruta = "ejemplograficos";
        //C:\Users\ramss\Downloads\Bloc
        //C:\Users\ramss\Documents\CarpetaJava\EjemploGraficos\src\imagenes
        String sFichero = "C:/Users/ramss/Documents/CarpetaJava/EjemploGraficos/src/imagenes/limpiarDos.png";
        File file = new File(sFichero);
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("Es un archivo");
            }
            if (file.isDirectory()) {
                System.out.println("Es un directorio");
            }
        } else {
            System.out.println("NO eiste el archivo");
        }
    }
}
