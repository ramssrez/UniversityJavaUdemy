package com.ramssrez.app.services;

import com.ramssrez.app.Constants.ConstantsMessegs;
import com.ramssrez.app.dummy.AlumnoDummy;
import com.ramssrez.app.dummy.MateriasDummy;
import com.ramssrez.app.exceptions.AgregarAlumnoException;
import com.ramssrez.app.exceptions.MateriasNotFoundException;
import com.ramssrez.app.models.Alumno;
import com.ramssrez.app.models.Materia;
import com.ramssrez.app.repositorio.IAlumnoRepository;
import com.ramssrez.app.repositorio.IMateriasRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
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

        verify(repository, times(1)).obtenerAlumno();
        verify(materiasRepository, times(1)).obtenerMaterias();

        assertEquals("Adrian",alumno.getNombre());
        assertEquals(1,alumno.getId());
    }

    @Test
    void testFailBuscarAlumnoPorNombreApellidoListaAlumnosVacia() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumnosListaVacia());

        Exception exception = assertThrows(NoSuchElementException.class, () ->{
            service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        });
        assertEquals(ConstantsMessegs.NO_NOMBRE_LISTA, exception.getMessage());
        verify(repository,  times(1)).obtenerAlumno();
        verify(materiasRepository, never()).obtenerMaterias();
    }

    @Test
    void ttestFailBuscarAlumnoPorNombreApellidoListaAlumnosNula() {
        when(repository.obtenerAlumno()).thenReturn(null);

        Exception excepcion = assertThrows(NullPointerException.class, () ->{
            service.buscarAlumnoPorNombreApllido("Adrian","Gonzalez");
        });
        verify(repository,  times(1)).obtenerAlumno();
        verify(materiasRepository, never()).obtenerMaterias();
        assertEquals(ConstantsMessegs.LISTA_SIN_DATOS,excepcion.getMessage());
    }

    @Test
    void testNoEncontradoAlumnoPorNombreApellido() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumno());
        Exception exception =  assertThrows(NoSuchElementException.class, () -> {
            service.buscarAlumnoPorNombreApllido("Raúl","Ramirez");
        });
        assertEquals(ConstantsMessegs.NO_NOMBRE_LISTA, exception.getMessage());
        verify(repository,  times(1)).obtenerAlumno();
        verify(materiasRepository, never()).obtenerMaterias();
    }

    @Test
    void testBuscarAlumnoNombreApellidoMateriaVacia() {
        when(repository.obtenerAlumno()).thenReturn(AlumnoDummy.obtenerAlumno());
        when(materiasRepository.obtenerMaterias()).thenReturn(MateriasDummy.obtenerMateriasListaVacia());

        Exception excepcion = assertThrows(MateriasNotFoundException.class, () -> {
            service.buscarAlumnoPorNombreApllido("Miguel", "Perez");
        });

        verify(repository, times(1)).obtenerAlumno();
        verify(materiasRepository, times(1)).obtenerMaterias();

        assertEquals(ConstantsMessegs.NO_LISTA_MATERIAS, excepcion.getMessage());
    }

    @Test
    void testSuccessAgregarAlumno() {
        List<Materia> materias = new ArrayList<>();
        materias.add(new Materia(6L,"POO 3"));
        when(repository.agregarAlumno(any(Alumno.class))).thenReturn(true);

        boolean resultado = service.crearAlumno("Pato", "Lucas", "Industrial", materias);

        verify(repository, times(1)).agregarAlumno(any(Alumno.class));
        verify(materiasRepository, never()).obtenerMaterias();

        assertTrue(resultado);
    }
    @Test
    void testFailAgregarAlumnoConDatosVacios() {
        List<Materia> materiasVacias = new ArrayList<>();
        //when(repository.agregarAlumno(any(Alumno.class))).thenReturn(false);
        Exception excepcion = assertThrows(AgregarAlumnoException.class, () -> service.crearAlumno("Pato", "", "", materiasVacias));
        verify(repository, never()).agregarAlumno(any(Alumno.class));
        verify(materiasRepository, never()).obtenerMaterias();
        assertEquals(ConstantsMessegs.ERROR_DATOS_ALUMNO, excepcion.getMessage());
    }

    @Test
    void testFailAgregarAlumnoConDatosNulos() {
        //when(repository.agregarAlumno(any(Alumno.class))).thenThrow(NullPointerException.class);

        Exception excepcion = assertThrows(AgregarAlumnoException.class, () -> service.crearAlumno("Pato", null, "Industrial", null));
        verify(repository, never()).agregarAlumno(any(Alumno.class));
        verify(materiasRepository, never()).obtenerMaterias();
        assertEquals(ConstantsMessegs.CAMPOS_SIN_DATOS, excepcion.getMessage());
    }
}