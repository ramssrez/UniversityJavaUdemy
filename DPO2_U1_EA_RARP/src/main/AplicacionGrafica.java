package main;

import javax.swing.*;

public class AplicacionGrafica  extends JFrame{
    private JPanel contentPanel;
    public AplicacionGrafica(){
        setTitle("Título de la ventana");
        setBounds(400,200,700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        setContentPane(contentPanel);
        
        //Asignación de una pantalla
        JLabel etiqueta =new JLabel("Hola mundo desde interfaz gráfica");
        etiqueta.setBounds(60, 20, 150, 20);
        contentPanel.add(etiqueta);
        
    }
   
    public static void main(String[] args) {
        AplicacionGrafica ventana = new AplicacionGrafica();
    }
    
}
