/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estamcia;

import database.HabitacionDAO;

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
        HabitacionDAO empleadoDAO = new HabitacionDAO();
        //Declaración del objeto empleado como nulo
        //Empleado empleado = null;
        //Asignación del empleado a lo que se recupere de la sentencia SQL
        empleadoDAO.seleccionar(1);
        //Sentencia if/else para el caso de que se recupere información
    }
    
}
