package interfacesgraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MEnu {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Marco / Frame");
        frame.setLocation(200, 200);
        frame.setVisible(true);
        frame.setSize(300, 200);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JPanel pnl = new javax.swing.JPanel();
        pnl.setBackground(Color.CYAN);
        JMenuBar barra = new javax.swing.JMenuBar();
        JMenu elemento1 = new javax.swing.JMenu();
        elemento1.setText("Elemento1");
        JMenu elemento2 = new javax.swing.JMenu();
        elemento2.setText("Elemento2");
        JMenuItem sub1 = new javax.swing.JMenuItem();
        sub1.setText("Sub-Elemento1");
        elemento2.add(sub1);
        barra.add(elemento1);
        barra.add(elemento2);

        frame.add(barra, BorderLayout.PAGE_START);
        frame.add(pnl, BorderLayout.PAGE_END);
    }
}
