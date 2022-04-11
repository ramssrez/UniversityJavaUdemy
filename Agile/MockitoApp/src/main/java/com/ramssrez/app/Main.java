package com.ramssrez.app;

import com.ramssrez.app.models.Alumno;
import com.ramssrez.app.repositorio.AlumnoRepositoryImp;
import com.ramssrez.app.repositorio.IAlumnoRepository;
import com.ramssrez.app.services.AlumnoServiceImpl;
import com.ramssrez.app.services.IAlumnoService;

public class Main {
    public static void main(String[] args) {
        IAlumnoRepository repository = new AlumnoRepositoryImp();
        IAlumnoService service = new AlumnoServiceImpl(repository);
        Alumno alumno = service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        System.out.println("Alumno encontrado: " + alumno);
    }
}
