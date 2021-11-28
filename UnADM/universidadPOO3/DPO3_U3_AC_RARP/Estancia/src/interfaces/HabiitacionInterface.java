/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package interfaces;

import database.HabitacionDAO;
import database.ReservacionDAO;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Habitacion;
import objetos.Reservacion;

public class HabiitacionInterface extends javax.swing.JFrame {

    //Declaración de variables necesarias
    private DefaultTableModel dtm;
    private DefaultTableModel dtmReservaiones;
    private List<Habitacion> listaHabitacionGlobal;
    private List<Reservacion> listaReservacionGlobal;
    private int costoHabitacion;
    private Thread hilo;
    private int contador;
    private final FondoPanel FONDO = new FondoPanel();

    public HabiitacionInterface() {
        //Asignación del fondo con una imagen elegida
        this.setContentPane(FONDO);
        initComponents();
        this.setTitle("Reservación");
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
        //Llamado a los metodos que retornan la información de la base de datos
        obtenerDatos();
        obtenerDatosReservacion();
    }

    //Creación de los titulos de la tabla de habitaciones
    private DefaultTableModel setTitulos() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Id Habitacioón");
        dtm.addColumn("Número Habitación");
        dtm.addColumn("Estatus");
        dtm.addColumn("Tipo");
        dtm.addColumn("Costo");
        return dtm;
    }

    //Creación de los titulos de la tabla de reservaciones
    private DefaultTableModel setTitulosReserva() {
        dtmReservaiones = new DefaultTableModel();
        dtmReservaiones.addColumn("Id Reservación");
        dtmReservaiones.addColumn("Fecha Entrada");
        dtmReservaiones.addColumn("Fecha Salida");
        dtmReservaiones.addColumn("Dias");
        dtmReservaiones.addColumn("Costo Total");
        dtmReservaiones.addColumn("No. Habitacion");
        return dtmReservaiones;
    }

    //Método que retorna la información de la base de datos de las habitaciones
    private void obtenerDatos() {
        //Implementacion de las sentencias de MySQL 
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        listaHabitacionGlobal = habitacionDAO.seleccionarLista();
        //Implementacion de los titulos
        setTitulos();
        Object[] fila = new Object[5];
        //Recorrido de los objetos habitación e impresión de los datos en la tabla
        listaHabitacionGlobal.forEach(habitacion -> {
            fila[0] = habitacion.getIdHabitacion();
            fila[1] = habitacion.getNumeroHabitacion();
            fila[2] = habitacion.getStatus();
            fila[3] = habitacion.getTipoHabitacion();
            fila[4] = habitacion.getCostoHabitacion();
            dtm.addRow(fila);
        });
        //Muestra de la información de la tabla
        tableData.setModel(dtm);
    }

    //Método que retorna la información de la base de datos de las reservaciones
    private void obtenerDatosReservacion() {
        //Implementacion de las sentencias de MySQL 
        ReservacionDAO rdao = new ReservacionDAO();
        listaReservacionGlobal = rdao.seleccionarLista();
        //Implementacion de los titulos
        setTitulosReserva();
        Object[] fila = new Object[6];
        //Recorrido de los objetos reservación e impresión de los datos en la tabla
        listaReservacionGlobal.forEach(reservacion -> {
            fila[0] = reservacion.getIdReservacion();
            fila[1] = reservacion.getFechaEntrada();
            fila[2] = reservacion.getFechaSalida();
            fila[3] = reservacion.getDias();
            fila[4] = reservacion.getCostoTotal();
            fila[5] = reservacion.getNumeroHabitacion();
            dtmReservaiones.addRow(fila);
        });
        //Muestra de la información de la tabla
        tableReser.setModel(dtmReservaiones);
    }

    //Método que modifica el estatus de la habitación con el ingreso del id
    public void modificarEstatusHabitacion(int numero) {
        //Instancia de la clase HabitacionDAO
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        //Retorno de la implemetación del metodo actualizar para el caso de no disponible
        int entero = habitacionDAO.actualizar(numero);
        //Musetra de dialogs en caso de que se agreguen correctamente los datos a la base de datos
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

    //Método que modifica el estatus de la habitación con el ingreso del id
    public void modificarEstatusHabitacionDos(int id) {
        //Instancia de la clase HabitacionDAO
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        //Retorno de la implemetación del metodo actualizar para el caso disponible
        int entero = habitacionDAO.actualizarDos(id);
        //Musetra de dialogs en caso de que se agreguen correctamente los datos a la base de datos
        if (entero > 0) {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "Se han terminado una reservación");
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
        } else {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "No se ha modificado el estatus de la habitación la habitación");
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
        }
    }

    //Método que limpia las cajas de tecto que se estan utilizando
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

    //Calculo de los dias entre dos fechas retornando la diferencia entre fechas
    public int diasEntreFechas(Date fechaSalida, Date fechaEntrada) {
        //Implementación de milisegundos al dia
        int milisecondsByDay = 86400000;
        //Determinación de los dias
        int dias = (int) ((fechaSalida.getTime() - fechaEntrada.getTime()) / milisecondsByDay);
        //Retorno de los dias
        return dias;
    }

    //Implementación del formato en SQL
    public java.sql.Date formatoFechaSql(Date date) {
        long dateLong = date.getTime();
        java.sql.Date dateSQL = new java.sql.Date(dateLong);
        return dateSQL;
    }

    //Calculo del costo total de la reservación por dias y costo de la habitación
    public int costoTotal(int numero, int dias) {
        listaHabitacionGlobal.forEach(hab -> {
            if (hab.getIdHabitacion() == numero) {
                costoHabitacion = hab.getCostoHabitacion();
            }
        });
        int costoTotal = costoHabitacion * dias;
        return costoTotal;
    }

    //Método que realiza el calculo del contador de horas
    public void contadorHoras(int dias) {
        //Impleentación del uso de holos
        hilo = new Thread(new Runnable() {
            //Sobrescritura del método run del la implemnacion del hilo
            @Override
            public void run() {
                //Multiplicacion de los dias por horas
                int horas = dias * 24;
                int minutos = 0, segundos = 0, i;
                i = contador;
                //Implementación del while para realizar el contador de horas, minutos y segundos
                while (!(horas == 0 && minutos == 0 && segundos == 0)) {
                    if (segundos == 0) {
                        if (minutos == 0) {
                            horas--;
                            minutos = 59;
                            segundos = 59;
                        } else if (minutos != 0) {
                            minutos--;
                            segundos = 59;
                        }
                    } else {
                        segundos--;
                    }
                    //Impresión de las horas, minutos y segundos restantes de la reserva
                    System.out.println("Habitacion " + i + ": " + " H:" + horas + " M: " + minutos + " S: " + segundos);
                }
                //Modificación del estatus en la habitación en la base de datos
                modificarEstatusHabitacionDos(i);
                //Implementación para mostrar la información en las tablas.
                listaHabitacionGlobal = null;
                obtenerDatos();
                listaReservacionGlobal = null;
                obtenerDatosReservacion();
            }
        });
        //Inicio del hilo
        hilo.start();

    }

    //Método que crea las reservación y la inserta en la base de datos
    public void crearReservacion() {
        //Retorno de la informaicón dentro de las cajas de tecto
        Date fechaEntrada = jdtStart.getDate();
        Date fechaSalida = jdtFinish.getDate();
        int numero = Integer.parseInt(jtfIdentificador.getText());
        //Inicialización del contador en base al id de la habitación
        contador = numero;
        //Calculo de los dias entre dos fechas
        int dias = diasEntreFechas(fechaSalida, fechaEntrada);
        int costo = costoTotal(numero, dias);
        //Creación del objeto reservación
        Reservacion reservacion = new Reservacion(formatoFechaSql(fechaEntrada), formatoFechaSql(fechaSalida), numero, dias, costo);
        ReservacionDAO rdao = new ReservacionDAO();
        //Llamado del metodo para insertar datos a la base de datos
        int entero = rdao.insertar(reservacion);
        //Musetra de dialogs en caso de que se agreguen correctamente los datos a la base de datos
        if (entero > 0) {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "Se han creado la reservación");
            //Modificación del estatus de la habitación disponibles
            modificarEstatusHabitacion(numero);
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
        } else {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "No se ha res3ervado la habitación");
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
        }
        //Comienzo del contador de las horas por medio de hilos
        contadorHoras(dias);
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
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu = new javax.swing.JMenuItem();

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

        tableReser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableReser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tableReser.setFocusable(false);
        jScrollPane4.setViewportView(tableReser);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Lista de reservaciones actuales");

        jMenu1.setText("Menú Principal");

        jMenu.setText("ir");
        jMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });
        jMenu1.add(jMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdtFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(220, 220, 220)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnCrearReservacion)
                        .addGap(313, 313, 313)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5)
                        .addGap(261, 261, 261)
                        .addComponent(jtfIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jdtFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jdtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearReservacion)
                    .addComponent(btnLimpiar))
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //Método para limpiar los datos de los campos de texto
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCrearReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearReservacionActionPerformed
        //Validacion de campos cuando esten vacios
        if (validacionCamposTexto()) {
            //Llamado al metodo para crear la reservación
            crearReservacion();
            //Lista de habbitaciones que se obtuvieron de la base de datos como nulo
            listaHabitacionGlobal = null;
            //Llamado al metodo para obtener los datos de la habitación
            obtenerDatos();
            //Lista de reservaciones que se obtuvieron de la base de datos como nulo
            listaReservacionGlobal = null;
            //Llamado al método para obtener las reservaciones de la base de datos
            obtenerDatosReservacion();
        } else {
            //Impresión del dialog en caso de que los campos se encuentrn vacios
            JOptionPane.showMessageDialog(null, "Los campos se encuentran vacios");
        }
    }//GEN-LAST:event_btnCrearReservacionActionPerformed

    private void jMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuActionPerformed
        // TODO add your handling code here:
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuActionPerformed

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
            java.util.logging.Logger.getLogger(HabiitacionInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HabiitacionInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HabiitacionInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HabiitacionInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HabiitacionInterface().setVisible(true);
            }
        });
    }
    //Variables de los diferentes componentes de la ventana


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearReservacion;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JMenuItem jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
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
