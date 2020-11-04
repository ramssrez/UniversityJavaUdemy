
package main;

import domain.FiguraGeometrica;
import domain.Rectangulo;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Impresión de clases abstractas");
        //FiguraGeometrica figura = new FiguraGeometrica();
       FiguraGeometrica figura = new Rectangulo("Rectangulo");
       figura.dibujar();
    }
}
