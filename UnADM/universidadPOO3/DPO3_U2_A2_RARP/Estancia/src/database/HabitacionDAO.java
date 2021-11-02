/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import objetos.Empleado;

/**
 *
 * @author ramssrez
 */
public class HabitacionDAO {
    //Declaración de la sentencia a realizar para seleccionar cada uno de los campos de la habitación
    private static final String SQL_SELECT = "SELECT no_habitacion, estatus,tipo, costo FROM habitaciones\n" +
    "INNER JOIN estatus ON habitaciones.id_estatus = estatus.id_estatus\n" +
    "INNER JOIN tipo_habitaciones ON habitaciones.id_tipo_habitacion = tipo_habitaciones.id_tipo_habitacion;";
    
     //Método seleccionar el cual se encarga de buscar un empleado en función del numero del empleado 
    public void seleccionar(int numeroEmpleadoEntrada) {
        //Declaración de las variables necesrias para poder realizar la conexion a la base de datos.
        //Declaración del objeto empleado
        //Empleado empleado = null;
        //Declaración del objeto del canal de conexión
        Connection conn = null;
        //Declaración del objetos de sentencias
        PreparedStatement preparedStatement = null;
        //Declaración de objeto de resultados de las sentencias
        ResultSet resultSet = null;
        //Bloque try/catch para las conexiones
        try {
            //Declaración del canal de conexión
            conn = ConexionDB.getConnection();
            //Envio de sentencias SQL para recuperar la información necesaria
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            //Envio de los parametros como el numero de empeado para recuperar la información
           // preparedStatement.setInt(1, numeroEmpleadoEntrada);
            //Sentencia para que se haga la consulta
            resultSet = preparedStatement.executeQuery();
            //Si es efectiva la consulta
            if (resultSet.next()) {
                //Impresión de los valores que se treen de la base de datos, solo para verificación
                System.out.println("");
                System.out.println("Numero habitación: " + resultSet.getString("no_habitacion"));
                System.out.println("Status: " + resultSet.getString("estatus"));
                System.out.println("Tipo: " + resultSet.getString("tipo"));
                System.out.println("Costo: " + resultSet.getString("costo"));
                
//                System.out.println("Fecha NacimienEmpleado: " + resultSet.getString("FecNacEmpleado"));
//                System.out.println("CURPEmpleado: " + resultSet.getString("CURPEmpleado"));
//                System.out.println("RFC NacimienEmpleado: " + resultSet.getString("RFCEmpleado"));
//                System.out.println("Sueldo Empleado: " + resultSet.getString("SueldoEmpleado"));
//                System.out.println("Puesto Empleado: " + resultSet.getString("PuestoEmpleado"));
//                System.out.println("FEcha ingresoEmpleado: " + resultSet.getString("FecIngresoEmpleado"));
//                System.out.println("");
//                //Se crea un objeto de tipo producto con los resultados obtnidos de la consulta
//                int idEmpleado = resultSet.getInt("idEmpleado");
//                int numeroEmpleado = resultSet.getInt("NumEmpleado");
//                String nombreEmpleado = resultSet.getString("NombreEmpleado");
//                String apellidoEmpleado = resultSet.getString("ApellidosEmpleado");
//                String fechaNacimiento = resultSet.getString("FecNacEmpleado");
//                String curpEmpleado = resultSet.getString("CURPEmpleado");
//                String rfcEmpleado = resultSet.getString("RFCEmpleado");
//                int sueldoEmpleado = resultSet.getInt("SueldoEmpleado");
//                String puestoEmpleado = resultSet.getString("PuestoEmpleado");
//                Date ingresoEmpleado = resultSet.getDate("FecIngresoEmpleado");
                //Creación del objeto empleado;
                //empleado = new Empleado(idEmpleado, numeroEmpleado, nombreEmpleado, apellidoEmpleado, fechaNacimiento, curpEmpleado, rfcEmpleado, sueldoEmpleado, puestoEmpleado, ingresoEmpleado);
            } //En caso de que no se haya hecho la conexión, se manda un mensaje de que no se han podido recuperar los datos
            else {
                System.out.println("No se han recuperado los datos");
            }

        } catch (SQLException ex) {
            System.out.println("Error Selección: " + ex.getMessage());
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
        //return empleado;
    }
    
}
