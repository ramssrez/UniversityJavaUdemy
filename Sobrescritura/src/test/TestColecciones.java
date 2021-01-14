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
        List miLista = new ArrayList();
        //Una lista mantienen el orden de los elementos conforme se van agregando
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

        //Uso del foreach para poder observar como es la organización de los elmenetos que se han utilizado
//        for (Object elemento : miLista) {
//            System.out.println("elemento: " + elemento);
//        }
        System.out.println("");
        //uso de operaciones tipo landa o flecha
        imprimir(miLista);
        
        System.out.println("");
        //Uso de set, es similar al array pero con la diferencia que no guarda un orden
        Set miSet = new HashSet();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        //No se pueden repetir valores repetidos en el elementos set
        miSet.add("Viernes");
        imprimir(miSet);
        
        System.out.println("");
        //Esta seccion es para la opcion Map del las coleccioness
        Map miMap = new HashMap();
        miMap.put("valor1", "Juan");
        miMap.put("Valor2", "KArla");
        miMap.put("Valor3", "Rosario");
        
        //Con esta opcion podemos oobtener los elementos de un map
        String elementoMap = (String) miMap.get("valor1");
        //Y de esta manera podemos imprimir lo que se obtuvo de la primera
        System.out.println("elementoMap = " + elementoMap);
        //Con esta sintaxis podemos obtener los valores de los llaves que hemos realizado
        imprimir(miMap.keySet());
        
        //Con esta sintaxis podemos obtener los valores asociados al map
        imprimir(miMap.values());
        
    }
    
    //Método que imprime las colecciiones que estamos analizando
    public static void imprimir(Collection collection) {
        collection.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
    }    
    
}
