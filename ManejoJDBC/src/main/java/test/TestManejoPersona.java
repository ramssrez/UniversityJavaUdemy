package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersona {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas = personaDAO.seleccionar();
        System.out.println("peronas" + personas.toString());
         
        System.out.println("uso del foreach");
        personas.forEach(persona ->{
            System.out.println("persona = " + persona);
        });
        //Uso del ciclo for
         for (Persona persona : personas) {
            System.out.println("persona = " + persona);
        }
    }
}
