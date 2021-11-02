/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
    //Variable URL que contienen la dirección de donde se tiene que conectar la base de datos
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/la_estancia";
    //Variable que contiene el usuario para la base de datos
    private static final String JDBC_USER = "root";
    //Variable que contiene la contraseña para conectarse a la base de dartos
    private static final String JDBC_PASSWORD = "admin";

    //Método que permite el canal de conexión a la base de datos en función de los parametros de entrada
    public static Connection getConnection() throws SQLException {
        //Retorno de la variable que realiza la conexión a la base de datos
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    //Método que permite el cierre del canal de conexion de la base de datos
    public static void close(Connection connection) throws SQLException {
        //Método que cierra el canal de conexión de la base de datos
        connection.close();
    }
    
    //Método  que permite el cierre de las sentencias enviadas hacia la base de datos
    public static void close(Statement statement) throws SQLException {
        //Método que cierra las sentencias enviadas.
        statement.close();
    }
    
    //Método que  permite el cierre de la respuesta de la base de datos
    public static void close(ResultSet resultSet) throws SQLException {
        //Método que permite de la respuesta
        resultSet.close();
    }

   

}
