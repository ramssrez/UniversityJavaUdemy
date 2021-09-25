
package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class VentanaDos extends JFrame{
    PanleDos panel = new PanleDos();
    public VentanaDos(){
        this.setTitle("Pagina de inglés");
        this.setSize(new Dimension(700, 700));
        this.setLocationRelativeTo(null);
        this.add(panel,BorderLayout.CENTER);
    }
    
}
