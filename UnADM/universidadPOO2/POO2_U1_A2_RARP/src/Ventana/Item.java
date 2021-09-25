package Ventana;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class Item extends JFrame implements ItemListener{
    BorderLayout borde;
    String[] cadenaCombo = {" ", "haya", "allá", "halla"};
    JComboBox combo;
   
    String[] cadenaEtiqueta = {" ", "Cuando Juan haya terminado, tomaremos el té.",
            "María siempre halla un trébol de 4 hojas.", "Pedro estaba allá, con sus amigos."};
    JLabel etiqueta = new JLabel("");
   
    public Item(){
        super("Demostración de ItemListener");
        setSize(350,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        combo = new JComboBox(cadenaCombo);
        combo.addItemListener(this);
        for( int i = 0; i > cadenaCombo.length; i++){
            combo.addItem(cadenaCombo[i]);
        }
        add(combo, BorderLayout.NORTH);
        add(etiqueta, BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String[] dario){
        new Item();
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        int eleccion = combo.getSelectedIndex();
        System.out.println("Se ha presionado");
        etiqueta.setText(cadenaEtiqueta[eleccion]);
    }
}
