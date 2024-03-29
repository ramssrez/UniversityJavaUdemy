package windows;

import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Inicio");
        btngrup.add(rdbOpción1);
        btngrup.add(rdbOpcion2);
        btngrup.add(rdbOpcion4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrup = new javax.swing.ButtonGroup();
        lebelWelcome = new javax.swing.JLabel();
        rdbOpción1 = new javax.swing.JRadioButton();
        rdbOpcion2 = new javax.swing.JRadioButton();
        btnIngresar = new javax.swing.JButton();
        rdbOpcion4 = new javax.swing.JRadioButton();
        lebelOpciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));

        lebelWelcome.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        lebelWelcome.setForeground(new java.awt.Color(0, 20, 223));
        lebelWelcome.setText("Bienvenido Profesor ");

        rdbOpción1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbOpción1.setText("Ingresar Examen");
        rdbOpción1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOpción1ActionPerformed(evt);
            }
        });

        rdbOpcion2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbOpcion2.setText("Lista de Alumnos y Calificaciones");
        rdbOpcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOpcion2ActionPerformed(evt);
            }
        });

        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(184, 7, 11));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        rdbOpcion4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbOpcion4.setText("Subir Archivos");
        rdbOpcion4.setToolTipText("");
        rdbOpcion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbOpcion4ActionPerformed(evt);
            }
        });

        lebelOpciones.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lebelOpciones.setForeground(new java.awt.Color(0, 218, 11));
        lebelOpciones.setText("¿Qué opción desea realizar?");
        lebelOpciones.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lebelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lebelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rdbOpción1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdbOpcion2)
                            .addComponent(rdbOpcion4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnIngresar)))
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lebelWelcome)
                .addGap(18, 18, 18)
                .addComponent(lebelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(rdbOpción1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbOpcion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbOpcion4)
                .addGap(32, 32, 32)
                .addComponent(btnIngresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbOpción1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOpción1ActionPerformed
        System.out.println("Seleccionsndo la opcion 1");
    }//GEN-LAST:event_rdbOpción1ActionPerformed

    private void rdbOpcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOpcion2ActionPerformed
        System.out.println("Seleccionsndo la opcion 3");
    }//GEN-LAST:event_rdbOpcion2ActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        System.out.println("Seleccionando el boton");
        String mensaje = "";
        if (rdbOpción1.isSelected()) {
            mensaje = "Seleccionaste opción 1";
            Examen examen = new Examen();
            examen.setVisible(true);
        } else if (rdbOpcion2.isSelected()) {
            mensaje = "Seleccionaste la opción 2";
            ListaAlumnos listaAlumnos = new ListaAlumnos();
            listaAlumnos.setVisible(true);
        }  else if (rdbOpcion4.isSelected()) {
            mensaje = "Seleccionamos la opción 4";
        } else {
            mensaje = "No se ha seleccionado una opción";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void rdbOpcion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbOpcion4ActionPerformed
        System.out.println("Seleccionando la opcion 4");
    }//GEN-LAST:event_rdbOpcion4ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.ButtonGroup btngrup;
    private javax.swing.JLabel lebelOpciones;
    private javax.swing.JLabel lebelWelcome;
    private javax.swing.JRadioButton rdbOpcion2;
    private javax.swing.JRadioButton rdbOpcion4;
    private javax.swing.JRadioButton rdbOpción1;
    // End of variables declaration//GEN-END:variables
}
