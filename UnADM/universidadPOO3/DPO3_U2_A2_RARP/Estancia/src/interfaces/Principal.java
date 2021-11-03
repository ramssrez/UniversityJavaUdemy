/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package interfaces;

import database.HabitacionDAO;
import database.ReservacionDAO;
import java.util.Date;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Habitacion;
import objetos.Reservacion;

public class Principal extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private List<Habitacion> listaHabitacionGlobal;
    private int costoHabitacion;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setTitle("Inicio");
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
        obtenerDatos();
    }

    private DefaultTableModel setTitulos() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("Número Habitación");
        dtm.addColumn("Estatus");
        dtm.addColumn("Tipo");
        dtm.addColumn("Costo");
        return dtm;
    }

    private DefaultTableModel setTitulosReserva() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("Fecha Entrada");
        dtm.addColumn("Fecha Salida");
        dtm.addColumn("Dias");
        dtm.addColumn("Costo Total");
        return dtm;
    }

    private void obtenerDatos() {
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        listaHabitacionGlobal = habitacionDAO.seleccionarLista();
        setTitulos();
        Object[] fila = new Object[5];
        listaHabitacionGlobal.forEach(habitacion -> {
            fila[0] = habitacion.getIdHabitacion();
            fila[1] = habitacion.getNumeroHabitacion();
            fila[2] = habitacion.getStatus();
            fila[3] = habitacion.getTipoHabitacion();
            fila[4] = habitacion.getCostoHabitacion();
            dtm.addRow(fila);
        });
        tableData.setModel(dtm);
    }

    public void modificarEstatusHabitacion(int numero) {
        //Instancia de la clase ProductoDAO
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        int entero = habitacionDAO.actualizar(numero);
        if (entero > 0) {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "Se han modificado el status de la habitación");
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
        } else {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "No se ha modificado el estatus de la habitación la habitación");
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        jdtStart.setDate(null);
        jdtFinish.setDate(null);
        jtfIdentificador.setText("");
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {

        if ((jdtStart.getDate() == null && jdtFinish.getDate() == null && jtfIdentificador.getText().equals(""))
                || jdtStart.getDate() == null || jdtStart.getDate() == null || jtfIdentificador.getText().equals("")) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;

        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Calculo de los dias entre dos fechas
    public int diasEntreFechas(Date fechaSalida, Date fechaEntrada) {
        int milisecondsByDay = 86400000;
        int dias = (int) ((fechaSalida.getTime() - fechaEntrada.getTime()) / milisecondsByDay);
        return dias;
    }

    public void cambioFechas() {
        Date fechaEntrada = jdtStart.getDate();
        long dE = fechaEntrada.getTime();
        Date fechaSalida = jdtFinish.getDate();
        long dS = fechaSalida.getTime();
        java.sql.Date entrada = new java.sql.Date(dE);
        JOptionPane.showMessageDialog(null, "Fecha entrada" + entrada);
        java.sql.Date salida = new java.sql.Date(dS);
        JOptionPane.showMessageDialog(null, "fecha Salida: " + salida);
    }

    public java.sql.Date formatoFechaSql(Date date) {
        long dateLong = date.getTime();
        java.sql.Date dateSQL = new java.sql.Date(dateLong);
        return dateSQL;
    }

    public int costoTotal(int numero, int dias) {
        listaHabitacionGlobal.forEach(hab -> {
            if (hab.getIdHabitacion() == numero) {
                costoHabitacion = hab.getCostoHabitacion();
            }
        });
        int costoTotal = costoHabitacion * dias;
        return costoTotal;
    }

    public void crearReservacion() {
        Date fechaEntrada = jdtStart.getDate();
        Date fechaSalida = jdtFinish.getDate();
        int numero = Integer.parseInt(jtfIdentificador.getText());
        modificarEstatusHabitacion(numero);
        int dias = diasEntreFechas(fechaSalida, fechaEntrada);
        int costo = costoTotal(numero, dias);
        Reservacion reservacion = new Reservacion(formatoFechaSql(fechaEntrada), formatoFechaSql(fechaSalida), numero, dias, costo);
        System.out.println("reservacion = " + reservacion.toString());
        ReservacionDAO rdao = new ReservacionDAO();
        int entero = rdao.insertar(reservacion);
        if (entero > 0) {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "Se han creado la reservación");
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
        } else {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "No se ha res3ervado la habitación");
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jdtStart = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdtFinish = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfIdentificador = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnCrearReservacion = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableReser = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableData.setFocusable(false);
        jScrollPane3.setViewportView(tableData);

        jdtStart.setDateFormatString("yyyy-MM-dd");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenidos al Hotel La Estancia");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Selecciona la fecha de entrada (yyyy-MM-dd)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Sistema de Reservaciones");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Selecciona la fecha de salida (yyyy-MM-dd)");

        jdtFinish.setDateFormatString("yyyy-MM-dd");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Ingresa el Id de la habitación");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Lista de habitaciones disponibles");

        jtfIdentificador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpiar.setText("LimpiarCampos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCrearReservacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrearReservacion.setText("Crear Reservación");
        btnCrearReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearReservacionActionPerformed(evt);
            }
        });

        tableReser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableReser.setFocusable(false);
        jScrollPane4.setViewportView(tableReser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdtFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtfIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnCrearReservacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addGap(77, 77, 77))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addComponent(jdtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jdtFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCrearReservacion))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCrearReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearReservacionActionPerformed
        if (validacionCamposTexto()) {
            JOptionPane.showMessageDialog(null, "Los campos se encuentran llenos");
            crearReservacion();
        } else {
            JOptionPane.showMessageDialog(null, "Los campos se encuentran vacios");
        }
        listaHabitacionGlobal = null;
        obtenerDatos();
    }//GEN-LAST:event_btnCrearReservacionActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    //Variables de los diferentes componentes de la ventana


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearReservacion;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdtFinish;
    private com.toedter.calendar.JDateChooser jdtStart;
    private javax.swing.JTextField jtfIdentificador;
    private javax.swing.JTable tableData;
    private javax.swing.JTable tableReser;
    // End of variables declaration//GEN-END:variables
}
