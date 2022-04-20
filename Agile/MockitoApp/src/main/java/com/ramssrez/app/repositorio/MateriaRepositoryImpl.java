package com.ramssrez.app.repositorio;

import com.ramssrez.app.models.Materia;

import java.util.Arrays;
import java.util.List;

public class MateriaRepositoryImpl implements IMateriasRepository{

    @Override
    public List<Materia> obtenerMaterias() {
        return Arrays.asList(
                new Materia(1L,"Fundamentos de programación"),
                new Materia(2L,"Algebra Superior"),
                new Materia(3L,"Bases de Datos"),
                new Materia(4L,"Programación Orientada a Objetos"),
                new Materia(5L,"Calculo Diferencial")
                );
    }
}
