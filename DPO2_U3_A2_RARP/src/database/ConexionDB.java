package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ramssrez
 */
public class ConexionDB {

    //Variable URL que contienen la dirección de donde se tiene que conectar la base de datos
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/restaurantepv";
    //Variable que contiene el usuario para la base de datos
    private static final String JDBC_USER = "root";
    //Variable que contiene la contraseña para conectarse a la base de dartos
    private static final String JDBC_PASSWORD = "admin";

    //Método que permite conectarse con la base de datos de SQL
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    //Método que permite el cierre del objeto del objeto Connection
    public static void close(Connection connection) throws SQLException {
        connection.close();
    }
}
