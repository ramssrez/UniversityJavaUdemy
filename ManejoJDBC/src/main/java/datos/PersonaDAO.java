package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {

    //Definir la sentecia SQL para poder ingresar a la base de datos
    private static final String SQL_SELECT = "SELECT idPersona, nombre,apellido, email, telefono FROM persona";

    //Creación del metodo que selecciona los objetos de tipo personaa
    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = getConnection();
            statement = conn.prepareStatement(SQL_SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idPersona = resultSet.getInt("idpersona");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                String telefono = resultSet.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
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

        return null;
    }

}
