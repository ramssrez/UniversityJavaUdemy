package mx.gm.peliculas.excepciones;

//Extiende de la clase Excepción para poder hacer uso de la sentencia try/catch
//Se puede hacer uso de RuntimeExeption pero para poder observar la clase Exeption
public class AccesoDatosEx extends Exception{
    public AccesoDatosEx (String mensaje){
        super(mensaje);
    }
}
