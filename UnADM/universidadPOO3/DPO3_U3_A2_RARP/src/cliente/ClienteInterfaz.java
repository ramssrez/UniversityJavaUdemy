package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;
import objetos.PacienteAlta;

/**
 *
 * @author ramssrez
 */
public class ClienteInterfaz extends javax.swing.JFrame implements Runnable {
    //Declaración del host para correr el servidor y cliente en la misma maquina
    private final String HOST = "127.0.0.1";
    //Declaración de los puertos tanto el servidor como el cliente
    private final int PUERTOSERVIDOR = 5000;
    private final int PUERTOCLIENTE = 5050;

    /**
     * Creates new form CrearArchivos
     */
    public ClienteInterfaz() {
        initComponents();
        this.setTitle("Cliente");
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
        //Creación del hilo para su implementación y se mantenga a la escucha del servidor
        Thread thread = new Thread(this);
        thread.start();
        jtaDatosServidor.setEnabled(false);
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {
        if ((jtfName.getText().equals("") && jtfSocialNumber.getText().equals("") && jtaSintomas.getText().equals(""))
                || jtfName.getText().equals("") || jtfSocialNumber.getText().equals("") || jtaSintomas.getText().equals("")) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;
        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Método para limpiár las areas de texto de la aplicación
    public void limpiarCampos() {
        jtfName.setText("");
        jtfSocialNumber.setText("");
        jtaSintomas.setText("");
    }

    //Método que genera la conexión con el servidor 
    public void generarConexionServidor() {
        //Obtención de los datos ingresados en las áreas de texto
        String nombre = jtfName.getText();
        String numero = jtfSocialNumber.getText();
        String sintomas = jtaSintomas.getText();
        //Instancia del objeto paciente con lo que se obtuvo del formulacio
        PacienteAlta paciente = new PacienteAlta(nombre, numero, sintomas);
        //Try/Catch para el socket
        try {
            //Instancia del socket con el uso del Host y el puerto del servidor
            Socket socket = new Socket(HOST, PUERTOSERVIDOR);
            //Instancia del Stream para enviar el objeto por medio de la red
            ObjectOutputStream envioDatos = new ObjectOutputStream(socket.getOutputStream());
            //Envio del objeto
            envioDatos.writeObject(paciente);
            //Cierre de la coneción del servidor
            socket.close();

            //Catch que registra algún error por parte del servidor
        } catch (IOException ex) {
            System.out.println("Error IOException: " + ex.getMessage());
            ex.printStackTrace(System.out);;
        }

    }

    //]Uso del método run, el cual es necesario usar por la implementación de runneable y se mantenga a la escucha del servidor
    @Override
    public void run() {
        System.out.println("Esto es desde el hilo cliente");
        //DElcaración de la variable del paciente
        PacienteAlta pacienteAsignado;
        
        //Try/catch para hacer el Cliente como un servidor, con su propio puerto
        try {
            //Declaración serverSocket asignando un puerto exclusivo para el cliente
            ServerSocket servidor = new ServerSocket(PUERTOCLIENTE);
            //Escucha del Cleitne para cuando el servidor mande los objetos creados
            while (true) {
                //Declaración del socket para inicializar un servidor dentro de Cliente
                Socket socket = servidor.accept();
                //DEclaración del Stream para obtener la información o datos que envie el servidor
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                //Parseo del objeto que venga del servidor a un PacienteAlta
                pacienteAsignado = (PacienteAlta) inputStream.readObject();
                //Impresión del mensaje de todos los datos que se obtuvieron del servidor
                String mensaje = "Turno: " + pacienteAsignado.getNumeroTurno() + 
                        "\nNúmero Seguro Social: " + pacienteAsignado.getNumeroSocial() +
                        "\nNombre: " + pacienteAsignado.getNombre() +
                        "\nSintomas: " + pacienteAsignado.getSintomas() +
                        "\nNombre Doctor: " + pacienteAsignado.getDoctorAsignado() +
                        "\nNúmero consultorio: " + pacienteAsignado.getNumeroConsultorio();
                //Impresión del mensaje en el área de texto
                jtaDatosServidor.setText(mensaje);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtnEnviar = new javax.swing.JButton();
        jtfName = new javax.swing.JTextField();
        jtfSocialNumber = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaSintomas = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaDatosServidor = new javax.swing.JTextArea();
        jbtnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Hospital General: Urgencias");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del paciente:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Número Seguro Social:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sintomas");

        jbtnEnviar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnEnviar.setText("Registrar");
        jbtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEnviarActionPerformed(evt);
            }
        });

        jtfName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfName.setText("Jorge Negrete Sanchez");
        jtfName.setToolTipText("");

        jtfSocialNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfSocialNumber.setText("589474036");
        jtfSocialNumber.setToolTipText("");

        jtaSintomas.setColumns(20);
        jtaSintomas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtaSintomas.setRows(5);
        jtaSintomas.setText("Dolor abdominal, temperatura de 39 °C, se queja de dolor en todo el cuerpo");
        jtaSintomas.setToolTipText("");
        jtaSintomas.setAutoscrolls(false);
        jScrollPane1.setViewportView(jtaSintomas);

        jtaDatosServidor.setColumns(20);
        jtaDatosServidor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtaDatosServidor.setRows(5);
        jtaDatosServidor.setToolTipText("");
        jtaDatosServidor.setAutoscrolls(false);
        jScrollPane2.setViewportView(jtaDatosServidor);

        jbtnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnLimpiar.setText("Limpiar Campos");
        jbtnLimpiar.setToolTipText("");
        jbtnLimpiar.setActionCommand("Limpiar Campos");
        jbtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(jLabel2))))
                            .addComponent(jtfName)
                            .addComponent(jtfSocialNumber, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jbtnEnviar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jbtnLimpiar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSocialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Evento del botón para el envio del objeto
    private void jbtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEnviarActionPerformed
        //Validación de los campos para que no se encuentren vacios
        if (validacionCamposTexto()) {
            //Llamado al método para la conexión del servidor
            generarConexionServidor();
        } else {
            //Dialog para el caso de que los campos se encuentran vacios
            JOptionPane.showMessageDialog(null, "Los campos se encuentran vacios");
        }
        //Llamado el método para limpiat los campos 
        limpiarCampos();
    }//GEN-LAST:event_jbtnEnviarActionPerformed

    private void jbtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        jtaDatosServidor.setText("");
    }//GEN-LAST:event_jbtnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnEnviar;
    private javax.swing.JButton jbtnLimpiar;
    private javax.swing.JTextArea jtaDatosServidor;
    private javax.swing.JTextArea jtaSintomas;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfSocialNumber;
    // End of variables declaration//GEN-END:variables
}
