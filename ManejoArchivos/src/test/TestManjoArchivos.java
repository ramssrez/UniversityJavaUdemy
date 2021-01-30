package test;

import static manejoarcivos.ManejoArchivos.crearArchivo;

public class TestManjoArchivos {
    public static void main(String[] args) {
        var nombreArchivo = "Prueba.txt";
        crearArchivo(nombreArchivo);
    }
}
