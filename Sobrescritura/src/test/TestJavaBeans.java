package test;

import domain.Persona;

public class TestJavaBeans {
    public static void main(String[] args) {
        //Prueba para javaBeans
        //Se usa la Serizalizable para que la clase o objeto pueda pasar a otro servidor
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        System.out.println("persona = " + persona.toString());
    }
}
