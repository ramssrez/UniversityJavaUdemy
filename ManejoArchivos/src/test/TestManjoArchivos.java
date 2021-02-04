package test;

import static manejoarcivos.ManejoArchivos.*;

public class TestManjoArchivos {
    public static void main(String[] args) {
        var nombreArchivo = "Prueba.txt";
        crearArchivo(nombreArchivo);
        escribiArchivo(nombreArchivo, "Hola desde Java");
        anexarArchivo(nombreArchivo, "Adios");
        anexarArchivo(nombreArchivo, "Que tranza papus");
        leerArchivo(nombreArchivo);
    }
}
