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
        //Uso de boton en nuestro sistema
        var button = new JButton("Pulsar");
        button.setBounds(43, 133, 89, 23);
        button.setBackground(Color.red);
        contentPanel.add(button);
        //Uso de radiobutton con su respectivo adatador
        var rdButton = new JRadioButton("Opción 1", true);
        var rdButton1 = new JRadioButton("Opción 2", false);
        var rdButton2 = new JRadioButton("Opción 3", false);
        rdButton.setBounds(43, 194, 109, 23);
        rdButton1.setBounds(43, 220, 109, 23);
        rdButton2.setBounds(43, 246, 109, 23);
        contentPanel.add(rdButton);
        contentPanel.add(rdButton1);
        contentPanel.add(rdButton2);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdButton);
        buttonGroup.add(rdButton1);
        buttonGroup.add(rdButton2);
    }

    public static void main(String[] args) {
        AplicacionGrafica ventana = new AplicacionGrafica();
    }

}
