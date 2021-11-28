package interfaces;

import database.PersonalDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Personal;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author ramssrez
 */
public class PersonalInterface extends javax.swing.JFrame {

    //Delcaración de variables necesarias para su utilización
    private DefaultTableModel dtm;
    private List<Personal> listaPersonal;
    private final FondoPanel fondo = new FondoPanel();

    public PersonalInterface() {
        this.setContentPane(fondo);
        initComponents();
        this.setTitle("Personal");
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
        //tablePersonal.setEnabled(false);

    }
    //Creación de los titulos de la tabla de habitaciones

    private DefaultTableModel setTitulos() {
        dtm = new DefaultTableModel();
        dtm.addColumn("N. Personal");
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellidos");
        dtm.addColumn("Edad");
        dtm.addColumn("Puesto");
        dtm.addColumn("Sueldo");
        dtm.addColumn("Area");
        return dtm;
    }

    //Método que limpia los campos de texto que se utilizaron
    public void limpiarCampos() {
        jtfNumberWorker.setText("");
        jtfName.setText("");
        jtfApellidos.setText("");
        jtfArea.setText("");
        jtfEdad.setText("");
        jtfPuesto.setText("");
        jtfSueldo.setText("");
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {

        if ((jtfApellidos.getText().equals("") && jtfNumberWorker.getText().equals("") && jtfName.getText().equals("")
                && jtfArea.getText().equals("") && jtfEdad.getText().equals("") && jtfPuesto.getText().equals("")
                && jtfSueldo.getText().equals(""))
                || jtfApellidos.getText().equals("") || jtfNumberWorker.getText().equals("") || jtfName.getText().equals("")
                || jtfArea.getText().equals("") || jtfEdad.getText().equals("") || jtfPuesto.getText().equals("")
                || jtfSueldo.getText().equals("")) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;
        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Método que crea las reservación y la inserta en la base de datos
    public void crearPersonal() {
        //Recuperación de la información desde las cajas de texto
        String nombre = jtfName.getText();
        String numeroTrabajdor = jtfNumberWorker.getText();
        String edad = jtfEdad.getText();
        String apellidos = jtfApellidos.getText();
        String area = jtfArea.getText();
        String puesto = jtfPuesto.getText();
        String sueldo = jtfSueldo.getText();
        //Creación del objeto Personal
        Personal personal = new Personal(nombre, apellidos, area, edad, numeroTrabajdor, puesto, sueldo);
        PersonalDAO pdao = new PersonalDAO();
        //Llamado del metodo para insertar datos a la base de datos
        int entero = pdao.insertar(personal);
        //Musetra de dialogs en caso de que se agreguen correctamente los datos a la base de datos
        if (entero > 0) {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "Se han creado un personal");
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
        } else {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            JOptionPane.showMessageDialog(null, "No se ha creado un pesonal");
            //Método que limpia las cajas de texto de la interface
            limpiarCampos();
        }
        //Comienzo del contador de las horas por medio de hilos
        //contadorHoras(dias);
    }

    public void retornarPersonal() {
        String numeroEmpleado = jtfNumberWorker.getText();
        //Instancia de la clase ProductoDAO
        PersonalDAO personalDAO = new PersonalDAO();
        //Declaración del objeto producto como nul
        Personal p = personalDAO.seleccionar(numeroEmpleado);
        System.out.println("p = " + p.toString());
        if (p != null) {
            jtfName.setText(p.getNombre());
            jtfApellidos.setText(p.getApellidos());
            jtfNumberWorker.setText(p.getNumeroEmpleado());
            jtfArea.setText(p.getArea());
            jtfEdad.setText(p.getEdad());
            jtfPuesto.setText(p.getPuesto());
            jtfSueldo.setText(p.getSueldo());
        } else {
            JOptionPane.showMessageDialog(null, "Este personal no existe");
        }
    }

    //Método que retorna la información de la base de datos de las habitaciones
    private void obtenerDatos() {
        //Implementacion de las sentencias de MySQL 
        PersonalDAO personalDAO = new PersonalDAO();
        listaPersonal = personalDAO.seleccionarLista();
        //Implementacion de los titulos
        setTitulos();
        Object[] fila = new Object[7];
        //Recorrido de los objetos personal e impresión de los datos en la tabla
        listaPersonal.forEach(personal -> {
            fila[0] = personal.getNumeroEmpleado();
            fila[1] = personal.getNombre();
            fila[2] = personal.getApellidos();
            fila[3] = personal.getEdad();
            fila[4] = personal.getPuesto();
            fila[5] = personal.getSueldo();
            fila[6] = personal.getArea();
            dtm.addRow(fila);
        });
        //Muestra de la información de la tabla
        tablePersonal.setModel(dtm);
    }

    //Método que permite generar un documento pdf donde se imprime los datos del personal
    private void generarDocumento(Personal p) {
        //Creación del documento de la librería
        Document document = new Document();

        //Uso de try/catch necesaria para poder realizar la creación de un documetno
        try {
            //Obtención de la ruta del sistema y el usuario
            String ruta = System.getProperty("user.home");
            //Seleccion de la ruta para agregar o crear un reporte
            PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/reporte.pdf"));
            //Apertura del documento para modificarlo
            document.open();
            //Uso de la clase PdfTable de la liraría para su implementación
            PdfPTable table = new PdfPTable(7);
            //Agregación de los nombres de las columnas del documento
            table.addCell("N. Trabajador");
            table.addCell("Nombre");
            table.addCell("Apellidos");
            table.addCell("Edad");
            table.addCell("Puesto");
            table.addCell("Sueldo");
            table.addCell("Área");

            //Sección en donde se agrega la inforamción del personal
            table.addCell(p.getNumeroEmpleado());
            table.addCell(p.getNombre());
            table.addCell(p.getApellidos());
            table.addCell(p.getEdad());
            table.addCell(p.getPuesto());
            table.addCell(p.getSueldo());
            table.addCell(p.getArea());

            //Agregación de la tabla al doumetno
            document.add(table);
            document.close();

            //Sección de las excepciones en el caso de que no se encuenre un documetno o se crea
        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } finally {
            //En el caso de que no se crea un documento validamos con el finaly para que se cierre
            document.close();
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
        jtfNumberWorker = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbtnCrear = new javax.swing.JButton();
        jtfApellidos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfSueldo = new javax.swing.JTextField();
        jtfArea = new javax.swing.JTextField();
        jtfEdad = new javax.swing.JTextField();
        jtfPuesto = new javax.swing.JTextField();
        jbtnBuscar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePersonal = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jbtnImprimir = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmtMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("La Estancia");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Número de Empleado");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Alta, Busqueda de personal");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jtfNumberWorker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfNumberWorker.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfNumberWorker.setText("12345");
        jtfNumberWorker.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Apellidos");

        jtfName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfName.setText("Jorge");
        jtfName.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Puesto");

        jbtnCrear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCrear.setText(" Crear Personal");
        jbtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearActionPerformed(evt);
            }
        });

        jtfApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfApellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfApellidos.setText("Negrete Sanchez");
        jtfApellidos.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Edad");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Sueldo");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Área");

        jtfSueldo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfSueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfSueldo.setText("12000");
        jtfSueldo.setToolTipText("");

        jtfArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfArea.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfArea.setText("Recursos Humanos");
        jtfArea.setToolTipText("");

        jtfEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfEdad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfEdad.setText("39");
        jtfEdad.setToolTipText("");

        jtfPuesto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfPuesto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfPuesto.setText("Coordinador");
        jtfPuesto.setToolTipText("");

        jbtnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnBuscar.setText("Buscar Personal");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        tablePersonal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablePersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablePersonal.setFocusable(false);
        tablePersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clieceado(evt);
            }
        });
        jScrollPane4.setViewportView(tablePersonal);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setText("Ingresa Solo en Número de empleado");

        jbtnImprimir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnImprimir.setText("Imprimir Personal");
        jbtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimirActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Lista de personal");

        jMenu1.setText("Menú Principal");

        jmtMenu.setText("ir");
        jmtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmtMenuActionPerformed(evt);
            }
        });
        jMenu1.add(jmtMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfArea, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfSueldo)
                                    .addComponent(jtfPuesto)
                                    .addComponent(jtfApellidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                    .addComponent(jtfNumberWorker)
                                    .addComponent(jtfName)
                                    .addComponent(jtfEdad, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtnCrear)
                                    .addComponent(jbtnBuscar)
                                    .addComponent(jbtnImprimir)
                                    .addComponent(jLabel10))))))
                .addGap(0, 57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNumberWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCrear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jbtnImprimir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método asignado al boton  de crear un personal
    private void jbtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearActionPerformed
        //Validación de los campos para que no se encuentren vacios
        if (validacionCamposTexto()) {
            //
            JOptionPane.showMessageDialog(null, "Los campos se encuentran Llenos");
            crearPersonal();
        } else {
            //Impresión del dialog en caso de que los campos se encuentrn vacios
            JOptionPane.showMessageDialog(null, "Los campos se encuentran vacios");
        }
    }//GEN-LAST:event_jbtnCrearActionPerformed

    //Método para moverse hacia el menú principal
    private void jmtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmtMenuActionPerformed
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jmtMenuActionPerformed

    //Método para buscar la información del personal
    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        //Validación de los campos para que no se encuentren vacios
        if (!jtfNumberWorker.getText().equals("")) {
            //Llamado al metodo para retornoar el perosonal
            retornarPersonal();
        } else {
            //Impresión del dialog en caso de que los campos se encuentrn vacios
            JOptionPane.showMessageDialog(null, "El campo del número de empleado esta vacio");
        }
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    //Método para obtener la lista de datos del personal
    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed
        //Método que realiza la consulta de los datos
        obtenerDatos();
    }//GEN-LAST:event_jbtnImprimirActionPerformed

    //Método que al presionar una de las opciones de la tabla genera el documento
    private void clieceado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clieceado
        //Obtención del objeto personal de la tabla
        Personal p = listaPersonal.get(tablePersonal.getSelectedRow());
        //Llamado al metodo para generar un documento
        generarDocumento(p);
    }//GEN-LAST:event_clieceado

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
            java.util.logging.Logger.getLogger(PersonalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonalInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnCrear;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JMenuItem jmtMenu;
    private javax.swing.JTextField jtfApellidos;
    private javax.swing.JTextField jtfArea;
    private javax.swing.JTextField jtfEdad;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfNumberWorker;
    private javax.swing.JTextField jtfPuesto;
    private javax.swing.JTextField jtfSueldo;
    private javax.swing.JTable tablePersonal;
    // End of variables declaration//GEN-END:variables
}
