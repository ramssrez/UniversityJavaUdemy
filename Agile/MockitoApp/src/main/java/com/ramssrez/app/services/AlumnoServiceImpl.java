package com.ramssrez.app.services;

import com.ramssrez.app.Constants.ConstantsMessegs;
import com.ramssrez.app.exceptions.AgregarAlumnoException;
import com.ramssrez.app.exceptions.MateriasNotFoundException;
import com.ramssrez.app.models.Alumno;
import com.ramssrez.app.models.Materia;
import com.ramssrez.app.repositorio.IAlumnoRepository;
import com.ramssrez.app.repositorio.IMateriasRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

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
                if (materias.size() > 0){
                    alumno.setMaterias(materias);
                    return alumno;
                }
                throw new MateriasNotFoundException(ConstantsMessegs.NO_LISTA_MATERIAS);
            }else{
                throw new NoSuchElementException(ConstantsMessegs.NO_NOMBRE_LISTA);
            }
        }catch (NullPointerException ex){
            throw new NullPointerException(ConstantsMessegs.LISTA_SIN_DATOS);
        }

    }

    @Override
    public boolean crearAlumno(String nombre, String apellido, String carrera, List<Materia> materias) {
        Random  random = new Random();
        if (!nombre.isEmpty() && !apellido.isEmpty() && !carrera.isEmpty() && materias.size() > 0){
            Alumno alumno = new Alumno(random.nextLong(), nombre, apellido, carrera);
            alumno.setMaterias(materias);
            boolean result = this.repository.agregarAlumno(alumno);
        }
        throw new AgregarAlumnoException(ConstantsMessegs.ERROR_DATOS_ALUMNO);
    }
}
