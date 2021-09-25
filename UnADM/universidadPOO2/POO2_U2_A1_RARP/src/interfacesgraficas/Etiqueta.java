package interfacesgraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Etiqueta {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Marco / Frame");
        frame.setLocation(200, 200);
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        JLabel etiq1= new javax.swing.JLabel(); 
        etiq1.setText("Ejemplo1"); 
        etiq1.setFont(new java.awt.Font("Calibri", 1, 11)); 
        JLabel etiq2= new javax.swing.JLabel(); 
        etiq2.setText("Ejemplo2"); 
        etiq2.setForeground(Color.yellow); 
        JLabel etiq3= new javax.swing.JLabel(); 
        etiq3.setText("Ejemplo3"); 
        etiq3.setVisible(false);
        
        frame.add(etiq1, BorderLayout.PAGE_START); 
        frame.add(etiq2, BorderLayout.CENTER); 
        frame.add(etiq3, BorderLayout.PAGE_END);
    }
}
