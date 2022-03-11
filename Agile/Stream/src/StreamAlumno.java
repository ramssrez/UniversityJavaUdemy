import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamAlumno {
    public static void main(String[] args) {
        /**
         * Crear clase Alumno con los campos
         * Nombre: String
         * Calificacion: int
         * Aprobado: boolean
         * Crear 10 objetos de tipo Alumno, asignar únicamente el nombre
         * Crear una lista de tipo Alumno y agregar los 10 alumnos a la lista
         * Imprimir nombres de los alumnos: forEach de la interfaz Stream
         * Asignar calificación usando la clase random en un rango entre 0 a 100, si el alumno tiene una calificación mínima de 80, setear true al campo Aprobado, si es menor de 80 asignar false al campo Aprobado: map
         * Imprimir los campos nombre, calificación y aprobado de cada Alumno: forEach de la interfaz Stream
         * Filtrar alumnos por el campo Aprobado en true,guardar en una nueva lista: filter
         * Imprimir los nombres de los alumnos de la lista filtrada: forEach
         */

        //Crear 10 objetos de tipo Alumno, asignar únicamente el nombre
        Alumno alumno1 = new Alumno("Jose");
        Alumno alumno2 = new Alumno("Manuel");
        Alumno alumno3 = new Alumno("Alba");
        Alumno alumno4 = new Alumno("Javier");
        Alumno alumno5 = new Alumno("Sandra");
        Alumno alumno6 = new Alumno("Juan");
        Alumno alumno7 = new Alumno("Jesus");
        Alumno alumno8 = new Alumno("Martha");
        Alumno alumno9 = new Alumno("Mario");
        Alumno alumno10 = new Alumno("Rosa");

        //Crear una lista de tipo Alumno y agregar los 10 alumnos a la lista
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);
        alumnos.add(alumno5);
        alumnos.add(alumno6);
        alumnos.add(alumno7);
        alumnos.add(alumno8);
        alumnos.add(alumno9);
        alumnos.add(alumno10);

        //Imprimir nombres de los alumnos: forEach de la interfaz Stream
        alumnos.stream().forEach( a -> System.out.println("nombre: " + a.getNombre()));

        Random r = new Random();
        r.nextInt(101); // 0 - 100

        int valorRandom = 101;
        //Asignar calificación usando la clase random en un rango entre 0 a 100, si el alumno tiene una calificación mínima de 80, setear true al campo Aprobado, si es menor de 80 asignar false al campo Aprobado: map
        alumnos = alumnos.stream().map(a -> {
            int random = r.nextInt(valorRandom);
            a.setCalificacion(random);
            if (random < 80){
                a.setAprobado(false);
            }else{
                a.setAprobado(true);
            }
            return a;
        }).collect(Collectors.toList());

        //Imprimir los campos nombre, calificación y aprobado de cada Alumno: forEach de la interfaz Stream
        alumnos.stream().forEach( a -> System.out.println(a.toString()));

        //Filtrar alumnos por el campo Aprobado en true,guardar en una nueva lista: filter
        alumnos =  alumnos.stream().filter(a-> a.isAprobado()).collect(Collectors.toList());
        System.out.println("\n\n\n\nAlumnos aprobados");
        alumnos.stream().forEach(a -> System.out.println(a.toString()));

    }
}
