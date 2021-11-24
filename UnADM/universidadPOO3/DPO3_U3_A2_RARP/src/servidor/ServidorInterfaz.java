package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import objetos.PacienteAlta;

/**
 *
 * @author ramssrez
 */
public class ServidorInterfaz extends javax.swing.JFrame implements Runnable {

    //Declaración de variables necesarias para su implementación
    private final String HOST = "127.0.0.1";
    //Declaración de puertos para el servidor y el cleinte
    private final int PUERTOSERVIDOR = 5000;
    private final int PUERTOCLIENTE = 5050;
    private int contador = 0;

    //Declaración de los doctores que con los que se cuentan en urgencias
    private final String dr1 = "Dr. Juan Sanchez Sanchez";
    private final String dr2 = "Dra. Irma Fernandez Fernandez";
    private final String dr3 = "Dr. Carlos Leon Leon";
    private final String dr4 = "Dra. Rosa Mercado Mercado";
    private final String dr5 = "Dr. Rodrigo Leyva Leyva";
    private final String dr6 = "Dra. Sofia Lazcano Lazcano";
    private final String dr7 = "Dr. Gerardo Martinez Martinez";
    private final String dr8 = "Dra. Alma Diaz Diaz";
    private final String dr9 = "Dr. Jose Rodriguez Rodrioguez";
    private final String dr10 = "Dra. Selena Sanchez Sanchez";

    //Creación del arreglos que contiene la información del 
    String[] doctores = {dr1, dr2, dr3, dr4, dr5, dr6, dr7, dr8, dr9, dr10};

    /**
     * Creates new form CrearArchivos
     */
    public ServidorInterfaz() {
        initComponents();
        this.setTitle("Servidor");
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
        jtfRegistro.setEditable(false);
        //Creación del hilo
        Thread thread = new Thread(this);
        thread.start();
    }

    //]Uso del método run, el cual es necesario usar por la implementación de runneable
    @Override
    public void run() {
        System.out.println("Esto es desde el hilo servidor");
        //Decalración del paciente}alta
        PacienteAlta pacienteAlta;

        //Try/catch
        try {
            //Declaración de la variable name
            String name;
            //Delaclaración del serverSocket con el puerto donde se va alojar el servidor
            ServerSocket servidor = new ServerSocket(PUERTOSERVIDOR);
            //Uso del while para que el servidor se encuentre constantemente a la escucha del cliente
            while (true) {
                //Inicializacion del socket
                Socket socket = servidor.accept();
                //Uso del if para el caso de que sea igual a un valor se resetea el contador
                if (contador == 10) {
                    contador = 0;
                }
                //Declaración del Stream para obtener los que envie el Cliente
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                //Parse del objeto que envia el cliente a un objeto de tipo PacienteAlta
                pacienteAlta = (PacienteAlta) inputStream.readObject();
                //Obtencio del nombre del paciente
                name = pacienteAlta.getNombre();
                //Impresión del nombre del paciente para comprobar que se registro exitosamente
                String message = "\n El paciente " + name + " fue registrado exitosamente";
                jtfRegistro.setText(message);
                //Asignación del doctor al paciente
                pacienteAlta.setDoctorAsignado(doctores[contador]);
                //Asignación del consultorio para el paciente
                String consultorio = String.valueOf(contador + 2);
                pacienteAlta.setNumeroConsultorio(consultorio);
                //Asignación del turno del paciente
                String turno = String.valueOf(contador + 1);
                pacienteAlta.setNumeroTurno(turno);
                //Declaración del socket en donde se cuenta con los daots del Cliente
                Socket socketRespuesta = new Socket(HOST, PUERTOCLIENTE);
                //Envio de los datos del objeto donde se modifico ciertos datos del objeto
                ObjectOutputStream envioCliente = new ObjectOutputStream(socketRespuesta.getOutputStream());
                //Envio del objetodo hacia el cliente
                envioCliente.writeObject(pacienteAlta);
                //Cierre de los socket de recibo y repuesta del servidor
                socketRespuesta.close();
                socket.close();
                //Incremento del contador
                contador++;
            }

        } catch (IOException ex) {
            System.out.println("Error Selección: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Selección: " + ex.getMessage());
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jtfRegistro = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Hospital General: Servidor");

        jtfRegistro.setColumns(20);
        jtfRegistro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfRegistro.setRows(5);
        jtfRegistro.setToolTipText("");
        jtfRegistro.setAutoscrolls(false);
        jScrollPane2.setViewportView(jtfRegistro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ServidorInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServidorInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServidorInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServidorInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServidorInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtfRegistro;
    // End of variables declaration//GEN-END:variables

}
