package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Principal {

    public static void main(String[] args) {
        //Asignacion del nombre al que se le dara la ventana que hemos seleccionado
        System.out.println("Esta es la clase principal");
        //Declaracion para el contenido de la pagina
        JFrame frame = new JFrame("Ejemplo de eventos");
        //Declaración de los elementos necesarios para darle vista y localizacion de la ventana
        frame.setLocation(100, 100);
        frame.setVisible(true);
        //Metodo que peromite el cierre de la ejecucion del programa
       
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cerrado de ventana");
                //Si no se le agrega esta opcion es posible de que no se cierre e programa
                System.exit(0);
            }

        });

    }
}
