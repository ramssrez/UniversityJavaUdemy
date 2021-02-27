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
            //cargar_txt();
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
        tableRegistros.setRowHeight(60);
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

    public void ingresarRegistro(File ruta) {
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

                //p = new Producto(leerCodigo(), leerNombre(), leerPrecio(), leerDescripcion());
//                if(rp.buscaCodigo(p.getCodigo())!= -1)mensaje("Este codigo ya existe");
//                else rp.agregarRegistro(p);
//                grabar_txt();
//                listarRegistro();
//                lt.limpiar_texto(panel); 
            }
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    public void grabarTxt() {
        FileWriter fileWriter;
        PrintWriter printWriter;
        try {
            fileWriter = new FileWriter(rutaTxt);
            printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < processRin.cantidadRegistro(); i++) {
                rinClass = processRin.obtenerRegistro(i);
                printWriter.println(String.valueOf(rinClass.getNombre() + ", " + rinClass.getPorcentajeRelativo() + ", " + rinClass.getAerodinamica()));
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

        jLabel1 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRinNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAerodinamica = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegistros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre del Rin");

        jLabel2.setText("Procentaje Relativo");

        jLabel3.setText("Aerodinamica");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Organizar ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Absoluto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(txtRinNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAerodinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRinNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAerodinamica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtRinNombre.getText().equals("")
                && txtPorcentaje.getText().equals("")
                && txtAerodinamica.getText().equals("")) {
            System.out.println("Los campos estan vacios");
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        } else if ((txtRinNombre.getText().equals(""))
                || (txtAerodinamica.getText().equals(""))
                || txtPorcentaje.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos");
            System.out.println("No se ha agregado la ");
        } else {
            float aero = Float.parseFloat(txtAerodinamica.getText());
            float porcentaje = Float.parseFloat(txtPorcentaje.getText());
            RinClass rin = new RinClass(txtRinNombre.getText(), porcentaje, aero);
            rinesGeneral.add(rin);
            JOptionPane.showMessageDialog(null, "Todos los datos estan llenos");
            rinesGeneral.forEach(rine -> {
                System.out.println("rine = " + rine);
                System.out.println("");
            });
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Collections.sort(rinesGeneral, new Comparator<RinClass>() {
            @Override
            public int compare(RinClass p1, RinClass p2) {
                return p1.getAerodinamica().compareTo(p2.getAerodinamica());
            }
        });
        rinesGeneral.forEach(rine -> {
            System.out.println("rine = " + rine);
            System.out.println("");
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        float sumaRelative = 0.0f;
        for (RinClass rin : rinesGeneral) {
            sumaRelative = sumaRelative + rin.getPorcentajeRelativo();
            System.out.println("suma " + sumaRelative);
        }
        for (RinClass rin : rinesGeneral) {
            var absoluto = (rin.getPorcentajeRelativo() * 100f) / sumaRelative;
            rin.setPorcentajeAbsoluto(absoluto);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRegistros;
    private javax.swing.JTextField txtAerodinamica;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtRinNombre;
    // End of variables declaration//GEN-END:variables
}
