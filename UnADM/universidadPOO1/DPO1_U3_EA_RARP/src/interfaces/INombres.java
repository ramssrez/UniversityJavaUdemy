package interfaces;

//Declaración de la interface llamada INombres
public interface INombres {

    //Declaración de los metodos abstractos donde depende del número de parametros que ingresan
    //Se puede observar la sobrecarga aplicado en los métodod abstractos.
    void ingresarNombre(String nombre);

    void ingresarNombre(String nombre, String apellidoPaterno);

    void ingresarNombre(String nombre, String apellidoPaterno, String apellidoMaterno);

}
