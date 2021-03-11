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
    private static final String SQL_SELECT = "SELECT idProducto, CodigoProducto, NombreProducto, InsumoProducto, SucursalProducto, ExistenciaProducto, MarcaProducto FROM productos WHERE CodigoProducto = ? AND SucursalProducto=?";

    //private static final String SQL_INSERT = " into productos(CodigoProducto, NombreProducto, InsumoProducto, SucursalProducto, ExistenciaProducto, MarcaProducto)values('273','Servilletas','productos','1','100','Suavel')";
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
            //Envio de los parametros como el condigo del producto y el de la sucursal
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
            } 
            //En caso de que no se haya hecho la conexión, se manda un mensaje de que no se han podido recuperar los datos
            else {
                JOptionPane.showMessageDialog(null, "No se han recuperado datos");
                System.out.println("No se han recuperado los datos");
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                ConexionDB.close(resultSet);
                ConexionDB.close(preparedStatement);
                ConexionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        //Se envia el objeto producto que se ha generado
        return producto;
    }
}
