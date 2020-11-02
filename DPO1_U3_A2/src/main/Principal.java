package main;

import clases.Persona;

public class Principal {

    public static void main(String[] args) {
        Persona persona = new Persona();
        System.out.println("persona = " + persona);

        Persona personaDos = new Persona("Jesus");
        System.out.println("personaDos = " + personaDos);

        Persona personaTres = new Persona("Jesus", "Esquivel", "Hernandez");
        System.out.println("personaTres = " + personaTres);

        Persona personaCuatro = new Persona("Jesus","Esquivel","Hernandez",25);
        System.out.println("personaCuatro = " + personaCuatro);
    }
}
