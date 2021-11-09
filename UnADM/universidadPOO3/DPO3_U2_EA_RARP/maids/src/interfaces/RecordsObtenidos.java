/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package interfaces;

import database.EmpleadoDAO;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import objetos.Empleado;

public class RecordsObtenidos extends javax.swing.JFrame {

    //Declaración de variables necesarias
    private DefaultTableModel dtmRecords;
    private List<Empleado> listaEmpleadosGlobal;
    private Thread hilo;
    private int contador;

    /**
     * Creates new form Principal
     */
    public RecordsObtenidos() {
        initComponents();
        this.setTitle("Records Obtenidos");
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
        obtenerDatosEmpleados();
    }

    //Creación de los titulos de la tabla de habitaciones
    private DefaultTableModel setTitulosTabla() {
        dtmRecords = new DefaultTableModel();
        dtmRecords.addColumn("Fecha");
        dtmRecords.addColumn("Trabajador");
        dtmRecords.addColumn("Cliente");
        dtmRecords.addColumn("Tiempo Trabajado");
        dtmRecords.addColumn("Comisión");
        dtmRecords.addColumn("Descuento");
        dtmRecords.addColumn("Sueldo Obtenido");
        return dtmRecords;
    }

    //Método que retorna la información de la base de datos de las habitaciones
    private void obtenerDatosEmpleados() {
        //Implementacion de las sentencias de MySQL 
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        listaEmpleadosGlobal = empleadoDAO.seleccionarLista();
        //Implementacion de los titulos
        setTitulosTabla();
        Object[] fila = new Object[7];
        //Recorrido de los objetos habitación e impresión de los datos en la tabla
        listaEmpleadosGlobal.forEach(empleado -> {
            fila[0] = empleado.getFecha();
            fila[1] = empleado.getNombreTrabajador();
            fila[2] = empleado.getNombreCliente();
            fila[3] = empleado.getTiempoTrabajado();
            fila[4] = empleado.getComision();
            fila[5] = empleado.getDescuentoRealizado();
            fila[6] = empleado.getSueldoTotal();
            dtmRecords.addRow(fila);
        });
        //Muestra de la información de la tabla
        tableData.setModel(dtmRecords);
    }

    //Método que retorna la información de la base de datos de las reservaciones
//    private void obtenerDatosReservacion() {
//        //Implementacion de las sentencias de MySQL 
//        ReservacionDAO rdao = new ReservacionDAO();
//        listaReservacionGlobal = rdao.seleccionarLista();
//        //Implementacion de los titulos
//        setTitulosReserva();
//        Object[] fila = new Object[6];
//        //Recorrido de los objetos reservación e impresión de los datos en la tabla
//        listaReservacionGlobal.forEach(reservacion -> {
//            fila[0] = reservacion.getIdReservacion();
//            fila[1] = reservacion.getFechaEntrada();
//            fila[2] = reservacion.getFechaSalida();
//            fila[3] = reservacion.getDias();
//            fila[4] = reservacion.getCostoTotal();
//            fila[5] = reservacion.getNumeroHabitacion();
//            dtmReservaiones.addRow(fila);
//        });
//        //Muestra de la información de la tabla
//        tableReser.setModel(dtmReservaiones);
//    }
    //Implementación del formato en SQL
    public java.sql.Date formatoFechaSql(Date date) {
        long dateLong = date.getTime();
        java.sql.Date dateSQL = new java.sql.Date(dateLong);
        return dateSQL;
    }

//    //Calculo del costo total de la reservación por dias y costo de la habitación
//    public int costoTotal(int numero, int dias) {
//        listaHabitacionGlobal.forEach(hab -> {
//            if (hab.getIdHabitacion() == numero) {
//                costoHabitacion = hab.getCostoHabitacion();
//            }
//        });
//        int costoTotal = costoHabitacion * dias;
//        return costoTotal;
//    }
//
//    //Método que realiza el calculo del contador de horas
//    public void contadorHoras(int dias) {
//        //Impleentación del uso de holos
//        hilo = new Thread(new Runnable() {
//            //Sobrescritura del método run del la implemnacion del hilo
//            @Override
//            public void run() {
//                //Multiplicacion de los dias por horas
//                int horas = dias * 24;
//                int minutos = 0, segundos = 0, i;
//                i = contador;
//                //Implementación del while para realizar el contador de horas, minutos y segundos
//                while (!(horas == 0 && minutos == 0 && segundos == 0)) {
//                    if (segundos == 0) {
//                        if (minutos == 0) {
//                            horas--;
//                            minutos = 59;
//                            segundos = 59;
//                        } else if (minutos != 0) {
//                            minutos--;
//                            segundos = 59;
//                        }
//                    } else {
//                        segundos--;
//                    }
//                    //Impresión de las horas, minutos y segundos restantes de la reserva
//                    System.out.println("Habitacion " + i + ": " + " H:" + horas + " M: " + minutos + " S: " + segundos);
//                }
//                //Modificación del estatus en la habitación en la base de datos
//                modificarEstatusHabitacionDos(i);
//                //Implementación para mostrar la información en las tablas.
//                listaHabitacionGlobal = null;
//                obtenerDatos();
//                listaReservacionGlobal = null;
//                obtenerDatosReservacion();
//            }
//        });
//        //Inicio del hilo
//        hilo.start();
//
//    }
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
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();

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

        jLabel9.setText("jLabel8");

        jLabel11.setText("jLabel8");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(RecordsObtenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecordsObtenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecordsObtenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecordsObtenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecordsObtenidos().setVisible(true);
            }
        });
    }
    //Variables de los diferentes componentes de la ventana


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableData;
    // End of variables declaration//GEN-END:variables
}
