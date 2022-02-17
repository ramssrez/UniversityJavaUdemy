package segundasesion;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<ProductoFinanciero> productos = new ArrayList<>();

    public void agregarProducto(ProductoFinanciero productoFinanciero){
        productos.add(productoFinanciero);
    }

    public List<ProductoFinanciero> getProductos() {
        return productos;
    }

    public boolean cancelarServicio(){
        for (ProductoFinanciero producto : productos){
            if (producto.getSaldo() != 0.0) {
                return false;
            }
        }
        return true;
    }
}
