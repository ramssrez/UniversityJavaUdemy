/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maids;

import database.EmpleadoDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import objetos.Empleado;

/**
 *
 * @author ramssrez
 */
public class Maids {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Empleado> listaEmpleados = new ArrayList<>();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        listaEmpleados = empleadoDAO.seleccionarLista();
        listaEmpleados.forEach((empleado) -> {
            System.out.println(empleado.toString());
        });
        Date fecha = new Date();
        java.sql.Date fechaSQL = formatoFechaSql(fecha);

        Empleado empleado = new Empleado(fechaSQL, "Raul Ramírez Pérez", "Alba Lopez Juarez", 480, 50, 50, 120);
        int valor = empleadoDAO.insertar(empleado);
        if (valor > 0) {
            System.out.println("Se ha agregado datos");
        } else {
            System.out.println("No se han agregado datos");
        }
        
        
        int min = -3;
        int max = 4;
        Random random = new Random();
        //numeros random
        for (int i = 0; i < 200; i++) {
            int value = random.nextInt(max-min) + min;
            System.out.println("value = " + value);
        }

    }
    //Implementación del formato en SQL

    public static java.sql.Date formatoFechaSql(Date date) {
        long dateLong = date.getTime();
        java.sql.Date dateSQL = new java.sql.Date(dateLong);
        return dateSQL;
    }

}
