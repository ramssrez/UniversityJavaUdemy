/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Date;
import objetos.Personal;

/**
 *
 * @author ramssrez
 */
public class PersonalDAO {
    //Declaración de la sentencia a realizar para insertar un registro a  la base de datos

    private static final String SQL_INSERT = "INSERT INTO personal(nombre, apellidos, numero_empleado, edad, puesto, sueldo, area) VALUES(?,?,?,?,?,?,?)";

    public int insertar(Personal personal) {
        //Declaración de las variables necesrias para poder realizar la conexion a la base de datos.
        //Declaración del objeto del canal de conexión
        Connection conn = null;
        //Declaración del objetos de sentencias
        PreparedStatement preparedStatement = null;
        //Delcaración de la variable que verifica si se ha hecho una modificación al registro
        int registros = 0;
        //Bloque try/catch para las conexiones}
        try {
            //Declaración del canal de coneción
            conn = ConexionDB.getConnection();
            //Envio de sentencias SQL para insertar datos a la base de datos
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            //Envio de los parametros que se han seleccionado para poder realizar la insersión de datos
            //Insersión de la la variable de tipo DateSql para la base de datos
            preparedStatement.setString(1, personal.getNombre());
            preparedStatement.setString(2, personal.getApellidos());
            preparedStatement.setString(3, personal.getNumeroEmpleado());
            preparedStatement.setString(4, personal.getEdad());
            preparedStatement.setString(5, personal.getPuesto());
            preparedStatement.setString(6, personal.getSueldo());
            preparedStatement.setString(7, personal.getArea());
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
