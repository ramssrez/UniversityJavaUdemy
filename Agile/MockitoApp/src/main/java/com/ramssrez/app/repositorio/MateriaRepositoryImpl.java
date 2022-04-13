package com.ramssrez.app.repositorio;

import com.ramssrez.app.models.Materia;

import java.util.Arrays;
import java.util.List;

public class MateriaRepositoryImpl implements IMateriasRepository{

    @Override
    public List<Materia> obtenerMaterias() {
        return Arrays.asList(
                new Materia(1L,"Fundamentos de programación"),
                new Materia(2L,"POO"),
                new Materia(3L,"Bases de datos"),
                new Materia(4L,"Algebra lineal"),
                new Materia(5L,"Fundamentos de POO")
                );
    }
}
