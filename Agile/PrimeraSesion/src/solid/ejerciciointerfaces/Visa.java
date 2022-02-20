package solid.ejerciciointerfaces;

public class Visa implements IPagarTajetaDebito{
    @Override
    public void calcularPago() {
        System.out.println("Calculando el pago");
    }

    @Override
    public void pagarTarjetaDebito() {
        System.out.println("Pagando con tarjeta de debito");
    }
}
