package ventanas;

import java.awt.Color;
import java.awt.TextComponent;
import java.awt.event.*;
import javax.swing.*;

public class Formulario extends JFrame implements ActionListener {

    private JButton button, button2;
    private JTextField txtFiel;
    private JLabel label;
    private TextComponent text;

    public Formulario() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("Mensaje: ");
        label.setBounds(15, 10, 100, 30);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Se esta presionado el label");
                label.setText("Clic");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Pasando");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Mensaje:");
            }

        });
        add(label);

        txtFiel = new JTextField();
        txtFiel.setBounds(80, 16, 190, 20);
             
        txtFiel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Se ha presionado con un teclado");
            }
        });
        add(txtFiel);

        button = new JButton("Mostrar");
        button.setBounds(80, 60, 100, 30);
        add(button);
        button.addActionListener(this);

//        button2 = new JButton("Oprime");
//        button2.setBounds(80, 100, 100, 30);
//        button2.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("Diste clic en el boton oprime");
//            }
//            
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                button2.setText("No prss nara");
//                button2.setBackground(Color.ORANGE);
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                button2.setBackground(Color.red);
//                button2.setText("Rojo Entra");
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                button2.setBackground(Color.PINK);
//                button2.setText("pink Sale");
//            }
//            
//
//        });
       // add(button2);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Se ha cerrado");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("La ventana se ha minimizado");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("La ventana ha vuelto");
            }
            
            
 
        });

        //
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.out.println("Se ha cerrado");
//                JOptionPane.showMessageDialog(null, "Ventana se ha cerrado");
//                System.exit(0);
//            }
//
//            @Override
//            public void windowDeiconified(WindowEvent e) {
//                System.out.println("La ventana ha vuelto");
//                JOptionPane.showMessageDialog(null, "Ventana ha maximizado");
//            }
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
        var formulario = new Formulario();
        formulario.setBounds(0, 0, 300, 200);
        formulario.setTitle("Formulario");
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null);
    }

}
