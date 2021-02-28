package interfacesgrafica;

import clases.ProcessRin;
import clases.RinClass;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import otros.ImgTabla;
import otros.LimpiarTxt;

public class Presentation extends javax.swing.JFrame {

    /**
     * Creates new form Presentation
     */
    List<RinClass> rinesGeneral = new ArrayList();

    private String rutaTxt = "datos.txt";
    private String rutaTxtSeleccion = "seleccion.txt";
    private RinClass rinClass;
    private ProcessRin processRin;
    private ProcessRin processRinEleccion;
    private int clicTabla;
    private LimpiarTxt limpiarTxt = new LimpiarTxt();

    public Presentation() {
        initComponents();
        setTitle("Rines");
        setLocationRelativeTo(null);
        processRin = new ProcessRin();
        processRinEleccion = new ProcessRin();
        //tableMostrar.setVisible(false);

        try {
            //Datos que se van a seleccionar
            cargarTxt();
            listarRegistro();
            //Datos que se van a seleccionar
//            listarSeleccion();
//            cargarTxtEleccion();
        } catch (Exception ex) {
            mensaje("No existe el archivo txt");
        }

    }

    public void listarRegistro() {
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Nombre");
        dt.addColumn("Porcentaje Relativo");
        dt.addColumn("Porcentaje Absoluto");
        dt.addColumn("Aerodinamica");

        tableRegistros.setDefaultRenderer(Object.class, new ImgTabla());
        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < processRin.cantidadRegistro(); i++) {
            rinClass = processRin.obtenerRegistro(i);
            fila[0] = rinClass.getNombre();
            fila[1] = rinClass.getPorcentajeRelativo();
            fila[2] = rinClass.getPorcentajeAbsoluto();
            fila[3] = rinClass.getAerodinamica();
            dt.addRow(fila);
        }
        tableRegistros.setModel(dt);
        tableRegistros.setRowHeight(20);
    }

    public void listarRegistroSelecionado() {
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Nombre");
        dt.addColumn("Porcentaje Relativo");
        dt.addColumn("Porcentaje Absoluto");
        dt.addColumn("Aerodinamica");

        tableMostrar.setDefaultRenderer(Object.class, new ImgTabla());
        Object fila[] = new Object[dt.getColumnCount()];
        //for (int i = 0; i < processRinEleccion.cantidadRegistro(); i++) {
            rinClass = processRinEleccion.obtenerRegistro(processRinEleccion.cantidadRegistro()-1);
            fila[0] = rinClass.getNombre();
            fila[1] = rinClass.getPorcentajeRelativo();
            fila[2] = rinClass.getPorcentajeAbsoluto();
            fila[3] = rinClass.getAerodinamica();
            dt.addRow(fila);
        //}
        tableMostrar.setModel(dt);
        tableMostrar.setRowHeight(20);
    }

    //Método que crea un mensaje en caso generalizado
    public void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    //Metodo que se encarga de verificar que el campo de nombre sea correcto
    public String leerNombre() {
        try {
            String nombre = txtRinNombre.getText().trim().replace(" ", "_");
            return nombre;
        } catch (Exception ex) {
            System.out.println("ex: " + ex.getMessage());
            return null;
        }
    }

    //Método que se encarga de verificar el campo de aerodinamica
    public float leerAerodinamica() {
        try {
            float codigo = Float.parseFloat(txtAerodinamica.getText().trim());
            return codigo;
        } catch (Exception ex) {
            System.out.println("ex = " + ex.getMessage());
            return -666;
        }
    }

    //Método que se encarga de verificar el campo de porfcentaje
    public float leerPorcentaje() {
        try {
            float codigo = Float.parseFloat(txtPorcentaje.getText().trim());
            return codigo;
        } catch (Exception ex) {
            System.out.println("ex = " + ex.getMessage());
            return -666;
        }
    }

    public void ingresarRegistro() {
        try {
            if ((leerNombre() == null) && (leerAerodinamica() == -666) && (leerPorcentaje() == -666)) {
                mensaje("Los campos esta vacios");
            } else if (leerNombre() == null) {
                mensaje("Ingresar el nombre");
            } else if (leerAerodinamica() == -666) {
                mensaje("Ingresar Aerodinamica");
            } else if (leerPorcentaje() == -666) {
                mensaje("Ingresar Porcentaje");
            } else {
                rinClass = new RinClass(leerNombre(), leerPorcentaje(), leerAerodinamica());
                processRin.agregarRegistro(rinClass);
                grabarTxt();
                listarRegistro();
                calculoPorcentajeAbsoluto();
                //processRin.ordenarLista();
                ordenarLista();
                limpiarTxt.limpiarTexto(panel);
            }
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    public void ordenarLista() {
        try {
            processRin.ordenarLista();
            listarRegistro();
            grabarTxt();
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    public void calculoPorcentajeAbsoluto() {
        try {
            float sumaRelativa = 0.0f;
            for (int i = 0; i < processRin.cantidadRegistro(); i++) {
                sumaRelativa = sumaRelativa + processRin.obtenerRegistro(i).getPorcentajeRelativo();
            }
            for (int i = 0; i < processRin.cantidadRegistro(); i++) {
                var absoluto = (processRin.obtenerRegistro(i).getPorcentajeRelativo() * 100f) / sumaRelativa;
                processRin.obtenerRegistro(i).setPorcentajeAbsoluto(absoluto);
            }
            listarRegistro();
            grabarTxt();

        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    public void validacionRines() {
        //cargarTxt();
        if (processRin.ultimoRin().getPorcentajeAbsoluto() > 33) {
            RinClass ultimo = processRin.ultimoRin();
            System.out.println("El rin seleccionado es: " + processRin.ultimoRin().toString());
            processRinEleccion.agregarRegistro(ultimo);
        } else if (processRin.primerRin().getPorcentajeAbsoluto() >= 67) {
            RinClass primero = processRin.ultimoRin();
            System.out.println("El rin seleccionado es: " + processRin.primerRin().toString());
            processRinEleccion.agregarRegistro(primero);

        } else {
            var sumaAbsolutos = 0.0f;

            for (int i = 0; i < processRin.cantidadRegistro(); i++) {
                sumaAbsolutos = sumaAbsolutos + processRin.obtenerRegistro(i).getPorcentajeAbsoluto();
                processRinEleccion.agregarRegistro(processRin.obtenerRegistro(i));
                if (sumaAbsolutos >= 67) {
                    break;
                }
            }
            System.out.println("suma :" + sumaAbsolutos);
            System.out.println("Los rines son");
            for (int i = 0; i < processRinEleccion.cantidadRegistro(); i++) {
                System.out.println(" " + processRinEleccion.obtenerRegistro(i).toString());
            }
        }
        listarRegistroSelecionado();
        processRinEleccion = new ProcessRin();
    }

    public void grabarTxt() {
        FileWriter fileWriter;
        PrintWriter printWriter;
        try {
            fileWriter = new FileWriter(rutaTxt);
            printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < processRin.cantidadRegistro(); i++) {
                rinClass = processRin.obtenerRegistro(i);
                printWriter.println(String.valueOf(rinClass.getNombre() + ", " + rinClass.getPorcentajeRelativo() + ", " + rinClass.getPorcentajeAbsoluto() + ", " + rinClass.getAerodinamica()));
            }
            printWriter.close();

        } catch (Exception ex) {
            mensaje("Error al grabar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void cargarTxt() {
        File ruta = new File(rutaTxt);
        try {

            FileReader fileReader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                rinClass = new RinClass();
                rinClass.setNombre(st.nextToken());
                rinClass.setPorcentajeRelativo(Float.parseFloat(st.nextToken()));
                rinClass.setPorcentajeAbsoluto(Float.parseFloat(st.nextToken()));
                rinClass.setAerodinamica(Float.parseFloat(st.nextToken()));
                processRin.agregarRegistro(rinClass);
            }
            bufferedReader.close();
        } catch (Exception ex) {
            mensaje("Error al cargar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public void cargarTxtSeleccionado() {
        File ruta = new File(rutaTxt);
        try {

            FileReader fileReader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                rinClass = new RinClass();
                rinClass.setNombre(st.nextToken());
                rinClass.setPorcentajeRelativo(Float.parseFloat(st.nextToken()));
                rinClass.setPorcentajeAbsoluto(Float.parseFloat(st.nextToken()));
                rinClass.setAerodinamica(Float.parseFloat(st.nextToken()));
                processRin.agregarRegistro(rinClass);
            }
            bufferedReader.close();
        } catch (Exception ex) {
            mensaje("Error al cargar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRinNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAerodinamica = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        buttonValidarRines = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegistros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableMostrar = new javax.swing.JTable();
        porcentaje = new javax.swing.JLabel();
        labelPorcentaje = new javax.swing.JLabel();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre del Rin");

        jLabel2.setText("Procentaje Relativo");

        jLabel3.setText("Aerodinamica");

        buttonAdd.setText("Agregar");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonValidarRines.setText("Listar Rines");
        buttonValidarRines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidarRinesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(txtRinNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAerodinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonValidarRines)
                    .addComponent(buttonAdd))
                .addGap(129, 129, 129))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRinNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdd))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonValidarRines))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAerodinamica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tableRegistros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableRegistros);

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        tableMostrar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tableMostrar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        porcentaje.setText("Porcentaje de Homolagación:");

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
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(labelPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(porcentaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPorcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed

//        if (txtRinNombre.getText().equals("")
//                && txtPorcentaje.getText().equals("")
//                && txtAerodinamica.getText().equals("")) {
//            System.out.println("Los campos estan vacios");
//            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
//        } else if ((txtRinNombre.getText().equals(""))
//                || (txtAerodinamica.getText().equals(""))
//                || txtPorcentaje.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "Faltan datos");
//            System.out.println("No se ha agregado la ");
//        } else {
//            float aero = Float.parseFloat(txtAerodinamica.getText());
//            float porcentaje = Float.parseFloat(txtPorcentaje.getText());
//            RinClass rin = new RinClass(txtRinNombre.getText(), porcentaje, aero);
//            rinesGeneral.add(rin);
//            JOptionPane.showMessageDialog(null, "Todos los datos estan llenos");
//            rinesGeneral.forEach(rine -> {
//                System.out.println("rine = " + rine);
//                System.out.println("");
//            });
//        }
        //File ruta = new File(rutaTxt);
        this.ingresarRegistro();

    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonValidarRinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidarRinesActionPerformed
//        float sumaRelative = 0.0f;
//        for (RinClass rin : rinesGeneral) {
//            sumaRelative = sumaRelative + rin.getPorcentajeRelativo();
//            System.out.println("suma " + sumaRelative);
//        }
//        for (RinClass rin : rinesGeneral) {
//            var absoluto = (rin.getPorcentajeRelativo() * 100f) / sumaRelative;
//            rin.setPorcentajeAbsoluto(absoluto);
//        }
        //File ruta = new File(rutaTxt);
        //calculoPorcentajeAbsoluto(ruta);
        validacionRines();
    }//GEN-LAST:event_buttonValidarRinesActionPerformed

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
            java.util.logging.Logger.getLogger(Presentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Presentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Presentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Presentation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonValidarRines;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labelPorcentaje;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JLabel porcentaje;
    private javax.swing.JTable tableMostrar;
    private javax.swing.JTable tableRegistros;
    private javax.swing.JTextField txtAerodinamica;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtRinNombre;
    // End of variables declaration//GEN-END:variables
}
