package mx.com.gm.ventas.test;

import mx.com.gm.ventas.*;

public class VentasTest {

    public static void main(String[] args) {
        Producto producto1 = new Producto("Camisa", 50.00);
        Producto producto2 = new Producto("Pantaon", 100.00);
        System.out.println("Esto es una prueba");

        Orden orden1 = new Orden();
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        orden1.mostrarOrden();

    }
}
