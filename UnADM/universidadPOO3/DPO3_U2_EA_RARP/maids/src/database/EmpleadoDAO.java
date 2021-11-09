/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objetos.Empleado;

/**
 *
 * @author ramssrez
 */
public class EmpleadoDAO {

    //Declaración de la sentencia a realizar para selecionar la información de los empleados
    private static final String SQL_SELECT = "SELECT id_comision, fecha, nombre_trabajador, nombre_cliente, tiempo_trabajado, comision_obtenida, "
            + "descuentos_realizados, sueldototal FROM empleados;";
    
    private static final String SQL_INSERT = "INSERT INTO empleados (fecha, nombre_trabajador, nombre_cliente, tiempo_trabajado, comision_obtenida, descuentos_realizados, sueldototal) "
            + "VALUES (?,?,?,?,?,?,?);";

    //Método que obtiene la lista de las habitaciones que hay en la base de datos
    public List<Empleado> seleccionarLista() {
        //Declaración de variables necesarias
        List<Empleado> listaEmpleados = new ArrayList<>();
        //Declaración de empleado como nulo
        Empleado empleado = null;
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
            //Sentencia para que se haga la consulta
            resultSet = preparedStatement.executeQuery();
            //ciclo while que retorno los datos de la base de datos
            while (resultSet.next()) {
                //Asignación de variables de los datos obtenidos de la base de datos
                int id = resultSet.getInt("id_comision");
                Date fecha = resultSet.getDate("fecha");
                String nombreTrabajador = resultSet.getString("nombre_trabajador");
                String nombreCliente = resultSet.getString("nombre_cliente");
                int tiempo = resultSet.getInt("tiempo_trabajado");
                int comision = resultSet.getInt("comision_obtenida");
                int descuento = resultSet.getInt("descuentos_realizados");
                int sueldo = resultSet.getInt("sueldototal");
                //Creación del objeto Empleado
                empleado = new Empleado(id,fecha, nombreTrabajador, nombreCliente, tiempo, comision, descuento, sueldo);
                //Agregación del objeto habitación a la lista
                listaEmpleados.add(empleado);
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
        return listaEmpleados;
    }
    
    public int insertar(Reservacion reservacion) {
        //Declaración de las variables necesrias para poder realizar la conexion a la base de datos.
        //Declaración del objeto del canal de conexión
        Connection conn = null;
        //Declaración del objetos de sentencias
        PreparedStatement preparedStatement = null;
        //Delcaración de la variable que verifica si se ha hecho una modificación al registro
        int registros = 0;
        //Bloque try/catch para las conexiones
        try {
            //Declaración del canal de coneción
            conn = ConexionDB.getConnection();
            //Envio de sentencias SQL para insertar datos a la base de datos
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            //Envio de los parametros que se han seleccionado para poder realizar la insersión de datos
            //Insersión de la la variable de tipo DateSql para la base de datos
            preparedStatement.setDate(1, reservacion.getFechaEntrada());
            preparedStatement.setDate(2, reservacion.getFechaSalida());
            preparedStatement.setString(3, String.valueOf(reservacion.getIdHabitacion()));
            preparedStatement.setString(4, String.valueOf(reservacion.getDias()));
            preparedStatement.setString(5, String.valueOf(reservacion.getCostoTotal()));
            //Sentencia para que se realice el alza de los datos
            registros = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace(System.out);
            registros = 0;
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
        //Retorno de registros afectados
        return registros;
    }

}
