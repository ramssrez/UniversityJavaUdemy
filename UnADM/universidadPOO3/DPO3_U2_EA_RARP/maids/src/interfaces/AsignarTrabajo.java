/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package interfaces;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AsignarTrabajo extends javax.swing.JFrame {

    //Declaración de variables necesarias
    private final int horas = 5;
    private Thread hilo;

    /**
     * Creates new form Principal
     */
    public AsignarTrabajo() {
        initComponents();
        this.setTitle("Asignar Trabajo");
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {
        if ((textTraUno.getText().equals("") && textTraDos.getText().equals("") && textTraTres.getText().equals("")
                && textCliUno.getText().equals("") && textCliDos.getText().equals("") && textCliTres.getText().equals("")
                && jTextFecha.getText().equals(""))
                || textTraUno.getText().equals("") || textTraDos.getText().equals("") || textTraTres.getText().equals("")
                || textCliUno.getText().equals("") || textCliDos.getText().equals("") || textCliTres.getText().equals("")
                || jTextFecha.getText().equals("")) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;
        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Método que genera una numero aleatio entre -3 y 3
    public int randomNumer() {
        int min = -3;
        int max = 4;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    //Método que realiza el calculo del contador de horas
    public void contadorHoras() {
        //Impleentación del uso de holos
        hilo = new Thread(new Runnable() {
            //Sobrescritura del método run del la implemnacion del hilo
            @Override
            public void run() {
                //Multiplicacion de los dias por horas
                int horas = 8;
                int minutos = 0, segundos = 0, i;
                //Implementación del while para realizar el contador de horas, minutos y segundos
                while (!(horas == 0 && minutos == 0 && segundos == 0)) {
                    try {
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
                        System.out.println("Habitacion " + ": " + " H:" + horas + " M: " + minutos + " S: " + segundos);
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AsignarTrabajo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        //Inicio del hilo
        hilo.start();
    }

    //Método que realiza el calculo del contador de horas
    public void llenarProgres() {
        int i = 0;
        //Impleentación del uso de holos
        hilo = new Thread(new Runnable() {
            //Sobrescritura del método run del la implemnacion del hilo
            @Override
            public void run() {
                //Multiplicacion de los dias por horas
                int horas = 0;
                int minutos = 0, segundos = 0;
                while (!(horas == 8)) {

                    if (segundos > 59) {
                        segundos = 0;
                        minutos++;
                        if (minutos > 59) {
                            minutos = 0;
                            horas++;
                        }
                    }
                    System.out.println(horas + " : " + minutos + " : " + segundos);

                    segundos++;
                }

//                //Implementación del while para realizar el contador de horas, minutos y segundos
//                for (int j = 0; j <= 100; j++) {
//                    try {
//                        Thread.sleep(100);
//
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(AsignarTrabajo.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    while (!(horas == 8)) {
//                        //i++;
//                    }
//                    jProgressBar1.setValue(j);
//                    if (jProgressBar1.getValue() == 100) {
//                        JOptionPane.showMessageDialog(null, "Se ha terminado el proceso");
//                    }
//                }
            }
        });
        //Inicio del hilo
        hilo.start();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnIniciarJornada = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFecha = new javax.swing.JTextField();
        jPanelTrabajdorUno = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textTraUno = new javax.swing.JTextField();
        textCliUno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanelTrabajdorUno1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textTraDos = new javax.swing.JTextField();
        textCliDos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jProgressBarTraDos = new javax.swing.JProgressBar();
        jPanelTrabajdorUno2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textTraTres = new javax.swing.JTextField();
        textCliTres = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jProgressBarTraTres = new javax.swing.JProgressBar();

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

        btnIniciarJornada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIniciarJornada.setText("Iniciar Jornada");
        btnIniciarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarJornadaActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fecha");

        jPanelTrabajdorUno.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del Trabajador 1");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre del Cliente 1");

        textTraUno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        textCliUno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Avance %");

        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanelTrabajdorUnoLayout = new javax.swing.GroupLayout(jPanelTrabajdorUno);
        jPanelTrabajdorUno.setLayout(jPanelTrabajdorUnoLayout);
        jPanelTrabajdorUnoLayout.setHorizontalGroup(
            jPanelTrabajdorUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrabajdorUnoLayout.createSequentialGroup()
                .addGap(0, 92, Short.MAX_VALUE)
                .addGroup(jPanelTrabajdorUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrabajdorUnoLayout.createSequentialGroup()
                        .addGroup(jPanelTrabajdorUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textCliUno, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTraUno, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrabajdorUnoLayout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
            .addGroup(jPanelTrabajdorUnoLayout.createSequentialGroup()
                .addGroup(jPanelTrabajdorUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTrabajdorUnoLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanelTrabajdorUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)))
                    .addGroup(jPanelTrabajdorUnoLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTrabajdorUnoLayout.setVerticalGroup(
            jPanelTrabajdorUnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrabajdorUnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(textTraUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCliUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTrabajdorUno1.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTrabajdorUno1.setPreferredSize(new java.awt.Dimension(434, 251));
        jPanelTrabajdorUno1.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre del Trabajador 2");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nombre del Cliente 2");

        textTraDos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        textCliDos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Avance %");

        javax.swing.GroupLayout jPanelTrabajdorUno1Layout = new javax.swing.GroupLayout(jPanelTrabajdorUno1);
        jPanelTrabajdorUno1.setLayout(jPanelTrabajdorUno1Layout);
        jPanelTrabajdorUno1Layout.setHorizontalGroup(
            jPanelTrabajdorUno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrabajdorUno1Layout.createSequentialGroup()
                .addGap(0, 92, Short.MAX_VALUE)
                .addGroup(jPanelTrabajdorUno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrabajdorUno1Layout.createSequentialGroup()
                        .addGroup(jPanelTrabajdorUno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textCliDos, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTraDos, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrabajdorUno1Layout.createSequentialGroup()
                        .addComponent(jProgressBarTraDos, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
            .addGroup(jPanelTrabajdorUno1Layout.createSequentialGroup()
                .addGroup(jPanelTrabajdorUno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTrabajdorUno1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanelTrabajdorUno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)))
                    .addGroup(jPanelTrabajdorUno1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTrabajdorUno1Layout.setVerticalGroup(
            jPanelTrabajdorUno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrabajdorUno1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(textTraDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCliDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBarTraDos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTrabajdorUno2.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTrabajdorUno2.setPreferredSize(new java.awt.Dimension(434, 251));
        jPanelTrabajdorUno2.setRequestFocusEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombre del Trabajador 3");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nombre del Cliente 3");

        textTraTres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        textCliTres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Avance %");

        javax.swing.GroupLayout jPanelTrabajdorUno2Layout = new javax.swing.GroupLayout(jPanelTrabajdorUno2);
        jPanelTrabajdorUno2.setLayout(jPanelTrabajdorUno2Layout);
        jPanelTrabajdorUno2Layout.setHorizontalGroup(
            jPanelTrabajdorUno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrabajdorUno2Layout.createSequentialGroup()
                .addGap(0, 92, Short.MAX_VALUE)
                .addGroup(jPanelTrabajdorUno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrabajdorUno2Layout.createSequentialGroup()
                        .addGroup(jPanelTrabajdorUno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textCliTres, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTraTres, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrabajdorUno2Layout.createSequentialGroup()
                        .addComponent(jProgressBarTraTres, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
            .addGroup(jPanelTrabajdorUno2Layout.createSequentialGroup()
                .addGroup(jPanelTrabajdorUno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTrabajdorUno2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanelTrabajdorUno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)))
                    .addGroup(jPanelTrabajdorUno2Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTrabajdorUno2Layout.setVerticalGroup(
            jPanelTrabajdorUno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrabajdorUno2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(textTraTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCliTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBarTraTres, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelTrabajdorUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelTrabajdorUno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelTrabajdorUno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(btnIniciarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTrabajdorUno2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTrabajdorUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTrabajdorUno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarJornadaActionPerformed
        // TODO add your handling code here:
        //contadorHoras();
        llenarProgres();
//        if (validacionCamposTexto()) {
//            //Impresión del dialog en caso de que los campos se encuentrn vacios
//            JOptionPane.showMessageDialog(null, "Los campos se encuentran llenos");
//        } else {
//            //Impresión del dialog en caso de que los campos se encuentrn vacios
//            JOptionPane.showMessageDialog(null, "Los campos se encuentran vacios");
//        }
    }//GEN-LAST:event_btnIniciarJornadaActionPerformed

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
            java.util.logging.Logger.getLogger(AsignarTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarTrabajo().setVisible(true);
            }
        });
    }
    //Variables de los diferentes componentes de la ventana


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarJornada;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelTrabajdorUno;
    private javax.swing.JPanel jPanelTrabajdorUno1;
    private javax.swing.JPanel jPanelTrabajdorUno2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBarTraDos;
    private javax.swing.JProgressBar jProgressBarTraTres;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFecha;
    private javax.swing.JTextField textCliDos;
    private javax.swing.JTextField textCliTres;
    private javax.swing.JTextField textCliUno;
    private javax.swing.JTextField textTraDos;
    private javax.swing.JTextField textTraTres;
    private javax.swing.JTextField textTraUno;
    // End of variables declaration//GEN-END:variables
}
