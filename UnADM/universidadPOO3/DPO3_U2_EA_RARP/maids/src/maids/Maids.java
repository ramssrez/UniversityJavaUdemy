/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maids;

import database.EmpleadoDAO;
import java.util.ArrayList;
import java.util.List;
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
    }
    
}
