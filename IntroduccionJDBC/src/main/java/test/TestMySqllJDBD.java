package test;

import java.sql.*;

public class TestMySqllJDBD {

    public static void main(String[] args) {
        //Cadena de conexion en la base de datos
        String url = "jdbc:mysql://localhost:3307/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Para aplicaciones web es requerida para poder conectarse a una base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, "root", "admin");
            Statement statement = connection.createStatement();
            var sql = "SELECT idpersona, nombre,apellido,email,telefono FROM persona";
            ResultSet resultSet = statement.executeQuery(sql);
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("error ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("error SQLException" + ex.getMessage());
        }
    }
}
