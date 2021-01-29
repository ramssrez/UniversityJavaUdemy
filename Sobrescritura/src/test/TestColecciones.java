package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Uso de API Colleciones para Java
public class TestColecciones {

    public static void main(String[] args) {
        //Uso de Arraylista para una lista
        //Uso de la sintaxis de la lista con la clase Generica
        //List miLista  = new ArrayList<>();

        //Modificacion de la lista para que se pueda agregar tipos genericos
        List<String> miLista = new ArrayList<>();
        //Una lista mantienen el orden de los elementos conforme se van agregando
        System.out.println("Esto es con una lista y generica");
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        //Como las listas se agregan se pueden repetir los valores
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Domingo");

        String elementoPrueba = miLista.get(0);
        System.out.println("elementoPrueba = " + elementoPrueba);

        //Uso del foreach para poder observar como es la organización de los elmenetos que se han utilizado
//        for (Object elemento : miLista) {
//            System.out.println("elemento: " + elemento);
//        }
        System.out.println("");
        //uso de operaciones tipo landa o flecha
        imprimir(miLista);

        System.out.println("");
        //Uso de set, es similar al array pero con la diferencia que no guarda un orden
        //esta linea es con el uso de la clase Generiacs
        //Set miSet = new HashSet();
        //De esta manera hacemos de la clase generica
        Set<String> miSet = new HashSet<>();
        System.out.println("Esto es con el uso de Set");
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        //No se pueden repetir valores repetidos en el elementos set
        miSet.add("Viernes");
        imprimir(miSet);

        System.out.println("");
        System.out.println("Esto es con el uso de map para las colecciones");
        //Esta seccion es para la opcion Map del las coleccioness
        //Map sin el uso de clases genericas
        //Map miMap = new HashMap();
        //Seccion con el uso demap en donde se va a pasar a clases genericas
        Map<String, String> miMap = new HashMap<>();
        miMap.put("valor1", "Juan");
        miMap.put("Valor2", "KArla");
        miMap.put("Valor3", "Rosario");
        //Si agregamos un nuevo valr con el mismo subindice, se subescribe
        miMap.put("Valor3", "Carlos");

        //Con esta opcion podemos oobtener los elementos de un map
        //Ya no es necesario el parseo de las clases 
        String elementoMap = miMap.get("valor1");
        //Y de esta manera podemos imprimir lo que se obtuvo de la primera
        System.out.println("elementoMap = " + elementoMap);
        //Con esta sintaxis podemos obtener los valores de los llaves que hemos realizado
        imprimir(miMap.keySet());

        //Con esta sintaxis podemos obtener los valores asociados al map
        imprimir(miMap.values());

    }

    //Método que imprime las colecciiones que estamos analizando
    public static void imprimir(Collection<String> collection) {
        collection.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
        
        //Uso de for en vez de foreach
//        for (String elemento : collection) {
//            System.out.println("elemento = " + elemento);
//        }
 
    }

}
