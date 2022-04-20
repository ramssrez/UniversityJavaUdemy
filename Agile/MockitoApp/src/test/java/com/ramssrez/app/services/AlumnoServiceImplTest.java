package com.ramssrez.app.services;

import com.ramssrez.app.dummy.AlumnoDummy;
import com.ramssrez.app.models.Alumno;
import com.ramssrez.app.repositorio.IAlumnoRepository;
import com.ramssrez.app.repositorio.IMateriasRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlumnoServiceImplTest {

    @Mock
     private IAlumnoRepository repository;

    @Mock
    private IMateriasRepository materiasRepository;

    @InjectMocks
    private AlumnoServiceImpl service;

    /*
    @BeforeEach
    void SetUp(){
        MockitoAnnotations.openMocks(this);
    }
     */

    @Test
    void testSuccessBuscarAlumnoPorNombreApeellido() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumno());

        Alumno alumno =  service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");

        Assertions.assertEquals("Adrian",alumno.getNombre());
        assertEquals(1,alumno.getId());
    }

    @Test
    void testFailBuscarAlumnoPorNombreApellidoListaVacia() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumnosListaVacia());

        assertThrows(NoSuchElementException.class, () ->{
            service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        });

    }

    @Test
    void testFailBuscarAlumnoPorNombreApellidoNull() {
        when(repository.obtenerAlumno()).thenReturn(null);

        assertThrows(NullPointerException.class, () ->{
            service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        });
    }

    @Test
    void testNoEncontradoAlumnoPorNombreApeellido() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumno());
        assertThrows(NoSuchElementException.class, () -> {
            service.buscarAlumnoPorNombreApllido("Raúl","Ramirez");
        },"El nombre no existe");
    }
}