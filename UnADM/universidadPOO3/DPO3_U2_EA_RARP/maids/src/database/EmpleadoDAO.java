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

/**
 *
 * @author ramssrez
 */
public class EmpleadoDAO {
    //Declaración de la sentencia a realizar para selecionar la información de los empleados
    private static final String SQL_SELECT = "SELECT id_comision, fecha, nombre_trabajador, nombre_cliente "
            + "FROM empleados;";

    //Método que obtiene la lista de las habitaciones que hay en la base de datos
    public void seleccionarLista() {
        //Declaración de variables necesarias
        ///List<Reservacion> listaReservacion = new ArrayList<>();
        //Reservacion reservacion = null;
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
                reservacion = new Reservacion(id, fechDateEntrada, fechDateSalida, dias, costoTotal, numeroHabitacion);
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

}
