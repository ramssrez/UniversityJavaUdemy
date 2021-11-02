/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estamcia;

import database.HabitacionDAO;
import java.util.ArrayList;
import java.util.List;
import objetos.Habitacion;

/**
 *
 * @author ramssrez
 */
public class Estamcia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Instancia de la clase EmpleadoDAO
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        //Declaración del objeto empleado como nulo
        //Asignación del empleado a lo que se recupere de la sentencia SQL
        //empleadoDAO.seleccionar();
        //Sentencia if/else para el caso de que se recupere información
        //Retorno de la lista}
        
        //habitacionDAO.seleccionar();
        System.out.println("Lista de objetos");
        List<Habitacion> listaHabitacion = new ArrayList<>();
        listaHabitacion = habitacionDAO.seleccionarLista();
        listaHabitacion.forEach(habitacion -> {
            System.out.println(habitacion.toString());
        });
        
        
    }
    
}
