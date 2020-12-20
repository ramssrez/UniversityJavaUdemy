
package test;

import clases.Gerente;


public class TestSobrescritura {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Jose" ,5000, "Sistemas" );
        gerente.obtenerDetalles();
        System.out.println("gerente = " + gerente.obtenerDetalles());
    }
}
