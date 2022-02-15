package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Esto es una prueba");
        //Referencia de memoria heap y observarlo en el stacj

        Persona persona = new Persona();
        persona.comer();
        persona.hablar("Raúl");
        //persona.firtsMame= "Raúl";

        System.out.println("persona = " + persona.firtsMame);
    }
}
