/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package interfaces;

import database.ProductoDAO;
import dialogs.ConfirmarLimpieza;
import dialogs.ConfimarSalir;
import dialogs.ConfirmacionRegistroProducto;
import dialogs.ConfirmarBusquedaProducto;
import dialogs.ErrorIngresarDatos;
import dialogs.ErrorIngresoProductos;
import dialogs.ErrorProductoNoExiste;
import dialogs.ErrorSoloNumeros;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import main.Principal;
import objetos.Producto;

public class InventarioAltas extends javax.swing.JFrame {

    //Variable global de tipo producto, esto para ser guardado cuando se encuentre un producto
    private Producto productoGlobal;

    public InventarioAltas() {
        initComponents();
        //Asignación de titulo a la ventana
        this.setTitle("Altas al inventario");
        //Método que permite centrar la pantalla en medio de la pantalla general
        this.setLocationRelativeTo(null);
        //Declaración de la variable globlas
        productoGlobal = null;
    }

    //Método que borra el contenido de las cajas de texto de la interfaz
    public void limpiarCajasTexto() {
        //Asignación de un caracter vacío a cada una de las cajas de el interfaz
        txtArticulo.setText("");
        txtCodigo.setText("");
        txtExistencia.setText("");
        txtMarca.setText("");
        txtSucursal.setText("");
        txtinsumo.setText("");
        txtCodigoBusqueda.setText("");
        txtSucursalBusqueda.setText("");
    }
    
    //Método que borra el contenidode las cajas de texto en la sección de busqueda
    public void limpiarCajasTextBusquesa(){
        //Asignación de un caracter vacío a cada una de las cajas de el interfaz
        txtCodigoBusqueda.setText("");
        txtSucursalBusqueda.setText("");
    }

