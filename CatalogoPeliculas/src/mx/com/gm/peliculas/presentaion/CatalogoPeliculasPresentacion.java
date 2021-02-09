package mx.com.gm.peliculas.presentaion;

import java.util.Scanner;
import mx.com.gm.pelicuas.servicio.CatalogoPelicuasImp;
import mx.com.gm.pelicuas.servicio.ICatalogoPeliculas;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        var opcion = -1;
        var Scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPelicuasImp();

        while (opcion != 0) {
            System.out.println("Elige una opcion \n"
                    + "1. Iniciar catalogo peliculas \n"
                    + "2. Agregar peliculas \n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar peliculas\n"
                    + "0. Salir"
            );

        }
    }
}
