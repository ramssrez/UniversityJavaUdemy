package com.ramssrez.app.services;

import com.ramssrez.app.models.Alumno;
import com.ramssrez.app.models.Materia;

import java.util.List;

public interface IAlumnoService {
    Alumno buscarAlumnoPorNombreApllido(String nombre, String apellido);
    boolean crearAlumno(String nombre, String apellido, String carrera, List<Materia> materias);
}
