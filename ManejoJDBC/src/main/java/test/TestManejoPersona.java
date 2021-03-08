package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersona {

    public static void main(String[] args) {
        //Instancia de la clase PersonaDAO
        PersonaDAO personaDAO = new PersonaDAO();

//        System.out.println("uso del foreach");
//        personas.forEach(persona -> {
//            System.out.println("persona = " + persona);
//        });
//        //Uso del ciclo for
//         for (Persona persona : personas) {
//            System.out.println("persona = " + persona);
//        }
        //Insertando un nuevo objeto de tipo persona
        Persona persona = new Persona("Ximena", "Sanchez", "ximena@ximena.com", "5555555526");
       
        personaDAO.insertar(persona);
        //Declaración de la lista de tipo personas a partir de lo que se obtienen de la base de datos
        List<Persona> personas = personaDAO.seleccionar();
        //Método que imrime la lista de las personas que se han recuperado de la base de datos
        imprimir(personas);

    }

    public static void imprimir(List<Persona> personas) {
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
