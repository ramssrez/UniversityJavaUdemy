package test;

import java.util.ArrayList;
import java.util.List;

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
    }
           
}