    public void insertarProducto(int codigo, String nombre, String insumo, String sucursal, int existencia, String marca) {
        //Instancia de la clase ProductoDAO
        ProductoDAO productoDAO = new ProductoDAO();
        //Instancias del objeto producto con las varibles que se ingresaron en el cuadro de texto
        Producto producto = new Producto(codigo, nombre, insumo, sucursal, existencia, marca);
        //Retorno de entero de la clae ProductoDAO
        int entero = productoDAO.insertar(producto);
        //Validación en caso de que se haya hecho correcta la insersión de la información en la base de datos
        if (entero > 0) {
            //Llamado al Dialog que manda un mensaje que se ha realizado correctamente el ingreso de información en la base de datos
            ConfirmacionRegistroProducto confirmacion = new ConfirmacionRegistroProducto(this, true);
            //Método que permite visualizar la ventana
            confirmacion.setVisible(true);
            //Método que limpia las cajas de texto de la interface
            limpiarCajasTexto();
        } else {
            //Dialog que manda un mensaje en caso de que no se realizo correctamente el ingreso de la inormación
            ErrorIngresoProductos error = new ErrorIngresoProductos(this, true);
            //Método que permite visualizar la ventana
            error.setVisible(true);
            //Método que limpia las cajas de texto de la interface
            limpiarCajasTexto();
        }
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCampos() {
        //Selección para el caso de que los campos se encuentren vacios
        if ((txtCodigo.getText().equals("") && txtSucursal.getText().equals("") && txtArticulo.getText().equals("")
                && txtExistencia.getText().equals("") && txtMarca.getText().equals("") && txtinsumo.getText().equals(""))
                || (txtCodigo.getText().equals("") || txtSucursal.getText().equals("") || txtArticulo.getText().equals("")
                || txtExistencia.getText().equals("") || txtMarca.getText().equals("") || txtinsumo.getText().equals(""))) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;
        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validarCamposBusqueda() {
        //Selección para el caso de que los campos se encuentren vacios
        if ((txtCodigoBusqueda.getText().equals("") && txtSucursalBusqueda.getText().equals(""))
                || (txtCodigoBusqueda.getText().equals("") || txtSucursalBusqueda.getText().equals(""))) {
            //Retorno falso en caso de que sea correcto los campos vacios
            return false;
        } else {
            //Retorno verdadero para el caso de que los campos esten llenos
            return true;
        }
    }

    //Método que genera un JOptin personalizado, por la libertad que nos brinda se ha escogido este tipo de JOption
    public int optionPersonalizado() {
        //Delcaración de etiqueta en donde podemos ingresar el tipo y tamaño de letra
        JLabel etiqueta = new JLabel("¿Deseas agregar este producto?");
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

    //método que permite bucar la información de un producto en la base de datos.  
    public void buscar(String codigo, String sucursal) {
        //Instancia de la clase ProductoDAO
        ProductoDAO productodao = new ProductoDAO();
        //Declaración del objeto producto como nul
        Producto producto = null;
        //Bloque try/catch para asignar en las respectivas cajas de texto
        try {
            //Asignación del producto a lo que se recupere de la sentencia SQL
            producto = productodao.seleccionar(codigo, sucursal);
            if (producto != null) {
                //Llamado del Dialog que menciona que existe un producto
                ConfirmarBusquedaProducto busquedaProducto = new ConfirmarBusquedaProducto(this, true);
                //Método que permite visualizar la ventana anteriormente mencionada
                busquedaProducto.setVisible(true);
                //Asignación de la información de lo que se obtuvo de la busquedda
                txtArticulo.setText(producto.getNombreProducto());
                txtMarca.setText(producto.getMarcaProducto());
                txtExistencia.setText(String.valueOf(producto.getExistenciaProducto()));
                txtinsumo.setText(producto.getInsumoProducto());
                txtCodigo.setText(String.valueOf(producto.getCodigoProducto()));
                txtSucursal.setText(producto.getSucursalProducto());
                //Sentencia solo para verificar que se obtenga un objeto
                System.out.println(producto.toString());
                //Método que limpia las cajas de texto de la interfaz en el area de busqueda
                limpiarCajasTextBusquesa();
            } else {
                //Llamado del Dialog que menciona que no existe un producto
                ErrorProductoNoExiste error = new ErrorProductoNoExiste(this, true);
                //Método que permite visualizar la ventana anteriormente mencionada
                error.setVisible(true);
                //Método que permite limpiar  los campos depues de ser ingresados
                limpiarCajasTexto();
            }
            //Asignaciónd del producto que se obtuvo de la base de datos a la variable global
            productoGlobal = producto;
        } catch (Exception ex) {
            //Sentencia que muestra un mensaje en caso de que no se cuente con información de los datoa
            if (producto == null) {
                //Llamado del Dialog que menciona que no existe un producto
                ErrorProductoNoExiste error = new ErrorProductoNoExiste(this, true);
                //Método que permite visualizar la ventana anteriormente mencionada
                error.setVisible(true);
                //Método que permite limpiar  los campos depues de ser ingresados
                limpiarCajasTexto();
            }
            System.out.println("es: " + ex.getMessage());
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

        jPanel8 = new javax.swing.JPanel();
        paneldatos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jleArticulo = new javax.swing.JLabel();
        txtArticulo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jleCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jlesucursal = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jleInsumo = new javax.swing.JLabel();
        txtinsumo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jleExistencia = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jleMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jleCodigo1 = new javax.swing.JLabel();
        txtCodigoBusqueda = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jlesucursal1 = new javax.swing.JLabel();
        txtSucursalBusqueda = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 0));

        paneldatos.setBackground(new java.awt.Color(255, 255, 204));
        paneldatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de insumos  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jleArticulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleArticulo.setText("Artículo:");

        txtArticulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleArticulo)
                    .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jlesucursal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlesucursal.setText("Sucursal:");

        txtSucursal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSucursalKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlesucursal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlesucursal)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jleInsumo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleInsumo.setText("Insumo:");

        txtinsumo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleInsumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleInsumo)
                    .addComponent(txtinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jleExistencia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleExistencia.setText("Existencia:");

        txtExistencia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtExistencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExistenciaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleExistencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleExistencia)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jleMarca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleMarca.setText("Marca:");

