package com.ramssrez.app.dummy;

import com.ramssrez.app.models.Materia;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MateriasDummy {
    public static List<Materia> obtenerMaterias() {
        return Arrays.asList(
                new Materia(1L, "Fundamentos de Programación"),
                new Materia(5L, "Cálculo Diferencial")
        );
    }

    public static List<Materia> obtenerMateriasListaVacia() {
        return Collections.emptyList();
    }
}
