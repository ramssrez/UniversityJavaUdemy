package main;
//Librerias utilizaas para la creacion de los eventos y adaptadores del mause y la ventana

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BottonClick {

    public static void main(String[] args) {
        //Creación de la ventana que va a contener los elemnttos
        //nombre que se le asigna a la ventana que vamos a crear
        JFrame frame = new JFrame("Ejemplo de eventos");
        //Caracteristicas de la ventana a la que estamos haciendo enfasis
        frame.setLocation(200, 200);
        frame.setVisible(true);
        //Tamaño que se le asigna a la ventana que estamos declarando
        frame.setSize(400, 400);

        //Declaración del botton con un texto en su interior
        JButton button = new JButton("Oprime");
        //Caracteristicas del boton como visibilidad, tamaño y el lugar en donde tiene que apaecer
        button.setVisible(true);
        button.setSize(50, 50);
        button.setLocation(100, 100);

        frame.add(button);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Has presionado el boton");
            }

        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cerrado de ventana");
                System.exit(0);
            }

        });

    }

}