        txtMarca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneldatosLayout = new javax.swing.GroupLayout(paneldatos);
        paneldatos.setLayout(paneldatosLayout);
        paneldatosLayout.setHorizontalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        paneldatosLayout.setVerticalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(153, 153, 0));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guarda.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnlimpiar.setBackground(new java.awt.Color(153, 153, 0));
        btnlimpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiarB.png"))); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(153, 153, 0));
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
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/insumos.png"))); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda y actualización  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo1.setText("Código:");

        txtCodigoBusqueda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCodigoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoBusquedaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCodigoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo1)
                    .addComponent(txtCodigoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jlesucursal1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlesucursal1.setText("Sucursal:");

        txtSucursalBusqueda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSucursalBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSucursalBusquedaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlesucursal1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(txtSucursalBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlesucursal1)
                    .addComponent(txtSucursalBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscar.setBackground(new java.awt.Color(153, 153, 0));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        Actualizar.setBackground(new java.awt.Color(153, 153, 0));
        Actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escribir.png"))); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
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

    //Método que permite guardar un registro o datos de un inventario
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Sentencia if/else que verifica si se cuentan con valores en los campos de texto
        if (validacionCampos()) {
            //Asignación de valores para los que se ctenga en los campos de texto
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtArticulo.getText();
            String insumo = txtinsumo.getText();
            String sucursal = txtSucursal.getText();
            int existencia = Integer.parseInt(txtExistencia.getText());
            String marca = txtMarca.getText();
            int valor = optionPersonalizado();
            //Validación si de desea agregar este producto
            if (valor == 0) {
                //Llamado al metodo que se encarga de agregar un regitro al proyecto
                insertarProducto(codigo, nombre, insumo, sucursal, existencia, marca);
            }
            System.out.println("Estan llenos los campos");
            //Sentencia else en caso de que los campos de texto no cuenten con información
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
        //Método que permite limpiar  los campos depues de ser ingresados
        limpiarCajasTexto();
        //Instancia del Dialog para confirmar la limpieza de los campos de texto del módulo
        ConfirmarLimpieza limpiar = new ConfirmarLimpieza(this, true);
        //Método que permite visualizar la ventana
        limpiar.setVisible(true);
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
    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        //Evento del teclado en donde recibe solo números
        //Declaración de la variable tipo char de lo que se obtenga del teclaso        
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);
    }//GEN-LAST:event_txtCodigoKeyTyped

    //Evento del teclado en donde recibe solo números
    private void txtSucursalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSucursalKeyTyped
        //Declaración de la variable tipo char de lo que se obtenga del teclaso        
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);
    }//GEN-LAST:event_txtSucursalKeyTyped

    //Evento del teclado en donde recibe solo números
    private void txtExistenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistenciaKeyTyped

        //Declaración de la variable tipo char de lo que se obtenga del teclaso        
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);
    }//GEN-LAST:event_txtExistenciaKeyTyped

    private void txtCodigoBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBusquedaKeyTyped
        //Declaración de la variable tipo char de lo que se obtenga del teclaso
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);
    }//GEN-LAST:event_txtCodigoBusquedaKeyTyped

    private void txtSucursalBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSucursalBusquedaKeyTyped
        //Declaración de la variable tipo char de lo que se obtenga del teclaso
        char validar = evt.getKeyChar();
        //Lllamado de la función para realizar su procedimiento
        esNumero(validar, evt);
    }//GEN-LAST:event_txtSucursalBusquedaKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Declaración de variables locales para recuperar el codigo y la sucursal
        String codigo = txtCodigoBusqueda.getText();
        String sucursal = txtSucursalBusqueda.getText();
        //Validación para lo que se recupere de la validación de los campos textos
        if (validarCamposBusqueda()) {
            //Llamado al m´todo que se encarga de la busqueda en la base de datos
            buscar(codigo, sucursal);
        } else {
            //En caso de que se retorne false, se manda a crear un Dialog
            System.out.println("No se han seleccionado datos");
            //Llamado del Dialog que menciona que no se ha ingresado valores
            ErrorIngresarDatos ee = new ErrorIngresarDatos(this, true);
            //Método que permite observar el dialg de error
            ee.setVisible(true);
            //Método que limpia las cajas de texto
            limpiarCajasTextBusquesa();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(InventarioAltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioAltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioAltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioAltas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarioAltas().setVisible(true);
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jleArticulo;
    private javax.swing.JLabel jleCodigo;
    private javax.swing.JLabel jleCodigo1;
    private javax.swing.JLabel jleExistencia;
    private javax.swing.JLabel jleInsumo;
    private javax.swing.JLabel jleMarca;
    private javax.swing.JLabel jlesucursal;
    private javax.swing.JLabel jlesucursal1;
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
    private javax.swing.JTextField txtArticulo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoBusqueda;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtSucursal;
    private javax.swing.JTextField txtSucursalBusqueda;
    private javax.swing.JTextField txtinsumo;
    // End of variables declaration//GEN-END:variables
}
