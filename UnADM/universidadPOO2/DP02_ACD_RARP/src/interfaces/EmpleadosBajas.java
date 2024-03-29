/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package interfaces;

import database.EmpleadoDAO;
import dialogs.ConfimarSalir;
import dialogs.ConfirmacionElminacionEmpleado;
import dialogs.ConfirmarBusquedaEmpleado;
import dialogs.ConfirmarLimpieza;
import dialogs.ErrorEiminacionProduto;
import dialogs.ErrorEmpleadoNoExiste;
import dialogs.ErrorIngresarDatos;
import dialogs.ErrorSoloNumeros;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import main.Principal;
import objetos.Empleado;

public class EmpleadosBajas extends javax.swing.JFrame {

    //Variable global de tipo empleado, esto para ser guardado cuando se encuentre un empleado
    private Empleado empleadoGlobal;

    public EmpleadosBajas() {
        initComponents();
        //Asignación de titulo a la ventana
        this.setTitle("Baja Empleado");
        //Método que permite centrar la pantalla en medio de la pantalla general
        this.setLocationRelativeTo(null);
        //Implementación de bloqueo de los campos de la pantalla
        txtNombre.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtRfc.setEnabled(false);
        txtCurp.setEnabled(false);
        txtSueldo.setEnabled(false);
        txtFIngreso.setEnabled(false);
        txtFNacimieto.setEnabled(false);
        txtPuesto.setEnabled(false);
        //Declaración del empleadoGlobal como nulo
        empleadoGlobal = null;
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
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
            //Declaración de objeto tipo Date el cual sirve como auxiliar para presentar un dato de tipo Date
            Date date = empleado.getFechaIngresoEmpleado();
            //Asignación de formato a la fecha que se desea obtener
            DateFormat fechaingreso = new SimpleDateFormat("yyyy-MM-dd");
            //Transformación a estring el formato de la fecha
            String fechaIngresoEmpleado = fechaingreso.format(date);
            //Asignación de la información que se obtuvo de la base de datos
            txtApellidos.setText(empleado.getApellidosEmpleado());
            txtCurp.setText(empleado.getCurpEmpleado());
            txtFIngreso.setText(fechaIngresoEmpleado);
            txtFNacimieto.setText(empleado.getFechaNacimientoEmpleado());
            txtNombre.setText(empleado.getNombreEmpleado());
            txtNumeroEmpleado.setText(String.valueOf(empleado.getNumEmpleado()));
            txtPuesto.setText(empleado.getPuestoEmpleado());
            txtRfc.setText(empleado.getRfcEmpleado());
            txtSueldo.setText("$" + String.valueOf(empleado.getSueldoEmpleado()));
            //Llamado del Dialog que menciona que existe un empleado
            ConfirmarBusquedaEmpleado cbe = new ConfirmarBusquedaEmpleado(this, true);
            //Método que permite visualizar la ventana anteriormente mencionada
            cbe.setVisible(true);
        } else {
            //Llamado del Dialog que menciona que no existe un empleado
            ErrorEmpleadoNoExiste eene = new ErrorEmpleadoNoExiste(this, true);
            //Método que permite visualizar la ventana anteriormente mencionada
            eene.setVisible(true);
            //Método que permite limpiar  los campos depues de ser ingresados
            limpiarCamposTexto();
        }
        //Asignaciónd del producto que se obtuvo de la base de datos a la variable global
        empleadoGlobal = empleado;
    }

    //Método que se encarga de la conexión con la base de datos, en función del empleado buscado
    public void eliminar() {
        //Instancia de la clase EmpleadoDAO
        EmpleadoDAO empleadodao = new EmpleadoDAO();
        //Linea de codigo auxiliar
        System.out.println("produto" + empleadoGlobal.toString());
        //Declaración del entero que es lo que retorna cuando se ha hecho una eliminación
        int entero = empleadodao.eliminar(empleadoGlobal);
        //Sentencia if/else en caso de que el entero sea mayor a cero
        if (entero > 0) {
            //Llamado del Dialog que menciona que se ha eliminado un empleado
            ConfirmacionElminacionEmpleado cee = new ConfirmacionElminacionEmpleado(this, true);
            //Método que permite que se muestre el dialog que se ha creado
            cee.setVisible(true);
            System.out.println("Se ha eliminado el elemento");
        } else {
            //Llamado del Dialog que menciona que no se ha eliminado un eempleado
            ErrorEiminacionProduto eep = new ErrorEiminacionProduto(this, true);
            //Método que permite que se muestre el dialog que se ha creado
            eep.setVisible(true);
            System.out.println("No se ha eliminado");

        }
    }

    //Método que genera un JOptin personalizado, por la libertad que nos brinda se ha escogido este tipo de JOption
    public int joptionPersonalizado() {
        //Delcaración de etiqueta en donde podemos ingresar el tipo y tamaño de letra
        JLabel etiqueta = new JLabel("¿Deseas eliminar este empleado?");
        //Fuente de la letra de nuestra etiqueta
        etiqueta.setFont(new Font("Tahoma", Font.BOLD, 24));
        //Asignación de lo valores de los botones
        Object[] options = {"Aceptar", "Cancelar"};
        //Declaración del icono que se desea mostrar en el JOption
        Icon icono = new ImageIcon(getClass().getResource("/imagenes/interrogacion.png"));
        //Instancia y declaración de una variable de tipo entero para que se genere un JOprionPane
        int valor = JOptionPane.showOptionDialog(null, etiqueta, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono, options, options[1]);
        System.out.println("valor = " + valor);
        //Retorno del valor para el caso que haya seleccionado el usuario
        return valor;
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {
        //Sentencia if/else que verifica si esta vacio el campo, en caso afirmativo retorna un booleano
        if (txtNumeroEmpleado.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    //Método que permite la limpieza de los datos que se han asignado
    public void limpiarCamposTexto() {
        txtApellidos.setText("");
        txtCurp.setText("");
        txtFIngreso.setText("");
        txtFNacimieto.setText("");
        txtNombre.setText("");
        txtNumeroEmpleado.setText("");
        txtPuesto.setText("");
        txtRfc.setText("");
        txtSueldo.setText("");
    }

    //Método que permtie observar el tipo de caracter que entra al teclado y diferencia si es letra o número
    public void esNumero(char validar, KeyEvent evt) {
        //Valida si es caracter de tipo letra 
        if (Character.isLetter(validar)) {
            //Método que emite una alerta de sonido en función del sistema operativo
            getToolkit().beep();
            //Método que no permite recibir lo que se teclea en función de lo que ingrese del teclaso
            evt.consume();
            System.out.println("Solo se aceptan numeros");
            //Dialog que manda un mensaje en caso de que no sean numeros en los campos de texto
            ErrorSoloNumeros esn = new ErrorSoloNumeros(this, true);
            //Método que permite visualizar la ventana
            esn.setVisible(true);
        }
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

        jPanel8 = new javax.swing.JPanel();
        paneldatos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jleArticulo = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jleCodigo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jleInsumo = new javax.swing.JLabel();
        txtFNacimieto = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jleExistencia = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jleCodigo1 = new javax.swing.JLabel();
        txtNumeroEmpleado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnNuevaBusqueda = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        paneldatos2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jleArticulo2 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jleCodigo2 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jleInsumo1 = new javax.swing.JLabel();
        txtFIngreso = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jleCodigo3 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 51, 204));

        paneldatos.setBackground(new java.awt.Color(255, 153, 255));
        paneldatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos empleado  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jleArticulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleArticulo.setText("Apellidos");

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jleInsumo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleInsumo.setText("Fecha de Nacimiento");

        txtFNacimieto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleInsumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFNacimieto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleInsumo)
                    .addComponent(txtFNacimieto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jleExistencia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleExistencia.setText("CURP:");

        txtCurp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleExistencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleExistencia)
                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo1.setText("N. Empleado:");

        txtNumeroEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNumeroEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroEmpleadoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo1)
                    .addComponent(txtNumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscar.setBackground(new java.awt.Color(102, 0, 102));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneldatosLayout.setVerticalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        btnSalir.setBackground(new java.awt.Color(102, 0, 102));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevaBusqueda.setBackground(new java.awt.Color(102, 0, 102));
        btnNuevaBusqueda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNuevaBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnNuevaBusqueda.setText("Nueva Busqueda");
        btnNuevaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaBusquedaActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 0, 102));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevaBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnNuevaBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        paneldatos2.setBackground(new java.awt.Color(255, 153, 255));
        paneldatos2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos empleado  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jleArticulo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleArticulo2.setText("Puesto:");

        txtPuesto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleArticulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleArticulo2)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo2.setText("Sueldo Bruto:");

        txtSueldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo2)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jleInsumo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleInsumo1.setText("Fecha ingreso");

        txtFIngreso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleInsumo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleInsumo1)
                    .addComponent(txtFIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout paneldatos2Layout = new javax.swing.GroupLayout(paneldatos2);
        paneldatos2.setLayout(paneldatos2Layout);
        paneldatos2Layout.setHorizontalGroup(
            paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldatos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneldatos2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        paneldatos2Layout.setVerticalGroup(
            paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatos2Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneldatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneldatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneldatos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
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
        ConfimarSalir confimarSalir = new ConfimarSalir(this, true);
        //Método que permite visualizar la ventana
        confimarSalir.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    //Método que permite eliminarun registro de la base de datos
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //Varificación de variable global por si se encuentra nula
        if (empleadoGlobal != null) {
            //Asignación devariable de tipo entero con lo que se obtuvo del JOptionPersonalizado
            int valor = joptionPersonalizado();
            System.out.println("valor = " + valor);
            //En caso de que el valor retornado sea 0 se manda a llamar la opción de eliminar
            if (valor == 0) {
                //Llamado al método que se encarga de la eliminación de un producto
                eliminar();
            }
            //Llamado a la función que se encarga de limpiar todas las cajas de la interfaz
            limpiarCamposTexto();
            //Declaración de variable global para que se vuelva nula de nuevos
            empleadoGlobal = null;
        } else {
            //Llamado del Dialog que menciona que no se ha ingresado valores
            ErrorIngresarDatos ee = new ErrorIngresarDatos(this, true);
            //Método que permite observar el dialg de error
            ee.setVisible(true);
            System.out.println("no se ha seleccinado un producto");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    //Método que permite realizar la busqueda de información de la base de datos
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Sentencia if/else para validar que se haya ingresado un datos en la caja de texto
        if (validacionCamposTexto()) {
            //Creación de la variable de tipo entero para ser enviado al metodo de busqueda
            int numeroEmpleado = Integer.parseInt(txtNumeroEmpleado.getText());
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

    //Método que permite la limpieza de las cajas de texto
    private void btnNuevaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaBusquedaActionPerformed
        //Método que permite limpiar kos campos de texto
        limpiarCamposTexto();
        //Instancia del Dialog para confirmar la limpieza de los campos de texto del módulo
        ConfirmarLimpieza limpiar = new ConfirmarLimpieza(this, true);
        //Método que permite visualizar la ventana
        limpiar.setVisible(true);
        //Asignación para que variable global sea nula
        empleadoGlobal = null;
    }//GEN-LAST:event_btnNuevaBusquedaActionPerformed

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

    //Evento del teclado en donde recibe solo números                                    
    private void txtNumeroEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroEmpleadoKeyTyped
        //Declaración de la variable tipo char de lo que se obtenga del teclaso        
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);    }//GEN-LAST:event_txtNumeroEmpleadoKeyTyped

    /**
     * @param args the command line arguments
     */
    //Función principal de la ventana
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
            java.util.logging.Logger.getLogger(EmpleadosBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadosBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadosBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadosBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpleadosBajas().setVisible(true);
            }
        });

    }

    //Variables de los diferentes componentes de la ventana
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevaBusqueda;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jleArticulo;
    private javax.swing.JLabel jleArticulo2;
    private javax.swing.JLabel jleCodigo;
    private javax.swing.JLabel jleCodigo1;
    private javax.swing.JLabel jleCodigo2;
    private javax.swing.JLabel jleCodigo3;
    private javax.swing.JLabel jleExistencia;
    private javax.swing.JLabel jleInsumo;
    private javax.swing.JLabel jleInsumo1;
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
    private javax.swing.JPanel paneldatos2;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtFIngreso;
    private javax.swing.JTextField txtFNacimieto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroEmpleado;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
