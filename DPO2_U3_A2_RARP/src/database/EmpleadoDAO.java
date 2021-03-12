/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import objetos.Empleado;

public class EmpleadoDAO {

    //Declaración de la sentencia a realizar para seleccionar cada uno de los campos de un empleado
    private static final String SQL_SELECT = "SELECT idEmpleado, NumEmpleado, nombreEmpleado, ApellidosEmpleado, FecNacEmpleado, CURPEmpleado, RFCEmpleado, SueldoEmpleado, PuestoEmpleado, FecIngresoEmpleado FROM empleados WHERE NumEmpleado = ?";
    //Declaración de la sentencia a realizar para insertar un registro a  la base de datos
    //private static final String SQL_INSERT = "INSERT INTO productos(CodigoProducto, NombreProducto, InsumoProducto, SucursalProducto, ExistenciaProducto, MarcaProducto) VALUES(?,?,?,?,?,?)";
    //Delcaración de la sentencia a realizar para eliminar un registro de la base de datos.
    //private static final String SQL_DELETE = "DELETE FROM productos WHERE idProducto = ?";

    //Método seleccionar el cual se encarga de buscar un empleado en función del numero del empleado 
    public Empleado seleccionar(int numeroEmpleadoEntrada) {
        //Declaración de las variables necesrias para poder realizar la conexion a la base de datos.
        //Declaración del objeto empleado
        Empleado empleado = null;
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
            //Envio de los parametros como el numero de empeado para recuperar la información
            preparedStatement.setInt(1, numeroEmpleadoEntrada);
            //preparedStatement.setString(2, sucursalProductoEntrada);
            //Sentencia para que se haga la consulta
            resultSet = preparedStatement.executeQuery();
            //Si es efectiva la consulta
            if (resultSet.next()) {
                //Impresión de los valores que se treen de la base de datos, solo para verificación
                System.out.println("");
                System.out.println("Numero empleado: " + resultSet.getString("idEmpleado"));
                System.out.println("Numero empleado: " + resultSet.getString("NumEmpleado"));
                System.out.println("Nombre: " + resultSet.getString("NombreEmpleado"));
                System.out.println("Apellidos: " + resultSet.getString("ApellidosEmpleado"));
                System.out.println("Fecha NacimienEmpleado: " + resultSet.getString("FecNacEmpleado"));
                System.out.println("CURPEmpleado: " + resultSet.getString("CURPEmpleado"));
                System.out.println("RFC NacimienEmpleado: " + resultSet.getString("RFCEmpleado"));
                System.out.println("Sueldo Empleado: " + resultSet.getString("SueldoEmpleado"));
                System.out.println("Puesto Empleado: " + resultSet.getString("PuestoEmpleado"));
                System.out.println("FEcha ingresoEmpleado: " + resultSet.getString("FecIngresoEmpleado"));
                System.out.println("");
                //Se crea un objeto de tipo producto con los resultados obtnidos de la consulta
                int idEmpleado = resultSet.getInt("idEmpleado");
                int numeroEmpleado = resultSet.getInt("NumEmpleado");
                String nombreEmpleado = resultSet.getString("NombreEmpleado");
                String apellidoEmpleado = resultSet.getString("ApellidosEmpleado");
                String fechaNacimiento = resultSet.getString("FecNacEmpleado");
                String curpEmpleado = resultSet.getString("CURPEmpleado");
                String rfcEmpleado = resultSet.getString("RFCEmpleado");
                int sueldoEmpleado = resultSet.getInt("SueldoEmpleado");
                String puestoEmpleado = resultSet.getString("PuestoEmpleado");
                Date ingresoEmpleado = resultSet.getDate("FecIngresoEmpleado");
                //Creación del objeto empleado;
                empleado = new Empleado(idEmpleado, numeroEmpleado, nombreEmpleado, apellidoEmpleado, fechaNacimiento, curpEmpleado, rfcEmpleado, sueldoEmpleado, puestoEmpleado, ingresoEmpleado);
            } //En caso de que no se haya hecho la conexión, se manda un mensaje de que no se han podido recuperar los datos
            else {
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
        //Se envia el objeto empleado que se ha generado
        return empleado;
    }
}
