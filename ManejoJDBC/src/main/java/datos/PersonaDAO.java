package datos;

import domain.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    //Definir la sentecia SQL para poder ingresar a la base de datos
    private static final String SQL_SELECT = "SELECT idPersona, nombre,apellido, email, telefono FROM persona";
    
    //Creación del metodo que selecciona los objetos de tipo personaa
    public List<Persona> seleccionar(){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        return null;
    }
        

}
