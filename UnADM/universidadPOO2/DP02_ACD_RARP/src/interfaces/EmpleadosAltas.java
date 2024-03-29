/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package interfaces;

import database.EmpleadoDAO;
import dialogs.ConfirmarLimpieza;
import dialogs.ConfimarSalir;
import dialogs.ConfirmacionActualizarEmpleado;
import dialogs.ConfirmacionActualizarProducto;
import dialogs.ConfirmacionRegistroEmpleado;
import dialogs.ConfirmarBusquedaEmpleado;
import dialogs.ErrorActualizacionCurso;
import dialogs.ErrorActualizarProducto;
import dialogs.ErrorEmpleadoNoExiste;
import dialogs.ErrorFormatoF;
import dialogs.ErrorIngresarDatos;
import dialogs.ErrorIngresoEmpleado;
import dialogs.ErrorSoloNumeros;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import main.Principal;
import objetos.Empleado;

public class EmpleadosAltas extends javax.swing.JFrame {

    //Variable global de tipo producto, esto para ser guardado cuando se encuentre un producto
    private Empleado empleadoGlobal;

    public EmpleadosAltas() {
        initComponents();
        //Asignación de titulo a la ventana
        this.setTitle("Alta Empleado");
        //Método que permite centrar la pantalla en medio de la pantalla general
        this.setLocationRelativeTo(null);
        //LLenado de cajasde texto para pruebas
        /*
        txtApellidos.setText("Perez Cordoba");
        txtCurp.setText("PEREASDF15");
        txtFIngreso.setText("2020-10-06");
        txtFNacimiento.setText("29/15/1992");
        txtNombre.setText("Gonzalo");
        txtNumeroEmpleado.setText("14");
        txtPuesto.setText("Cocinero");
        txtRfc.setText("SDFsDF155");
        txtSueldo.setText("8000");
         */
        empleadoGlobal = null;
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
    }

    //Método que permite la limpieza de los datos que se han asignado
    public void limpiarCamposTexto() {
        txtApellidos.setText("");
        txtCurp.setText("");
        txtFIngreso.setText("");
        txtFNacimiento.setText("");
        txtNombre.setText("");
        txtNumeroEmpleado.setText("");
        txtPuesto.setText("");
        txtRfc.setText("");
        txtSueldo.setText("");
        txtNEmpleadoBusqueda.setText("");
    }
    //Método que borra el contenido de las cajas de texto en la sección de busqueda

    public void limpiarCajasTextBusqueda() {
        txtNEmpleadoBusqueda.setText("");;
    }
    //Método que verifica que los campos no se encuentren vacios

