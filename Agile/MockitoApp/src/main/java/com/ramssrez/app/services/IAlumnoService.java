package com.ramssrez.app.services;

import com.ramssrez.app.models.Alumno;

public interface IAlumnoService {
    Alumno buscarAlumnoPorNombreApllido(String nombre, String apellid);
}
