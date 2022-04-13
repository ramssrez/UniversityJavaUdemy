package com.ramssrez.app.services;

import com.ramssrez.app.models.Alumno;
import com.ramssrez.app.repositorio.AlumnoRepositoryImp;
import com.ramssrez.app.repositorio.IAlumnoRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

public class AlumnoServiceImpl implements IAlumnoService {
    private IAlumnoRepository repository;

    public AlumnoServiceImpl(IAlumnoRepository repository) {
        this.repository = repository;
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
                alumno = alumnoOptional.get();
            }else{
                throw new NoSuchElementException("El alumno no existe");
            }
            return alumno;
        }catch (NullPointerException ex){
            throw new NullPointerException("La lista no tiene datos");
        }

    }
}
