package ejemplograficos;

import java.awt.Frame;
import javax.swing.JFrame;

public class EjemploGraficos {
    
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setTitle("Frame vacíio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        Frame frame2 = new Frame();
        frame2.setSize(300, 400);
        frame2.setVisible(true);
        frame2.setTitle("Frame vacío dos");
        
        
    }
    
}
