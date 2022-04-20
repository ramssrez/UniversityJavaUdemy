package com.ramssrez.app.repositorio;

import com.ramssrez.app.models.Alumno;

import java.util.List;

public interface IAlumnoRepository {
    List<Alumno> obtenerAlumno();
    boolean agregarAlumno(Alumno alumno);
}
