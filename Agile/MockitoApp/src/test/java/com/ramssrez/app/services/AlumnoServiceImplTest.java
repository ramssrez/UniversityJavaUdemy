package com.ramssrez.app.services;

import com.ramssrez.app.Constants.ConstantsMessegs;
import com.ramssrez.app.dummy.AlumnoDummy;
import com.ramssrez.app.dummy.MateriasDummy;
import com.ramssrez.app.exceptions.MateriasNotFoundException;
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
    void testSuccessBuscarAlumnoPorNombreApellido() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumno());
        when(materiasRepository.obtenerMaterias()).thenReturn(MateriasDummy.obtenerMaterias());

        Alumno alumno =  service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");

        Assertions.assertEquals("Adrian",alumno.getNombre());
        assertEquals(1,alumno.getId());
    }

    @Test
    void testFailBuscarAlumnoPorNombreApellidoListaAlumnosVacia() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumnosListaVacia());

        Exception exception = assertThrows(NoSuchElementException.class, () ->{
            service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        });
        assertEquals(ConstantsMessegs.NO_NOMBRE_LISTA, exception.getMessage());
    }

    @Test
    void ttestFailBuscarAlumnoPorNombreApellidoListaAlumnosNula() {
        when(repository.obtenerAlumno()).thenReturn(null);

        Exception excepcion = assertThrows(NullPointerException.class, () ->{
            service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        });
        assertEquals(ConstantsMessegs.LISTA_SIN_DATOS,excepcion.getMessage());
    }

    @Test
    void testNoEncontradoAlumnoPorNombreApellido() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumno());
        Exception exception =  assertThrows(NoSuchElementException.class, () -> {
            service.buscarAlumnoPorNombreApllido("Raúl","Ramirez");
        });
        assertEquals(ConstantsMessegs.NO_LISTA_MATERIAS, exception.getMessage());
    }

    @Test
    void testBuscarAlumnoNombreApellidoMateriaVacia() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumno());
        when(materiasRepository.obtenerMaterias()).thenReturn(MateriasDummy.obtenerMateriasListaVacia());

        Exception excepcion = assertThrows(MateriasNotFoundException.class, () -> {
            service.buscarAlumnoPorNombreApllido("Miguel", "Perez");
        });

        assertEquals(ConstantsMessegs.NO_LISTA_MATERIAS, excepcion.getMessage());
    }
    
    @Test
    void testSuccessAgregarAlumno() {
        when(repository.agregarAlumno(any(Alumno.class))).thenReturn(true);
        boolean resultado = service.crearAlumno("Pato", "Lucas", "Industrial", null);

        assertTrue(resultado);
    }
}