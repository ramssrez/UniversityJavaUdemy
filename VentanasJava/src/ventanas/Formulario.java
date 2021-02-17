package ventanas;

import java.awt.event.*;
import javax.swing.*;


public class Formulario extends JFrame implements ActionListener {

    private JButton button;
    private JTextField txtFiel;
    private JLabel label;

    public Formulario() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        label = new JLabel("Mensaje");
        label.setBounds(15, 10, 100, 30);
        add(label);
        
        txtFiel = new JTextField();
        txtFiel.setBounds(80, 16, 190, 20);
        add(txtFiel);
        
        button = new JButton("Mostrar");
        button.setBounds(10, 60, 100, 30);
        add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String cadena = txtFiel.getText();
            System.out.println("Esto es la accion del boton");
            JOptionPane.showMessageDialog(null, cadena);
        }
    }
    
    public static void main(String[] args) {
        var formulario =new Formulario();
        formulario.setBounds(0, 0, 300, 150);
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null);
    }

}
