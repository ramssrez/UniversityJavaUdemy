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
    private float sumarelativa;

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

    //método que permite el listar los resgistros que se tengan de la lista en question
    public void listarRegistro() {
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //Asignación de los nombres de las columnas
        dt.addColumn("Nombre");
        dt.addColumn("Porcentaje Relativo");
        dt.addColumn("Porcentaje Absoluto");
        dt.addColumn("Aerodinamica");

        //Asignación la tabla en donde se lleva a cabo los registros
        tableRegistros.setDefaultRenderer(Object.class, new ImgTabla());
        Object fila[] = new Object[dt.getColumnCount()];
        //Recorrido de la lista para obtener cada uno de sus atrbutos
        for (int i = 0; i < processRin.cantidadRegistro(); i++) {
            rinClass = processRin.obtenerRegistro(i);
            fila[0] = rinClass.getNombre();
            fila[1] = rinClass.getPorcentajeRelativo();
            fila[2] = rinClass.getPorcentajeAbsoluto();
            fila[3] = rinClass.getAerodinamica();
            dt.addRow(fila);
        }
        //Asignación cada uno de las columnas a la tabla
        tableRegistros.setModel(dt);
        //Asignación de tamaño de la tabla para cada una de las filas
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
        rinClass = processRinEleccion.obtenerRegistro(processRinEleccion.cantidadRegistro() - 1);
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

    //método que permite ingresar un registro a la tabla 
    public void ingresarRegistro() {
        try {
            if (txtRinNombre.getText().equals("")
                    && txtPorcentaje.getText().equals("")
                    && txtAerodinamica.getText().equals("")) {
                mensaje("Los campos esta vacios");
            } else if ((leerNombre() == null)
                    || (leerAerodinamica() == -666)
                    || (leerPorcentaje() == -666)) {
                mensaje("Falta agregar datos");
            } else if (!aerodinamicaValor()) {
                mensaje("Aerodinamica mayor a 0 menor a 1");
            } else if (!porcentajeValor()) {
                mensaje("Porcentaje mayor a 0 menor a 100");
            } else {
                rinClass = new RinClass(leerNombre(), leerPorcentaje(), leerAerodinamica());
                processRin.agregarRegistro(rinClass);
                grabarTxt();
                listarRegistro();
                calculoPorcentajeAbsoluto();
                ordenarLista();
                limpiarTxt.limpiarTexto(paneTexto);
            }
            sumarelativa = sumaPorcentajeRelativo();
            if (sumarelativa >= 100.0) {
                txtRinNombre.setEnabled(false);
            }
            System.out.println("suma = " + sumarelativa);
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    //Método que ordena la lista de rines en funcion de la aerodinamica de mayor a menor
    public void ordenarLista() {
        try {
            processRin.ordenarLista();
            listarRegistro();
            grabarTxt();
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }

    //Método que permite el calculo del porcentaje absoluto
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

    //Método de porcentaje relativo
    public float sumaPorcentajeRelativo() {
        try {
            float sumaRelativa = 0.0f;
            for (int i = 0; i < processRin.cantidadRegistro(); i++) {
                sumaRelativa = sumaRelativa + processRin.obtenerRegistro(i).getPorcentajeRelativo();
            }
            return sumaRelativa;
        } catch (Exception ex) {
            System.out.println("mensaje : " + ex.getMessage());
            return -666;
        }
    }

    //cargarTxt();
    public void validacionRines() {
        if (processRin.ultimoRin().getPorcentajeAbsoluto() > 33.0) {
            System.out.println("Este es el ultimo rin");
            RinClass ultimo = processRin.ultimoRin();
            System.out.println("El rin seleccionado es: " + processRin.ultimoRin().toString());
            processRinEleccion.agregarRegistro(ultimo);
        } else if (processRin.primerRin().getPorcentajeAbsoluto() >= 67.0) {
            System.out.println("Este es el primer rin");
            RinClass primero = processRin.primerRin();
            System.out.println("El rin seleccionado es: " + processRin.primerRin().toString());
            processRinEleccion.agregarRegistro(primero);

        } else {
            System.out.println("Esta es la suma de la lista");
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

    //Metodo que permite grabar un txt
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

    //Método que permite la carga de datos en un txt, es posible que se pueda eliminar
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

    //No se ha utilizado este método por lo que puede set eliminado
//    public void cargarTxtSeleccionado() {
//        File ruta = new File(rutaTxt);
//        try {
//
//            FileReader fileReader = new FileReader(ruta);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String linea = null;
//            while ((linea = bufferedReader.readLine()) != null) {
//                StringTokenizer st = new StringTokenizer(linea, ",");
//                rinClass = new RinClass();
//                rinClass.setNombre(st.nextToken());
//                rinClass.setPorcentajeRelativo(Float.parseFloat(st.nextToken()));
//                rinClass.setPorcentajeAbsoluto(Float.parseFloat(st.nextToken()));
//                rinClass.setAerodinamica(Float.parseFloat(st.nextToken()));
//                processRin.agregarRegistro(rinClass);
//            }
//            bufferedReader.close();
//        } catch (Exception ex) {
//            mensaje("Error al cargar archivo: " + ex.getMessage());
//            System.out.println(ex.getMessage());
//        }
//    }
    public boolean aerodinamicaValor() {
        float num;
        try {
            num = Float.parseFloat(txtAerodinamica.getText());
            if (num > 0.0 && num <= 1.0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("ex " + ex.getMessage());
            return false;
        }
    }

    public boolean porcentajeValor() {
        float num;
        try {
            num = Float.parseFloat(txtPorcentaje.getText());
            if (num > 0.0 && num <= 100) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("ex " + ex.getMessage());
            return false;
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
        paneTexto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRinNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAerodinamica = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        buttonValidarRines = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegistros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableMostrar = new javax.swing.JTable();
        labelPorcentaje = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelHomologacion = new javax.swing.JLabel();
        labelporcentaje = new javax.swing.JLabel();

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

        paneTexto.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setText("Nombre del Rin");

        txtPorcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcentajeKeyTyped(evt);
            }
        });

        jLabel2.setText("Procentaje Relativo");

        txtRinNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRinNombreKeyTyped(evt);
            }
        });

        jLabel3.setText("Aerodinamica");

        txtAerodinamica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAerodinamicaKeyTyped(evt);
            }
        });

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

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneTextoLayout = new javax.swing.GroupLayout(paneTexto);
        paneTexto.setLayout(paneTextoLayout);
        paneTextoLayout.setHorizontalGroup(
            paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTextoLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneTextoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(txtRinNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonValidarRines)
                            .addComponent(buttonAdd)
                            .addComponent(btnSalir)
                            .addComponent(btnLimpiar)))
                    .addComponent(jLabel3))
                .addGap(129, 129, 129))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneTextoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAerodinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(275, 275, 275))
        );
        paneTextoLayout.setVerticalGroup(
            paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRinNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdd))
                .addGroup(paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneTextoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(buttonValidarRines)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir))
                    .addGroup(paneTextoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAerodinamica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tableRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

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

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tableMostrar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
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

        labelHomologacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHomologacion.setText("Porcentaje de Homolagación:");

        labelporcentaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelporcentaje.setText("%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(labelHomologacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelporcentaje))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHomologacion)
                    .addComponent(labelporcentaje))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(276, 276, 276)
                                .addComponent(labelPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(labelPorcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        this.ingresarRegistro();
        //txtAerodinamica.setEnabled(false);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonValidarRinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidarRinesActionPerformed
        this.validacionRines();
    }//GEN-LAST:event_buttonValidarRinesActionPerformed

    private void txtRinNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRinNombreKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            mensaje("Solo ingresa letras");
        }
    }//GEN-LAST:event_txtRinNombreKeyTyped

    private void txtAerodinamicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAerodinamicaKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            mensaje("Solo ingresa números");
        }
    }//GEN-LAST:event_txtAerodinamicaKeyTyped

    private void txtPorcentajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            mensaje("Solo ingresa números");
        }
    }//GEN-LAST:event_txtPorcentajeKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarTxt.limpiarTexto(paneTexto);
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonValidarRines;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labelHomologacion;
    private javax.swing.JLabel labelPorcentaje;
    private javax.swing.JLabel labelporcentaje;
    private javax.swing.JPanel paneTexto;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JTable tableMostrar;
    private javax.swing.JTable tableRegistros;
    private javax.swing.JTextField txtAerodinamica;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtRinNombre;
    // End of variables declaration//GEN-END:variables
}
