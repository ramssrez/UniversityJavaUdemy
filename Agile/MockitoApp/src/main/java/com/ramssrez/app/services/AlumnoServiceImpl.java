package com.ramssrez.app.services;

import com.ramssrez.app.models.Alumno;
import com.ramssrez.app.models.Materia;
import com.ramssrez.app.repositorio.IAlumnoRepository;
import com.ramssrez.app.repositorio.IMateriasRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AlumnoServiceImpl implements IAlumnoService {
    private IAlumnoRepository repository;
    private IMateriasRepository materiasRepository;

    public AlumnoServiceImpl(IAlumnoRepository repository, IMateriasRepository materiasRepository) {
        this.repository = repository;
        this.materiasRepository = materiasRepository;
    }

/*
    public AlumnoServiceImpl() {
        this.repository = new AlumnoRepositoryImp();
    }

     */

    @Override
    public Alumno buscarAlumnoPorNombreApllido(String nombre, String apellid) {
        try{
            Optional<Alumno> alumnoOptional = this.repository.obtenerAlumno().stream().filter(a -> a.getNombre().equals(nombre) && a.getApellido().equals(apellid)).findFirst();
            Alumno alumno = null;
            if (alumnoOptional.isPresent()){
                List<Materia> materias = this.materiasRepository.obtenerMaterias();
                alumno = alumnoOptional.get();
                alumno.setMaterias(materias);
            }else{
                throw new NoSuchElementException("El alumno no existe");
            }
            return alumno;
        }catch (NullPointerException ex){
            throw new NullPointerException("La lista no tiene datos");
        }

    }
}
