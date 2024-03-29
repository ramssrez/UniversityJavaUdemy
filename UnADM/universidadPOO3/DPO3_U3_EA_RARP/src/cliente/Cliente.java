package cliente;

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
public class Cliente extends javax.swing.JFrame implements Runnable {

    //Declaración del host para correr el servidor y cliente en la misma maquina
    private final String HOST = "127.0.0.1";
    //Declaración de los puertos tanto el servidor como el cliente
    private final int PUERTOSERVIDOR = 5000;
    private final int PUERTOCLIENTE = 5050;

    /**
     * Creates new form Registro
     */
    public Cliente() {
        initComponents();
        this.setTitle("Cliente");
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
        //Creación del hilo para su implementación y se mantenga a la escucha del servidor
        Thread thread = new Thread(this);
        thread.start();
        //Asignación de los radio group para ingresar los radio button
        btngRadios.add(jrbPackOne);
        btngRadios.add(jrbPackTwo);
        btngRadios.add(jrbPackThree);
        btngRadios.add(jrbPackFor);
        jrbPackOne.setSelected(true);
        //Asignación del área de texto como no modificable
        jtStatus.setEditable(false);
    }

    //Implementación del la clase Run para comenzar con el hilo de la aplicación
    @Override
    public void run() {
        System.out.println("Esto es un hilo desde el Cliente");
        //Declaración de la variable del pedido
        Pedido pedido;

        //Try/catch para hacer el Cliente como un servidor, con su propio puerto
        try {
            //Declaración serverSocket asignando un puerto exclusivo para el cliente
            ServerSocket servidor = new ServerSocket(PUERTOCLIENTE);
            //Escucha del Cliente para cuando el servidor mande los objetos creados
            while (true) {
                //Declaración del socket para inicializar un servidor dentro de Cliente
                Socket socket = servidor.accept();
                //Declaración del Stream para obtener la información o datos que envie el servidor
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                //Parseo del objeto que venga del servidor a un PacienteAlta
                pedido = (Pedido) inputStream.readObject();
                //Impresión del mensaje de todos los datos que se obtuvieron del servidor
                String mensaje = "Estimado cliente: " + pedido.getNombre() + " hemos recibido"
                        + "\nsu pedido " + pedido.getPack() +", lo estaremos enviando a la "
                        + "\ndirección " + pedido.getDirección() + ". En un tiempo estimado de " + pedido.getTiempo() + ","
                        + "\nsu repartidor es " + pedido.getRepartidor() + " gracias por su preferencia";
                
                //Impresión del mensaje en el área de texto
                jtStatus.setText(mensaje);
                //Cierre del socket
                socket.close();
            }
            //Excepción para el el caso del ServerSocket
        } catch (IOException ex) {
            System.out.println("Error IOException: " + ex.getMessage());
            ex.printStackTrace(System.out);
            //Excepción para el caso de que no se encuentre un objeto desde el servidor
        } catch (ClassNotFoundException ex) {
            System.out.println("Error ClassNotFound: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {
        if ((jtfName.getText().equals("") && jtfPhone.getText().equals("") && jtAdress.getText().equals(""))
                || jtfName.getText().equals("") || jtfPhone.getText().equals("") || jtAdress.getText().equals("")) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;
        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Método que genera la conexión con el servidor 
    public void generarConexionServidor() {
        //Obtención de los datos ingresados en las áreas de texto
        String nombre = jtfName.getText();
        String direccion = jtAdress.getText();
        String telefono = jtfPhone.getText();
        String paquete = null;
        if (jrbPackOne.isSelected()) {
            paquete = "Paquete Uno";
        } else if (jrbPackTwo.isSelected()) {
            paquete = "Paquete Dos";
        } else if (jrbPackThree.isSelected()) {
            paquete = "Paquete Tres";
        } else if (jrbPackFor.isSelected()) {
            paquete = "Paquete Cuatro";
        }
        //Instancia del objeto pedido con lo que se obtuvo del formulario
        Pedido pedido = new Pedido(nombre, direccion, paquete, telefono);
        System.out.println(pedido.toString());
        
        
        //Try/Catch para el socket
        try {
            //Instancia del socket con el uso del Host y el puerto del servidor
            Socket socket = new Socket(HOST, PUERTOSERVIDOR);
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
        //Impresión de que se se ha creado un enio
        jtStatus.setText("Se ha enviado el pedido....");
    }
    
    //Método que limpia los campos de texto que se utilizaron
    public void limpiarCampos(){
        jtAdress.setText("");
        jtfName.setText("");
        jtfPhone.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngRadios = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfPhone = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAdress = new javax.swing.JTextArea();
        jrbPackOne = new javax.swing.JRadioButton();
        jrbPackTwo = new javax.swing.JRadioButton();
        jrbPackThree = new javax.swing.JRadioButton();
        jrbPackFor = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jbtnReealizarPedido = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtStatus = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("La Hamburguesa");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Ingresa los siguientes datos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Teléfono");

        jtfName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfName.setText("Jorge Negrete Sanchez");
        jtfName.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Dirección de entrega");

        jtfPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfPhone.setText("5555555552");
        jtfPhone.setToolTipText("");

        jtAdress.setColumns(20);
        jtAdress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtAdress.setRows(5);
        jtAdress.setText("Av. Revolución #9, Colonia San Pedro Culhuacan\nTexcoco, Estado de México\n");
        jtAdress.setToolTipText("");
        jtAdress.setAutoscrolls(false);
        jScrollPane2.setViewportView(jtAdress);

        jrbPackOne.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbPackOne.setText("Pack 1");

        jrbPackTwo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbPackTwo.setText("Pack 2");

        jrbPackThree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbPackThree.setText("Pack 3");

        jrbPackFor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbPackFor.setText("Pack 4");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Escoge alguno de nuestro paquete");

        jbtnReealizarPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnReealizarPedido.setText("Realizar Pedido");
        jbtnReealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnReealizarPedidoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Status del Pedido");

        jtStatus.setColumns(20);
        jtStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtStatus.setRows(5);
        jtStatus.setToolTipText("");
        jtStatus.setAutoscrolls(false);
        jScrollPane3.setViewportView(jtStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(86, 86, 86))))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jbtnReealizarPedido))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbPackTwo)
                                    .addComponent(jrbPackOne)
                                    .addComponent(jrbPackThree)
                                    .addComponent(jrbPackFor))))
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfName)
                            .addComponent(jtfPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addComponent(jrbPackOne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbPackTwo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbPackThree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbPackFor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnReealizarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método asignado al boton 
    private void jbtnReealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnReealizarPedidoActionPerformed
        //Validación de los campos para que no se encuentren vacios
        if (validacionCamposTexto()) {
            //Llamado al método para la conexión del servidor
            generarConexionServidor();
            //Dialog confirmando que se ha enviado el pedido
            JOptionPane.showMessageDialog(null, "Se ha enviado el pedido");
            //llamado al método que limpia los campos de texto
            limpiarCampos();
            
        } else {
            //Dialog para el caso de que los campos se encuentran vacios
            JOptionPane.showMessageDialog(null, "Los campos se encuentran vacios");
        }
    }//GEN-LAST:event_jbtnReealizarPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngRadios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnReealizarPedido;
    private javax.swing.JRadioButton jrbPackFor;
    private javax.swing.JRadioButton jrbPackOne;
    private javax.swing.JRadioButton jrbPackThree;
    private javax.swing.JRadioButton jrbPackTwo;
    private javax.swing.JTextArea jtAdress;
    private javax.swing.JTextArea jtStatus;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPhone;
    // End of variables declaration//GEN-END:variables
}
