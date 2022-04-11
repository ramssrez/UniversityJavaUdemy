package com.ramssrez.app.repositorio;

import com.ramssrez.app.models.Alumno;

import java.util.Arrays;
import java.util.List;

public class AlumnoRepositoryImp implements IAlumnoRepository{
    @Override
    public List<Alumno> obtenerAlumno() {
        return Arrays.asList(
                new Alumno(1L,"Adrian","Gonzalez","Sistemas computacionales"),
                new Alumno(2L,"Juan","Sanchez","Computación"),
                new Alumno(3L,"Miguel","Perez","Biología"),
                new Alumno(4L,"Minnie","Gonzalez","Administración")
                );
    }
}
