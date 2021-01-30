package main;

import java.awt.event.KeyAdapter; 
import java.awt.event.KeyEvent; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import javax.swing.JFrame; 
import javax.swing.JTextField;

public class TecladoEvent {

    public static void main(String[] args) {
        JTextField cajaTexto= new JTextField("Etiqueta"); 
        cajaTexto.setVisible(true); 
        cajaTexto.setSize(50, 50); 
        cajaTexto.setLocation(100,100);
        
        JFrame frame=new JFrame("Ejemplo de eventos");
        frame.setLocation(200, 200); 
        frame.setVisible(true); 
        frame.setSize(300, 300); 
        frame.add(cajaTexto);
        
        cajaTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                metodoAccion();
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
    
    public static void metodoAccion(){
        System.out.println("Mensaje de salida");
    }
}
