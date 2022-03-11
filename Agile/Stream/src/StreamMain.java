import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        Persona p1 = new Persona("Adrian","Gonzales", LocalDate.of(1998,7,19));
        Persona p2 = new Persona("Juan","Gonzales", LocalDate.of(1987,6,25));
        Persona p3 = new Persona("Pepe","Gonzales", LocalDate.of(1985,9,10));
        Persona p4 = new Persona("Jose","Gonzales", LocalDate.of(1989,1,19));
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);

        /*
         *Imprimir los nombres
         *
         */
        //Opción tradicional
        for (Persona p : personas){
            System.out.println(p.getNombre());
        }

        //Opcion con for each
        personas.forEach(persona -> {
            System.out.println(persona.getNombre());
        });

        //opción con stram
        personas.stream().forEach(persona -> {
            System.out.println(persona.getNombre());
        });

        //desde la interfaz stream en una sola linea
        personas.stream().forEach(persona -> System.out.println(persona.getNombre()));



        /*
         * Calcular la edad con base en la fecha nacimiento
         * map siempre retorna algo
         */
        personas =  personas.stream().map(p -> {
            int edad = Period.between(p.getFechaNacimiento(),LocalDate.now()).getYears();
            p.setEdad(edad);
            return p;
        }).collect(Collectors.toList());
        personas.stream().forEach(p -> System.out.println("edad: " + p.getEdad()));

        //List<String> nombres = personas.stream().map(p -> p.getNombre()).collect(Collectors.toList());

        /*
         *Filtrar la lista de personas por aquellos que nacieron en ño biciesto
         */
    }
}