    public boolean validarCamposBusqueda() {
        //Selección para el caso de que los campos se encuentren vacios
        if ((txtNEmpleadoBusqueda.getText().equals(""))) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;
        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {
        if ((txtApellidos.getText().equals("") && txtCurp.getText().equals("") && txtFIngreso.getText().equals("")
                && txtFNacimiento.getText().equals("") && txtNombre.getText().equals("") && txtNumeroEmpleado.getText().equals("")
                && txtPuesto.getText().equals("") && txtRfc.getText().equals("") && txtSueldo.getText().equals(""))
                || (txtApellidos.getText().equals("") || txtCurp.getText().equals("") || txtFIngreso.getText().equals("")
                || txtFNacimiento.getText().equals("") || txtNombre.getText().equals("") || txtNumeroEmpleado.getText().equals("")
                || txtPuesto.getText().equals("") || txtRfc.getText().equals("") || txtSueldo.getText().equals(""))) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;

        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Método que genera un JOptin personalizado, por la libertad que nos brinda se ha escogido este tipo de JOption
    public int joptionPersonalizado(String frase) {
        //Delcaración de etiqueta en donde podemos ingresar el tipo y tamaño de letra
        JLabel etiqueta = new JLabel(frase);
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

    //Método que permite actualizar un empleado en la base de datos
    private void actualizarEmpleado(Empleado empleado) {
        //Instancia de la clase ProductoDAO
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        //Recuperación de la información de las cajas de texto que se van a acualizar

        //Bloque try/catch para el formato de la fecha de ingreso
        try {
            int numero = Integer.parseInt(txtNumeroEmpleado.getText());
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String fechaNac = txtFNacimiento.getText();
            String curp = txtCurp.getText();
            String rfc = txtRfc.getText();
            int sueldo = Integer.parseInt(txtSueldo.getText());
            String puesto = txtPuesto.getText();
            String fechaString = txtFIngreso.getText();
            //Asignación de formato a la fecha que se desea obtener o ingresar a la base de datos
            DateFormat fechaformat = new SimpleDateFormat("yyyy-MM-dd");
            //Declaración de objeto tipo DateJava el cual sirve como auxiliar para guardar la información
            Date fechaIngreso = fechaformat.parse(fechaString);
            //Creación de un nuevo objeto de tipo empleado, con el id del producto global oomo su id, e ingresando los datos que se recuperaron de las cajas de texto
            Empleado empleadoActualizar = new Empleado(empleado.getIdEmpleado(), numero, nombre, apellidos, fechaNac, curp, rfc, sueldo, puesto, fechaIngreso);
            //Recuperación del entero en caso de que se haya realizado la actualización
            int entero = empleadoDAO.actualizar(empleadoActualizar);
            //Validación en caso de que se haya hecho correcta la insersión de la información en la base de datos
            if (entero > 0) {
                //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
                ConfirmacionActualizarEmpleado confirmacion = new ConfirmacionActualizarEmpleado(this, true);
                //Método que permite visualizar la ventana
                confirmacion.setVisible(true);
                //Método que limpia las cajas de texto de la interface
                limpiarCamposTexto();
            } else {
                //Dialog que manda un mensaje en caso de que no se realizo correctamente el ingreso de la inormación
                ErrorActualizarProducto error = new ErrorActualizarProducto(this, true);
                //Método que permite visualizar la ventana
                error.setVisible(true);
                //Método que limpia las cajas de texto de la interface
                limpiarCamposTexto();
            }
        } catch (ParseException ex) {
            System.out.println("Error " + ex.getMessage());
            //Llamado del Dialog que menciona que el formato de la fecha no es correcto
            ErrorFormatoF effe = new ErrorFormatoF(this, true);
            //Método que permite observar el dialg de error
            effe.setVisible(true);
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
            txtFNacimiento.setText(empleado.getFechaNacimientoEmpleado());
            txtNombre.setText(empleado.getNombreEmpleado());
            txtNumeroEmpleado.setText(String.valueOf(empleado.getNumEmpleado()));
            txtPuesto.setText(empleado.getPuestoEmpleado());
            txtRfc.setText(empleado.getRfcEmpleado());
            txtSueldo.setText(String.valueOf(empleado.getSueldoEmpleado()));
            //Llamado del Dialog que menciona que existe un empleado
            ConfirmarBusquedaEmpleado cbe = new ConfirmarBusquedaEmpleado(this, true);
            //Método que permite visualizar la ventana anteriormente mencionada
            cbe.setVisible(true);
            //Método que limpia las cajas de texto del la busqueda
            limpiarCajasTextBusqueda();
            //Bloqueo del boton guardar cuando se busque la información y se desea actualizar
            btnGuardar.setEnabled(false);
        } else {
            //Llamado del Dialog que menciona que no existe un empleado
            ErrorEmpleadoNoExiste eene = new ErrorEmpleadoNoExiste(this, true);
            //Método que permite visualizar la ventana anteriormente mencionada
            eene.setVisible(true);
            //Método que permite limpiar  los campos depues de ser ingresados
            limpiarCamposTexto();
        }
        //Asignaciónd del empleado que se obtuvo de la base de datos a la variable global
        empleadoGlobal = empleado;
    }

    //Método que permite insertar un registro en la base de datos, en función de los datos agregado por el usuario
    public void insertarEmpleado(int numero, String nombre, String apellidos, String fechaNac, String curp, String rfc, int sueldo, String puesto, Date fechaIngreso) {
        //Instancia de la clase EmpleadoDAO
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        //Instancias del objeto empleado con las varibles que se ingresaron en el cuadro de texto
        Empleado empleado = new Empleado(numero, nombre, apellidos, fechaNac, curp, rfc, sueldo, puesto, fechaIngreso);
        //Retorno de entero de la clae empleadoDAO
        int entero = empleadoDAO.insertar(empleado);
        //Validación en caso de que se haya hecho correcta la insersión de la información en la base de datos
        if (entero > 0) {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            ConfirmacionRegistroEmpleado confirmacion = new ConfirmacionRegistroEmpleado(this, true);
            //Método que permite visualizar la ventana
            confirmacion.setVisible(true);
            //Método que limpia las cajas de texto de la interface
            limpiarCamposTexto();
        } else {
            //Dialog que manda un mensaje en caso de que no se realizo correctamente el ingreso de la inormación
            ErrorIngresoEmpleado error = new ErrorIngresoEmpleado(this, true);
            //Método que permite visualizar la ventana
            error.setVisible(true);
            //Método que limpia las cajas de texto de la interface
            limpiarCamposTexto();
        }
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
        jPanel4 = new javax.swing.JPanel();
        jleInsumo = new javax.swing.JLabel();
        txtFNacimiento = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jleExistencia = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jleCodigo1 = new javax.swing.JLabel();
        txtNumeroEmpleado = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jleCodigo3 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jleCodigo2 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jleArticulo2 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        paneldatos2 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jleInsumo1 = new javax.swing.JLabel();
        txtFIngreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jleCodigo4 = new javax.swing.JLabel();
        txtNEmpleadoBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
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

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));

        paneldatos.setBackground(new java.awt.Color(51, 255, 255));
        paneldatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos empleado  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jleArticulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleArticulo.setText("Apellidos:");

        txtApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        txtFNacimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFNacimientoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleInsumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleInsumo)
                    .addComponent(txtFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        txtSueldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout paneldatosLayout = new javax.swing.GroupLayout(paneldatos);
        paneldatos.setLayout(paneldatosLayout);
        paneldatosLayout.setHorizontalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        paneldatosLayout.setVerticalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        btnGuardar.setBackground(new java.awt.Color(0, 51, 51));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guarda.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnlimpiar.setBackground(new java.awt.Color(0, 51, 51));
        btnlimpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiarB.png"))); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 51, 51));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        paneldatos2.setBackground(new java.awt.Color(51, 255, 255));
        paneldatos2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos empleado  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jleInsumo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleInsumo1.setText("Fecha ingreso");

        txtFIngreso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFIngresoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Formato Fecha yyyy-mm-dd");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jleInsumo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleInsumo1)
                    .addComponent(txtFIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneldatos2Layout = new javax.swing.GroupLayout(paneldatos2);
        paneldatos2.setLayout(paneldatos2Layout);
        paneldatos2Layout.setHorizontalGroup(
            paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatos2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        paneldatos2Layout.setVerticalGroup(
            paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/empleado.png"))); // NOI18N

        jPanel10.setBackground(new java.awt.Color(102, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda y actualización  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo4.setText("N. empleado");

        txtNEmpleadoBusqueda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNEmpleadoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNEmpleadoBusquedaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNEmpleadoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo4)
                    .addComponent(txtNEmpleadoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscar.setBackground(new java.awt.Color(0, 51, 51));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        Actualizar.setBackground(new java.awt.Color(0, 51, 51));
        Actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escribir.png"))); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(paneldatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paneldatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
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

    //Método que permite guardar un registro o datos de un empleado
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validacionCamposTexto()) {
            //Sentencia Try/catch para el parseo de la fecha que se obtiene de los campos de texto
            try {
                //Asignación de valores para los que se ctenga en los campos de texto
                int numero = Integer.parseInt(txtNumeroEmpleado.getText());
                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                String fechaNac = txtFNacimiento.getText();
                String curp = txtCurp.getText();
                String rfc = txtRfc.getText();
                int sueldo = Integer.parseInt(txtSueldo.getText());
                String puesto = txtPuesto.getText();
                String fechaString = txtFIngreso.getText();
                //Impresión de los valores ingresado para observar el funcionamiento de las variables
                /*
                System.out.println("numero = " + numero);
                System.out.println("nombre = " + nombre);
                System.out.println("apellidos = " + apellidos);
                System.out.println("fechaNac = " + fechaNac);
                System.out.println("curp = " + curp);
                System.out.println("rfc = " + rfc);
                System.out.println("sueldo = " + sueldo);
                System.out.println("puesto = " + puesto);
                System.out.println("fechaString = " + fechaString);
                 */
                //Asignación de formato a la fecha que se desea obtener o ingresar a la base de datos
                DateFormat fechaformat = new SimpleDateFormat("yyyy-MM-dd");
                //Declaración de objeto tipo DateJava el cual sirve como auxiliar para guardar la información
                Date fechaIngreso = fechaformat.parse(fechaString);
                //Impresion de la fecha que se ha ingresado
                System.out.println("fechaIngreso = " + fechaIngreso);
                int valor = joptionPersonalizado("¿Deseas agregar este empleado?");
                //Validación si de desea agregar este empleado
                if (valor == 0) {
                    //Llamado al metodo que se encarga de agregar un regitro al proyecto
                    insertarEmpleado(numero, nombre, apellidos, fechaNac, curp, rfc, sueldo, puesto, fechaIngreso);
                }
                System.out.println("Estan llenos los campos");
                //Sentencia else en caso de que los campos de texto no cuenten con información
            } catch (ParseException ex) {
                System.out.println("Error " + ex.getMessage());
                //Llamado del Dialog que menciona que el formato de la fecha no es correcto
                ErrorFormatoF effe = new ErrorFormatoF(this, true);
                //Método que permite observar el dialg de error
                effe.setVisible(true);
            }
        } else {
            System.out.println("No estan llenos los campos");
            //Llamado del Dialog que menciona que no se ha ingresado valores
            ErrorIngresarDatos ee = new ErrorIngresarDatos(this, true);
            //Método que permite observar el dialg de error
            ee.setVisible(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    //Método que permite limpiar los campos de texto
    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        //Instancia del Dialog para confirmar la limpieza de los campos de texto del módulo
        ConfirmarLimpieza limpiar = new ConfirmarLimpieza(this, true);
        //Método que permite visualizar la ventana
        limpiar.setVisible(true);
        //método que permite limpiar todos los datos
        limpiarCamposTexto();
        //Asignación para que variable global sea nula
        empleadoGlobal = null;
        //Sentencia para desbloquear el boton de buscar
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnlimpiarActionPerformed

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
        esNumero(validar, evt);
    }//GEN-LAST:event_txtNumeroEmpleadoKeyTyped

    //Evento del teclado en donde recibe solo números
    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        //Declaración de la variable tipo char de lo que se obtenga del teclaso        
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);
    }//GEN-LAST:event_txtSueldoKeyTyped

    //Evento del teclado en donde recibe solo números
    private void txtFNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFNacimientoKeyTyped
        //Declaración de la variable tipo char de lo que se obtenga del teclaso        
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);
    }//GEN-LAST:event_txtFNacimientoKeyTyped

    //Evento del teclado en donde recibe solo números
    private void txtFIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFIngresoKeyTyped
        //Declaración de la variable tipo char de lo que se obtenga del teclaso        
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);
    }//GEN-LAST:event_txtFIngresoKeyTyped

    //Evento del teclado en donde recibe solo números
    private void txtNEmpleadoBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNEmpleadoBusquedaKeyTyped
        //Declaración de la variable tipo char de lo que se obtenga del teclaso
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);
    }//GEN-LAST:event_txtNEmpleadoBusquedaKeyTyped

    //Método que nos permite la busqueda de un empleado
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Sentencia if/else para validar que se haya ingresado un datos en la caja de texto
        if (validarCamposBusqueda()) {
            //Creación de la variable de tipo entero para ser enviado al metodo de busqueda
            int numeroEmpleado = Integer.parseInt(txtNEmpleadoBusqueda.getText());
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

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        //Varificación de variable global por si se encuentra nula
        if (validacionCamposTexto()) {
            if (empleadoGlobal != null) {
                //Asignación devariable de tipo entero con lo que se obtuvo del JOptionPersonalizado
                int valor = joptionPersonalizado("¿Deseas actualizar este empleado?");
                System.out.println("valor = " + valor);
                //En caso de que el valor retornado sea 0 se manda a llamar la opción de eliminar
                if (valor == 0) {
                    //Llamado al método que se encarga de la eliminación de un producto
                    //eliminar();
                    actualizarEmpleado(empleadoGlobal);
                }
                //Llamado a la función que se encarga de limpiar todas las cajas de la interfaz
                limpiarCamposTexto();
                //Declaración de variable global para que se vuelva nula de nuevos
                empleadoGlobal = null;
            }
        } else {
            //Llamado del Dialog que menciona que no se ha ingresado valores
            ErrorIngresarDatos ee = new ErrorIngresarDatos(this, true);
            //Método que permite observar el dialg de error
            ee.setVisible(true);
            System.out.println("no se ha actualizado un producto");
        }
        //Cuando se actualice la información se recupera el estado del botón de buscar
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_ActualizarActionPerformed

    //Método que permite saber si esta desactivado el botón de guardar para actualizar los regitros
    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        //Verificación para determinar si esta desactivado el botón de buscar
        if (!btnGuardar.isEnabled()) {
            //Método que manda un mensaje en caso de que se esta actualizando un registro
            ErrorActualizacionCurso eac = new ErrorActualizacionCurso(this, true);
            //Método que permite observar el dialg de error
            eac.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarMouseClicked

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
            java.util.logging.Logger.getLogger(EmpleadosAltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadosAltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadosAltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadosAltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpleadosAltas().setVisible(true);
            }
        });

    }

    //Variables de los diferentes componentes de la ventana
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
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
    private javax.swing.JLabel jleCodigo4;
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
    private javax.swing.JTextField txtFNacimiento;
    private javax.swing.JTextField txtNEmpleadoBusqueda;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroEmpleado;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
