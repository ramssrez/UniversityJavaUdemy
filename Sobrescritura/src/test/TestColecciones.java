package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        miLista.add("Sabado");
        miLista.add("Domingo");  
        
        //Uso del foreach para poder observar como es la organización de los elmenetos que se han utilizado
        for (Object elemento : miLista) {
            System.out.println("elemento: " + elemento);
        }
        
        System.out.println("");
        //uso de operaciones tipo landa o flecha
        miLista.forEach(elemento -> {
            System.out.println("elemento: " + elemento);
        });
        
        System.out.println("");
        //Uso de set, es similar al array pero con la diferencia que no guarda un orden
        Set miSet = new HashSet();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
                
        
        miSet.forEach(elemento ->{
                System.out.println("elemento: " + elemento);
        });
    }
           
}
