/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dialog.ConfimacionInicio;
import dialog.Confirmacion;
import dialog.ErrorDatosVacios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import main.Inicio;

/**
 *
 * @author Raúl Ramírez Pérez
 */
public class AltasInventario extends javax.swing.JFrame {

    private File nombreArchivo;

    /**
     * Creates new form AltasProduto
     */
    public AltasInventario() {
        initComponents();
        //Método que permite asignarle un titulo a la ventana
        this.setTitle("Altas Inventario");
        //Método que permite mostrarlo en el centro de la pantalla
        this.setLocationRelativeTo(null);
        //Sentencia que desactiva el minimizar y maximizar de las ventanas principales
        this.setResizable(false);
        txtnewName.setVisible(false);
        btnAceptRename.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneldatos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jleArticulo = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jleCodigo = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jlesucursal = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListText = new javax.swing.JList<>();
        btnRename = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtnewName = new javax.swing.JTextField();
        btnAceptRename = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneldatos.setBackground(new java.awt.Color(255, 255, 255));
        paneldatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventario  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jleArticulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleArticulo.setText("Producto:");

        txtProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleArticulo)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jleCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jleCodigo.setText("Marca :");

        txtMarca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jleCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jleCodigo)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jlesucursal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlesucursal.setText("Precio :");

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlesucursal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlesucursal)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneldatosLayout = new javax.swing.GroupLayout(paneldatos);
        paneldatos.setLayout(paneldatosLayout);
        paneldatosLayout.setHorizontalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
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
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListText);

        btnRename.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRename.setText("Renombrar");
        btnRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenameActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtnewName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAceptRename.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptRename.setText("Aceptar");
        btnAceptRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptRenameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneldatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addComponent(btnRename)
                            .addComponent(btnDelete))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnewName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAceptRename, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnBuscar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRename)
                    .addComponent(txtnewName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptRename)
                    .addComponent(btnDelete))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        paneldatos.getAccessibleContext().setAccessibleName("Registro de inventario ");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método para limpiar los campos
    public void limpiarDatos() {
        txtMarca.setText("");
        txtPrecio.setText("");
        txtProducto.setText("");
        txtnewName.setText("");

    }

    //Método que verifica que los campos no se encuentren vacios
    public boolean validacionCamposTexto() {
        //Validación de los campos de texto que retorna un booleano para un cierto caso
        if (txtMarca.getText().equals("") && txtPrecio.getText().equals("") && txtProducto.getText().equals("")
                || txtMarca.getText().equals("") || txtPrecio.getText().equals("") || txtProducto.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }
    //Método para crear un archivo en Java

    public void crearArchivo(String nombreArchivo) {
        //Inicialización del archivo con file
        File archivo = new File(nombreArchivo);
        try {
            //Clase que permite crear al archivo con un nombre especifico
            PrintWriter salida = new PrintWriter(archivo);
            //Método que permite cerra el archivo creado
            salida.close();
            //Catch que recupera la información en caso de que no se recuperé un archivo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //Método para crear un archivo en Java con parametros de entrada como un archivo y una cadena de texto
    public void crearArchivo(File archivo, String cadena) {
        //Inicialización del printwiter
        PrintWriter salida;
        try {
            //Clase que permite crear al archivo con un nombre especifico
            salida = new PrintWriter(archivo);
            salida.write(cadena);
            //Método que permite cerra el archivo creado
            salida.close();
            //Catch que recupera la información en caso de que no se recuperé un archivo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //Método para anexar informaión al archivo desde Java
    public void anexarArchivo(String nombreArchivo, String contenido) {
        //Inicialización del archivo con file
        File archivo = new File(nombreArchivo);
        try {
            //Clase que permite escribir en el archivo
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            //Metodo que ingresa informción al archivo
            salida.println(contenido);
            //Método que cierra el documento abierto
            salida.close();
            //Catch que recupera el error en caso de que no se pueda abrir un archivo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            //Catch que recupera el error en caso de que no se modifique el texto
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //Método para anexar informaión al archivo desde Java
    public void anexarArchivo(File archivo, String contenido) {
        //Inicialización del printwiter
        PrintWriter salida;
        try {
            //Clase que permite escribir en el archivo
            salida = new PrintWriter(new FileWriter(archivo, true));
            //Metodo que ingresa informción al archivo
            salida.println(contenido);
            //Método que cierra el documento abierto
            salida.close();
            //Catch que recupera el error en caso de que no se pueda abrir un archivo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            //Catch que recupera el error en caso de que no se modifique el texto
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //Método para leer un archivo 
    public List<String> leerArchivo(String nombreArchivo) {
        //Inicialización del archivo con file
        File archivo = new File(nombreArchivo);
        //Lista que guarda una lista de textos recuperados del archivo
        List<String> listaTextos = new ArrayList<>();
        try {
            //Clase que permite leer en el archivo
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            //Recuperación del texto por lineas
            String lectura = entrada.readLine();
            //Ciclo while que recuperad los texto si son varias filas
            while (lectura != null) {
                listaTextos.add(lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
            //Catch que recupera el error en caso de que no se pueda abrir un archivo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            //Catch que recupera el error en caso de que no se modifique el texto
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        //retorno de la lista
        return listaTextos;
    }

    //Método que cambia el nombre del archivo
    public boolean cambiarNombre(String nombreNuevo, File archivo) {
        //Asignnación del nuevo nombre del archivo
        String nuevoNombre = nombreNuevo + ".txt";
        //Creación de un nuevo archivo con el nuevo nombre
        File f2 = new File(nuevoNombre);
        //Retorno si se ha cambiado el nombre
        return archivo.renameTo(f2);
    }

    //Método que permite escoger la dirección en donde se realice el guardado del archivo
    public File retornoDireccionArchivo() {
        //Mostrado del dialog que permite la apertura del dialog al usuario para escoger eel lugar donde se gurdara los archivos
        JOptionPane.showMessageDialog(null, "Selecciona el lugar para guardar el archivo");
        //Inicialización de la clase que abre el dialog
        JFileChooser guardar = new JFileChooser();
        //Metodo que hace que aparezca el dialog para escoger la ruta de guardado
        guardar.showSaveDialog(null);
        //Selección de la ruta especificada
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //Retorno del la ruta del archivo
        return guardar.getSelectedFile();
    }

    public boolean isFile(File file) {
        boolean retorno;
        if (file == null) {
            retorno = false;
        } else {
            retorno = true;
        }
        return retorno;
    }

    //Método que permite escoger la dirección en donde se realice el guardado del archivo
    public File retornoDireccionArchivoRenombrar() {
        //Mostrado del dialog que permite la apertura del dialog al usuario para escoger eel lugar donde se gurdara los archivos
        JOptionPane.showMessageDialog(null, "Selecciona el archivo a renombrar");
        //Inicialización de la clase que abre el dialog
        JFileChooser guardar = new JFileChooser();
        //Metodo que hace que aparezca el dialog para escoger la ruta de guardado
        guardar.showSaveDialog(null);
        //Selección de la ruta especificada
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //Retorno del la ruta del archivo
        return guardar.getSelectedFile();
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Verifica que los camposs esten llenos
        if (validacionCamposTexto()) {
            //Recuperación de la información de los campos de texto
            String producto = "Producto: " + txtProducto.getText() + ", ";
            String precio = "Precio: $" + txtPrecio.getText();
            String marca = "Marca: " + txtMarca.getText() + ", ";
            String contenido = marca + producto + precio;
            File archivo = retornoDireccionArchivo();
            if (isFile(archivo)) {
                anexarArchivo(archivo, contenido);
                //Lllamado al dialog para avisar de los campos de texto recuperados
                Confirmacion confirmacion = new Confirmacion(this, true);
                //Muestra el dialog
                confirmacion.setVisible(true);
                //Llamado al metodo para limpiar los datos
                limpiarDatos();
                //En caso de que los campos de texto esten vacios se manda un dialog de error
            }else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado el archivo para guardar");
            }

        } else {
            //Llalmado al dialog del error al no tener los datos vacios
            ErrorDatosVacios error = new ErrorDatosVacios(this, true);
            error.setVisible(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Clase que abre un dialog para escoger el archivo a leer
        JFileChooser jf = new JFileChooser();
        //Adignación del lugar para abrir el dialog
        jf.showOpenDialog(null);
        //Recuperación del URL de archivo
        File file = jf.getSelectedFile();
        //Creación de la lista para recupear los textos
        List<String> listaTextoBuscar = new ArrayList<>();
        //Condicional para el caso de que el archivo sea nulo
        if (file != null) {
            //Asignación del metodo que recupera la informaicón al leer el archivo
            listaTextoBuscar = leerArchivo(file.toString());
            //Creción del modelos para agregarlos en la lista de texto
            DefaultListModel modelo = new DefaultListModel();
            //recorrido de la lista del texto
            listaTextoBuscar.forEach(texto -> {
                //Asignación de texto en los modelos creados
                modelo.addElement(texto);
            });
            //Asignación del texto recuperado en la lissta para ser mostrada
            jListText.setModel(modelo);
        } else {
            //Dialog en caso de que no se seleccino un archivo para extraer su información
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un archivo");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    //Método que retorna al menú principal
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        ConfimacionInicio ci = new ConfimacionInicio(this, true);
        ci.setVisible(true);
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
//Método que permite eliminar un archivo
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JOptionPane.showMessageDialog(null, "Selecciona el archivo a eliminar");
        //Clase que abre un dialog para escoger el archivo a leer
        JFileChooser jf = new JFileChooser();
        //Adignación del lugar para abrir el dialog
        jf.showOpenDialog(null);
        //Recuperación del URL de archivo
        File file = jf.getSelectedFile();
        if (file != null) {
            if (file.delete()) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el archivo");
            } else {
                JOptionPane.showMessageDialog(null, "No ha eliminado el archivo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un archivo");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
//Método que permite abrir un dialog para escoger el archivo que se desea cambiar el nombre
    private void btnRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenameActionPerformed
        //Recuperación del URL de archivo
        nombreArchivo = retornoDireccionArchivoRenombrar();
        //Verificación que el archivo tenga valores
        if (nombreArchivo != null) {
            //Impresión de un dialog para confirmar que se puede cambiar el nombre
            JOptionPane.showMessageDialog(null, "Ingresa el nuevo nombre");
            //Muestra de elementos que estaban ocultos al usuario
            txtnewName.setVisible(true);

            btnAceptRename.setVisible(true);
        } else {
            //Ipresión de dialog para confimar que no se ha seleccionado un archivo
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un archivo");
        }
    }//GEN-LAST:event_btnRenameActionPerformed
//Método que permite realizar el cambio de nombre del archivo
    private void btnAceptRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptRenameActionPerformed
        //Validación para verificar que el campo de texto no este vacio
        if (!txtnewName.getText().equals("")) {
            //Validación para el cambio de nombre
            if (cambiarNombre(txtnewName.getText(), nombreArchivo)) {
                //Impresión de dialog que confirma el cambio de nombre
                JOptionPane.showMessageDialog(null, "Se ha cambiado el nombre");
                //Ocultamiento de los elementos 
                txtnewName.setVisible(false);
                btnAceptRename.setVisible(false);
                nombreArchivo = null;
            } else {
                //Impresión de dialog que mencina que no se ha cambiado el nombre
                JOptionPane.showMessageDialog(null, "No se ha cambiado el nombre");
            }
        } else {
            //En caso de que el campo de texto este vacio se 
            ErrorDatosVacios edv = new ErrorDatosVacios(this, true);
            edv.setVisible(true);
        }
        limpiarDatos();
    }//GEN-LAST:event_btnAceptRenameActionPerformed

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
            java.util.logging.Logger.getLogger(AltasInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltasInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltasInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltasInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltasInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptRename;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRename;
    private javax.swing.JButton btnSalir;
    private javax.swing.JList<String> jListText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jleArticulo;
    private javax.swing.JLabel jleCodigo;
    private javax.swing.JLabel jlesucursal;
    private javax.swing.JPanel paneldatos;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtnewName;
    // End of variables declaration//GEN-END:variables
}
