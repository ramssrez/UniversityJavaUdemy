package com.ramssrez.app.dummy;

import com.ramssrez.app.models.Alumno;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlumnoDummy {
    public static List<Alumno> obtenerAlumno() {
        return Arrays.asList(
                new Alumno(2L,"Juan","Sanchez","Computación"),
                new Alumno(3L,"Miguel","Perez","Biología"),
                new Alumno(4L,"Minnie","Gonzalez","Administración"),
                new Alumno(1L,"Adrian","Gonzalez","Sistemas computacionales")
        );
    }
    public static List<Alumno> obtenerAlumnosListaVacia(){
        return Collections.emptyList();
    }
}
