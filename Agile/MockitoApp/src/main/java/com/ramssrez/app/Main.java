package com.ramssrez.app;

import com.ramssrez.app.models.Alumno;
import com.ramssrez.app.services.AlumnoServiceImpl;
import com.ramssrez.app.services.IAlumnoService;

public class Main {
    public static void main(String[] args) {
        IAlumnoService service = new AlumnoServiceImpl();
        Alumno alumno = service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        System.out.println("Alumno encontrado: " + alumno);
    }
}
