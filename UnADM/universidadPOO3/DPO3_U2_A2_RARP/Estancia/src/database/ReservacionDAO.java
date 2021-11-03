/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package database;

/**
 *
 * @author ramssrez
 */
public class ReservacionDAO {

    //Declaración de la sentencia a realizar para insertar un registro a  la base de datos
    private static final String SQL_INSERT = "INSERT INTO reservacion(fecha_entrada, fecha_salida, id_habitacion, dias, costo_total) VALUES(?,?,?,?,?)";

    public int insertar(Reservacion reservacion) {
        //Declaración de las variables necesrias para poder realizar la conexion a la base de datos.
        //Delaración de Date del paquete de SQL para poder realizar el guardado de campos de tipo Date
        Date dateSql = null;
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
            preparedStatement.setString(1, String.valueOf(empleado.getNumEmpleado()));
            preparedStatement.setString(2, empleado.getNombreEmpleado());
            preparedStatement.setString(3, empleado.getApellidosEmpleado());
            preparedStatement.setString(4, empleado.getFechaNacimientoEmpleado());
            preparedStatement.setString(5, empleado.getCurpEmpleado());
            preparedStatement.setString(6, empleado.getRfcEmpleado());
            preparedStatement.setString(7, String.valueOf(empleado.getSueldoEmpleado()));
            preparedStatement.setString(8, empleado.getPuestoEmpleado());
            //Tansformación del tipo Date de Java al Date de SQL
            dateSql = new Date(empleado.getFechaIngresoEmpleado().getTime());
            //Impresión de la variable que se ha creado
            System.out.println("dateSql = " + dateSql);
            //Insersión de la la variable de tipo DateSql para la base de datos
            preparedStatement.setDate(9, dateSql);
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
