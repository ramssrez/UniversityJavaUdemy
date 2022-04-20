package com.ramssrez.app.repositorio;

import com.ramssrez.app.models.Alumno;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlumnoRepositoryImp implements IAlumnoRepository{
    private static final List<Alumno> ALUMNOS = Arrays.asList(
            new Alumno(1L,  "Adrián", "González", "Sistemas Computacionales"),
            new Alumno(2L,  "Juan", "Perez", "Informática"),
            new Alumno(3L,  "Mickey", "Mouse", "Sistemas de Información"),
            new Alumno(4L,  "Minnie", "Mouse", "Administración")
    );
    @Override
    public List<Alumno> obtenerAlumno() {
        System.out.println("Se invocó el método de de la clase " + getClass().getName());
        return ALUMNOS;
    }

    @Override
    public boolean agregarAlumno(Alumno alumno) {
        return ALUMNOS.add(alumno);
    }
}
