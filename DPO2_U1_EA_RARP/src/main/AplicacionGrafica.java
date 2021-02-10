package main;

import java.awt.Color;
import javax.swing.*;

public class AplicacionGrafica extends JFrame {

    private JPanel contentPanel;

    public AplicacionGrafica() {
        setTitle("Título de la ventana");
        setBounds(400, 200, 700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        setContentPane(contentPanel);

        //Asignación de una pantalla
        //Etiqueta
        JLabel etiqueta = new JLabel("¡Hola mundo!");
        etiqueta.setBounds(60, 20, 100, 20);
        contentPanel.add(etiqueta);

        //Campo de texto
        var textField = new JTextField();
        textField.setBounds(43, 67, 86, 26);
        contentPanel.add(textField);
    }

    public static void main(String[] args) {
        AplicacionGrafica ventana = new AplicacionGrafica();
    }

}
