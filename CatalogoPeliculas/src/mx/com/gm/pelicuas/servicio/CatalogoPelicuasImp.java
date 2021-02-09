package mx.com.gm.pelicuas.servicio;

import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatosImplemetation;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;

public class CatalogoPelicuasImp implements ICatalogoPeliculas{

    private final IAccesoDatos datos;

    public CatalogoPelicuasImp() {
        this.datos = new AccesoDatosImplemetation();
    }
    
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de aeso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarPelicula(String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iniciarCatalogoPeiulas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
