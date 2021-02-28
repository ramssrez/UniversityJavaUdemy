package interfacesgrafica;

import clases.ProcessRin;
import clases.RinClass;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    RinClass rinClass;
    ProcessRin processRin;
    int clicTabla;
    LimpiarTxt limpiarTxt = new LimpiarTxt();

    public Presentation() {
        initComponents();
        setTitle("Rines");
        setLocationRelativeTo(null);
        processRin = new ProcessRin();

        try {
            cargarTxt();
            listarRegistro();
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
            if (leerNombre() == null) {
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

//    public void calculoPorcentajeAbsoluto(File ruta) {
//        try {
//            /*
//                    float sumaRelative = 0.0f;
//        for (RinClass rin : rinesGeneral) {
//            sumaRelative = sumaRelative + rin.getPorcentajeRelativo();
//            System.out.println("suma " + sumaRelative);
//        }
//        for (RinClass rin : rinesGeneral) {
//            var absoluto = (rin.getPorcentajeRelativo() * 100f) / sumaRelative;
//            rin.setPorcentajeAbsoluto(absoluto);
//        }
//             */
//
//            float sumaRelativa = 0.0f;
//            for (int i = 0; i < processRin.cantidadRegistro(); i++) {
//                sumaRelativa = sumaRelativa + processRin.obtenerRegistro(i).getPorcentajeRelativo();
//            }
//            System.out.println("suma relativa " + sumaRelativa);
//            for (int i = 0; i < processRin.cantidadRegistro(); i++) {
//                var absoluto = (processRin.obtenerRegistro(i).getPorcentajeRelativo() * 100f) / sumaRelativa;
//                processRin.obtenerRegistro(i).setPorcentajeAbsoluto(absoluto);
//            }
//            listarRegistro();
//            grabarTxt();
//
////            if (leerNombre() == null) {
////                mensaje("Ingresar el nombre");
////            } else if (leerAerodinamica() == -666) {
////                mensaje("Ingresar Aerodinamica");
////            } else if (leerPorcentaje() == -666) {
////                mensaje("Ingresar Porcentaje");
////            } else {
////                rinClass = new RinClass(leerNombre(), leerPorcentaje(), leerAerodinamica());
////                processRin.agregarRegistro(rinClass);
////                grabarTxt();
////                listarRegistro();
////                limpiarTxt.limpiarTexto(panel);
////            }
//        } catch (Exception ex) {
//            mensaje(ex.getMessage());
//        }
//    }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRinNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAerodinamica = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        buttonOrganizar = new javax.swing.JButton();
        buttonPorAbsoli = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegistros = new javax.swing.JTable();
        panelEleccion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEleccion = new javax.swing.JTable();

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

        buttonOrganizar.setText("Organizar ");
        buttonOrganizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOrganizarActionPerformed(evt);
            }
        });

        buttonPorAbsoli.setText("Absoluto");
        buttonPorAbsoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPorAbsoliActionPerformed(evt);
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
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonPorAbsoli)
                            .addComponent(buttonAdd))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOrganizar)
                        .addContainerGap())))
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
                    .addComponent(buttonPorAbsoli))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAerodinamica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOrganizar))
                .addContainerGap(34, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablaEleccion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaEleccion);

        javax.swing.GroupLayout panelEleccionLayout = new javax.swing.GroupLayout(panelEleccion);
        panelEleccion.setLayout(panelEleccionLayout);
        panelEleccionLayout.setHorizontalGroup(
            panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelEleccionLayout.setVerticalGroup(
            panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
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

    private void buttonOrganizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOrganizarActionPerformed
//        Collections.sort(rinesGeneral, new Comparator<RinClass>() {
//            @Override
//            public int compare(RinClass p1, RinClass p2) {
//                return p1.getAerodinamica().compareTo(p2.getAerodinamica());
//            }
//        });
//        rinesGeneral.forEach(rine -> {
//            System.out.println("rine = " + rine);
//            System.out.println("");
//        });
    }//GEN-LAST:event_buttonOrganizarActionPerformed

    private void buttonPorAbsoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPorAbsoliActionPerformed
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
    }//GEN-LAST:event_buttonPorAbsoliActionPerformed

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
    private javax.swing.JButton buttonOrganizar;
    private javax.swing.JButton buttonPorAbsoli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelEleccion;
    private javax.swing.JTable tablaEleccion;
    private javax.swing.JTable tableRegistros;
    private javax.swing.JTextField txtAerodinamica;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtRinNombre;
    // End of variables declaration//GEN-END:variables
}
