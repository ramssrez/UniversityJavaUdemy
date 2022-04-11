package com.ramssrez.app.services;

import com.ramssrez.app.dummy.AlumnoDummy;
import com.ramssrez.app.models.Alumno;
import com.ramssrez.app.repositorio.AlumnoRepositoryImp;
import com.ramssrez.app.repositorio.IAlumnoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoServiceImplTest {

    @Mock
    IAlumnoRepository repository;

    @InjectMocks
    IAlumnoService service;

    @Test
    void testSuccessBuscarAlumnoPorNombreApeellido() {
        //IAlumnoRepository repository = new AlumnoRepositoryImp();
        IAlumnoRepository  repository = mock(IAlumnoRepository.class);
        IAlumnoService service = new AlumnoServiceImpl(repository);
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumno());

        Alumno alumno =  service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");

        Assertions.assertEquals("Adrian",alumno.getNombre());
        assertEquals(1,alumno.getId());
    }

    @Test
    void testFailBuscarAlumnoPorNombreApellidoListaVacia() {
        IAlumnoRepository  repository = mock(IAlumnoRepository.class);
        IAlumnoService service = new AlumnoServiceImpl(repository);
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumnosListaVacia());

       // Alumno alumno =  service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");

        assertThrows(NoSuchElementException.class, () ->{
            service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        });

    }

    @Test
    void testFailBuscarAlumnoPorNombreApellidoNull() {
        IAlumnoRepository  repository = mock(IAlumnoRepository.class);
        IAlumnoService service = new AlumnoServiceImpl(repository);
        when(repository.obtenerAlumno()).thenReturn(null);

        // Alumno alumno =  service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");

        assertThrows(NullPointerException.class, () ->{
            service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        });

    }
}