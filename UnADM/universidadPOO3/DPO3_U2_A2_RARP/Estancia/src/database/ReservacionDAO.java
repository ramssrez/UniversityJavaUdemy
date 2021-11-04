/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package database;

import java.sql.Connection;
import objetos.Reservacion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author ramssrez
 */
public class ReservacionDAO {

    //Declaración de la sentencia a realizar para insertar un registro a  la base de datos
    private static final String SQL_INSERT = "INSERT INTO reservaciones(fecha_entrada, fecha_salida, id_habitacion, dias, costo_total) VALUES(?,?,?,?,?)";
    
    private static final String SQL_SELECT = "SELECT id_reservacion, fecha_entrada, fecha_salida,dias, costo_total, no_habitacion FROM reservaciones\n"
            + "INNER JOIN habitaciones ON habitaciones.id_habitacion = reservaciones.id_habitacion";

    //Método que obtiene la lista de las habitaciones que hay en la base de datos
    public List<Reservacion> seleccionarLista() {
        //Declaración de variables necesarias
        List<Reservacion> listaReservacion = new ArrayList<>();
        Reservacion reservacion = null;
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
                int id = resultSet.getInt("id_reservacion");
                Date fechDateEntrada = resultSet.getDate("fecha_entrada");
                Date fechDateSalida = resultSet.getDate("fecha_salida");
                int dias = resultSet.getInt("dias");
                int costoTotal = resultSet.getInt("costo_total");
                int numeroHabitacion = resultSet.getInt("no_habitacion");
                //Creación del objeto habitación
                reservacion = new Reservacion(id,fechDateEntrada,fechDateSalida,dias,costoTotal,numeroHabitacion);
                //Agregación del objeto habitación a la lista
                listaReservacion.add(reservacion);
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
        return listaReservacion;
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
