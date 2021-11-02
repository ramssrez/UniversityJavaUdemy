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

//     //Método seleccionar el cual se encarga de btener toda la lista de habitaciones
//    public void seleccionar() {
//        //Declaración del objeto del canal de conexión
//        Connection conn = null;
//        //Declaración del objetos de sentencias
//        PreparedStatement preparedStatement = null;
//        //Declaración de objeto de resultados de las sentencias
//        ResultSet resultSet = null;
//        //Bloque try/catch para las conexiones
//        try {
//            //Declaración del canal de conexión
//            conn = ConexionDB.getConnection();
//            //Envio de sentencias SQL para recuperar la información necesaria
//            preparedStatement = conn.prepareStatement(SQL_SELECT);
//            //Envio de los parametros como el numero de empeado para recuperar la información
//           // preparedStatement.setInt(1, numeroEmpleadoEntrada);
//            //Sentencia para que se haga la consulta
//            resultSet = preparedStatement.executeQuery();
//            //Si es efectiva la consulta
//            while(resultSet.next()){
//                System.out.println("Esto es desde el while");
//                System.out.println("");
//                System.out.println("Id habitacion: " + resultSet.getInt("id_habitacion"));
//                System.out.println("Numero habitación: " + resultSet.getInt("no_habitacion"));
//                System.out.println("Status: " + resultSet.getString("estatus"));
//                System.out.println("Tipo: " + resultSet.getString("tipo"));
//                System.out.println("Costo: " + resultSet.getInt("costo")); 
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Error Selección: " + ex.getMessage());
//            ex.printStackTrace(System.out);
//        } finally {
//            try {
//                //Cierre del resultado de la sentencia
//                ConexionDB.close(resultSet);
//                //Cierre de la sentecia enviada
//                ConexionDB.close(preparedStatement);
//                //Cierre del canal de conexión
//                ConexionDB.close(conn);
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.out);
//            }
//        }
//        //Se envia el objeto empleado que se ha generado
//        //return empleado;
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
