package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Esta es la clase principal");
        JFrame frame = new JFrame("Ejemlo de eventos");
        frame.setLocation(100, 100);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cerrado de ventana");
                System.exit(0);
            }

        });

    }
}
