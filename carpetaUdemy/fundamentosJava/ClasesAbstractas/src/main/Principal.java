package main;

import accesodatos.IAccesodatos;
import accesodatos.ImplementacionMySql;
import accesodatos.ImplementacionOracle;
import domain.FiguraGeometrica;
import domain.Rectangulo;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Impresión de clases abstractas");
        //FiguraGeometrica figura = new FiguraGeometrica();
        FiguraGeometrica figura = new Rectangulo("Rectangulo");
        figura.dibujar();

        //Uso de las interfaces
        IAccesodatos datos = new ImplementacionMySql();
        imprimir(datos);
        System.out.println("                 ");
        datos = new ImplementacionOracle();
        imprimir(datos);
    }

    public static void imprimir(IAccesodatos datos) {
        datos.eliminar();
        datos.listar();
        datos.actualizar();
        datos.insertar();
    }
}
