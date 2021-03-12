/*
 *Código elaborado por: Raúl Ramírez Pérez
 */package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import objetos.Producto;

public class ProductoDAO {

    //Declaración de la sentencia a realizar para seleccionar cada uno de los campos de un producto
    private static final String SQL_SELECT = "SELECT idProducto, CodigoProducto, NombreProducto, InsumoProducto, SucursalProducto, ExistenciaProducto, MarcaProducto FROM productos WHERE CodigoProducto = ? AND SucursalProducto = ?";
    //Declaración de la sentencia a realizar para insertar un registro a  la base de datos
    private static final String SQL_INSERT = "INSERT INTO productos(CodigoProducto, NombreProducto, InsumoProducto, SucursalProducto, ExistenciaProducto, MarcaProducto) VALUES(?,?,?,?,?,?)";

    //Método que permite ingresar un registro a la base de datos con parametros de entrada un objeto de tipo Producto
    public int insertar(Producto producto) {
        //Declaración de las variables necesrias para poder realizar la conexion a la base de datos.
        //Declaración del objeto del canal de conexión
        Connection conn = null;
        //Declaración del objetos de sentencias
        PreparedStatement preparedStatement = null;
        //Declaración de objeto de resultados de las sentencias
        ResultSet resultSet = null;
        //Delcaración de la variable que verifica si se ha hecho una modificación al registro
        int registros = 0;
        //Bloque try/catch para las conexiones
        try {
            //Declaración del canal de coneción
            conn = ConexionDB.getConnection();
            //Envio de sentencias SQL para insertar datos a la base de datos
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            //Envio de los parametros que se han seleccionado para poder realizar la insersión de datos
            preparedStatement.setString(1, String.valueOf(producto.getCodigoProducto()));
            preparedStatement.setString(2, producto.getNombreProducto());
            preparedStatement.setString(3, producto.getInsumoProducto());
            preparedStatement.setString(4, producto.getSucursalProducto());
            preparedStatement.setString(5, String.valueOf(producto.getExistenciaProducto()));
            preparedStatement.setString(6, producto.getMarcaProducto());
            //Sentencia para que se realice el alza de los datos
            registros = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } finally {
            try {
                //Cierre de la sentecia enviada
                ConexionDB.close(preparedStatement);
                //Cierre del canal de conexión
                ConexionDB.close(conn);
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

//Método seleccionar el cual se encarga de buscar el producto en función del codigo del producto y sucursal del productos
    public Producto seleccionar(String codigoProductoEntrada, String sucursalProductoEntrada) {
        //Declaración de las variables necesrias para poder realizar la conexion a la base de datos.
        //Declaración del objeto producto
        Producto producto = null;
        //Declaración del objeto del canal de conexión
        Connection conn = null;
        //Declaración del objetos de sentencias
        PreparedStatement preparedStatement = null;
        //Declaración de objeto de resultados de las sentencias
        ResultSet resultSet = null;
        //Bloque try/catch para las conexiones
        try {
            //Declaración del canal de coneción
            conn = ConexionDB.getConnection();
            //Envio de sentencias SQL para recuperar la información necesaria
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            //Envio de los parametros como el codigo del producto y el de la sucursal
            preparedStatement.setString(1, codigoProductoEntrada);
            preparedStatement.setString(2, sucursalProductoEntrada);
            //Sentencia para que se haga la consulta
            resultSet = preparedStatement.executeQuery();
            //Si es efectiva la consulta
            if (resultSet.next()) {
                //Impresión de los valores que se treen de la base de datos, solo para verificación
                System.out.println("idProducto: " + resultSet.getInt("idProducto"));
                System.out.println("Codigo: " + resultSet.getString("CodigoProducto"));
                System.out.println("Nombre: " + resultSet.getString("NombreProducto"));
                System.out.println("Insumo: " + resultSet.getString("InsumoProducto"));
                System.out.println("Sucursal: " + resultSet.getString("SucursalProducto"));
                System.out.println("Marca: " + resultSet.getString("MarcaProducto"));
                System.out.println("");
                //Se crea un objeto de tipo producto con los resultados obtnidos de la consulta
                int idProducto = resultSet.getInt("idProducto");
                int codigoProducto = resultSet.getInt("CodigoProducto");
                String nombreProducto = resultSet.getString("NombreProducto");
                String insumoProducto = resultSet.getString("InsumoProducto");
                String sucursalProducto = resultSet.getString("SucursalProducto");
                int existenciaProducto = resultSet.getInt("ExistenciaProducto");
                String marcaProducto = resultSet.getString("MarcaProducto");
                //Creación del objeto producto;
                producto = new Producto(idProducto, codigoProducto, nombreProducto, insumoProducto, sucursalProducto, existenciaProducto, marcaProducto);
            } //En caso de que no se haya hecho la conexión, se manda un mensaje de que no se han podido recuperar los datos
            else {
                
                JOptionPane.showMessageDialog(null, "No se han recuperado datos");
                System.out.println("No se han recuperado los datos");
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } finally {
            try {
                //Cierre del resultado de la sentencia
                ConexionDB.close(resultSet);
                //Cierre de la sentecia enviada
                ConexionDB.close(preparedStatement);
                //Cierre del canal de conexión
                ConexionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        //Se envia el objeto producto que se ha generado
        return producto;
    }
}
