package datos;

import static datos.Conexion.*;
import domain.Persona;
import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    //Definir la sentecia SQL para poder ingresar a la base de datos
    private static final String SQL_SELECT = "SELECT idusuario, username, password FROM usuario";
    //Definicion de sentecia SQL para insertar un registro a la columna
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    //Definicicion de la sentencia SQL para actualizar un registro
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";
    //Definición de la sentencia SQL para eliminar un regitro
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona = ?";
    
    //Creación del metodo que selecciona los objetos de tipo personaa
    public List<Usuario> seleccionar() {
        //Declaración de la variable conn de tipo Connection
        Connection conn = null;
        //Declaraión de la variable statmente de tipo PreparedStatment
        PreparedStatement statement = null;
        //Declaración de la variable resultSet de tipo ResultSet
        ResultSet resultSet = null;
        //Declaración de objeto de tipo persona
        Usuario usuario = null;
        //Declaración de las lista de tipo personas
        List<Usuario> usuarios = new ArrayList<>();

        //Bloque try catch para recuperar los datos de la base de datos
        try {
            //declaración para conectarse a la base de datos con getConnection()
            conn = getConnection();
            //Sentencia par realizar la consulta deseada
            statement = conn.prepareStatement(SQL_SELECT);
            //Sentencia que comienza con la conexion con la base de datos
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idusuario = resultSet.getInt("idusuario");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                usuario = new Usuario(idusuario,username,password);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {

        } finally {
            try {
                close(resultSet);
                close(statement);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return usuarios;
    }

    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
     public int eliminar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
