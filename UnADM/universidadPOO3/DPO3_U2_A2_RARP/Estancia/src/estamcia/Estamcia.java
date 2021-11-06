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
    public static void main(String[] args) throws InterruptedException {
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
        
        int horas = 5, minutos = 3, segundos = 10;

        while (!(horas == 0 && minutos == 0 && segundos == 0)) {

            if (horas < 10) {
                System.out.print("0" + horas);
            } else {
                System.out.print(horas);
            }

            System.out.print(":");

            if (minutos < 10) {
                System.out.print("0" + minutos);
            } else {
                System.out.print(minutos);
            }

            System.out.print(":");

            if (segundos < 10) {
                System.out.print("0" + segundos);
            } else {
                System.out.print(segundos);
            }

            System.out.println("");

            if (segundos == 0) {

                if (minutos == 0) {
                    horas--;
                    minutos = 59;
                    segundos = 59;
                } else if (minutos != 0) {
                    minutos--;
                    segundos = 59;
                }

            } else {
                segundos--;
            }
            System.out.println("segundos" + segundos);
            System.out.println("minutos" + minutos);
            System.out.println("horas:" + horas);

             Thread.sleep(1000);
            
        }

        System.out.println("00:00:00");
        System.out.println("Fin de la cuenta atras");
        
        
    }
    
}
