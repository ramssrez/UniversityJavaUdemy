/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package interfaces;

import database.EmpleadoDAO;
import dialogs.ConfirmarLimpieza;
import dialogs.ConfimarSalir;
import dialogs.ConfirmarBusquedaEmpleado;
import dialogs.ErrorEmpleadoNoExiste;
import dialogs.ErrorIngresarDatos;
import dialogs.ErrorIngresarPorcentaje;
import main.Principal;
import objetos.Empleado;

public class CalculoNomina extends javax.swing.JFrame {

    //Variables globales para enviar a la ventana de información
    private double sueldoBruto;
    public String nombre;
    public String apellidos;
    public double sueldoNetoCalculado;
    public double impuesto;
    public String rfc;
    public int numeroempleadoVentana;
    public double descuentoVentana;

    public CalculoNomina() {
        initComponents();
        //Asignación de titulo a la ventana
        this.setTitle("Cálculo de Nómina");
        //Método que permite centrar la pantalla en medio de la pantalla general
        this.setLocationRelativeTo(null);
        //Implementación de bloqueo de los campos de la pantalla
        txtNombre.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtRfc.setEnabled(false);
        txtSueldoBruto.setEnabled(false);
        sueldoBruto = 0.0d;
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);

    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {
        //Sentencia if/else que verifica si esta vacio el campo, en caso afirmativo retorna un booleano
        if (txtNEmpleado.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    //Método que permite la conexión a la base de datos con el dato de entrada como el número empleado
    public void buscarEmpleado(int numeroEmpleado) {
        //Instancia de la clase EmpleadoDAO
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        //Declaración del objeto empleado como nulo
        Empleado empleado = null;
        //Asignación del empleado a lo que se recupere de la sentencia SQL
        empleado = empleadoDAO.seleccionar(numeroEmpleado);
        //Sentencia if/else para el caso de que se recupere información
        if (empleado != null) {
            //Asignación de la información que se obtuvo de la base de datos en los campos de texto
            txtApellidos.setText(empleado.getApellidosEmpleado());
            txtNombre.setText(empleado.getNombreEmpleado());
            txtRfc.setText(empleado.getRfcEmpleado());
            txtSueldoBruto.setText("$" + String.valueOf(empleado.getSueldoEmpleado()));
            //Asignación a las variables globales para su impresión en la ventana de iformación
            sueldoBruto = empleado.getSueldoEmpleado();
            rfc = empleado.getRfcEmpleado();
            nombre = empleado.getNombreEmpleado();
            apellidos = empleado.getApellidosEmpleado();
            numeroempleadoVentana = empleado.getNumEmpleado();
            //Llamado del Dialog que menciona que existe un empleado
            ConfirmarBusquedaEmpleado cbe = new ConfirmarBusquedaEmpleado(this, true);
            //Método que permite visualizar la ventana anteriormente mencionada
            cbe.setVisible(true);
            txtPorcentaje.setText("");
            txtSueldoNeto.setText("");
        } else {
            //Llamado del Dialog que menciona que no existe un empleado
            ErrorEmpleadoNoExiste eene = new ErrorEmpleadoNoExiste(this, true);
            //Método que permite visualizar la ventana anteriormente mencionada
            eene.setVisible(true);
            //Método que permite limpiar  los campos depues de ser ingresados
            limpiarCamposTexto();
        }
    }

    //Método que permite la limpieza de los datos que se han asignado
    public void limpiarCamposTexto() {
        txtNEmpleado.setText("");
        txtApellidos.setText("");
        txtNombre.setText("");
        txtRfc.setText("");
        txtSueldoBruto.setText("");
        txtPorcentaje.setText("");
        txtSueldoNeto.setText("");
    }

    //Método que permite la creación de la ventana de información, 
    public void ventanaImpresion() {
        //Creación de la ventana de información
        Informacion info = new Informacion();
        //Asignación de las varibles globales a las variables de la ventana de información
        Informacion.sueldoBru = sueldoBruto;
        Informacion.iva = impuesto;
        Informacion.sueldoNeto = sueldoNetoCalculado;
        Informacion.rfc = rfc;
        Informacion.nombre = nombre;
        Informacion.apellidos = apellidos;
        Informacion.numeroempleado = numeroempleadoVentana;
        Informacion.descuento = descuentoVentana;
        //Método que permite la visualización de la ventana
        info.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //Sección del código que permite la creación de la ventana principal 
    //y cada uno de los componentes que se encuentren dentro de la ventana
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel8 = new javax.swing.JPanel();
        paneldatos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jleArticulo = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jleCodigo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jleCodigo1 = new javax.swing.JLabel();
        txtNEmpleado = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jleCodigo3 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jleCodigo2 = new javax.swing.JLabel();
        txtSueldoBruto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnCalculoNuevo = new javax.swing.JButton();
        btnCalcularNomina = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        paneldatos1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jleCodigo10 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jleCodigo11 = new javax.swing.JLabel();
        txtSueldoNeto = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuEmpleado = new javax.swing.JMenu();
        menuAltaEmpleado = new javax.swing.JMenuItem();
        menuBajaEmpleado = new javax.swing.JMenuItem();
        menuInventario = new javax.swing.JMenu();
        menuIteAltaInsumo = new javax.swing.JMenuItem();
        menuIteBjaInsumo = new javax.swing.JMenuItem();
        menuNomina = new javax.swing.JMenu();
        menuItemCalcluarNomina = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        menuItemConsultaPersonal = new javax.swing.JMenuItem();
        menuItemConsultaInsumos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemPrincipal = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(29, 183, 238));

        paneldatos.setBackground(new java.awt.Color(162, 220, 245));
        paneldatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos empleado  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jleArticulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleArticulo.setText("Apellidos :");

        txtApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleArticulo)
                .addGap(40, 40, 40)
                .addComponent(txtApellidos)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleArticulo)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo1.setText("N. Empleado:");

        txtNEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo1)
                    .addComponent(txtNEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo3.setText("RFC :");

        txtRfc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo3)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo2.setText("Sueldo Bruto:");

        txtSueldoBruto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(txtSueldoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo2)
                    .addComponent(txtSueldoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscar.setBackground(new java.awt.Color(21, 102, 180));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneldatosLayout = new javax.swing.GroupLayout(paneldatos);
        paneldatos.setLayout(paneldatosLayout);
        paneldatosLayout.setHorizontalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        paneldatosLayout.setVerticalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(162, 220, 245));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        btnCalculoNuevo.setBackground(new java.awt.Color(21, 102, 180));
        btnCalculoNuevo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCalculoNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calcular.png"))); // NOI18N
        btnCalculoNuevo.setText("Nuevo Cálculo");
        btnCalculoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoNuevoActionPerformed(evt);
            }
        });

        btnCalcularNomina.setBackground(new java.awt.Color(21, 102, 180));
        btnCalcularNomina.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCalcularNomina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calculoNuevo.png"))); // NOI18N
        btnCalcularNomina.setText("Cálcular Nómina");
        btnCalcularNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularNominaActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(21, 102, 180));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalcularNomina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalculoNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCalculoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalcularNomina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nomina.png"))); // NOI18N

        paneldatos1.setBackground(new java.awt.Color(162, 220, 245));
        paneldatos1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Impuestos y sueldo neto  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo10.setText("Impuestos %");

        txtPorcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo10)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo11.setText("Sueldo Neto:");

        txtSueldoNeto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSueldoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo11)
                    .addComponent(txtSueldoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneldatos1Layout = new javax.swing.GroupLayout(paneldatos1);
        paneldatos1.setLayout(paneldatos1Layout);
        paneldatos1Layout.setHorizontalGroup(
            paneldatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatos1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldatos1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneldatos1Layout.setVerticalGroup(
            paneldatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatos1Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(paneldatos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneldatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paneldatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );

        menuEmpleado.setText("Empleado");

        menuAltaEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/altaEmp.png"))); // NOI18N
        menuAltaEmpleado.setText("Alta Empleado");
        menuAltaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaEmpleadoActionPerformed(evt);
            }
        });
        menuEmpleado.add(menuAltaEmpleado);

        menuBajaEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bajasEmpleado.png"))); // NOI18N
        menuBajaEmpleado.setText("Baja Empleado");
        menuBajaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBajaEmpleadoActionPerformed(evt);
            }
        });
        menuEmpleado.add(menuBajaEmpleado);

        jMenuBar1.add(menuEmpleado);

        menuInventario.setText("Inventario");

        menuIteAltaInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/InsumoBaja_1.png"))); // NOI18N
        menuIteAltaInsumo.setText("Alta Insumo");
        menuIteAltaInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIteAltaInsumoActionPerformed(evt);
            }
        });
        menuInventario.add(menuIteAltaInsumo);

        menuIteBjaInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/insumoAlta.png"))); // NOI18N
        menuIteBjaInsumo.setText("Baja Insumo");
        menuIteBjaInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIteBjaInsumoActionPerformed(evt);
            }
        });
        menuInventario.add(menuIteBjaInsumo);

        jMenuBar1.add(menuInventario);

        menuNomina.setText("Nómina");

        menuItemCalcluarNomina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calcular.png"))); // NOI18N
        menuItemCalcluarNomina.setText("Cálcular Nómina");
        menuItemCalcluarNomina.setToolTipText("");
        menuItemCalcluarNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCalcluarNominaActionPerformed(evt);
            }
        });
        menuNomina.add(menuItemCalcluarNomina);

        jMenuBar1.add(menuNomina);

        menuConsultas.setText("Consultas");

        menuItemConsultaPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/empleo.png"))); // NOI18N
        menuItemConsultaPersonal.setText("Consulta Personal");
        menuItemConsultaPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConsultaPersonalActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemConsultaPersonal);

        menuItemConsultaInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventarios.png"))); // NOI18N
        menuItemConsultaInsumos.setText("Consulta Insumos");
        menuItemConsultaInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConsultaInsumosActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemConsultaInsumos);

        jMenuBar1.add(menuConsultas);

        jMenu2.setText("Principal");

        menuItemPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        menuItemPrincipal.setText("Regresar Inicio");
        menuItemPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPrincipalActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemPrincipal);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método que manda a llamar el Dialog de confirmar para salir del sistema
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Instancia del Dialog para confirmar la salida del sistema
        ConfimarSalir salir = new ConfimarSalir(this, true);
        //Método que permite visualizar la ventana
        salir.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    //Método que permite borrar todo lo que contiene los campos de texto
    private void btnCalculoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoNuevoActionPerformed
        //Método que permite limpiar los campos de texto
        limpiarCamposTexto();
        //Instancia del Dialog para confirmar la limpieza de los campos de texto del módulo
        ConfirmarLimpieza limpiar = new ConfirmarLimpieza(this, true);
        //Método que permite visualizar la ventana
        limpiar.setVisible(true);
    }//GEN-LAST:event_btnCalculoNuevoActionPerformed

    //Método que permite calcular la nómina de un empleado
    private void btnCalcularNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularNominaActionPerformed
        //Sentencia if/else para validar que se haya ingresado un datos en la caja de texto
        if (validacionCamposTexto()) {
            //Sentencia if/else que verifica se se ha agregado un porcentaje al campo de texto de porcentaje
            if (txtPorcentaje.getText().equals("")) {
                System.out.println("No se ha agregado un porcentaje");
                //Llamado del Dialog que menciona que no se ha ingresado valores
                ErrorIngresarPorcentaje ee = new ErrorIngresarPorcentaje(this, true);
                //Método que permite observar el dialg de error
                ee.setVisible(true);
            } else {
                //Creación de la varibla iva en función de lo que se agregue en la caja de texto
                double iva = Double.valueOf(txtPorcentaje.getText());
                //Calculo del sueldo neto en función del sueldo bruto y el iva
                double sueldoNeto = sueldoBruto - (sueldoBruto) * (iva / 100);
                //Asignación del sueldo neto global al sueldo neto calculado
                sueldoNetoCalculado = sueldoNeto;
                //Asignación del impuesto global al iva que se ingreso en el campo de texto
                impuesto = iva;
                //Asignación del descuento para la variable global
                descuentoVentana = -(sueldoBruto) * (iva / 100);
                System.out.println("El sueldo es. " + sueldoNeto);
                //Impresión del sueldo neto en el campo de texto de la interfaz
                txtSueldoNeto.setText("$" + String.valueOf(sueldoNeto));
                //Llamado a la función que se encarga de crear la ventana de información
                ventanaImpresion();
            }
        } else {
            //En caso de que se retorne false, se manda a crear un Dialog
            //Llamado del Dialog que menciona que no se ha ingresado valores
            ErrorIngresarDatos ee = new ErrorIngresarDatos(this, true);
            //Método que permite observar el dialg de error
            ee.setVisible(true);
        }
    }//GEN-LAST:event_btnCalcularNominaActionPerformed

    //Método que permite abrir la ventana para dar de alta un Empleado
    private void menuAltaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaEmpleadoActionPerformed
        //Instancia para la ventana de alta de empleados
        EmpleadosAltas altas = new EmpleadosAltas();
        //Método que permite visualizar la ventana
        altas.setVisible(true);
        //Método que cierra la ventana para abrir otra
        dispose();
    }//GEN-LAST:event_menuAltaEmpleadoActionPerformed

    //Método que permite abrir la ventana para dar de baja a un Empleado
    private void menuBajaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBajaEmpleadoActionPerformed
        //Instancia para la ventana de baja de empleados
        EmpleadosBajas bajas = new EmpleadosBajas();
        //Método que permite visualizar la ventana
        bajas.setVisible(true);
        //Método que cierra la ventana para abrir otra
        dispose();
    }//GEN-LAST:event_menuBajaEmpleadoActionPerformed

    //Método que permite abrir la ventana para dar de alta un insumo
    private void menuIteAltaInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIteAltaInsumoActionPerformed
        //Instancia para la ventana de  alta de insumos
        InventarioAltas altas = new InventarioAltas();
        //Método que permite visualizar la ventana
        altas.setVisible(true);
        //Método que cierra la ventana para abrir otra
        dispose();
    }//GEN-LAST:event_menuIteAltaInsumoActionPerformed

    //Método que permite abrir la ventana para dar de baja un Insumo
    private void menuIteBjaInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIteBjaInsumoActionPerformed
        //Instancia para la ventana de  baja de insumos
        InventarioBajas bajas = new InventarioBajas();
        //Método que permite visualizar la ventana
        bajas.setVisible(true);
        //Método que cierra la ventana para abrir otra
        dispose();
    }//GEN-LAST:event_menuIteBjaInsumoActionPerformed

    //Método que permite regresar a la pagina principal
    private void menuItemPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPrincipalActionPerformed
        //Instancia para la ventana Principal
        Principal principal = new Principal();
        //Método que permite visualizar la ventana
        principal.setVisible(true);
        //Método que cierra la ventana para abrir otra
        dispose();
    }//GEN-LAST:event_menuItemPrincipalActionPerformed

    //Método que permite realizar la busqueda de un empleado
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Sentencia if/else para validar que se haya ingresado un datos en la caja de texto
        if (validacionCamposTexto()) {
            //Creación de la variable de tipo entero para ser enviado al metodo de busqueda
            int numeroEmpleado = Integer.parseInt(txtNEmpleado.getText());
            System.out.println("numeroEmpleado = " + numeroEmpleado);
            //Método que se conecta a la base de datos para recuperar la información del Empleado
            buscarEmpleado(numeroEmpleado);
        } else {
            //En caso de que se retorne false, se manda a crear un Dialog
            //Llamado del Dialog que menciona que no se ha ingresado valores
            ErrorIngresarDatos ee = new ErrorIngresarDatos(this, true);
            //Método que permite observar el dialg de error
            ee.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    //Método que permite abrir la ventana de calculo de nomina
    private void menuItemCalcluarNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCalcluarNominaActionPerformed
        //Instancia para la ventana de  calculo de nómina
        CalculoNomina nomina = new CalculoNomina();
        //Método que permite visualizar la ventana
        nomina.setVisible(true);
        //Método que cierra la ventana para abrir otra
        dispose();
    }//GEN-LAST:event_menuItemCalcluarNominaActionPerformed

    //Método que permite abrir la ventana de consulta de personal
    private void menuItemConsultaPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemConsultaPersonalActionPerformed
        //Instancia para la ventana de Consulta de personal
        ConsultaPersonal cp = new ConsultaPersonal();
        //Método que permite visualizar la ventana
        cp.setVisible(true);
        //Método que cierra la ventana para abrir otra
        dispose();
    }//GEN-LAST:event_menuItemConsultaPersonalActionPerformed

