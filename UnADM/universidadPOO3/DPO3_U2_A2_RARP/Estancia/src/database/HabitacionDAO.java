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
import objetos.Habitacion;

/**
 *
 * @author ramssrez
 */
public class HabitacionDAO {

    //Declaración de la sentencia a realizar para seleccionar cada uno de los campos de la habitación
    private static final String SQL_SELECT = "SELECT id_habitacion, no_habitacion, estatus,tipo, costo FROM habitaciones\n"
            + "INNER JOIN estatus ON habitaciones.id_estatus = estatus.id_estatus\n"
            + "INNER JOIN tipo_habitaciones ON habitaciones.id_tipo_habitacion = tipo_habitaciones.id_tipo_habitacion \n"
            + "AND estatus = 'Disponible' ORDER BY no_habitacion";
    //Declaración de la sentencia a realizar para insertar un registro a  la base de datos
    private static final String SQL_INSERT = "INSERT INTO reservacion(fecha_entrada, fecha_salida, id_habitacion) VALUES(?,?,?)";

    //Definicicion de la sentencia SQL para actualizar un registro
    private static final String SQL_UPDATE = "UPDATE habitaciones SET id_estatus = 2 WHERE (id_habitacion = ?)";

    //Método que permite actualizar un producto de la base de datos, se ingresa un objeto completo
    public int actualizar(int idHabitacion) {
        //Declaración del objeto del canal de conexión
        Connection conn = null;
        //Declaración del objetos de sentencias
        PreparedStatement preparedStatement = null;
        //Delcaración de la variable que verifica si se ha hecho una modificación al registro
        int registros = 0;
        try {
            //Declaración del canal de coneción
            conn = ConexionDB.getConnection();
            //Envio de sentencias SQL para insertar datos a la base de datos
            preparedStatement = conn.prepareStatement(SQL_UPDATE);
            //Envio de los parametros que se han seleccionado para poder realizar la insersión de datos
            //Se insertan todos los datos, por el beneficio de no realizar validación para cada uno de los campos de la base de datos
            preparedStatement.setString(1, String.valueOf(idHabitacion));
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
        //Retorno de regostros afectados
        return registros;
    }

//    public int insertar(Empleado empleado) {
//        //Declaración de las variables necesrias para poder realizar la conexion a la base de datos.
//        //Delaración de Date del paquete de SQL para poder realizar el guardado de campos de tipo Date
//        Date dateSql = null;
//        //Declaración del objeto del canal de conexión
//        Connection conn = null;
//        //Declaración del objetos de sentencias
//        PreparedStatement preparedStatement = null;
//        //Delcaración de la variable que verifica si se ha hecho una modificación al registro
//        int registros = 0;
//        //Bloque try/catch para las conexiones
//        try {
//            //Declaración del canal de coneción
//            conn = ConexionDB.getConnection();
//            //Envio de sentencias SQL para insertar datos a la base de datos
//            preparedStatement = conn.prepareStatement(SQL_INSERT);
//            //Envio de los parametros que se han seleccionado para poder realizar la insersión de datos
//            preparedStatement.setString(1, String.valueOf(empleado.getNumEmpleado()));
//            preparedStatement.setString(2, empleado.getNombreEmpleado());
//            preparedStatement.setString(3, empleado.getApellidosEmpleado());
//            preparedStatement.setString(4, empleado.getFechaNacimientoEmpleado());
//            preparedStatement.setString(5, empleado.getCurpEmpleado());
//            preparedStatement.setString(6, empleado.getRfcEmpleado());
//            preparedStatement.setString(7, String.valueOf(empleado.getSueldoEmpleado()));
//            preparedStatement.setString(8, empleado.getPuestoEmpleado());
//            //Tansformación del tipo Date de Java al Date de SQL
//            dateSql = new Date(empleado.getFechaIngresoEmpleado().getTime());
//            //Impresión de la variable que se ha creado
//            System.out.println("dateSql = " + dateSql);
//            //Insersión de la la variable de tipo DateSql para la base de datos
//            preparedStatement.setDate(9, dateSql);
//            //Sentencia para que se realice el alza de los datos
//            registros = preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("Error: " + ex.getMessage());
//            ex.printStackTrace(System.out);
//            registros = 0;
//        } finally {
//            try {
//                //Cierre de la sentecia enviada
//                ConexionDB.close(preparedStatement);
//                //Cierre del canal de conexión
//                ConexionDB.close(conn);
//            } catch (SQLException ex) {
//                System.out.println("Error: " + ex.getMessage());
//                ex.printStackTrace(System.out);
//            }
//        }
//        //Retorno de registros afectados
//        return registros;
//    }
    //Método que obtiene la lista de las habitaciones que hay en la base de datos
    public List<Habitacion> seleccionarLista() {
        //Declaración de variables necesarias
        List<Habitacion> listaHabitacion = new ArrayList<>();
        Habitacion habitacion = null;
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
                //Impresiones de pantalla de los datos que se estan obteniendo
//                System.out.println("");
//                System.out.println("Id habitacion: " + resultSet.getInt("id_habitacion"));
//                System.out.println("Numero habitación: " + resultSet.getInt("no_habitacion"));
//                System.out.println("Status: " + resultSet.getString("estatus"));
//                System.out.println("Tipo: " + resultSet.getString("tipo"));
//                System.out.println("Costo: " + resultSet.getInt("costo"));
                //Declaración de variables para crear los objetos
                int id = resultSet.getInt("id_habitacion");
                int numHabi = resultSet.getInt("no_habitacion");
                String status = resultSet.getString("estatus");
                String type = resultSet.getString("tipo");
                int cost = resultSet.getInt("costo");
                //Creación del objeto habitación
                habitacion = new Habitacion(id, numHabi, status, type, cost);
                //Agregación del objeto habitación a la lista
                listaHabitacion.add(habitacion);
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
        return listaHabitacion;
    }

}
