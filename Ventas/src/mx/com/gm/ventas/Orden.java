package mx.com.gm.ventas;

public class Orden {

    private final int idOrden;
    private Producto productos[];
    private static int contadorOrdenes;
    private int contadorProductos;
    private static final int MAX_PRODUCTOS = 10;

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    }

    public void agregarProducto(Producto producto) {
        if (this.contadorProductos < Orden.MAX_PRODUCTOS) {
            productos[contadorProductos++] = producto;
        } else {
            System.out.println("Se ha superado el máximo de productos: " + Orden.MAX_PRODUCTOS);
        }
    }

}