//Método que permite abrir la ventana de consulta de insumos
    private void menuItemConsultaInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemConsultaInsumosActionPerformed
        //Instancia para la ventana de Consulta de insumos
        ConsultaInsumos insumos = new ConsultaInsumos();
        //Método que permite visualizar la ventana
        insumos.setVisible(true);
        //Método que cierra la ventana para abrir otra
        dispose();
    }//GEN-LAST:event_menuItemConsultaInsumosActionPerformed

    /**
     * @param args the command line arguments
     */
    //Función principal de esta ventana
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
            java.util.logging.Logger.getLogger(CalculoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculoNomina().setVisible(true);
            }
        });

    }

    //Variables de los diferentes componentes de la ventana
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcularNomina;
    private javax.swing.JButton btnCalculoNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jleArticulo;
    private javax.swing.JLabel jleCodigo;
    private javax.swing.JLabel jleCodigo1;
    private javax.swing.JLabel jleCodigo10;
    private javax.swing.JLabel jleCodigo11;
    private javax.swing.JLabel jleCodigo2;
    private javax.swing.JLabel jleCodigo3;
    private javax.swing.JMenuItem menuAltaEmpleado;
    private javax.swing.JMenuItem menuBajaEmpleado;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuEmpleado;
    private javax.swing.JMenu menuInventario;
    private javax.swing.JMenuItem menuIteAltaInsumo;
    private javax.swing.JMenuItem menuIteBjaInsumo;
    private javax.swing.JMenuItem menuItemCalcluarNomina;
    private javax.swing.JMenuItem menuItemConsultaInsumos;
    private javax.swing.JMenuItem menuItemConsultaPersonal;
    private javax.swing.JMenuItem menuItemPrincipal;
    private javax.swing.JMenu menuNomina;
    private javax.swing.JPanel paneldatos;
    private javax.swing.JPanel paneldatos1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNEmpleado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtSueldoBruto;
    private javax.swing.JTextField txtSueldoNeto;
    // End of variables declaration//GEN-END:variables
}
