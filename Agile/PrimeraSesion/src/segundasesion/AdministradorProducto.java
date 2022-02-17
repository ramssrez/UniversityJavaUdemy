package segundasesion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdministradorProducto {
    private Configuracion configuracion;
    private Map<String,List<ProductoFinanciero>> mapaProductos = new HashMap<>();


    public AdministradorProducto(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public void agregarProducto(Cliente cliente, ProductoFinanciero productoFinanciero){
        List<ProductoFinanciero> financieros = mapaProductos.get(cliente.getNumCliente());
        if(financieros == null){
            financieros = new ArrayList<>();
            mapaProductos.put(cliente.getNumCliente(), financieros);
        }
        if(productoFinanciero instanceof TarjetaCredito){
            double ingresoMensual = cliente.getIngresoMensual();
            double lineaCredito = ((TarjetaCredito) financieros).getLineaCredito();
            if(lineaCredito > ingresoMensual*configuracion.getMaxLineaCreditoPorIngresoMensual()){
                System.out.println("Linea de crédito excesiva pra este cliente");
                return;
            }
        }
        financieros.add(productoFinanciero);
    }

    public List<ProductoFinanciero> getProductos(String numCliente) {
        List<ProductoFinanciero> financieros = mapaProductos.get(numCliente);
        if(financieros == null){
            System.out.println("El cliente no tiene productos asignados");
        }
        return financieros;
    }

    public boolean puedeCancelar(Cliente cliente){
        List<ProductoFinanciero> financieros = mapaProductos.get(cliente.getNumCliente());
        boolean resultado = true;

        for (ProductoFinanciero producto : financieros){
            if (producto.getSaldo() != 0.0) {
                resultado = false;
                producto.imprimirEstadoCuenta();
            }
        }
        return resultado;
    }
}
