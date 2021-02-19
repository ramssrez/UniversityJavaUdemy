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

    private JLabel label;
    private JButton button;

    public Formulario() {
        setLayout(null);
        label = new JLabel("Mensaje: ");
        label.setBounds(15, 10, 150, 30);
        add(label);

        button = new JButton("Presionar");
        button.setBounds(80, 60, 100, 30);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "El botón se ha presionado");
                label.setText("Se ha presionado el botón");
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
