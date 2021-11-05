/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package database;

import java.sql.Connection;
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

    //Definicicion de la sentencia SQL para actualizar un registro
    private static final String SQL_UPDATE = "UPDATE habitaciones SET id_estatus = 2 WHERE (id_habitacion = ?)";
    
     //Definicicion de la sentencia SQL para actualizar un registro
    private static final String SQL_UPDATE_DOS = "UPDATE habitaciones SET id_estatus = 1 WHERE (id_habitacion = ?)";

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
