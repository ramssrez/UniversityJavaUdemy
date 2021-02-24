package interfacesgraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Panle { 
    public static void main(String[] args) {
        JFrame frame=new JFrame("Marco / Frame");
        frame.setLocation(200, 200); 
        frame.setVisible(true); 
        frame.setSize(500, 500);
        frame.addWindowListener(new WindowAdapter() { 
            @Override 
            public void windowClosing(WindowEvent e){ 
                System.exit(0); 
            } 
        });
        JPanel pnl = new javax.swing.JPanel(); 
        pnl.setBackground(Color.CYAN); 
        JPanel pnl2 = new javax.swing.JPanel(); 
        pnl2.setBackground(Color.MAGENTA);
        pnl2.setBorder(javax.swing.BorderFactory.createTitledBorder("Borde con titulo")); 
        JPanel pnl3 = new javax.swing.JPanel(); 
        pnl3.setBackground(Color.ORANGE);
        frame.add(pnl, BorderLayout.PAGE_START); 
        frame.add(pnl2, BorderLayout.CENTER); 
        frame.add(pnl3, BorderLayout.PAGE_END);
        
    }
    
}    