package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import objetos.Pedido;

/**
 *
 * @author ramssrez
 */
public class Servidor extends javax.swing.JFrame implements Runnable {

    //Declaración del host para correr el servidor y cliente en la misma maquina
    private final String HOST = "127.0.0.1";
    //Declaración de los puertos tanto el servidor como el cliente
    private final int PUERTOSERVIDOR = 5000;
    private final int PUERTOCLIENTE = 5050;
    private Pedido pedido;

    /**
     * Creates new form Registro
     */
    public Servidor() {
        initComponents();
        this.setTitle("Servidor");
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
        //Creación del hilo para su implementación y se mantenga a la escucha del servidor
        Thread thread = new Thread(this);
        thread.start();
        //Asignación del área de texto como no modificable
        jtDatosPedidos.setEditable(false);
    }

    //Uso del metodo run para poder realizar un hilo para que se mantenga a la escucha del cliente
    @Override
    public void run() {
        System.out.println("Esto es un hilo desde el Servidor");

        //Try/catch
        try {
            //Delaclaración del serverSocket con el puerto donde se va alojar el servidor
            ServerSocket servidor = new ServerSocket(PUERTOSERVIDOR);
            //Uso del while para que el servidor se encuentre constantemente a la escucha del cliente
            while (true) {
                //Inicializacion del socket
                Socket socket = servidor.accept();
                //Declaración del Stream para obtener los que envie el Cliente
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                //Parse del objeto que envia el cliente a un objeto de tipo PacienteAlta
                pedido = (Pedido) inputStream.readObject();
                //Recuperación de la información del pedido para mostrarla en el área de texto
                String mensajePedido = "Pedido recibido: "
                        + "\nNombre cliente: " + pedido.getNombre()
                        + "\nPaquete escogido: " + pedido.getPack()
                        + "\nTelefono: " + pedido.getTelefono()
                        + "\nDirección: " + pedido.getDirección();
                //Asiganción de la información que se obtuvo del cliente
                jtDatosPedidos.setText(mensajePedido);
                //Cierre del socket
                socket.close();
            }

        } catch (IOException ex) {
            System.out.println("Error Selección: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Selección: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {
        if ((jtfNameRepartidor.getText().equals("") && jtfHora.getText().equals(""))
                || jtfNameRepartidor.getText().equals("") || jtfHora.getText().equals("")) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;
        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Método que genera la conexión con el servidor 
    public void generarConexionCliente() {
        //Obtención de los datos ingresados en las áreas de texto
        String nombre = jtfNameRepartidor.getText();
        String tiempo = jtfHora.getText();
        pedido.setRepartidor(nombre);
        pedido.setTiempo(tiempo);

        //Instancia del objeto formulario con lo que se obtuvo del formulario
        //Pedido pedido = new Pedido(nombre, direccion, paquete, telefono);
        System.out.println(pedido.toString());

        //Try/Catch para el socket
        try {
            //Instancia del socket con el uso del Host y el puerto del servidor
            Socket socket = new Socket(HOST, PUERTOCLIENTE);
            //Instancia del Stream para enviar el objeto por medio de la red
            ObjectOutputStream envioDatos = new ObjectOutputStream(socket.getOutputStream());
            //Envio del objeto
            envioDatos.writeObject(pedido);
            //Cierre de la coneción del servidor
            socket.close();

            //Catch que registra algún error por parte del servidor
        } catch (IOException ex) {
            System.out.println("Error IOException: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }

    //Método que se encarga de limpiar los ccampos de texto
    public void limpiarCampos() {
        jtDatosPedidos.setText("");
        jtfNameRepartidor.setText("");
        jtfHora.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtDatosPedidos = new javax.swing.JTextArea();
        jtfNameRepartidor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfHora = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("La Hamburguesa:Servidor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Datos del pedido");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nombre del repartidor");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Asignar Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtDatosPedidos.setColumns(20);
        jtDatosPedidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtDatosPedidos.setRows(5);
        jtDatosPedidos.setToolTipText("");
        jtDatosPedidos.setAutoscrolls(false);
        jScrollPane3.setViewportView(jtDatosPedidos);

        jtfNameRepartidor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfNameRepartidor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfNameRepartidor.setText("Pedro Infante");
        jtfNameRepartidor.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tiempo de entrega");

        jtfHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfHora.setText("30 Minutos");
        jtfHora.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jtfNameRepartidor)
                    .addComponent(jtfHora))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNameRepartidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método asginado al boton
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (pedido != null) {
            //Validación de los campos para que no se encuentren vacios
            if (validacionCamposTexto()) {
                //Llamado al método para la conexión del servidor
                generarConexionCliente();
                //JDialog que menciona que se a enviado a un repartidor
                JOptionPane.showMessageDialog(null, "Se ha enviado al repartidor");
                //Lllamado al método para limpiar datos
                limpiarCampos();
                //Asignación del pedido como nulo
                pedido = null;
            } else {
                //Dialog para el caso de que los campos se encuentran vacios
                JOptionPane.showMessageDialog(null, "Los campos se encuentran vacios");
            }
        } else {
            //Dialog para el caso de que los campos se encuentran vacios
            JOptionPane.showMessageDialog(null, "No se cuenta con información de algún pedido");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtDatosPedidos;
    private javax.swing.JTextField jtfHora;
    private javax.swing.JTextField jtfNameRepartidor;
    // End of variables declaration//GEN-END:variables
}
