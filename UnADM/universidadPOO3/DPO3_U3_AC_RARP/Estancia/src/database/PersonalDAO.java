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
import objetos.Personal;

/**
 *
 * @author ramssrez
 */
public class PersonalDAO {
    //Declaración de la sentencia a realizar para insertar un registro a  la base de datos

    private static final String SQL_INSERT = "INSERT INTO personal(nombre, apellidos, numero_empleado, edad, puesto, sueldo, area) VALUES(?,?,?,?,?,?,?)";

    private static final String SQL_SELECT = "SELECT id_personal, nombre, apellidos, numero_empleado, edad, puesto, sueldo, area FROM personal WHERE numero_empleado = ?";

    private static final String SQL_SELECT_LIST = "SELECT id_personal, nombre, apellidos, numero_empleado, edad, puesto, sueldo, area FROM personal ORDER BY numero_empleado";

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

    //Método seleccionar el cual se encarga de buscar el producto en función del codigo del producto y sucursal del productos
    public Personal seleccionar(String numeroEmpleado) {
        //Declaración de las variables necesrias para poder realizar la conexion a la base de datos.
        //Declaración del objeto producto
        Personal p = null;
        //Declaración del objeto del canal de conexión
        Connection conn = null;
        //Declaración del objetos de sentencias
        PreparedStatement preparedStatement = null;
        //Declaración de objeto de resultados de las sentencias
        ResultSet resultSet = null;
        //Bloque try/catch para las conexiones
        try {
            //Declaración del canal de coneción
            conn = ConexionDB.getConnection();
            //Envio de sentencias SQL para recuperar la información necesaria
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            //Envio de los parametros como el codigo del producto y el de la sucursal
            preparedStatement.setString(1, numeroEmpleado);
            //Sentencia para que se haga la consulta
            resultSet = preparedStatement.executeQuery();
            //Si es efectiva la consulta
            if (resultSet.next()) {
                //Se crea un objeto de tipo personal con los resultados obtnidos de la consulta
                int idPersonal = resultSet.getInt("id_personal");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellidos");
                String numero = resultSet.getString("numero_empleado");
                String edad = resultSet.getString("edad");
                String puesto = resultSet.getString("puesto");
                String sueldo = resultSet.getString("sueldo");
                String area = resultSet.getString("area");
                //Creación del objeto personal
                p = new Personal(idPersonal, nombre, apellido, area, edad, numero, puesto, sueldo);

            } //En caso de que no se haya hecho la conexión, se manda un mensaje de que no se han podido recuperar los datos
            else {
                System.out.println("No se han recuperado los datos");
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
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
        //Se envia el objeto producto que se ha generado
        return p;
    }

    //Método que obtiene la lista del personal que hay en la base de datos
    public List<Personal> seleccionarLista() {
        //Declaración de variables necesarias
        List<Personal> listaPersonal = new ArrayList<>();
        Personal p = null;
        //Declaración del objeto del canal de conexión
        Connection conn = null;
        //Declaración del objetos de sentencias
        PreparedStatement preparedStatement = null;
        //Declaración de objeto de resultados de las sentencias
        ResultSet resultSet = null;

        try {
            //Declaración del canal de conexión
            conn = ConexionDB.getConnection();
            //Envio de sentencias SQL para recuperar la información necesaria
            preparedStatement = conn.prepareStatement(SQL_SELECT_LIST);
            //Sentencia para que se haga la consulta
            resultSet = preparedStatement.executeQuery();
            //ciclo while que retorno los datos de la base de datos
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellidos");
                String numero = resultSet.getString("numero_empleado");
                String edad = resultSet.getString("edad");
                String puesto = resultSet.getString("puesto");
                String sueldo = resultSet.getString("sueldo");
                String area = resultSet.getString("area");
                //Creación del objeto personal
                p = new Personal(nombre, apellido, area, edad, numero, puesto, sueldo);
                //Agregación del objeto personal a la lista
                listaPersonal.add(p);
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
        return listaPersonal;
    }
}
