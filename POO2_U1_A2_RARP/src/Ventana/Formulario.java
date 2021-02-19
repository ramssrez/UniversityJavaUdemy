package Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Formulario extends JFrame {

    //Declaración de las variables etiqueta y boton
    private JLabel etiqueta;
    private JButton boton;

    public Formulario() {
        setLayout(null);
        //Declaración de una etiqueta que contiene el texto Mensaje
        etiqueta = new JLabel("Mensaje: ");
        //Dimensiones que se le asignan a la etiqueta
        etiqueta.setBounds(15, 10, 150, 30);
        //Se agrega la etiqueta al Frame para que se pueda visualizar
        add(etiqueta);

        //Intancia del objeto boton con un texto en su interior
        boton = new JButton("Presionar");
        //Dimensiones que se le asigna al boton
        boton.setBounds(80, 60, 100, 30);
        //Se agrega la boton al Frame para que se pueda visualizar
        add(boton);
        //Uso del listener para que el boton pueda ser escuchado
        boton.addActionListener(new ActionListener() {
            //Sobreescritura del método actionPerformed
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se cambia el texto de la etiqueta
                etiqueta.setText("Se ha presionado el botón");
            }
        });
    }

    public static void main(String[] args) {
        var formulario = new Formulario();
        formulario.setBounds(0, 0, 300, 200);
        formulario.setTitle("Formulario");
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null);
    }
}
