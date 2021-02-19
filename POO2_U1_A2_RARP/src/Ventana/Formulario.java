package Ventana;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Formulario extends JFrame {

    //Declaración de las variables etiqueta y boton
    private JLabel etiqueta;
    private JButton boton;
    private JCheckBox checkbox;

    public Formulario() {
        setLayout(null);
        //Declaración de una etiqueta que contiene el texto Mensaje
        etiqueta = new JLabel("Mensaje: ");
        //Dimensiones que se le asignan a la etiqueta
        etiqueta.setBounds(15, 10, 200, 30);
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

        //Uso de listener para la ventana y pueda ser escuchado
        addWindowListener(new WindowAdapter() {
            //Sobreescritura del método windowIconified
            @Override
            public void windowIconified(WindowEvent e) {
                //Creación de una pantalla que menciona que la ventana se ha
                //minimizado
                JOptionPane.showMessageDialog(null, "Ventana se ha minimizado");
            }

            //Sobrescrituradel método windowDeinconified
            @Override
            public void windowDeiconified(WindowEvent e) {
                //Creación de una pantalla que menciona que la ventana se ha
                //maximizado
                JOptionPane.showMessageDialog(null, "Ventana ha maximizado");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Se ha cerrado");
                System.exit(0);
            }
        });

        //Instancia del checkbox
        checkbox = new JCheckBox("Opción 1");
        //Asignación de tamaño y posición de checkbox
        checkbox.setBounds(80, 90, 150, 30);
        //Implementación del listener
        checkbox.addItemListener(new ItemListener() {
            //Sobrescritura del método que recibe el cambio de estado del checkbox
            @Override
            public void itemStateChanged(ItemEvent e) {
                //Uso de sentencia if, para el caso cuando esta selecionado
                if (checkbox.isSelected()) {//Sentencia cuando cambia de estado el componente
                    //Cambio del texto de la etiqueta y de checkbox
                    etiqueta.setText("El checbox esta seleccionado");
                    checkbox.setText("Seleccionado");
                } else {
                    //Cambio de texto cuando no esta seleccionado
                    etiqueta.setText("El checbox no esta seleccionado");
                    checkbox.setText("No seleccionado");
                }
            }
        });
        //Agregar el checkbox en el Frame
        add(checkbox);

    }

    public static void main(String[] args) {
        var formulario = new Formulario();
        formulario.setBounds(0, 0, 300, 200);
        formulario.setTitle("Formulario");
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null);
    }
}
